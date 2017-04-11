/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author mikisugimoto
 */
public class SuperController {
        
    private final AlarmController alarm;
    private final ClockController clock;
    private final RadioController radio;
    
    public SuperController() {
        alarm = new AlarmController();
        clock = new ClockController();
        radio = new RadioController(0, 0, "fm");
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                alarmCheck();
            }
        }, 5*1000, 5*1000);
    }
    
    public void upClockHours() {
        clock.incrementHours();
    }
    
    public void downClockHours() {
        clock.decrementHours();
    }
    
    public void upClockMinutes() {
        clock.incrementMinutes();
    }
    
    public void downClockMinutes() {
        clock.decrementMinutes();
    }
    
    public void alarmCheck() {
        if (alarm.getAlarmTime() == clock.getCurrentTime()) {
            if (alarm.isAlarmActive() == true) {
                  soundAlarm();
            }
        }
    }
    
    public void soundAlarm() {
        if (alarm.isStockAlarm() == true) {
            alarm.soundAlert();
        } else {
            radio.play();
        }
    }
    
    public void turnOffAlarm() {
        alarm.deactivateAlarm();
        if (alarm.isStockAlarm() == false) {
            radio.stop();
        }
    }
    
    public void snooze() {
        if (alarm.isStockAlarm() == false) {
            radio.stop();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                soundAlarm();
            }
        }, 540*1000, 540*1000);
    }
    
    public void upAlarmHours() {
        alarm.incrementHours();
    }
    
    public void downAlarmHours() {
        alarm.decrementHours();
    }
    
    public void upAlarmMinutes() {
        alarm.incrementMinutes();
    }
    
    public void downAlarmMinutes() {
        alarm.decrementMinutes();
    }
    
    public void upVolume() {
        radio.setVolume(radio.getVolume() + 0.1);
    }
    
    public void downVolume() {
        radio.setVolume(radio.getVolume() - 0.1);
    }
    
    public void switchTuning() {
        radio.toggleTuning();
    }
    
    public void upFrequency() {
        radio.setFrequency(radio.getFrequency() + 0.1);
    }
    
    public void downFrequency() {
        radio.setFrequency(radio.getFrequency() + 0.1);
    }
    
    public void playRadio() {
        radio.play();
    }
    
    public void stopRadio() {
        radio.stop();
    }
    
    public void setVolume(double val) {
        radio.setVolume(val);
    }
    
}
