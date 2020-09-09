package p2.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import p2.spark.Conf;

/**
 *
 * @author markp
 */
public class Database {
    private final static String URL = Conf.getDB_URL_ADDRESS() + ":" + Conf.getDB_URL_PORT() + "/" +  Conf.getDB_URL_NAME() + "?" +  Conf.getDB_URL_OPTION();
    private final static String USER = Conf.getDB_Username();
    private final static String PASSWORD = Conf.getDB_Password();
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static boolean sign_in(String username, String password, int admin) throws ClassNotFoundException, SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "INSERT INTO utenti (username, password, is_admin) VALUES ('" + username +"', '" + password + "'," + admin + ")";
            Class.forName(DRIVER);
            return stmt.executeUpdate(query) == 1;
        }catch(SQLException e){
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return false;
        }
    }
    
    public static boolean login(String username, String password, boolean admin) throws ClassNotFoundException, SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();
            ){
            String query = "SELECT * FROM utenti WHERE username = '" + username +"' AND password = '" + password + "'";
            if(admin){
                query += " AND is_admin = 1";
            }
            Class.forName(DRIVER);
            ResultSet rs = stmt.executeQuery(query);
            return rs.first();
        }catch(SQLException e){
            System.out.println("error code: " + e.getErrorCode());
            System.out.println("sql state: " + e.getSQLState());
            return false;
        }
    }
}
