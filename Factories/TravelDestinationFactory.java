/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import Classes.LinkedQueue;
import Classes.Travel.AbstractTravelDestination;
import Classes.Travel.City;
import Classes.Travel.Landmark;
import Classes.Travel.NaturalWonder;
import Interfaces.Queue;

/**
 * Factory class for generating TravelDestinations with preset info
 * @author Carl
 */
public class TravelDestinationFactory {
    /**
     * Generates 30 custom travel destinations
     * @return a queue containing the travel destinations
     */
    public static Queue<AbstractTravelDestination> GenerateTravelDestinations() {
        Queue<AbstractTravelDestination> destinationQueue = new LinkedQueue();
        
        destinationQueue.enqueue(new City("Charleston", 3, 4.3, "U.S.A.", "North America", 130113));
        destinationQueue.enqueue(new City("New Orleans", 5, 4.1, "U.S.A.", "North America", 391006));
        destinationQueue.enqueue(new City("Seoul", 9, 4.8, "South Korea", "Asia", 9776000));
        destinationQueue.enqueue(new City("Sydney", 7, 4.1, "Australia", "Oceania", 5230000));
        destinationQueue.enqueue(new City("Mexico City", 6, 3.9, "Mexico", "North America", 8855000));
        destinationQueue.enqueue(new City("Brasilia", 4, 3.2, "Brazil", "South America", 2481000));
        destinationQueue.enqueue(new City("Lima", 5, 2.9, "Peru", "South America", 268352));
        destinationQueue.enqueue(new City("London", 8, 4.7, "England", "Europe", 8982000));
        destinationQueue.enqueue(new City("Paris", 10, 4.9, "France", "Europe", 2148000));
        destinationQueue.enqueue(new City("Moscow", 7, 3.6, "Russia", "Asia", 11920000));
        
        destinationQueue.enqueue(new Landmark("Eiffel Tower", 3, 4.3, "France", "Europe", "Historical"));
        destinationQueue.enqueue(new Landmark("Great Wall of China", 5, 4.1, "China", "Asia", "Historical"));
        destinationQueue.enqueue(new Landmark("Grand Kremlin Palace", 9, 4.8, "Russia", "Asia", "Architecture"));
        destinationQueue.enqueue(new Landmark("Leaning Tower of Pisa", 7, 4.1, "Italy", "Europe", "Historical"));
        destinationQueue.enqueue(new Landmark("Great Pyramid of Giza", 6, 4.0, "Egypt", "Africa", "Historical"));
        destinationQueue.enqueue(new Landmark("Sydney Opera House", 4, 3.2, "Australia", "Oceania", "Architecture"));
        destinationQueue.enqueue(new Landmark("Statue of Liberty", 5, 2.9, "U.S.A.", "North America", "Historical"));
        destinationQueue.enqueue(new Landmark("Taj Mahal", 8, 4.7, "India", "Asia", "Architecture"));
        destinationQueue.enqueue(new Landmark("Moai on Easter Island", 10, 4.9, "Chile", "South America", "Historical"));
        destinationQueue.enqueue(new Landmark("Machu Picchu", 7, 3.6, "Peru", "South America", "Historical"));
        
        destinationQueue.enqueue(new NaturalWonder("Sahara Desert", 3, 2.0, "Libya", "Africa", "Hiking"));
        destinationQueue.enqueue(new NaturalWonder("Ha Long Bay", 5, 4.1, "Vietnam", "Asia", "Coastal"));
        destinationQueue.enqueue(new NaturalWonder("Mount Everest", 9, 4.8, "Nepal", "Asia", "Hiking"));
        destinationQueue.enqueue(new NaturalWonder("Great Barrier Reef", 7, 4.1, "Australia", "Oceania", "Coastal"));
        destinationQueue.enqueue(new NaturalWonder("Grand Canyon", 6, 3.9, "Arizona", "North America", "Hiking"));
        destinationQueue.enqueue(new NaturalWonder("Iguazu Falls", 4, 3.2, "Brazil", "South America", "Coastal"));
        destinationQueue.enqueue(new NaturalWonder("Amazon", 5, 2.9, "Brazil", "South America", "Hiking"));
        destinationQueue.enqueue(new NaturalWonder("Galapagos Islands", 8, 4.7, "Ecuador", "South America", "Coastal"));
        destinationQueue.enqueue(new NaturalWonder("Serengeti", 10, 3.0, "Tanzania", "Africa", "Hiking"));
        destinationQueue.enqueue(new NaturalWonder("Yosemite National Park", 7, 3.6, "U.S.A.", "North America", "Hiking"));
        
        return destinationQueue;
    }
}