/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

/**
 *
 * @author baldy
 */
public class AlarmController {
    Alarm alarm = new Alarm();
    
    public String getAlarmTime(){
        return alarm.getTimeOfAlarm();
    }
    
    public void setAlarmTime(String time){
        alarm.setTimeOfAlarm(time);
    }
    
    public boolean isStockAlarm(){
        return alarm.shouldSoundAlert();
    }
    
    public void setStockAlarm(boolean b){
        alarm.setStockAlert(b);
    }
    
    public void soundAlert(){
        alarm.soundAlert();
    }
    
    
    
    
}
