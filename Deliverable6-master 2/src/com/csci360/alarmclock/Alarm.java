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
    private String timeOfAlarm;
    
    //if false play radio
    //if true play default alarm
    private Boolean playStockAlert = true;
    Calendar currentTime;
    
    
    public Calendar getTime() {
        return currentTime;
    }
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(currentTime.getTime());
    }
    
    
    public String getTimeOfAlarm(){
        return timeOfAlarm;
    }
    
    public void setTimeOfAlarm(String t){
        
            this.timeOfAlarm = t;
       
    }
    
    public Boolean willPlayAlarm(){
        return playStockAlert;
    }
    
    public void setStockAlert(Boolean pA){
        this.playStockAlert = pA;
    }
    
    public Boolean shouldSoundAlert(){
       return playStockAlert;
    }
    
    public void soundAlert() {
        System.out.println("Wake me up inside");
    }
    

       public static void main(String[] args) {
        
        //String dateOut;
        //dateOut = LocalDateTime.now().format(format);
//        LocalDateTime timeUnf = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
//        LocalDateTime time = LocalDateTime.parse(timeUnf, formatter);
        //System.out.println(dateOut);
//System.out.println(LocalDateTime.now().ofLocalizedTime());
        // TODO code application logic here
        String input =  "11:33 p";
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
        LocalTime time = LocalTime.parse(input, format);
        System.out.println(time);
        

    }
    
}
