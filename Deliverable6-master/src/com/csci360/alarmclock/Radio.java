package com.csci360.alarmclock;

/**
* @author benjaminmuldrow
*/
public class Radio {

    // Constant values
    public static final double DEFAULT_FM = 88.0;
    public static final double DEFAULT_AM = 540.0;

    // Attributes with default values
    private double volume;
    private double frequency;
    private String tuning;

    public Radio(double vol, double freq, String tuning) {
        this.volume = vol;
        this.tuning = tuning;
        this.frequency = freq;
    }

    public void playRadio() {
        // to be added with radio component
        // tuneIn(this.volume, this.frequency, this.tuning)
    }

    public void stop() {
        // to be added with radio component
        // stop radio transmission
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double vol) {
        this.volume = vol;
    }

    public double getFrequency() {
        return this.frequency;
    }

    public void setFrequency(double freq) {
        this.frequency = freq;
    }

    public String getTuning() {
        return this.tuning;
    }

    public void setTuning(String tuning) {
        this.tuning = tuning;
    }

}
