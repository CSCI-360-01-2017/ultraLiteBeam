package com.csci360.alarmclock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author miki
 */
public class ClockController {
        
    Clock clock;
    
    public ClockController(AlarmController alarmController) {
        clock = new Clock(alarmController);
    }
    
    public String getCurrentTime() {
        return clock.getTime();
    }
    
}
