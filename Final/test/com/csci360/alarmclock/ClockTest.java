package com.csci360.alarmclock;

import com.csci360.alarmclock.RadioController;
import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author Miki
 */
public class ClockTest {
    
    private Clock myClock;
    
    public ClockTest() {
    }
 
    
    @Before
    public void setUp() {
        this.myClock = new Clock(new AlarmController());
    }
    
    @After
    public void tearDown() {
        this.myClock = null;
    }

    /**
     * Test of theClock method, of class theClock.
     */
    @Test
    public void testTheClock() {
        //
    }
}

    /**
     * Test of adjustMinutes method, of class theClock.
     *
    @Test
    public void testAdjustMinutes() {
        System.out.println("This should reset clock to 1 minute past the current hour");
         this.myClock.resetTime();
         this.myClock.adjustMinutes(1);
         Calendar test = myClock.getTime();
         int minutes = test.get(Calendar.MINUTE);
         assertEquals(1, minutes);
    }

    /**
     * Test of adjustHours method, of class theClock.
     *
    @Test
    public void testAdjustHours() {
        System.out.println("This should reset clock to 1AM, keeping current minutes");
         this.myClock.resetTime();
         this.myClock.adjustHours(1);
         Calendar test = myClock.getTime();
         int hours = test.get(Calendar.HOUR_OF_DAY);
         assertEquals(1, hours);
    }
    * 
    /**
     * Test of resetTime method, of class theClock.
     *
    @Test
    public void testResetTime() {
        this.myClock.resetTime();
        Calendar setTime = this.myClock.getTime();
        assertEquals(Calendar.getInstance(), setTime);
    }
    */