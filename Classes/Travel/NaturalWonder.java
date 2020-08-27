/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Travel;

/**
 * A travel destination that is a natural wonder
 * @author Carl
 */
public class NaturalWonder extends AbstractTravelDestination {
    /**
     * The type of appeal for this natural wonder (Coastal or hiking)
     */
    private String type;
    
    public NaturalWonder(String name, int travelPopularity, double rating, String country, 
            String continent, String type) {
        super(name, travelPopularity, rating, country, continent);
        this.type = type;
    }

    /**
     * Gets the type of this natural wonder
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the natural wonder
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }
}
