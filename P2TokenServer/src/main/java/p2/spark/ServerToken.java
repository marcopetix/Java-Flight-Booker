package p2.spark;

import static p2.jwt.JWT.createJWT;
import p2.mysql.Database;
import p2.spark.Conf;
import static spark.Spark.get;
import static spark.Spark.port;

/**
 *
 * @author markp
 */
public class ServerToken {
    
    public static void main(String[] args) throws Exception {
        
        new Conf();
        port(5678);
      
        get("/login/:username/:password", (req, res) -> {
            if( Database.login(req.params("username"), req.params("password"), false)){
                System.out.println("login");
                return createJWT("0", req.params("username"), "User Login");
            }else{
                System.out.println("no-login");
                return null;
            }
        });

        get("/sign_in/:username/:password", (req, res) -> {
            return Database.sign_in(req.params("username"), req.params("password"), 0);
        });
        
        get("/login_admin/:username/:password", (req, res) -> {
            if( Database.login( req.params("username"), req.params("password"), true)){
                return createJWT("0", req.params("username"), "User Login");
            }else{
                return null;
            }
        });

        get("/sign_in_admin/:username/:password", (req, res) -> {
            return Database.sign_in(req.params("username"), req.params("password"), 1);
        });
  
    }
}
