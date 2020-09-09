package p2.logic;

/**
 *
 * @author markp
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import p2.gui.LoginForm;
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
        String url = Token_url + "/login_admin/" + username + "/" + password;
        System.out.println(url);
        
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
        String url = Token_url + "/sign_in_admin/" + username + "/" + password;
        
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
    
    public static ArrayList<Utente> getUtenti(String token) {
        String url = Server_url + "/utenti";
        
        ArrayList<Utente> utenti = new ArrayList<>();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            JsonObject jsonObject = new JsonParser().parse(stringEntity).getAsJsonObject();
            
            JsonArray arrUtenti = jsonObject.getAsJsonArray("Utenti");
            
            for (int i = 0; i < arrUtenti.size(); i++) {                
                Utente utente = new Gson().fromJson(arrUtenti.get(i).getAsJsonObject(), Utente.class);
                utenti.add(utente);
            }
            EntityUtils.consume(entity);
            
            return utenti;

        } catch (Exception e) {
            
        }
        return null;
        
    }

    public static ArrayList<Ricerca> getRicerche() {
        String url = Server_url + "/storicoTot";
        
        ArrayList<Ricerca> ricerche = new ArrayList<>();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            JsonObject jsonObject = new JsonParser().parse(stringEntity).getAsJsonObject();
            
            JsonArray arrLog = jsonObject.getAsJsonArray("Storico");
            
            for (int i = 0; i < arrLog.size(); i++) {
                
                Ricerca ricerca = new Gson().fromJson(arrLog.get(i).getAsJsonObject(), Ricerca.class);
                ricerche.add(ricerca);
            }
            EntityUtils.consume(entity);
            
            return ricerche;

        } catch (Exception e) {
            
        }
        return null;
    }
    
    public static ArrayList<Ricerca> getRicerche(String username) {
        String url = Server_url + "/storico/" + username;
        
        ArrayList<Ricerca> ricerche = new ArrayList<>();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            JsonObject jsonObject = new JsonParser().parse(stringEntity).getAsJsonObject();
            
            JsonArray arrLog = jsonObject.getAsJsonArray("Storico");
            
            for (int i = 0; i < arrLog.size(); i++) {
                
                Ricerca ricerca = new Gson().fromJson(arrLog.get(i).getAsJsonObject(), Ricerca.class);
                ricerche.add(ricerca);
            }
            EntityUtils.consume(entity);
            
            return ricerche;

        } catch (Exception e) {
            
        }
        return null;
    }
    
    public static ArrayList<Prenotazione> getPrenotazioni() {
        String url = Server_url + "/prenotazioni";
        
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            JsonObject jsonObject = new JsonParser().parse(stringEntity).getAsJsonObject();
            JsonArray arrLog = jsonObject.getAsJsonArray("Prenotazioni");
            for (int i = 0; i < arrLog.size(); i++) {
                
                Prenotazione prenotazione = new Gson().fromJson(arrLog.get(i).getAsJsonObject(), Prenotazione.class);
                prenotazioni.add(prenotazione);
            }
            EntityUtils.consume(entity);
            
            return prenotazioni;

        } catch (Exception e) {
            
        }
        return null;
    }
    
    public static ArrayList<Prenotazione> getPrenotazioni(String username) {
        String url = Server_url + "/prenotazioni/" + username;
        
        ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            String stringEntity = EntityUtils.toString(entity);
            JsonObject jsonObject = new JsonParser().parse(stringEntity).getAsJsonObject();
            
            JsonArray arrLog = jsonObject.getAsJsonArray("Prenotazioni");
            
            for (int i = 0; i < arrLog.size(); i++) {
                
                Prenotazione prenotazione = new Gson().fromJson(arrLog.get(i).getAsJsonObject(), Prenotazione.class);
                prenotazioni.add(prenotazione);
            }
            EntityUtils.consume(entity);
            
            return prenotazioni;

        } catch (Exception e) {
            
        }
        return null;
    }
    
    
        
}
