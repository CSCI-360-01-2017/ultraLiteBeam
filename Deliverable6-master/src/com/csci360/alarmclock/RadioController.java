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
        double volume = 1.0;
        double frequency = 88.0;
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
            return (freq >= 540 && freq <= 1600);
        } else if (tuning.equals("fm")) {
            return (freq >= 88 && freq <= 108);
        } else {
            // invalid tuning
            return false;
        }
    }

    // check if volume is between 0 and 1
    private boolean isValidVolume(double vol) {
        if (vol >= 0 && vol <= 1) {
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

    public void stop() {
        radio.stop();
    }

}
