/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

/**
 *
 * @author benjaminmuldrow
 */
public class RadioController {

    private final Radio radio;

    public RadioController(double vol, double freq, String tune) {

        // default values
        double volume = Radio.MAX_VOL;
        double frequency = Radio.MIN_FM;
        String tuning = "fm";

        // check validity
        if (isValidVolume(vol)) {
            volume = vol;
        }
        if (tune.equals("fm") || tune.equals("am")) {
            tuning = tune;
        }
        if (isValidFrequency(freq, tuning)) {
            frequency = freq;
        }

        // instantiate radio object
        this.radio = new Radio(volume, frequency, tuning);
    }

    // toggle the tuning between am and fm
    public void toggleTuning() {
        if (radio.getTuning().equals("am")) {
            radio.setTuning("fm");
            radio.setFrequency(Radio.DEFAULT_FM);
        } else {
            radio.setTuning("am");
            radio.setFrequency(Radio.DEFAULT_AM);
        }
    }

    // check if frequency is valid aginst current tuning
    private boolean isValidFrequency(double freq, String tuning) {
        if (tuning.equals("am")) {
            return (freq >= Radio.MIN_AM && freq <= Radio.MAX_AM);
        } else if (tuning.equals("fm")) {
            return (freq >= Radio.MIN_FM && freq <= Radio.MAX_FM);
        } else {
            // invalid tuning
            return false;
        }
    }

    // check if volume is between 0 and 1
    private boolean isValidVolume(double vol) {
        if (vol >= Radio.MIN_VOL && vol <= Radio.MAX_VOL) {
            return true;
        } else {
            return false;
        }
    }

    public void setFrequency(double freq) {
        if (isValidFrequency(freq, radio.getTuning())) {
            this.radio.setFrequency(freq);
        }
    }

    public void setVolume(double vol) {
        if (isValidVolume(vol)) {
            this.radio.setVolume(vol);
        }
    }

    public String getTuning() {
        return radio.getTuning();
    }

    public double getFrequency() {
        return radio.getFrequency();
    }

    public double getVolume() {
        return radio.getVolume();
    }
    
    public void play() {
        radio.playRadio();
    }

    public void stop() {
        radio.stop();
    }

}
