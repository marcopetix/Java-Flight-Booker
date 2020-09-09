package pyt.logic;

/**
 *
 * @author markp
 */

import pyt.gui.LoginForm;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

public class App {
    
    private static String AES_Key;
    private static String Token_url;
    private static String Server_url;
   
    public static void main(String[] args) throws IOException, Exception {        

        new Conf();
        AES_Key = Conf.getAES_Key();
        Token_url = Conf.getToken_url();
        Server_url = Conf.getServer_url();
        
        SwingUtilities.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
    
    public static String login_utente(String username, String password) {
        String url = Token_url + "/login/" + username + "/" + password;
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                String token = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
                return token;
            }
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean registra_utente(String username, String password) {
        String url = Token_url + "/sign_in/" + username + "/" + password;
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
            
                EntityUtils.consume(entity);
                return true;
            }            
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 
    public static ArrayList<VoloRequest> getStorico(String token) {
        String url = Server_url + "/storico";
        ArrayList<VoloRequest> storico = new ArrayList<>();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);        
        httpGet.addHeader("token", token);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            JsonObject jsonObject = new JsonParser().parse(stringEntity).getAsJsonObject();
            
            JsonArray arrStorico = jsonObject.getAsJsonArray("Storico");           
                        
            for (int i = 0; i < arrStorico.size(); i++) {
                
                VoloRequest request = new Gson().fromJson(arrStorico.get(i).getAsJsonObject(), VoloRequest.class);
                storico.add(request);
            }
            EntityUtils.consume(entity);
            
            return storico;
            
        }catch (Exception e) {
            return null;
        }
        
    }
    
    public static ArrayList<Aeroporto> getAeroporti(String place) {
        String url = Server_url + "/aeroporti/" + place;
        ArrayList<Aeroporto> aeroporti = new ArrayList<>();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);        
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            JsonObject jsonObject = new JsonParser().parse(stringEntity).getAsJsonObject();
            
            JsonArray arrAeroporti = jsonObject.getAsJsonArray("Places");           
            
            for (int i = 0; i < arrAeroporti.size(); i++) {
                
                Aeroporto aeroporto = new Gson().fromJson(arrAeroporti.get(i).getAsJsonObject(), Aeroporto.class);
                aeroporti.add(aeroporto);
            }
            EntityUtils.consume(entity);
            
            return aeroporti;
            
        }catch (Exception e) {
            return null;
        }    
    }
    
    public static String getMappa(String origine, String destinazione) {
        origine = origine.replaceAll("\\s", "+");
        destinazione = destinazione.replaceAll("\\s", "+");
        String url = Server_url + "/mappa/" + origine + "/" + destinazione;
        System.out.println(url);
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);        
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            
            EntityUtils.consume(entity);
            
            return stringEntity;
            
        }catch (Exception e) {
            return null;
        }    
    }
    
    public static ArrayList<VoloResponse> getVoli(String token, String origineId, String origineNome, String destinazioneId, String destinazioneNome, String data, String adulti) throws UnsupportedEncodingException {
        String url = Server_url + "/voli";
        ArrayList<VoloResponse> voli = new ArrayList<>();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        
        VoloRequest voloRequest = new VoloRequest(origineId, origineNome, destinazioneId, destinazioneNome, data, adulti);
        String request_plain = new Gson().toJson(voloRequest);
        
        String request_encrypted = AES.encrypt(request_plain, AES_Key);
        
//        System.out.println("before: " + request_plain);
//        System.out.println("key: " + AES_Key);
//        System.out.println("after: " + request_encrypted);
 
        StringEntity request_entity = new StringEntity(request_encrypted);
        httpPost.setEntity(request_entity);
        httpPost.addHeader("token", token);
        
        try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            HttpEntity entity = response.getEntity();

            String stringEntity = EntityUtils.toString(entity);

            JsonObject jsonObject = new JsonParser().parse( AES.decrypt(stringEntity, AES_Key) ).getAsJsonObject();

            JsonArray arrVoli = jsonObject.getAsJsonArray("voli");

            for (int i = 0; i < arrVoli.size(); i++) {
                VoloResponse volo = new Gson().fromJson(arrVoli.get(i).getAsJsonObject(), VoloResponse.class);
                voli.add(volo);
            }
            EntityUtils.consume(entity);           
            
            return voli;

        } catch (Exception e) {
            return null;
        }        
    }
    
    public static String getMeteo(String luogo) {
        String url = Server_url + "/meteo/" + luogo;
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            
            String stringEntity = EntityUtils.toString(entity);
                        
            JsonObject jsonObject = new JsonParser().parse(stringEntity).getAsJsonObject();
            
            Meteo meteo = new Gson().fromJson(jsonObject, Meteo.class);
            
            EntityUtils.consume(entity);
                        
            return meteo.toString();

        } catch (Exception e) {
            return null;
        }                
    }
    
    public static void setPrenotazione(String token, VoloResponse volo) throws UnsupportedEncodingException, IOException {
        String url = Server_url + "/prenota";
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        
        String request_plain = new Gson().toJson(volo);
        
        String request_encrypted = AES.encrypt(request_plain, AES_Key);
         
        StringEntity request_entity = new StringEntity(request_encrypted);
        httpPost.setEntity(request_entity);
        httpPost.addHeader("token", token);
        
        CloseableHttpResponse response = httpclient.execute(httpPost);
        
    }
    
    public static boolean isSconto(String token){
        String url = Server_url + "/spesaTotale";
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("token", token);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            
            String stringEntity = EntityUtils.toString(entity);
                        
            float spesa = Float.parseFloat(stringEntity);
            
            EntityUtils.consume(entity);
                        
            return (spesa > 300);

        } catch (Exception e) {
            return false;
        }                
    }
}
