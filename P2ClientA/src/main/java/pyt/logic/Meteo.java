/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyt.logic;

/**
 *
 * @author markp
 */
class Meteo {
    private String luogo;
    private String descrizione;
    private String temp;
    private String temp_min;
    private String temp_max;
    
    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }
    
    @Override
    public String toString()
    {
        return "<html>" + luogo + ": " + descrizione + "<br>Temperatura: " + temp + " [Min: " + temp_min + ", Max: " + temp_max + "] </html>";
    }
    
}
