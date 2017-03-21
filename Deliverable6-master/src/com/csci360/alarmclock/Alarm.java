/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author baldy
 */
public class Alarm {
    private String timeOfAlarm;
    
    //if false play radio
    //if true play default alarm
    private Boolean playStockAlert = true;
    
    
    private String getCurrentTime(){
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
        String text = currentTime.format(format);
        return text;
    }
    // Time must be in the following format 
    // H:M A 
    // Where H is any int between 1 & 12 inclusive
    // Where M is any int between 0 & 59
    // Where A is either AM or PM
    
    
    public String getTimeOfAlarm(){
        return timeOfAlarm;
    }
    
    public void setTimeOfAlarm(String t){
        if(isValidTime(t)){
            this.timeOfAlarm = t;
        }
        else
            System.out.println("Incorrect Time Format");
        
    }
    
    public Boolean willPlayAlarm(){
        return playStockAlert;
    }
    
    public void setStockAlert(Boolean pA){
        this.playStockAlert = pA;
    }
    
    public Boolean shouldSoundAlert(){
       return timeOfAlarm.equals(getCurrentTime());
    }
    
    public void soundAlert() {
        System.out.println("Wake me up inside");
    }
    
    public Boolean isValidTime(String time){
        String delims = "[: ]";
        String[] toke = time.split(delims);
        int h = Integer.parseInt(toke[0]);
        int m = Integer.parseInt(toke[2]);
        String a = toke[4];
        
        if((h>12)||(h<1)){
            return false;
        }
        else if((m>59)||(m<0)){
            return false;
        }
        else if( !a.equals("AM")||!a.equals("PM")){
            return false;
        }
        return true;
        
         
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
