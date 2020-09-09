/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2.logic;

/**
 *
 * @author markp
 */
public class Utente {
    String username;
    String totale_spesa;

    public Utente(String username, String totale_spesa) {
        this.username = username;
        this.totale_spesa = totale_spesa;
    }

    public String getTotale_spesa() {
        return totale_spesa;
    }

    public void setTotale_spesa(String totale_spesa) {
        this.totale_spesa = totale_spesa;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Override
    public String toString(){
        String text = "<html>" + getUsername();
        if(Float.parseFloat(totale_spesa) > 500){
            text += " ( <font color='green'>" + getTotale_spesa() + " \u20ac</font> )";
        }else{
            text += " ( " + getTotale_spesa() + " \u20ac )";
        }
        return text;
    }

}
