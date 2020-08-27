/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Travel;

/**
 * A travel destination that is a City
 * @author Carl
 */
public class City extends AbstractTravelDestination {
    /**
     * The population of the city, I suppose some people would prefer
     * larger or smaller cities!
     */
    private int population;
    
    public City(String name, int travelPopularity, double rating, String country, 
            String continent, int population) {
        super(name, travelPopularity, rating, country, continent);
        this.population = population;
    }

    /**
     * Gets the population of the city
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets the population of the city
     * @param population 
     */
    public void setPopulation(int population) {
        this.population = population;
    }
}
