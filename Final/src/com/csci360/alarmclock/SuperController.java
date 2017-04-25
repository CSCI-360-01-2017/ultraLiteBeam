/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;

/**
 *
 * @author mikisugimoto
 */
public class SuperController {
        
    public final AlarmController alarmController;
    private final ClockController clockController;
    private final RadioController radioController;
    
    public SuperController() {
        alarmController = new AlarmController();
        clockController = new ClockController(alarmController);
        radioController = new RadioController(0, 0, "fm");
    }
    
    /*public void snooze() {
        if (alarmController.isStockAlarm() == false) {
            radioController.stop();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                soundAlarm();
            }
        }, 540*1000, 540*1000);
    }*/
    
    public void dismiss() {
        
        // alarm 1
        if (alarmController.isAlarm1Active()) {
            alarmController.deactivateAlarm1();
        }
        
        // alarm 2
        if (alarmController.isAlarm2Active()) {
            alarmController.deactivateAlarm2();
        }
    }
    
    public void upVolume() {
        radioController.setVolume(radioController.getVolume() + 0.1);
    }
    
    public void downVolume() {
        radioController.setVolume(radioController.getVolume() - 0.1);
    }
    
    public void switchTuning() {
        radioController.toggleTuning();
    }
    
    public void upFrequency() {
        radioController.setFrequency(radioController.getFrequency() + 0.1);
    }
    
    public void downFrequency() {
        radioController.setFrequency(radioController.getFrequency() - 0.1);
    }
    
    public String getFrequency() {
        return String.format("%.2f",radioController.getFrequency());
    }
    
    public String getTuning() {
        return radioController.getTuning();
    }
    
    public void playRadio() {
        radioController.play();
    }
    
    public void stopRadio() {
        radioController.stop();
    }
    
    public void setVolume(double val) {
        radioController.setVolume(val);
    }
    
    public String getTime() {
        return clockController.getCurrentTime();
    }
    
    public boolean isValidTime(String timeAsString) {
        boolean result = false;
        Pattern timePattern = Pattern.compile("\\p{Digit}{1,2}:\\p{Digit}{1,2}:\\p{Digit}{1,2}");
        Matcher matcher = timePattern.matcher(timeAsString);             
        boolean valid = matcher.matches();
        if (valid) {
            String[] time = timeAsString.split(":");
            int hours = Integer.parseInt(time[0]);
            int minutes = Integer.parseInt(time[1]);
            int seconds = Integer.parseInt(time[2]);
            if (hours < 24 && minutes < 60 && seconds < 60) {
                result = true;
            }
        }
        return result;
    }
    
    public void soundAlarm(StringProperty alarmField) {
        alarmField.setValue("Alarm is going off");
    }
    
}
