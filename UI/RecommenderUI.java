/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Classes.LinkedStack;
import Classes.Sort;
import Classes.Travel.AbstractTravelDestination;
import Classes.Travel.TravelPreference;
import Classes.UnsortedTableMap;
import Comparators.TravelDestinationAggregateComparator;
import Comparators.TravelDestinationComparator;
import Comparators.TravelDestinationContinentComparator;
import Comparators.TravelDestinationCountryComparator;
import Comparators.TravelDestinationPopularityComparator;
import Comparators.TravelDestinationRatingComparator;
import Factories.TravelDestinationFactory;
import Interfaces.Queue;
import Interfaces.Stack;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * The user interface for the Travel Recommender
 * @author Carl
 */
public class RecommenderUI {
    private UnsortedTableMap<TravelPreference, Queue<AbstractTravelDestination>> recommendationStore;
    private final Queue<AbstractTravelDestination> travelDestinations;
    
    private TravelDestinationComparator aggregateComp;
    
    private TravelPreference preference;
    
    public RecommenderUI() {
        recommendationStore = new UnsortedTableMap<>();
        travelDestinations = TravelDestinationFactory.GenerateTravelDestinations();
    }
    
    /**
     * The main menu where the user enters their travel preferences
     */
    public void MainMenu() {
        JTextField input_continent = new JTextField();
        JTextField input_country = new JTextField();
        JTextField input_popularity = new JTextField();
        JTextField input_rating = new JTextField();
        input_popularity.setText("0");
        input_rating.setText("0.0");
        
        Object[] message = {
            "<html>Please input some info about your travel interests.<br/>Skip the field to exclude from search.",
            "Preferred continent:", input_continent,
            "Preferred country:", input_country,
            "Preferred travel popularity (0 to 10):", input_popularity,
            "Preferred rating (0.0 to 5.0):", input_rating
        };
        int inputIndex = JOptionPane.showConfirmDialog(null, message, "Search", 
                JOptionPane.OK_CANCEL_OPTION);
        
        switch (inputIndex) {
            case 0:
                String continent = input_continent.getText();
                String country = input_country.getText();
                int popularity;
                double rating;
                // Try parsing the user input to int and double. If this fails, throw an exception.
                try {
                    popularity = Integer.parseInt(input_popularity.getText());
                    rating = Double.parseDouble(input_rating.getText());
                } catch(NumberFormatException e) {
                    System.out.println("Invalid popularity or rating input.");
                    break;
                } 
                preference = new TravelPreference(continent, country, popularity, rating); //Put everything in a new object
                aggregateComp = new TravelDestinationAggregateComparator(continent, country, popularity, rating); //Now the aggregate comparator is ready
                    
                Queue<AbstractTravelDestination> storeResult = recommendationStore.get(preference); //Check if preference is in the memory
                if (storeResult == null) { //If not, run a new sort
                    Stack compStack = new LinkedStack(); //This will contain only used comparators, and we can put in here from most useful to least, since it's a stack
                    if (!"".equals(continent))
                        compStack.push(new TravelDestinationContinentComparator(continent));
                    if (!"".equals(country))
                        compStack.push(new TravelDestinationCountryComparator(country));
                    if (popularity != 0)
                        compStack.push(new TravelDestinationPopularityComparator(popularity));
                    if (rating != 0.0)
                        compStack.push(new TravelDestinationRatingComparator(rating));

                    Sort.multikeySort(travelDestinations, compStack);//Runs quick sort across all comps
                    recommendationStore.put(preference, travelDestinations);//Plops it in the memory map
                    ResultsList(travelDestinations);
                } else {
                    ResultsList(storeResult);
                }
                break;
            case 1:
                System.exit(0);
                break;
            default:
                System.exit(0);
                break;
        }
    }
    
    /**
     * Lists the results of the search
     * @param results the sorted results to display
     */
    public void ResultsList(Queue<AbstractTravelDestination> results) {
        JFrame frame = new JFrame("Search Results (In Order)");
        
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.dispose();
                MainMenu();
            }
        });
        
        AbstractTravelDestination[] unpackedResults = new AbstractTravelDestination[results.size()];
        int size = results.size();
        for (int i = 0; i < size; i++) {
            unpackedResults[i] = results.dequeue();
            results.enqueue(unpackedResults[i]);
        }
        
        frame.setLayout(new GridLayout(1,2));
        Container listPane = new JPanel();
        Container resultsPane = new JPanel();
        frame.getContentPane().add(listPane, BorderLayout.WEST);
        frame.getContentPane().add(resultsPane, BorderLayout.EAST);

        JLabel resultsLabel = new JLabel();
        resultsPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        resultsPane.add(resultsLabel);
        
        JList jlist = new JList(unpackedResults);
        CellRenderer cr = new CellRenderer();
        jlist.setCellRenderer(cr);
        JScrollPane scrollPane1 = new JScrollPane(jlist);
        listPane.add(scrollPane1, BorderLayout.WEST);

        /**
         * Displays in results window
         */
        ListSelectionListener listSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                AbstractTravelDestination selected = (AbstractTravelDestination)jlist.getSelectedValue();
                resultsLabel.setText(String.format("<html>%s<br/>%s, %s<br/>Rating: %.1f / 5<br/>Popularity: %d / 10<br/>Type: %s</html>", 
                    selected.getName(),
                    selected.getCountry(),
                    selected.getContinent(), 
                    selected.getRating(), 
                    selected.getTravelPopularity(),
                    selected.getClass().getSimpleName()
                ));
            }
        };
        jlist.addListSelectionListener(listSelectionListener);
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * This is to display the JList in an acceptable way
     */
    public class CellRenderer extends DefaultListCellRenderer {
        /** Creates a new instance of LocaleRenderer */   
        public CellRenderer(){   } 
        @Override
        public Component getListCellRendererComponent(JList list,
        Object value, int index, boolean isSelected, 
        boolean cellHasFocus) { 
            super.getListCellRendererComponent(list, value,index,isSelected,cellHasFocus);  
            AbstractTravelDestination l = (AbstractTravelDestination)value; 
            setText(String.format("%s (%s match)", l.getName(), NumberFormat.getPercentInstance().format(aggregateComp.similarity(l))));  
            return this;   
        } 
    }
}
