package com.csci360.alarmclock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author miki
 */
public class ClockController {
        
    Clock clock;
    
    public ClockController() {
        clock = new Clock();
    }
    
    public void incrementMinutes() {
        clock.setMinutes(clock.getMinutes() + 1);
    }
    
    public void incrementHours() {
        clock.setHours(clock.getHours() + 1);
    }
    
    public void decrementMinutes() {
        clock.setMinutes(clock.getMinutes() - 1);
    }
    
    public void decrementHours() {
        clock.setHours(clock.getHours() - 1);
    }
    
    public String getCurrentTime() {
        return clock.getTime();
    }
    
}
