/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

/**
 *
 * @author baldy
 */
public class Alarm {
    //private String timeOfAlarm;
    
    //if false play radio
    //if true play default alarm
    public boolean alarmActive;
    private boolean playStockAlert;
    private Time time = new Time(0,0,0);
    private final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    
    public Alarm() {
        playStockAlert = true;
        alarmActive = false;
    }
    
    public void setAlarmSeconds(int seconds) {
        if (seconds < 60 && seconds >= 0) {
            time.seconds = seconds;
        }
    }
    
    public void setAlarmMinutes(int minutes) {
        if (minutes < 60 && minutes >= 0)
        time.minutes = minutes;
    }
 
    public void setAlarmHours(int hours) {
        if (hours < 24 && hours >= 0)
        time.hours = hours;
    }
    
    public int getAlarmHours() {
        return time.hours;
    }
    
    public int getAlarmMinutes() {
        return time.minutes;
    }
    
    public String getAlarmTime() {
        return time.toString();
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
    
    @FXML
    public void soundAlert() {
        Toolkit.getDefaultToolkit().beep();
        Platform.runLater(
            () -> {
                try {
                    FXMLLoader loader = new FXMLLoader(ULBAlarmClock.class.getResource("newMain.fxml"));
                    loader.load();
                    UIController ui = loader.getController();
                    ui.notificationLabel.textProperty().setValue("Wake Up!");
                    ui.alarmStatus = true;
                } catch (IOException ex) {
                    Logger.getLogger(Alarm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
          );
    }
    
    public void snooze() {
        int minutes = time.minutes;
        int hours = time.hours;
        minutes += 9;
        if (minutes / 60 > 0) {
            minutes = minutes % 60;
            hours += 1;
        }
        this.time = new Time(hours,  minutes, this.time.seconds);
    }
    
    public String toString() {
        return time.toString();
    }

    
    
}
