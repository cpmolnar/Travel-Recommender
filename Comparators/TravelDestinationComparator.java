/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import java.util.Comparator;

/**
 * Abstract class for defining the similarity function
 * @author Carl
 */
public abstract class TravelDestinationComparator implements Comparator {
    public abstract double similarity(Object o2);
}
