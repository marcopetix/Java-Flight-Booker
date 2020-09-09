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
public class VoloRequest {

    String origineNome;
    String origineId;
    String destinazioneNome;
    String destinazioneId;
    String passeggeri;
    String data; 
    
    public VoloRequest(String origineId, String origineNome, String destinazioneId, String destinazioneNome, String data, String passeggeri) {
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

}
