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
        if (clock.getMinutes() == 59) {
            clock.setMinutes(0);
        } else {
            clock.setMinutes(clock.getMinutes() + 1);
        }
    }
    
    public void incrementHours() {
        if (clock.getHours() == 23) {
            clock.setHours(0);
        } else {
            clock.setHours(clock.getHours() + 1);
        }
    }
    
    public void decrementMinutes() {
        if (clock.getMinutes() == 0) {
            clock.setMinutes(59);
        } else {
        clock.setMinutes(clock.getMinutes() - 1);
        }
    }
    
    public void decrementHours() {
        if (clock.getHours() == 0) {
            clock.setHours(23);
        } else {
            clock.setHours(clock.getHours() - 1);
        }
    }
    
    public String getCurrentTime() {
        return clock.getTime();
    }
    
}
