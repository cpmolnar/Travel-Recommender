/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Travel;

/**
 * A travel destination that is a landmark
 * @author Carl
 */
public class Landmark extends AbstractTravelDestination {
    /**
     * The type of landmark (Historical or Architectural)
     */
    private String type;
    
    public Landmark(String name, int travelPopularity, double rating, String country, 
            String continent, String type) {
        super(name, travelPopularity, rating, country, continent);
        this.type = type;
    }

    /**
     * Gets the type of landmark
     * @return the type of landmark
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of landmark
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
