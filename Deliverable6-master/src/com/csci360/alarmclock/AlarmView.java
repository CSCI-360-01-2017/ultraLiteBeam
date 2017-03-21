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
public class AlarmView {
      public void printAlarmDetails(String time, Boolean playsAlert){
        System.out.println("Alarm will play @ " + time);
        System.out.println("The alarm will sound: " + playsAlert);
    }
}
