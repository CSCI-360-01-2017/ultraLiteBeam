/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author benjaminmuldrow
 */
public class Time {
    
    public int hours = 0;
    public int minutes = 0;
    public int seconds = 0;
    
    /**
     * Time constructor. Validity checking will be handled by controllers.
     * @param hours
     * @param minutes
     * @param seconds 
     */
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    
    public String toString() {
        return this.hours + ":" + this.minutes + ":" + this.seconds;
    }
    
    public static Time fromString(String timeString) {
        String[] timeComponents = timeString.split(":");   
        int hours = Integer.parseInt(timeComponents[0]);
        int minutes = Integer.parseInt(timeComponents[1]);
        int seconds = Integer.parseInt(timeComponents[2]);
        return new Time(hours, minutes, seconds);
    }
    
    /**
     * Compares two Time instances
     * @param time1
     * @param time2
     * @return if they indicate the same times
     */
    public static boolean areEqual(Time time1, Time time2) {
        return (
            time1.hours == time2.hours &&
            time1.minutes == time2.minutes &&
            time1.seconds == time2.seconds
        );
    }
    
    /**
     * parses Calendar time as a Time instance
     * Validity checking is inherent to Calendar class
     * @return 
     */
    public static Time getCalendarTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timeString = sdf.format(Calendar.getInstance().getTime());
        String[] timeComponents = timeString.split(":");   
        int hours = Integer.parseInt(timeComponents[0]);
        int minutes = Integer.parseInt(timeComponents[1]);
        int seconds = Integer.parseInt(timeComponents[2]);
        return new Time(hours,minutes,seconds);
    }
    
}
