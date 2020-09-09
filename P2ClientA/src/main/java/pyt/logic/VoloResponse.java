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
public class VoloResponse {
    private String compagniaAerea;
    private String agentePrenotazione;
    private String numeroVolo;
    private String orarioPartenza;
    private String prezzo;
    private String origineNome;
    private String destinazioneNome;
    private String bookingUrl;
    private String data;
    private String passeggeri;

    public VoloResponse(String compagniaAerea, String agentePrenotazione, String numeroVolo, String orarioPartenza, String prezzo, String origineNome, String destinazioneNome, String bookingUrl) {
        this.compagniaAerea = compagniaAerea;
        this.agentePrenotazione = agentePrenotazione;
        this.numeroVolo = numeroVolo;
        this.orarioPartenza = orarioPartenza;
        this.prezzo = prezzo;
        this.origineNome = origineNome;
        this.destinazioneNome = destinazioneNome;
        this.bookingUrl = bookingUrl;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPasseggeri() {
        return passeggeri;
    }

    public void setPasseggeri(String passeggeri) {
        this.passeggeri = passeggeri;
    }
    
    public String getCompagniaAerea() {
        return compagniaAerea;
    }

    public void setCompagniaAerea(String compagniaAerea) {
        this.compagniaAerea = compagniaAerea;
    }

    public String getAgentePrenotazione() {
        return agentePrenotazione;
    }

    public void setAgentePrenotazione(String agentePrenotazione) {
        this.agentePrenotazione = agentePrenotazione;
    }

    public String getNumeroVolo() {
        return numeroVolo;
    }

    public void setNumeroVolo(String numeroVolo) {
        this.numeroVolo = numeroVolo;
    }

    public String getOrarioPartenza() {
        return orarioPartenza;
    }

    public void setOrarioPartenza(String orarioPartenza) {
        this.orarioPartenza = orarioPartenza;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public String getOrigineNome() {
        return origineNome;
    }

    public void setOrigineNome(String origineNome) {
        this.origineNome = origineNome;
    }

    public String getDestinazioneNome() {
        return destinazioneNome;
    }

    public void setDestinazioneNome(String destinazioneNome) {
        this.destinazioneNome = destinazioneNome;
    }

    public String getBookingUrl() {
        return bookingUrl;
    }

    public void setBookingUrl(String bookingUrl) {
        this.bookingUrl = bookingUrl;
    }
    
    
    
    @Override
    public String toString(){
        String text = "<html><b>" + getCompagniaAerea() + "</b> - Volo N. " + getNumeroVolo() + "<br/>Data: " + getOrarioPartenza();
        text += "<br/>Partenza: " + getOrigineNome() + " -  Arrivo: " + getDestinazioneNome() + "<br/></html>";
        return text;
    }
}
