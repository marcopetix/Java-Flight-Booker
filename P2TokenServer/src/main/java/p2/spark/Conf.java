/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.spark;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



/**
 *
 * @author markp
 */
public class Conf {
    private static String DB_Username;
    private static String DB_Password;
    private static String DB_URL_NAME;
    private static String DB_URL_PORT;
    private static String DB_URL_ADDRESS;
    private static String DB_URL_OPTION;
    private static String JWT_Key;
    private static long JWT_TTL;

    public Conf() throws Exception {       
        JSONObject jo = (JSONObject) readJsonSimpleDemo("conf_token.json");
              
        setDB_Username((String) jo.get("DB_Username"));
        setDB_Password((String) jo.get("DB_Password"));
        setDB_URL_NAME((String) jo.get("DB_URL_NAME"));
        setDB_URL_PORT((String) jo.get("DB_URL_PORT"));
        setDB_URL_ADDRESS((String) jo.get("DB_URL_ADDRESS"));
        setDB_URL_OPTION((String) jo.get("DB_URL_OPTION"));
        setJWT_Key((String) jo.get("JWT_Key"));
        setJWT_TTL(Long.parseLong((String) jo.get("JWT_TTL")));
       }

    public static long getJWT_TTL() {
        return JWT_TTL;
    }

    public static void setJWT_TTL(long JWT_TTL) {
        Conf.JWT_TTL = JWT_TTL;
    }

    
    public static String getDB_URL_NAME() {
        return DB_URL_NAME;
    }

    public static void setDB_URL_NAME(String DB_URL_NAME) {
        Conf.DB_URL_NAME = DB_URL_NAME;
    }

    public static String getDB_URL_PORT() {
        return DB_URL_PORT;
    }

    public static void setDB_URL_PORT(String DB_URL_PORT) {
        Conf.DB_URL_PORT = DB_URL_PORT;
    }

    public static String getDB_URL_ADDRESS() {
        return DB_URL_ADDRESS;
    }

    public static void setDB_URL_ADDRESS(String DB_URL_ADDRESS) {
        Conf.DB_URL_ADDRESS = DB_URL_ADDRESS;
    }

    public static String getDB_URL_OPTION() {
        return DB_URL_OPTION;
    }

    public static void setDB_URL_OPTION(String DB_URL_OPTION) {
        Conf.DB_URL_OPTION = DB_URL_OPTION;
    }

    public static String getDB_Username() {
        return DB_Username;
    }

    public static void setDB_Username(String DB_Username) {
        Conf.DB_Username = DB_Username;
    }

    public static String getDB_Password() {
        return DB_Password;
    }

    public static void setDB_Password(String DB_Password) {
        Conf.DB_Password = DB_Password;
    }

    public static String getJWT_Key() {
        return JWT_Key;
    }

    public static void setJWT_Key(String JWT_Key) {
        Conf.JWT_Key = JWT_Key;
    }

    public static Object readJsonSimpleDemo(String filename) throws Exception {
    FileReader reader = new FileReader(filename);
    JSONParser jsonParser = new JSONParser();
    return jsonParser.parse(reader);
    }

}
