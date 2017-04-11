/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

/**
 *
 * @author benjaminmuldrow
 */
public class ClockUIController implements Initializable {
    
    private SuperController sc;
    public static StringProperty timeProperty = new SimpleStringProperty("xx:xx:xx");
    
    // ui components
    @FXML
    private Button alarm1Button;
    
    @FXML
    private Button alarm2Button;    
    
    @FXML
    private Button leftButton;
    
    @FXML
    private Button rightButton;
    
    @FXML
    private Slider volumeSlider;
    
    @FXML
    private Label displayTime;

    public ClockUIController() throws IOException {
        sc = new SuperController();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        displayTime.textProperty().bind(timeProperty);
        
        alarm1Button.setOnAction(event -> {
            // alarm 1 clicked
        });
        
        alarm2Button.setOnAction(event -> {
            //alarm 2 clicked
        });
        
        leftButton.setOnAction(event -> {
            //left button clicked
            sc.downFrequency();
        });
        
        rightButton.setOnAction(event -> {
            //right button cliked
            sc.upFrequency();
        });
        
        volumeSlider.setMax(1.0);
        volumeSlider.setMin(0.0);
        volumeSlider.setBlockIncrement(0.1f);
        volumeSlider.valueProperty().addListener(change -> {
            sc.setVolume(this.volumeSlider.getValue());
        });
    }
    
    
}
