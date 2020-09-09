/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.spark;

/**
 *
 * @author markp
 */
public class Coordinate {
    private String latitudine;
    private String longitudine;

    public Coordinate(String latitudine, String longitudine) {
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }
    
    
}
