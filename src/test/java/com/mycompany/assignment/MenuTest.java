/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.assignment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

/**
 *
 * @author Akani Mbambo
 */
public class MenuTest {
    
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    /**
     * Stub of the Series class so Menu can compile & run.
     */
    public static class Series {
        public static void CaptureSeries() { System.out.println("CaptureSeries called"); }
        public static void SearchSeries() { System.out.println("SearchSeries called"); }
        public static void UpdateSeries() { System.out.println("UpdateSeries called"); }
        public static void DeleteSeries() { System.out.println("DeleteSeries called"); }
        public static void SeriesReport() { System.out.println("SeriesReport called"); }
        public static void ExitSeriesApplication() { 
            System.out.println("ExitSeriesApplication called"); 
            System.exit(0); // end program loop
        }
    }

    @Test
    void testMenuOption1CallsCaptureSeries() {
        String simulatedInput = "1\n6\n"; // user selects 1, then exits
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Run in a separate thread so System.exit(0) doesn't kill JUnit
        assertThrows(SecurityException.class, () -> {
            forbidSystemExit();
            new Menu().displayMenu();
        });

        String output = outContent.toString();
        assertTrue(output.contains("CaptureSeries called"));
    }

    @Test
    void testInvalidChoice() {
        String simulatedInput = "99\n6\n"; // invalid option, then exit
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        assertThrows(SecurityException.class, () -> {
            forbidSystemExit();
            new Menu().displayMenu();
        });

        String output = outContent.toString();
        assertTrue(output.contains("Invalid choice."));
    }

    /**
     * Prevent System.exit(0) from killing JUnit during tests.
     */
    private void forbidSystemExit() {
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(java.security.Permission perm) {
                if ("exitVM.0".equals(perm.getName())) {
                    throw new SecurityException("System.exit(0) not allowed during test");
                }
            }
        });
    }
    
}
