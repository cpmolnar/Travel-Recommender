/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clients;

import UI.RecommenderUI;

/**
 * The client to run the UI.
 * @author Carl
 */
public class RecommenderClient {
    public static void main(String[] args) {
        RecommenderUI ui = new RecommenderUI();
        ui.MainMenu();
    }
}
