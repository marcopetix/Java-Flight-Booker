/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.logic;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import p2.spark.Conf;
import p2.spark.Prenotazione;
import p2.spark.Utente;
import p2.spark.VoloRequest;
import p2.spark.Coordinate;

/**
 *
 * @author markp
 */

public class InterazioneApi{
    
    static private String RAPID_API_KEY = Conf.getRapidApi_Key();
    static private String OPENCAGE_KEY = Conf.getOPENCAGE_KEY();
    static private String GOOGLE_KEY = Conf.getGOOGLE_KEY();
    static private String IMGUR_KEY = Conf.getIMGUR_KEY();
    
    public static String creaSessione(String origineId, String destinazioneId, String data, String passeggeri) throws UnsupportedEncodingException {
        
        String url_session = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0";
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url_session);
        httpPost.addHeader("x-rapidapi-host", " skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        httpPost.addHeader("x-rapidapi-key", RAPID_API_KEY);
        httpPost.addHeader("content-type", " application/x-www-form-urlencoded");
        List<NameValuePair> params = new ArrayList<>();
        
        params.add(new BasicNameValuePair("originPlace", origineId));
        params.add(new BasicNameValuePair("destinationPlace", destinazioneId));
        params.add(new BasicNameValuePair("outboundDate", data));
        params.add(new BasicNameValuePair("adults", passeggeri));
        
        params.add(new BasicNameValuePair("country", "IT"));
        params.add(new BasicNameValuePair("locale", "it-IT"));
        params.add(new BasicNameValuePair("currency", "EUR"));
        params.add(new BasicNameValuePair("cabinClass", "economy"));
        params.add(new BasicNameValuePair("groupPricing", "'true'"));
                
        httpPost.setEntity(new UrlEncodedFormEntity(params));
                
        try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            
            Header[] header = response.getHeaders("location");
            String location = header[0].getValue();                         
            return location.split("/")[location.split("/").length -1 ];
        } catch (Exception e) {
            return null;
        }
           
    }
    
    public static String getVoli(String location) {
        String url_results = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/uk2/v1.0/" + location + "?sortType=price&sortOrder=asc&pageIndex=0&pageSize=10";
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url_results);
        httpGet.addHeader("x-rapidapi-host", " skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        httpGet.addHeader("x-rapidapi-key", RAPID_API_KEY);
        httpGet.addHeader("content-type", " application/x-www-form-urlencoded");
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            
            String ris = EntityUtils.toString(entity);
            
            JSONObject jo = new JSONObject(ris);
            
            JSONObject voli = new JSONObject();
            
            JSONArray arrVoli = new JSONArray();
            
            JSONObject query = jo.getJSONObject("Query");
            
            JSONArray itineraries = jo.getJSONArray("Itineraries");
            JSONArray legs = jo.getJSONArray("Legs");
            JSONArray places = jo.getJSONArray("Places");
            JSONArray carriers = jo.getJSONArray("Carriers");
            JSONArray agents = jo.getJSONArray("Agents");
            
            String outboundLegId = null;
            int agentId = 0;
            Float price = null;
            String bookingUrl = null;
            String idStringTest = null;
            int idIntTest = 0;
            
            int originStationId = 0;
            int destinationStationId = 0;
            String departure = null;
            String arrival = null;
            int duration = 0;
            int carrierId = 0;
            String flightNumber = null;
            
            String originStation = null;
            String destinationStation = null;
            String carrier = null;
            String agent = null;
            
            for (int i = 0; i < itineraries.length(); i++) {
                outboundLegId = itineraries.getJSONObject(i).getString("OutboundLegId");
                agentId = itineraries.getJSONObject(i).getJSONArray("PricingOptions").getJSONObject(0).getJSONArray("Agents").getInt(0);                
                bookingUrl = itineraries.getJSONObject(i).getJSONArray("PricingOptions").getJSONObject(0).getString("DeeplinkUrl");               
                price = itineraries.getJSONObject(i).getJSONArray("PricingOptions").getJSONObject(0).getFloat("Price");                
                                
                for(int j = 0; j < legs.length(); j ++) {
                    idStringTest = legs.getJSONObject(j).getString("Id");
                    if( idStringTest.equals(outboundLegId) ) {
                        originStationId = legs.getJSONObject(j).getInt("OriginStation");
                        destinationStationId = legs.getJSONObject(j).getInt("DestinationStation");
                        departure = legs.getJSONObject(j).getString("Departure");
                        arrival = legs.getJSONObject(j).getString("Arrival");
                        duration = legs.getJSONObject(j).getInt("Duration");
                        carrierId = legs.getJSONObject(j).getJSONArray("Carriers").getInt(0);                        
                        flightNumber = legs.getJSONObject(j).getJSONArray("FlightNumbers").getJSONObject(0).getString("FlightNumber");
                        break;
                    }
                }                
                
                for(int j = 0; j < places.length(); j ++) {
                    idIntTest = places.getJSONObject(j).getInt("Id");
                    if( idIntTest == originStationId ) {
                        originStation = places.getJSONObject(j).getString("Name");
                        break;
                    }
                }                
                
                for(int j = 0; j < places.length(); j ++) {
                    idIntTest = places.getJSONObject(j).getInt("Id");
                    if( idIntTest == destinationStationId ) {
                        destinationStation = places.getJSONObject(j).getString("Name");
                        break;
                    }
                }

                for(int j = 0; j < carriers.length(); j ++) {
                    idIntTest = carriers.getJSONObject(j).getInt("Id");
                    if( idIntTest == carrierId ) {
                        carrier = carriers.getJSONObject(j).getString("Name");
                        break;
                    }
                }
                
                for(int j = 0; j < agents.length(); j ++) {
                    idIntTest = agents.getJSONObject(j).getInt("Id");
                    if( idIntTest == agentId ) {
                        agent = agents.getJSONObject(j).getString("Name");
                        break;
                    }
                }                                
                
                JSONObject volo = new JSONObject();

                volo.put("prezzo", price);
                volo.put("bookingUrl", bookingUrl);
                volo.put("origineNome", originStation);
                volo.put("destinazioneNome", destinationStation);
                volo.put("compagniaAerea", carrier);
                volo.put("agentePrenotazione", agent);
                volo.put("orarioPartenza", departure);
                volo.put("numeroVolo", flightNumber);

                arrVoli.put(i , volo);                                
            }
            
            voli.put("voli", arrVoli);
                                             
            EntityUtils.consume(entity);                        
            
            return voli.toString();
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public static String getAeroporti(String query){
        String url = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/IT/EUR/it-IT/?query=" + query ;

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("x-rapidapi-host", " skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        httpGet.addHeader("x-rapidapi-key", RAPID_API_KEY);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            
            String ris = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            
            return ris;
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public static String getMeteo(String query) {
        String url = "https://community-open-weather-map.p.rapidapi.com/weather?lang=it&units=metric&q=" + query;
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("x-rapidapi-host", " community-open-weather-map.p.rapidapi.com");
        httpGet.addHeader("x-rapidapi-key", RAPID_API_KEY);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            
            String res = EntityUtils.toString(entity);
            
            JSONObject jo = new JSONObject(res);           
            
            String luogo = jo.getString("name");
            Float temp = jo.getJSONObject("main").getFloat("temp");
            Float temp_min = jo.getJSONObject("main").getFloat("temp_min");
            Float temp_max = jo.getJSONObject("main").getFloat("temp_max");
            
            String descrizione = jo.getJSONArray("weather").getJSONObject(0).getString("description");
            
            jo = new JSONObject();
            
            jo.put("luogo", luogo);
            jo.put("descrizione", descrizione);
            jo.put("temp", temp);
            jo.put("temp_min", temp_min);
            jo.put("temp_max", temp_max);
                        
            EntityUtils.consume(entity);           
            
            return jo.toString();
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public static Coordinate getCoordinate(String nomeLuogo) {
        String url = "https://api.opencagedata.com/geocode/v1/geojson?no_annotations=1&pretty=1&key=" + OPENCAGE_KEY + "&q=" + nomeLuogo;
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            
            HttpEntity entity = response.getEntity();
            
            String res = EntityUtils.toString(entity);
            
            JSONObject jo = new JSONObject(res);
            
            JSONArray coor = jo.getJSONArray("features").getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates");
            
            Coordinate coordinate = new Coordinate(Float.toString(coor.getFloat(1)), Float.toString(coor.getFloat(0)));
            
            EntityUtils.consume(entity);           
            
            return coordinate;
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public static String getMapURL(Coordinate coordinate_a, Coordinate coordinate_b) throws UnsupportedEncodingException{
        String mapURL = "https://maps.googleapis.com/maps/api/staticmap?size=500x500&maptype=hybrid&center=Roma,Italia&zoom=5&language=it";
        mapURL += "&markers=color:red%7Clabel:1%7C" + coordinate_a.getLatitudine() + "," + coordinate_a.getLongitudine();
        mapURL += "&markers=color:red%7Clabel:2%7C" + coordinate_b.getLatitudine() + "," + coordinate_b.getLongitudine();
        mapURL += "&path=color:0x0000ff|weight:5|" + coordinate_a.getLatitudine() + "," + coordinate_a.getLongitudine() + "|";
        mapURL += coordinate_b.getLatitudine() + "," + coordinate_b.getLongitudine(); 
        mapURL += "&key=" + GOOGLE_KEY;
        
        System.out.println(mapURL);
        
        String url = "https://api.imgur.com/3/image";
        
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Authorization", "Client-ID " + IMGUR_KEY);
        httpPost.addHeader("x-rapidapi-key", RAPID_API_KEY);
        httpPost.addHeader("content-type", " application/x-www-form-urlencoded");
        List<NameValuePair> params = new ArrayList<>();
        
        params.add(new BasicNameValuePair("image", mapURL));
        params.add(new BasicNameValuePair("type", "url"));
        
        httpPost.setEntity(new UrlEncodedFormEntity(params));
                
        try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            
            HttpEntity entity = response.getEntity();
            
            String res = EntityUtils.toString(entity);
            
            JSONObject jo = new JSONObject(res);
            
            return jo.getJSONObject("data").getString("link");
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public static String getUtenti(ArrayList<Utente> utenti){
        
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();
        
        for(int i = 0; i<utenti.size(); i++){
            JSONObject joo = new JSONObject();
            joo.put("username", utenti.get(i).getUsername());
            joo.put("totale_spesa", utenti.get(i).getTotale_spesa());
            ja.put(joo);
        }
        
        jo.put("Utenti", ja);
        
        return jo.toString();
        
    }

    public static String getLogRicerche(ArrayList<VoloRequest> logVoli) {
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();
        
        for(int i = 0; i<logVoli.size(); i++){
            JSONObject joo = new JSONObject();
            joo.put("origineId", logVoli.get(i).getOrigineId());
            joo.put("destinazioneId", logVoli.get(i).getDestinazioneId());
            joo.put("origineNome", logVoli.get(i).getOrigineNome());
            joo.put("destinazioneNome", logVoli.get(i).getDestinazioneNome());
            joo.put("data", logVoli.get(i).getData());
            joo.put("passeggeri", logVoli.get(i).getPasseggeri());
            if(logVoli.get(i).getUtente() != null){
                joo.put("utente", logVoli.get(i).getUtente());
            }
            ja.put(joo);
        }
        
        jo.put("Storico", ja);
                
        return jo.toString();
    }
    
    public static String getPrenotazioni(ArrayList<Prenotazione> logPrenotazioni) {
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();
        
        for(int i = 0; i<logPrenotazioni.size(); i++){
            JSONObject joo = new JSONObject();
            joo.put("origineNome", logPrenotazioni.get(i).getOrigineNome());
            joo.put("destinazioneNome", logPrenotazioni.get(i).getDestinazioneNome());
            joo.put("compagniaAerea", logPrenotazioni.get(i).getCompagniaAerea());
            joo.put("numeroVolo", logPrenotazioni.get(i).getNumeroVolo());
            joo.put("orarioPartenza", logPrenotazioni.get(i).getOrarioPartenza());
            joo.put("agentePrenotazione", logPrenotazioni.get(i).getAgentePrenotazione());
            joo.put("prezzo", logPrenotazioni.get(i).getPrezzo());
            
            if(logPrenotazioni.get(i).getUtente() != null){
                joo.put("utente", logPrenotazioni.get(i).getUtente());
            }
            ja.put(joo);
        }
        
        jo.put("Prenotazioni", ja);
                
        return jo.toString();
    }
    
}

