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
public class theClock {

    
    Calendar currentTime;

    
    /*
    Clock which is synchronized to the system time
    */
    public void theClock() {
        currentTime = Calendar.getInstance();
    }
    
   public void adjustMinutes(int minutes) {
       currentTime.set(Calendar.MINUTE, minutes);
       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       System.out.println(sdf.format(currentTime.getTime()));
   }
    
   public void adjustHours(int hours){
       currentTime.set(Calendar.HOUR_OF_DAY, hours);
       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
       System.out.println(sdf.format(currentTime.getTime()));
   }
    
    /*
    Sets clock time to current system time
    */
    public void resetTime() {
        currentTime = Calendar.getInstance();
    }
    
    /*
    Returns the time stored in the clock
    */
    public Calendar getTime() {
        return currentTime;
    }
    
    /*
    Returns statement with the current time stored in the clock
    */
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(currentTime.getTime());
    }
    
}
