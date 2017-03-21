/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.csci360.alarmclock.RadioController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author benjaminmuldrow
 */
public class RadioTest {

    private RadioController radioController;

    public RadioTest() {
    }

    @Before
    public void setUp() {
        // create a RadioController with valid Radio params
        this.radioController = new RadioController(1.0, 89.9, "fm");
    }

    @After
    public void tearDown() {
        this.radioController.stop();
    }

    @Test
    public void testVolume() {

        // Test Invalid Volume
        this.radioController.setVolume(99);
        assertEquals("Invalid volume must be rejected and replaced"
                    +"with default or last valid entry",
                    1.0, this.radioController.getVolume(), 0.01);

        // Test Valid Volume
        this.radioController.setVolume(0.8);
        assertEquals("Valid volume should be set", 0.8,
                    this.radioController.getVolume(), 0.01);
    }

    @Test
    public void testFrequency() {

        // Test Invalid Frequency according to tuning
        this.radioController.setFrequency(1000);
        assertEquals("Invalid frequency for FM tuning",
                    89.9, this.radioController.getFrequency(), 0.01);

        // Test toggle tuning
        this.radioController.toggleTuning();
        assertTrue("Tuning toggle should change the tuning string",
                    this.radioController.getTuning().equals("am"));

        // Test valid frequency according to tuning
        this.radioController.setFrequency(1000);
        assertEquals("Setting a valid frequency according to tuning",
                    1000, this.radioController.getFrequency(), 0.01);

    }
}
