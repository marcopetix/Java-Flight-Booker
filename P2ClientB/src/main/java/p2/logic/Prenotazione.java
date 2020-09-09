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
public class Prenotazione {
    
    private String origineNome;
    private String destinazioneNome;
    private String compagniaAerea;
    private String numeroVolo;
    private String orarioPartenza;
    private String agentePrenotazione;
    private String prezzo;
    private String utente;

    public Prenotazione(String origineNome, String destinazioneNome, String compagniaAerea, String numeroVolo, String orarioPartenza, String agentePrenotazione, String prezzo) {
        this.origineNome = origineNome;
        this.destinazioneNome = destinazioneNome;
        this.compagniaAerea = compagniaAerea;
        this.numeroVolo = numeroVolo;
        this.orarioPartenza = orarioPartenza;
        this.agentePrenotazione = agentePrenotazione;
        this.prezzo = prezzo;
    }

    public Prenotazione(String origineNome, String destinazioneNome, String compagniaAerea, String numeroVolo, String orarioPartenza, String agentePrenotazione, String prezzo, String utente) {
        this.origineNome = origineNome;
        this.destinazioneNome = destinazioneNome;
        this.compagniaAerea = compagniaAerea;
        this.numeroVolo = numeroVolo;
        this.orarioPartenza = orarioPartenza;
        this.agentePrenotazione = agentePrenotazione;
        this.prezzo = prezzo;
        this.utente = utente;
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

    public String getCompagniaAerea() {
        return compagniaAerea;
    }

    public void setCompagniaAerea(String compagniaAerea) {
        this.compagniaAerea = compagniaAerea;
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

    public String getAgentePrenotazione() {
        return agentePrenotazione;
    }

    public void setAgentePrenotazione(String agentePrenotazione) {
        this.agentePrenotazione = agentePrenotazione;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }


    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    @Override
    public String toString(){
        String text = "<html>";
        if(utente != null){
            text += "<font color'red'>" + getUtente() + "</font><br>   ";
        }
        text += "Volo " + getCompagniaAerea() + " N. " + getNumeroVolo() + " [ " + getOrigineNome() + " -> " + getDestinazioneNome() + " in partenza alle " + getOrarioPartenza() + "] <br>";
        text += "Prenotato tramite " + getAgentePrenotazione() + " per " + getPrezzo() + " \u20ac</html>";
        return text;
    }
    
}
