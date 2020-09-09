/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import javax.xml.bind.DatatypeConverter;
import p2.spark.Conf;


/**
 *
 * @author markp
 */
public class JWT {
    
    private final static String SECRET_KEY = Conf.getJWT_Key();
     
    public static Boolean parseJWT(String jwt) {

        try{
            Claims claims = Jwts.parser()         
               .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
               .parseClaimsJws(jwt).getBody();
//            System.out.println("ID: " + claims.getId());
//            System.out.println("Subject: " + claims.getSubject());
//            System.out.println("Issuer: " + claims.getIssuer());
//            System.out.println("Expiration: " + claims.getExpiration());
        }
        catch(ExpiredJwtException | MalformedJwtException | SignatureException | UnsupportedJwtException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }
    
    public static String getUtenteFromJWT(String jwt) {
        Claims claims = Jwts.parser()         
           .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
           .parseClaimsJws(jwt).getBody();
        return claims.getIssuer();
    }
}
