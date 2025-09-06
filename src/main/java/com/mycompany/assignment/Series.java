/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment;

/**
 *
 * @author Akani Mbambo
 */

import java.util.ArrayList;
import java.util.*;

public class Series {
    
    //Shared list to store all series objects
    public static ArrayList<Series>seriesList = new ArrayList<>();

    //field for each series
    private String SeriesId;
    private String SeriesName;
    private String SeriesAge;
    private String SeriesNumberOfEpisodes;

    //Constructor for creating a series object
    public Series(String id, String name, String age, String episodes){
        this.SeriesId = id;
        this.SeriesAge = age;
        this.SeriesName = name;
        this.SeriesNumberOfEpisodes = episodes;
        
    }
    
    public String getSeriesId(){
        return SeriesId;
    }
    // Capture a new series
    public static void CaptureSeries(){
        Scanner series = new Scanner(System.in);
        
        System.out.println("********************************************");
        
        System.out.print("enter series ID: ");
        String id = series.nextLine().trim();
        
        System.out.print("enter series name: ");
        String name = series.nextLine().trim();
        
        System.out.print("Enter age restriction: ");
        String age = series.nextLine().trim();
        
        System.out.print("Enter number of episodes: ");
        String episodes = series.nextLine().trim();
        
        System.out.println("********************************************");
        
        seriesList.add(new Series(id, name, age, episodes));
        System.out.println("Series added successfully.");
    }
    
    // Search for a series
    public static void SearchSeries(){
        
        Scanner series = new Scanner(System.in);
        
        System.out.println("********************************************");
        
        System.out.println("Enter series ID to search: ");
        String id = series.nextLine().trim();
        
        System.out.println("------------------------------------------------");
        for (Series s : seriesList){
            if (s.SeriesId.equalsIgnoreCase(id)){
                System.out.println(s);
                return;
            }
            System.out.println("------------------------------------------------");
        }
        System.out.println("------------------------------------------------");
        System.out.println("series not found.");
        System.out.println("------------------------------------------------");
    }
    
    //Update a series
    public static void UpdateSeries(){
        Scanner series = new Scanner(System.in);
        
        System.out.println("********************************************");
        
        System.out.print("Enter series ID to update: ");
        String id = series.nextLine().trim();
        
        //
        for(Series s : seriesList){
            if (s.SeriesId.equalsIgnoreCase(id)){
                System.out.println("Enter new name orleave blank to keep current:");
                String name = series.nextLine().trim();
                if(!name.isEmpty())s.SeriesName = name;
                
                System.out.println("Enter new age restriction or leave blank to keep current:");
                String age = series.nextLine().trim();
                if(!age.isEmpty())s.SeriesAge = age;
                
                System.out.println("Enter new number of episodes or leave blank to keep current:");
                String episodes = series.nextLine().trim();
                if(!episodes.isEmpty())s.SeriesNumberOfEpisodes = episodes;
                
                System.out.println("********************************************");
                
                System.out.println("Series updated successfullly.");
                return;
            }
        }
        System.out.println("Series not found.");
    }
    
    //Delete a series
    public static void DeleteSeries(){
        Scanner series = new Scanner(System.in);
        
        System.out.println("********************************************");
        
        System.out.println("Enter series ID to delete: ");
        String id = series.nextLine().trim();
        
        Series toDelete= null;
        for (Series s : Series.seriesList){
            if (s.getSeriesId().equalsIgnoreCase(id)){
                toDelete = s;
                break;
            }
        }
        if (toDelete != null){
            seriesList.remove(toDelete);
            System.out.println("Series deleted.");
        }
        else {
            System.out.println("Series not found.");
        }
    }
    
    //Print series report
    public static void SeriesReport() {
        System.out.println("--- Series Report ---");
        
        //for
        for(Series s : seriesList){
            System.out.println(s);
            System.out.println("------------------------------------------------");
        }
    }
    
    //exit application
    public static void ExitSeriesApplication(){
        System.out.println("Exiting the application...");
        System.exit(0);
    }
    
     @Override
                        public String toString(){
                            return "ID: " + SeriesId + "\nName: " + SeriesName + "\nAge Restriction: " + SeriesAge + "\nNumber of Episodes: " + SeriesNumberOfEpisodes;
                        }
}
