/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment;

import java.util.*;

/**
 *
 * @author Akani Mbambo
 */
public class Assignment {

    public static void main(String[] args) {
        
        Scanner menu = new Scanner(System.in);
        
        System.out.println("______________________________________________________________________________________________________________________________________________________________________");
        
        System.out.println(" LATEST SERIES - 2025 ");
        System.out.println (" **********************************************************************");
        System.out.print (" Enter (1) to lanch menu or any other key to exit ");
        String input = menu.nextLine();
        if (input.equals("1")){
            // get menu fuction
            System.out.println(" Starting menu ...");
            
            //Creating a Menu class
            Menu ObjLogin = new Menu();
            ObjLogin.displayMenu();
        }
        else{
            System.out.println(" Ending program.");
            System.out.println(" Good bye :)");
            
    }
    }
}
