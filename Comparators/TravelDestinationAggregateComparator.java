/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Classes.Travel.AbstractTravelDestination;

/**
 * This is a class that aggregates the other comparators to make a complex similarity algorithm.
 * Using this class, we can find the similarity of AbstractTravelDestinations across all their fields!
 * @author Carl
 */
public class TravelDestinationAggregateComparator extends TravelDestinationComparator {
    private TravelDestinationContinentComparator continentComparator;
    private TravelDestinationCountryComparator countryComparator;
    private TravelDestinationPopularityComparator popularityComparator;
    private TravelDestinationRatingComparator ratingComparator;
    
    public TravelDestinationAggregateComparator() {};
    public TravelDestinationAggregateComparator(String continent, String country, int popularity, double rating) {
        // Note that all unused fields are NOT initialized
        if (!"".equals(continent))
            continentComparator=new TravelDestinationContinentComparator(continent);
        if (!"".equals(country))
            countryComparator=new TravelDestinationCountryComparator(country);
        if (popularity != 0)
            popularityComparator=new TravelDestinationPopularityComparator(popularity);
        if (rating != 0.0)
            ratingComparator=new TravelDestinationRatingComparator(rating);
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        AbstractTravelDestination e1 = (AbstractTravelDestination)o1;
        AbstractTravelDestination e2 = (AbstractTravelDestination)o2;
        return e1.getCountry().compareTo(e2.getCountry());
    }

    /**
     * Computes the similarity of two AbstractTravelDestinations across multiple fields.
     * I came up with this algorithm. It's not perfect but works ok!
     * @param o2 the object to compare
     * @return The similarity value from 0.0 to 1.0
     */
    @Override
    public double similarity(Object o2) {
        double quotient = 0.0; //The quotient is used to weigh only used fields
        
        //Note that all unused fields will be factored out
        double continentSimilarity = 0.0;
        double countrySimilarity = 0.0;
        double popularitySimilarity = 0.0;
        double ratingSimilarity = 0.0;
        
        //Factor out all unused fields
        if (continentComparator != null) {
            continentSimilarity = continentComparator.similarity(o2);
            quotient += .6;
        }
        if (countryComparator != null) {
            countrySimilarity = countryComparator.similarity(o2);
            quotient += .2;
        }
        if (popularityComparator != null){
            popularitySimilarity = popularityComparator.similarity(o2);
            quotient += .1;
        }
        if (ratingComparator != null){
            ratingSimilarity = ratingComparator.similarity(o2);
            quotient += .1;
        }
        
        //Adds some default weights to fields relative to their importance in my opinion.
        return (((.6)*continentSimilarity) + ((.2)*countrySimilarity) + ((.1)*popularitySimilarity) + ((.1)*ratingSimilarity))/quotient;
    } 
}
