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
public class Aeroporto {
    private String PlaceName;
    private String PlaceId;

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String PlaceName) {
        this.PlaceName = PlaceName;
    }

    public String getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(String PlaceId) {
        this.PlaceId = PlaceId;
    }
    
    @Override
    public String toString(){
        return PlaceName + ", " + PlaceId;
    }
}
