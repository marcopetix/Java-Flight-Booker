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
public class VoloRequest {

    private String origineNome;
    private String origineId;
    private String destinazioneNome;
    private String destinazioneId;
    private String passeggeri;
    private String data; 
    private String utente;

    public VoloRequest(String origineNome, String origineId, String destinazioneNome, String destinazioneId, String passeggeri, String data, String utente) {
        this.origineNome = origineNome;
        this.origineId = origineId;
        this.destinazioneNome = destinazioneNome;
        this.destinazioneId = destinazioneId;
        this.passeggeri = passeggeri;
        this.data = data;
        this.utente = utente;
    }
    
    public VoloRequest(String origineNome, String origineId, String destinazioneNome, String destinazioneId, String passeggeri, String data) {
        this.origineNome = origineNome;
        this.origineId = origineId;
        this.destinazioneNome = destinazioneNome;
        this.destinazioneId = destinazioneId;
        this.passeggeri = passeggeri;
        this.data = data;
    }
    
    public VoloRequest(String origineNome, String destinazioneNome) {
        this.origineNome = origineNome;
        this.destinazioneNome = destinazioneNome;
    }

    public String getOrigineNome() {
        return origineNome;
    }

    public void setOrigineNome(String origineNome) {
        this.origineNome = origineNome;
    }

    public String getOrigineId() {
        return origineId;
    }

    public void setOrigineId(String origineId) {
        this.origineId = origineId;
    }

    public String getDestinazioneNome() {
        return destinazioneNome;
    }

    public void setDestinazioneNome(String destinazioneNome) {
        this.destinazioneNome = destinazioneNome;
    }

    public String getDestinazioneId() {
        return destinazioneId;
    }

    public void setDestinazioneId(String destinazioneId) {
        this.destinazioneId = destinazioneId;
    }

    public String getPasseggeri() {
        return passeggeri;
    }

    public void setPasseggeri(String passeggeri) {
        this.passeggeri = passeggeri;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

}