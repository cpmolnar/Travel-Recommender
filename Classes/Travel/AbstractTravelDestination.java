/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Travel;

/**
 * Abstract class for defining a travel destination.
 * @author Carl
 */
public abstract class AbstractTravelDestination {
    /**
     * The name of the travel destination
     */
    private String name;
    
    /**
     * The popularity score, which is supposed to be from 0 to 10
     */
    private int travelPopularity;
    
    /**
     * The user rating of this tourist destination, which is supposed to be from 0.0 to 5.0
     */
    private double rating;
    
    /**
     * The name of the country which this destination resides
     */
    private String country;
    
    /**
     * The name of the continent which this destination resides
     */
    private String continent;

    public AbstractTravelDestination(String name, int travelPopularity, double rating, String country, String continent) {
        this.name = name;
        this.travelPopularity = travelPopularity;
        this.rating = rating;
        this.country = country;
        this.continent = continent;
    }

    /**
     * Gets the name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the travel popularity
     * @return travel popularity
     */
    public int getTravelPopularity() {
        return travelPopularity;
    }

    /**
     * Sets the travel popularity
     * @param travelPopularity
     */
    public void setTravelPopularity(int travelPopularity) {
        this.travelPopularity = travelPopularity;
    }

    /**
     * Gets the user rating
     * @return user rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets the user rating
     * @param rating 
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the country
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country
     * @param country 
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the continent
     * @return continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets the continent
     * @param continent 
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Converts this object to String
     * @return string representation of object
     */
    @Override
    public String toString() {
        return "AbstractTravelDestination{" + "name=" + name + ", travelPopularity=" + travelPopularity + ", rating=" + rating + ", country=" + country + ", continent=" + continent + '}';
    }
}
