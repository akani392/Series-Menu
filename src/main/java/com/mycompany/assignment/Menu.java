/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

import java.util.*;

/**
 *
 * @author Akani Mbambo
 */
public class Menu {
    
    public Menu (){
        
    }
    
    public void displayMenu(){
        Scanner series = new Scanner(System.in);
        
        //
        while(true){
            System.out.println("\nPlease select 1 of the menu options");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");
            
            String choice = series.nextLine();
            
            //
            switch (choice){
                case "1": Series.CaptureSeries();
                break;
                case "2": Series.SearchSeries();
                break;
                case "3": Series.UpdateSeries();
                break;
                case "4": Series.DeleteSeries();
                break;
                case "5": Series.SeriesReport();
                break;
                case "6": Series.ExitSeriesApplication();
                break;
                
                default: System.out.println("Invalid choice.");
        }
        }
    }
   
}   
    
    
    
    

