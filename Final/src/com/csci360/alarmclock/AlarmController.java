/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.io.IOException;

/**
 *
 * @author baldy
 */
public class AlarmController {
    
    // initialize alarms
    private Alarm[] alarm = { new Alarm(), new Alarm() };
    
    public void notifyAlarms(Time time) {
        // Alarm 1 is ready
        if (time.toString().compareTo(getAlarm1Time()) == 0) {
            soundAlert1();
            
        // Alarm 2 is ready
        } else if (time.toString().compareTo(getAlarm2Time()) == 0) {
            soundAlert2();
        }
    }
    
    public void snooze() {
        if (isAlarm1Active())
            alarm[0].snooze();
        if (isAlarm2Active())
            alarm[1].snooze();
    }
    
    public void setAlarm1Time(Time time){
        alarm[0].setAlarmHours(time.hours);
        alarm[0].setAlarmMinutes(time.minutes);
        alarm[0].setAlarmSeconds(time.seconds);
    }
    
    public void setAlarm2Time(Time time){
        alarm[1].setAlarmHours(time.hours);
        alarm[1].setAlarmMinutes(time.minutes);
        alarm[1].setAlarmSeconds(time.seconds);
    }
    
    public String getAlarm1Time(){
        return alarm[0].getAlarmTime();
    }
    
    public String getAlarm2Time(){
        return alarm[1].getAlarmTime();
    }
    
    public void activateAlarm1() {
        alarm[0].turnOn();
    }
    
    public void activateAlarm2() {
        alarm[1].turnOn();
    }
    
    public void deactivateAlarm1() {
        alarm[0].turnOff();
    }
    
    public void deactivateAlarm2() {
        alarm[1].turnOff();
    }
    
    public void toggleAlarm1() {
        if (isAlarm1Active()) { 
            deactivateAlarm1();
        } else {
            activateAlarm1();
        }
    }
    
    public void toggleAlarm2() {
        if (isAlarm2Active()) { 
            deactivateAlarm2();
        } else {
            activateAlarm2();
        }
    }
    
    public boolean isAlarm1Active() {
        return alarm[0].alarmActive;
    }
    
    public boolean isAlarm2Active() {
        return alarm[1].alarmActive;
    }
    
    public boolean isStockAlarm1(){
        return alarm[0].shouldSoundAlert();
    }
    
    public boolean isStockAlarm2(){
        return alarm[1].shouldSoundAlert();
    }
    
    public void setStockAlarm1(boolean stock){
        alarm[0].setStockAlert(stock);
    }
    
    public void setStockAlarm2(boolean stock){
        alarm[1].setStockAlert(stock);
    }
    
    public void soundAlert1() {
        alarm[0].soundAlert();
    }
    
    public void soundAlert2() {
        alarm[1].soundAlert();
    }
    
}
