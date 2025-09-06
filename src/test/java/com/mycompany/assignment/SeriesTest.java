/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.assignment;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Akani Mbambo
 */
public class SeriesTest {
    
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Series.seriesList.clear(); // reset list before each test
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testCaptureSeriesAddsToList() {
        String simulatedInput = "S1\nBreaking Bad\n18+\n62\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Series.CaptureSeries();

        assertEquals(1, Series.seriesList.size());
        assertEquals("S1", Series.seriesList.get(0).getSeriesId());
        assertTrue(outContent.toString().contains("Series added successfully."));
    }

    @Test
    void testSearchSeriesFound() {
        Series.seriesList.add(new Series("S2", "Dark", "16+", "26"));

        String simulatedInput = "S2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Series.SearchSeries();

        String output = outContent.toString();
        assertTrue(output.contains("S2"));
        assertFalse(output.contains("series not found."));
    }

    @Test
    void testSearchSeriesNotFound() {
        String simulatedInput = "S99\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Series.SearchSeries();

        assertTrue(outContent.toString().contains("series not found."));
    }

    @Test
    void testUpdateSeriesUpdatesValues() {
        Series.seriesList.add(new Series("S3", "OldName", "12+", "10"));

        String simulatedInput = "S3\nNewName\n18+\n15\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Series.UpdateSeries();

        Series updated = Series.seriesList.get(0);
        assertEquals("NewName", updated.toString()); // toString contains new name
        assertTrue(outContent.toString().contains("Series updated successfullly."));
    }

    @Test
    void testUpdateSeriesNotFound() {
        String simulatedInput = "S404\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Series.UpdateSeries();

        assertTrue(outContent.toString().contains("Series not found."));
    }

    @Test
    void testDeleteSeriesRemovesFromList() {
        Series.seriesList.add(new Series("S4", "Peaky Blinders", "18+", "36"));

        String simulatedInput = "S4\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Series.DeleteSeries();

        assertEquals(0, Series.seriesList.size());
        assertTrue(outContent.toString().contains("Series deleted."));
    }

    @Test
    void testDeleteSeriesNotFound() {
        String simulatedInput = "S100\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Series.DeleteSeries();

        assertTrue(outContent.toString().contains("Series not found."));
    }

    @Test
    void testSeriesReportPrintsAll() {
        Series.seriesList.add(new Series("S5", "Friends", "13+", "200"));

        Series.SeriesReport();

        String output = outContent.toString();
        assertTrue(output.contains("Friends"));
        assertTrue(output.contains("--- Series Report ---"));
    }

    @Test
    void testExitSeriesApplicationThrowsSecurityException() {
        // Prevent System.exit from killing JUnit
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(java.security.Permission perm) {
                if (perm.getName().startsWith("exitVM")) {
                    throw new SecurityException("System.exit not allowed");
                }
            }
        });

        assertThrows(SecurityException.class, Series::ExitSeriesApplication);

        System.setSecurityManager(null); // restore normal security
    }
    
}
