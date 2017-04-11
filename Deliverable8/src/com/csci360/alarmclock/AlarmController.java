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
        return alarm.getAlarmTime();
    }
    
    public void incrementMinutes() {
        if (alarm.getAlarmMinutes() == 59) {
            alarm.setAlarmMinutes(0);
        } else {
            alarm.setAlarmMinutes(alarm.getAlarmMinutes() + 1);
        }
    }
    
    public void incrementHours() {
        if (alarm.getAlarmHours() == 23) {
            alarm.setAlarmHours(0);
        } else {
            alarm.setAlarmHours(alarm.getAlarmHours() + 1);
        }
    }
    
    public void decrementMinutes() {
        if (alarm.getAlarmMinutes() == 0) {
            alarm.setAlarmMinutes(59);
        } else {
        alarm.setAlarmMinutes(alarm.getAlarmMinutes() - 1);
        }
    }
    
    public void decrementHours() {
        if (alarm.getAlarmHours() == 0) {
            alarm.setAlarmHours(23);
        } else {
            alarm.setAlarmHours(alarm.getAlarmHours() - 1);
        }
    }
    
    public String getCurrentTime() {
        return alarm.getAlarmTime();
    }
    
    public void activateAlarm() {
        alarm.turnOn();
    }
    
    public void deactivateAlarm() {
        alarm.turnOff();
    }
    
    public boolean isAlarmActive() {
        return alarm.alarmActive;
    }
    
    /*
    public void setAlarmTime(String time){
        alarm.setTimeOfAlarm(time);
    }
    */
    
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
