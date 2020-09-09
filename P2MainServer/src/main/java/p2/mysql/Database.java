/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import p2.logic.InterazioneApi;
import p2.spark.Conf;
import p2.spark.Prenotazione;
import p2.spark.Utente;
import p2.spark.VoloRequest;

/**
 *
 * @author markp
 */
public class Database {
    private final static String URL = Conf.getDB_URL_ADDRESS() + ":" + Conf.getDB_URL_PORT() + "/" +  Conf.getDB_URL_NAME() + "?" +  Conf.getDB_URL_OPTION();
    private final static String USER = Conf.getDB_Username();
    private final static String PASSWORD = Conf.getDB_Password();
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static boolean insertVolo(VoloRequest volo) throws ClassNotFoundException, SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "INSERT INTO ricerche (username, origineId, OrigineNome, destinazioneId, destinazioneNome, data, passeggeri) VALUES ('";
            query += volo.getUtente() +"', '" + volo.getOrigineId() + "', '" + volo.getOrigineNome() + "', '" + volo.getDestinazioneId() + "', '" + volo.getDestinazioneNome() + "', '" + volo.getData() + "', '" + Integer.parseInt(volo.getPasseggeri()) + "')";
            Class.forName(DRIVER);
            if(!checkUtente(volo.getUtente())){
                insertUtente(volo.getUtente());
            }
            return stmt.executeUpdate(query) == 1;
        }catch(SQLException e){
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return false;
        }
    }
    
    public static boolean insertPrenotazione(Prenotazione volo) throws ClassNotFoundException{
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){          
            String v = "', '";
            String query = "INSERT INTO prenotazioni (origineNome, destinazioneNome, compagniaAerea, numeroVolo, ";
            query += "orarioPartenza, agentePrenotazione, prezzo, utente) VALUES ('";
            query += volo.getOrigineNome() + v + volo.getDestinazioneNome() + v + volo.getCompagniaAerea();
            query += v + Integer.parseInt(volo.getNumeroVolo()) + v + volo.getOrarioPartenza() + v + volo.getAgentePrenotazione() + v;
            query += Float.parseFloat(volo.getPrezzo()) + v + volo.getUtente() + "')";
            Class.forName(DRIVER);
            updateSpesaTotale(volo.getUtente(), Float.parseFloat(volo.getPrezzo()));
            return stmt.executeUpdate(query) == 1;
        }catch(SQLException e){
            System.out.println("insertPrenotazione");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return false;
        }
    }
    
    public static boolean insertUtente(String utente) throws ClassNotFoundException{
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){          
            String query = "INSERT INTO utenti VALUES ('" + utente + "', '" + 0 +"')";   
            Class.forName(DRIVER);
            return stmt.executeUpdate(query) == 1;
        }catch(SQLException e){
            System.out.println("insertUtente");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return false;
        }
    }
    
    public static boolean checkUtente(String utente) throws ClassNotFoundException{
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){          
            String query = "SELECT * FROM utenti WHERE username='" + utente + "')";   
            Class.forName(DRIVER);
            return stmt.executeUpdate(query) == 1;
        }catch(SQLException e){
            System.out.println("getUtente");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return false;
        }
    }

    
    public static double getSpesaTotale(String username) throws ClassNotFoundException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "SELECT totale_spesa FROM utenti WHERE username = '" + username + "'";
            Class.forName(DRIVER);
            ResultSet rs = stmt.executeQuery(query);
            if(rs.first()){
                return rs.getDouble("totale_spesa");
            }else{
                return 0;
            }
            
        }catch(SQLException e){
            System.out.println("getSpesaTotale");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return 0;
        }
    }
    
    public static boolean updateSpesaTotale(String username, float newSpesa) throws ClassNotFoundException{
        
        double oldSpesaTotale = getSpesaTotale(username);
        float newSpesaTotale = (float)oldSpesaTotale + newSpesa;
        
        String query;
        
        query = "UPDATE utenti SET totale_spesa = " + newSpesaTotale + " WHERE username = '" + username +"';";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            Class.forName(DRIVER);
            return stmt.executeUpdate(query) == 1;
        }catch(SQLException e){
            System.out.println("updateSpesaTotale");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return false;
        }
    }
    
    public static String getUtenti() throws ClassNotFoundException {
        
        ArrayList<Utente> utenti = new ArrayList();
           
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "SELECT * FROM utenti";
            Class.forName(DRIVER);
            
             ResultSet rs = stmt.executeQuery(query);
      
            while (rs.next())
            {
              String username = rs.getString("username");
              String totale_spesa = rs.getString("totale_spesa");
              utenti.add(new Utente(username, totale_spesa));
            }               
            return InterazioneApi.getUtenti(utenti);
        }catch(SQLException e){
            System.out.println("getUtenti");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return null;
        }
    }
    
    public static String getLogRicerche(String utente) throws ClassNotFoundException {
        
        ArrayList<VoloRequest> logVoli = new ArrayList();
           
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "SELECT * FROM ricerche WHERE username = '" + utente + "'";
            Class.forName(DRIVER);
            
            ResultSet rs = stmt.executeQuery(query);
      
            while (rs.next())
            {
                String origineNome = rs.getString("origineNome");
                String origineId = rs.getString("origineId");
                String destinazioneNome = rs.getString("destinazioneNome");
                String destinazioneId = rs.getString("destinazioneId");
                String passeggeri = rs.getString("passeggeri");
                String data = rs.getString("data");
              
              logVoli.add(new VoloRequest(origineNome, origineId, destinazioneNome, destinazioneId, passeggeri, data));
            }
            
            return InterazioneApi.getLogRicerche(logVoli);
        }catch(SQLException e){
            System.out.println("getLogRicerche");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return null;
        }
    }
    
    public static String getStoricoUtente(String utente) throws ClassNotFoundException {
        
        ArrayList<VoloRequest> logVoli = new ArrayList();
           
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "SELECT DISTINCT origineNome, destinazioneNome FROM ricerche WHERE username = '" + utente + "'";
            Class.forName(DRIVER);
            
            ResultSet rs = stmt.executeQuery(query);
      
            while (rs.next())
            {
                String origineNome = rs.getString("origineNome");
                String destinazioneNome = rs.getString("destinazioneNome");
              
              logVoli.add(new VoloRequest(origineNome, destinazioneNome));
            }
            
            return InterazioneApi.getLogRicerche(logVoli);
        }catch(SQLException e){
            System.out.println("getLogRicerche");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return null;
        }
    }
    
    public static String getLogRicerche() throws ClassNotFoundException {
        
        ArrayList<VoloRequest> logVoli = new ArrayList();
           
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "SELECT * FROM ricerche";
            Class.forName(DRIVER);
            
            ResultSet rs = stmt.executeQuery(query);
      
            while (rs.next())
            {
                String origineNome = rs.getString("origineNome");
                String origineId = rs.getString("origineId");
                String destinazioneNome = rs.getString("destinazioneNome");
                String destinazioneId = rs.getString("destinazioneId");
                String passeggeri = rs.getString("passeggeri");
                String data = rs.getString("data");
                String utente = rs.getString("username");
              
              logVoli.add(new VoloRequest(origineNome, origineId, destinazioneNome, destinazioneId, passeggeri, data, utente));
            }
            
            return InterazioneApi.getLogRicerche(logVoli);
        }catch(SQLException e){
            System.out.println("getLogRicerche");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return null;
        }
    }
    
    public static String getPrenotazioni(String utente) throws ClassNotFoundException {
        
        ArrayList<Prenotazione> logPrenotazioni = new ArrayList();
           
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "SELECT * FROM prenotazioni WHERE utente = '" + utente + "'";
            Class.forName(DRIVER);
            
            ResultSet rs = stmt.executeQuery(query);
      
            while (rs.next())
            {
                String origineNome = rs.getString("origineNome");
                String compagniaAerea = rs.getString("compagniaAerea");
                String destinazioneNome = rs.getString("destinazioneNome");
                String numeroVolo = Integer.toString(rs.getInt("numeroVolo"));
                String orarioPartenza = rs.getString("orarioPartenza");
                String agentePrenotazione = rs.getString("agentePrenotazione");
                String prezzo = Float.toString(rs.getFloat("prezzo"));                
              
              logPrenotazioni.add(new Prenotazione(origineNome, destinazioneNome, compagniaAerea, numeroVolo, orarioPartenza, agentePrenotazione, prezzo));
            }
            
            return InterazioneApi.getPrenotazioni(logPrenotazioni);
        }catch(SQLException e){
            System.out.println("getPrenotazioni");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return null;
        }
    }
    
        public static String getPrenotazioni() throws ClassNotFoundException {
        
        ArrayList<Prenotazione> logPrenotazioni = new ArrayList();
           
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "SELECT * FROM prenotazioni";
            Class.forName(DRIVER);
            
            ResultSet rs = stmt.executeQuery(query);
      
            while (rs.next())
            {
                String origineNome = rs.getString("origineNome");
                String compagniaAerea = rs.getString("compagniaAerea");
                String destinazioneNome = rs.getString("destinazioneNome");
                String numeroVolo = Integer.toString(rs.getInt("numeroVolo"));
                String orarioPartenza = rs.getString("orarioPartenza");
                String agentePrenotazione = rs.getString("agentePrenotazione");
                String prezzo = Float.toString(rs.getFloat("prezzo"));
                String utente = rs.getString("utente");
                
              
              logPrenotazioni.add(new Prenotazione(origineNome, destinazioneNome, compagniaAerea, numeroVolo, orarioPartenza, agentePrenotazione, prezzo, utente));
            }
            
            return InterazioneApi.getPrenotazioni(logPrenotazioni);
        }catch(SQLException e){
            System.out.println("getPrenotazioni");
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return null;
        }
    }
    

    
    
    
}
