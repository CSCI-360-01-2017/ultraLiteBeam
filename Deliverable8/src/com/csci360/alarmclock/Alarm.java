/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 *
 * @author baldy
 */
public class Alarm {
    //private String timeOfAlarm;
    
    //if false play radio
    //if true play default alarm
    boolean alarmActive;
    private Boolean playStockAlert;
    Calendar currentTime;
    Calendar timeOfAlarm;
    SimpleDateFormat sdf;
    
    public Alarm() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        timeOfAlarm = Calendar.getInstance();
        timeOfAlarm.set(Calendar.MINUTE, 0);
        timeOfAlarm.set(Calendar.HOUR_OF_DAY, 0);
        playStockAlert = true;
        alarmActive = false;
        

    }
    
    
    
    /*
    public Calendar getTime() {
        return currentTime;
    }
    
    public String getTimeOfAlarm(){
        return timeOfAlarm;
    }
    
    public void setTimeOfAlarm(String t){
        
            this.timeOfAlarm = t;
       
    }
    */
    
    public void setAlarmMinutes(int minutes) {
        timeOfAlarm.set(Calendar.MINUTE, minutes);
    }
 
    public void setAlarmHours(int hours) {
        currentTime.set(Calendar.HOUR_OF_DAY, hours);
    }
    
    public int getAlarmHours() {
        return timeOfAlarm.get(Calendar.HOUR_OF_DAY);
    }
    
    public int getAlarmMinutes() {
        return timeOfAlarm.get(Calendar.MINUTE);
    }
    
    public String getAlarmTime() {
        return sdf.format(currentTime.getTime());
    }
    
    public void turnOn() {
        alarmActive = true;
    }
    
    public void turnOff() {
        alarmActive = false;
    }
    
    public boolean isActive() {
        return alarmActive;
    }
    
    // set whether alarm will be stock sound or radio
    public void setStockAlert(Boolean pA){
        this.playStockAlert = pA;
    }
    
    // whether alarm will play stock sound or radio
    // if true, stock sound, if false, radio
    public Boolean shouldSoundAlert(){
       return playStockAlert;
    }
    
    public void soundAlert() {
        System.out.println("Wake me up inside");
    }
    
    public String toString() {
        return sdf.format(timeOfAlarm.getTime());
    }
    
}
