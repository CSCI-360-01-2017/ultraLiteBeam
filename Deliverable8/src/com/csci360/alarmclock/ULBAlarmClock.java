/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csci360.alarmclock;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author benjaminmuldrow
 */
public class ULBAlarmClock extends Application{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(ULBAlarmClock.class, (java.lang.String[])null);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {        
        Pane settings = (Pane) FXMLLoader.load(ULBAlarmClock.class.getResource("alarmSettings.fxml"));
        
        ScrollPane sp = new ScrollPane();
        sp.setContent((Pane) FXMLLoader.load(ULBAlarmClock.class.getResource("main.fxml")));
        
        Scene scene = new Scene(sp, 480, 640);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("ULB Radio Alarm Clock");
        primaryStage.show();
        
    }

}
