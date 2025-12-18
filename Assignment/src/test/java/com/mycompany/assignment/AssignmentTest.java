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
public class AssignmentTest {
    
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

    @Test
    void testProgramExitsWhenNotEntering1() {
        String simulatedInput = "x\n"; // user enters x instead of 1
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Assignment.main(new String[]{}); // run main

        String output = outContent.toString();
        assertTrue(output.contains("Ending program."));
        assertTrue(output.contains("Good bye :)"));
    }

    @Test
    void testProgramLaunchesMenuWhenEntering1() {
        String simulatedInput = "1\n"; // user enters 1
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Assignment.main(new String[]{}); // run main

        String output = outContent.toString();
        assertTrue(output.contains("Starting menu ..."));
    }
    
}
