/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyt.logic;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author markp
 */
public class Conf {
    private static String AES_Key;
    private static String Server_url;
    private static String Token_url;

    public static String getServer_url() {
        return Server_url;
    }

    public static void setServer_url(String Server_url) {
        Conf.Server_url = Server_url;
    }

    public static String getToken_url() {
        return Token_url;
    }

    public static void setToken_url(String Token_url) {
        Conf.Token_url = Token_url;
    }
    
    public Conf() throws Exception {
        JSONObject jo = (JSONObject) readJsonSimpleDemo("conf_app.json");
        
        setAES_Key((String) jo.get("AES_Key"));
        setServer_url((String) jo.get("Server_url"));
        setToken_url((String) jo.get("Token_url"));
    }

    public static String getAES_Key() {
        return AES_Key;
    }

    public static void setAES_Key(String AES_Key) {
        Conf.AES_Key = AES_Key;
    }
    
    public static Object readJsonSimpleDemo(String filename) throws Exception {
    FileReader reader = new FileReader(filename);
    JSONParser jsonParser = new JSONParser();
    return jsonParser.parse(reader);
    }
}
