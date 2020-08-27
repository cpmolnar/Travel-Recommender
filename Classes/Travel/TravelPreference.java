/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Travel;

import java.util.Objects;

/**
 * This class stores travel preferences. But why? So that we can save 
 * the search query in memory to speed up searches.
 * @author Carl
 */
public class TravelPreference {
    private String country;
    private String continent;
    private int popularity;
    private double rating;

    public TravelPreference(String continent, String country, int popularity, double rating) {
        this.country = country;
        this.continent = continent;
        this.popularity = popularity;
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TravelPreference other = (TravelPreference) obj;
        if (this.popularity != other.popularity) {
            return false;
        }
        if (Double.doubleToLongBits(this.rating) != Double.doubleToLongBits(other.rating)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.continent, other.continent)) {
            return false;
        }
        return true;
    }
    
    
}
