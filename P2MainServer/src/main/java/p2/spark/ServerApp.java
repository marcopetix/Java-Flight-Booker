package p2.spark;

import com.google.gson.Gson;
import p2.jwt.JWT;
import p2.mysql.Database;
import p2.logic.InterazioneApi;
import static spark.Spark.get;
import static spark.Spark.post;

/**
 *
 * @author markp
 */
public class ServerApp {
    
    public static void main(String[] args) throws Exception {  
        
        new Conf();
        
        String AES_Key = Conf.getAES_Key();
        
        get("/utenti", (req, res) ->{
            return Database.getUtenti();
        });
        
        get("/storicoTot", (req, res) ->{
            return Database.getLogRicerche();
        });        
        
        get("/storico", (req, res) ->{
            String utente = JWT.getUtenteFromJWT(req.headers("token"));
            return Database.getStoricoUtente(utente);
        });
        
        get("/storico/:username", (req, res) ->{
            return Database.getLogRicerche(req.params("username"));
        });
        
        get("/prenotazioni", (req, res) ->{
            return Database.getPrenotazioni();
        });
        
        get("/prenotazioni/:username", (req, res) ->{
            return Database.getPrenotazioni(req.params("username"));
        });
        
        get("/spesaTotale", (req, res) ->{
            String utente = JWT.getUtenteFromJWT(req.headers("token"));
            return Database.getSpesaTotale(utente);
        });
        
        get("/mappa/:luogo_a/:luogo_b", (req, res) ->{
            Coordinate coordinate_a = InterazioneApi.getCoordinate(req.params("luogo_a"));
            Coordinate coordinate_b = InterazioneApi.getCoordinate(req.params("luogo_b"));
            return InterazioneApi.getMapURL(coordinate_a, coordinate_b);
        });
      
        get("/aeroporti/:place", (req, res) ->{
            return InterazioneApi.getAeroporti(req.params("place"));
        });
        
        get("/meteo/:place", (req, res) ->{
            return InterazioneApi.getMeteo(req.params("place"));
        });        

        post("/voli", (req, res) ->{
            
            String location;
            String token = req.headers("token");
            VoloRequest volo = new Gson().fromJson(AES.decrypt(req.body(), AES_Key), VoloRequest.class);
            volo.setUtente(JWT.getUtenteFromJWT(token));
            if(JWT.parseJWT(token)){
                
                do{
                    location = InterazioneApi.creaSessione(volo.getOrigineId(), volo.getDestinazioneId(), volo.getData(), volo.getPasseggeri());
                }while(location == null);
                Database.insertVolo(volo);   
                res.status(200);
                return AES.encrypt(InterazioneApi.getVoli(location), AES_Key); 
            }else{
                res.status(401);
                return null;
            } 
        });   
        
        post("/prenota", (req, res) ->{
            
            String location;
            String token = req.headers("token");
            Prenotazione volo = new Gson().fromJson(AES.decrypt(req.body(), AES_Key), Prenotazione.class);
            volo.setUtente(JWT.getUtenteFromJWT(token));
            if(JWT.parseJWT(token)){
                Database.insertPrenotazione(volo);
                res.status(200);
                return null; 
            }else{
                res.status(401);
                return null;
            }  
        });   
    
    }
    
    
}


