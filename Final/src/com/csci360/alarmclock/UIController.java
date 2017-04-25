/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import com.sun.jmx.snmp.Timestamp;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 *
 * @author benjaminmuldrow
 */
public class UIController implements Initializable {
    
    private SuperController sc;
    public static Boolean alarmStatus = false;
    public static StringProperty timeProperty = new SimpleStringProperty("xx:xx:xx");
    public static StringProperty statusProperty = new SimpleStringProperty("Welcome!");
    public static StringProperty frequencyProperty = new SimpleStringProperty("88.00fm");
    public Boolean radioPlaying = false;
    
    @FXML
    Label timeDisplay = new Label();
    
    @FXML
    Button snoozeBtn = new Button();

    @FXML
    Button dismissBtn = new Button();
    
    @FXML
    Label notificationLabel = new Label();
    
    // RADIO
    
    @FXML
    Button decreaseFrequencyBtn = new Button();
    
    @FXML
    Button radioDisplay = new Button();
    
    @FXML
    Button increaseFrequencyBtn = new Button();
    
    @FXML
    ToggleButton radioOnOff = new ToggleButton();
    
    @FXML
    Label radioFeedBack = new Label();
    
    
    
    
    
    // ALARM 1
    
    @FXML
    CheckBox alarm1ActiveBox = new CheckBox();
    
    @FXML
    Button setAlarm1Btn = new Button();
    
    @FXML
    TextField alarm1TextBox = new TextField();
    
    @FXML
    Label alarm1Display = new Label();
    
    @FXML
    ToggleButton alarmRadioToggle1 = new ToggleButton();
    
    // ALARM 2
    
    @FXML
    CheckBox alarm2ActiveBox = new CheckBox();
    
    @FXML
    Button setAlarm2Btn = new Button();
    
    @FXML
    TextField alarm2TextBox = new TextField();
    
    @FXML
    Label alarm2Display = new Label();
    
    @FXML
    ToggleButton alarmRadioToggle2 = new ToggleButton();
    
    public UIController() throws IOException {
        sc = new SuperController();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        // Update clock every second
        // Threading solution credited to Azul Systems software engineer Sergey Grinev
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable(){
                    @Override
                    public void run() {
                        timeProperty.setValue(sc.getTime());
                    }
                });
            }
        }, 0, 1000);
                
        // bind text properties
        timeDisplay.textProperty().bind(timeProperty);
        notificationLabel.textProperty().bindBidirectional(statusProperty);
        radioDisplay.textProperty().bind(frequencyProperty);
        
        snoozeBtn.setOnAction(event->{
            //sc.snooze();
        });
        
        dismissBtn.setOnAction(event->{
            //sc.dismiss();
        });
        
        decreaseFrequencyBtn.setOnAction(event->{
            sc.downFrequency();
            frequencyProperty.setValue(sc.getFrequency() + sc.getTuning());
            if(radioPlaying){
                radioFeedBack.setText("Station " + frequencyProperty.getValue() + " is now playing");
            }
        });
        
        increaseFrequencyBtn.setOnAction(event->{
           sc.upFrequency();
           frequencyProperty.setValue(sc.getFrequency() + sc.getTuning());
           if(radioPlaying){
                radioFeedBack.setText("Station " + frequencyProperty.getValue() + " is now playing");
            }
        });
        
        radioDisplay.setOnAction(event->{
            sc.switchTuning();
            frequencyProperty.setValue(sc.getFrequency() + sc.getTuning());
            if(radioPlaying){
                radioFeedBack.setText("Station " + frequencyProperty.getValue() + " is now playing");
            }
        });
        
        radioOnOff.setOnAction(event->{
           radioPlaying = !radioPlaying;
           if(radioPlaying){
               radioFeedBack.setText("Station " + frequencyProperty.getValue()+ " is now playing");
               radioOnOff.setText("Radio On");
           }
           else{
               radioFeedBack.setText("Radio off");
               radioOnOff.setText("Radio Off");
           }
        });
        
        alarm1ActiveBox.setOnAction(event->{
            sc.alarmController.toggleAlarm1();
        });
        
        alarm2ActiveBox.setOnAction(event->{
            sc.alarmController.toggleAlarm2();
        });
        
        setAlarm1Btn.setOnAction(event->{
            if (sc.isValidTime(alarm1TextBox.getText())) {
                sc.alarmController.setAlarm1Time(
                        Time.fromString(alarm1TextBox.getText())
                );
                alarm1Display.textProperty().setValue(alarm1TextBox.getText());
            }
        });
        
        setAlarm2Btn.setOnAction(event->{
            if (sc.isValidTime(alarm2TextBox.getText())) {
                sc.alarmController.setAlarm2Time(
                        Time.fromString(alarm2TextBox.getText())
                );
                alarm2Display.textProperty().setValue(alarm2TextBox.getText());
            }
        });
        
        snoozeBtn.setOnAction(event->{
            if (alarmStatus) {
                alarmStatus = false;
                sc.alarmController.snooze();
                statusProperty.setValue("snoozed Alarm(s)");
            }
        });
        
        dismissBtn.setOnAction(event->{
            if (alarmStatus) {
                alarmStatus = false;
                sc.dismiss();
                statusProperty.setValue("dismissed Alarm(s)");
                
            }
        });
        alarmRadioToggle1.setOnAction(event->{
            if(alarmRadioToggle1.getText().equals("Alarm")){
                alarmRadioToggle1.setText("Radio");
            }
            else{
                alarmRadioToggle1.setText("Alarm");
            }
    });
        
        alarmRadioToggle2.setOnAction(event->{
            if(alarmRadioToggle2.getText().equals("Alarm")){
                alarmRadioToggle2.setText("Radio");
            }
            else{
                alarmRadioToggle2.setText("Alarm");
            }
    });        
    }
    
}
