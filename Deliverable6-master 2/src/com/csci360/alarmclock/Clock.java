package com.csci360.alarmclock;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

/**
 *
 * @author Miki
 */
public class Clock {

    
    Calendar currentTime;
    Timer timer;
    SimpleDateFormat sdf;

    
    /*
    Clock which is synchronized to the system time
    */
    public Clock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        currentTime = Calendar.getInstance();
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                currentTime.set(Calendar.SECOND, (currentTime.get(Calendar.SECOND) + 5));
            }
        }, 5*1000, 5*1000);
    }
    
    /*
    Sets clock time to current system time
    */
    public void resetTime() {
        currentTime = Calendar.getInstance();
    }
    

    public void setMinutes(int minutes) {
        currentTime.set(Calendar.MINUTE, minutes);
        currentTime.getTime();
    }
    
    public void setHours(int hours) {
        currentTime.set(Calendar.HOUR_OF_DAY, hours);
        currentTime.getTime();
    }
    

    /*
    Returns the time stored in the clock
    */
    public int getHours() {
        return currentTime.get(Calendar.HOUR_OF_DAY);
    }
    
    public int getMinutes() {
        return currentTime.get(Calendar.MINUTE);
    }
    
    public String getTime() {
        return sdf.format(currentTime.getTime());

    
    /*
    Returns statement with the current time stored in the clock
    */
    public String toString() {

        return "The current time is " + sdf.format(currentTime.getTime());

    }
    
}
