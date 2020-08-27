/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Classes.StringSimilarity;
import Classes.Travel.AbstractTravelDestination;

/**
 * Class containing comparator for Country
 * @author Carl
 */
public class TravelDestinationCountryComparator extends TravelDestinationComparator {
    private String country;
    public TravelDestinationCountryComparator() {};
    public TravelDestinationCountryComparator(String country) {
        this.country = country;
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        AbstractTravelDestination e1 = (AbstractTravelDestination)o1;
        AbstractTravelDestination e2 = (AbstractTravelDestination)o2;
        return e1.getCountry().compareTo(e2.getCountry());
    }
    
    /**
     * Runs our cool algorithm for calculating similarity of two strings.
     * @param o2 the object to compare with
     * @return The similarity of the strings (0.0 to 1.0)
     */
    @Override
    public double similarity(Object o2) {
        AbstractTravelDestination e2 = (AbstractTravelDestination)o2;
        return StringSimilarity.similarity(country, e2.getCountry());
    } 
}
