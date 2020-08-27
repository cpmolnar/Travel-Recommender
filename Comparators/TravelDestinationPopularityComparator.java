/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Classes.Travel.AbstractTravelDestination;

/**
 * Class containing comparator for Popularity
 * @author Carl
 */
public class TravelDestinationPopularityComparator extends TravelDestinationComparator {
    private int popularity;
    public TravelDestinationPopularityComparator() {};
    public TravelDestinationPopularityComparator(int popularity) {
        this.popularity = popularity;
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        AbstractTravelDestination e1 = (AbstractTravelDestination)o1;
        AbstractTravelDestination e2 = (AbstractTravelDestination)o2;
        return e1.getTravelPopularity() - e2.getTravelPopularity();
    }
    
    /**
     * Custom algorithm to (very) roughly compute the similarity of two popularities
     * @param o2 the object to compare popularities with
     * @return the similarity of the popularities (0.0 to 1.0)
     */
    @Override
    public double similarity(Object o2) {
        AbstractTravelDestination e2 = (AbstractTravelDestination)o2;
        double abs = Math.abs(popularity - e2.getTravelPopularity()); // I wanted larger and smaller numbers to have the same direction
        // Normalize to fall within 0 and 1 using Sigmoid function, note that sigmoid 
        // approaches 0.5 for small positive numbers so I added 0.5, 
        // can't remember the alg that goes 0 to 1 actually... so this is notably scuffed in that regard
        return 0.5+(1 / (1 + Math.pow(Math.E, abs))); 
    }
}
