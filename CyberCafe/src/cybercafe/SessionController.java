/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cybercafe;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Jayasurya
 */
public class SessionController implements Initializable {
    Timeline timeline;
    LocalTime time = LocalTime.parse("00:00:00");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    @FXML
    private JFXButton end_session;
    @FXML
    private Label user_name_display;
    
    @FXML
    public Label timerLabel;
    public static String no;
    public static float bill=0;
    public static String user_id;
   public static String usage_time;
   
   String phone_number1=MainController.phone_number;
     String user_name1=MainController.user_name;

    @FXML
    public void endSession(ActionEvent ends) throws IOException,SQLException
      {
        //  System.out.println("Phone"+phone_number1+user_name1);
          ((Node)ends.getSource()).getScene().getWindow().hide();
           timeline.pause();
           end_session.setDisable(true);
           usage_time=timerLabel.getText();
           String new1;
           new1=usage_time.replace(":", "");
            System.out.println(new1); 
           String new2= new1.substring(0,2);
           Integer hours= Integer.parseInt(new2);
            String new3= new1.substring(2,4);
           Integer mins= Integer.parseInt(new3); 
           String new4= new1.substring(4,6);
           Integer seconds= Integer.parseInt(new4);
           System.out.println(hours);
           System.out.println(mins);
           System.out.println(seconds);
           float hours_sec=hours*3600;
           float mins_sec=mins*60;
           float sec=seconds;
           float total_secs=hours_sec+mins_sec+sec;
           System.out.println(total_secs);
         //  float bill=0;
           if(total_secs<=1800)
           {
               bill=10;
           }
           else  if(total_secs>1800 && total_secs<=2700)
           {
               bill=15;
           }
           else  if(total_secs>2700 && total_secs<=3600)
           {
               bill=20;
           }
            else  if(total_secs>3600 && total_secs<=4500)
           {
               bill=25;
           }
           else  if(total_secs>4500 && total_secs<=5400)
           {
               bill=30;
           }
           else  if(total_secs>5400 && total_secs<=6300)
           {
               bill=35;
           }
           else  if(total_secs>6300 && total_secs<=7200)
           {
               bill=40;
           }
            else  if(total_secs>7200 && total_secs<=8100)
           {
               bill=45;
           }
            else if (total_secs>8100 && total_secs<=9000)
           {
               bill=50;
           }
           else if (total_secs>9000 && total_secs<=9900)
           {
               bill=55;
           }
            else if (total_secs>9900 && total_secs<=10800)
           {
               bill=60;
           }
           else
           {
               bill=70;
           }

           System.out.println(bill);  
           try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection abc=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jayasurya","4196");
                String statem="select user_id from user_info where user_name=?";
                PreparedStatement xyz=abc.prepareStatement(statem);
                
                xyz.setString(1, user_name1);
                ResultSet rs =xyz.executeQuery();
                                 user_id="";
                                while(rs.next())
                                {
                         user_id=rs.getString(1);
                                }
               
               xyz.executeUpdate("insert into user_session (USER_ID,user_name,USAGE_TIME) values('"+user_id+"','"+user_name1+"','"+usage_time+"')");
               xyz.executeUpdate("insert into usage_charges (USER_ID,USAGE_TIME,BILL_AMOUNT) values('"+user_id+"','"+usage_time+"','"+bill+"')");
           }
           catch(ClassNotFoundException ce)
                   {
                       System.out.println("Exception!!!!!!");
                   }
           
           catch(SQLException se)
           {
               System.out.println("SQL EXception");
           }
           
           // FXMLLoader loader=new FXMLLoader();
       Pane root = FXMLLoader.load(getClass().getResource("session_bill.fxml"));
        Scene scene = new Scene(root);
         Stage stage=new Stage();
          stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UTILITY);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Bill Amount");
         //  stage.setOnCloseRequest(e ->[e.consume()]);
      }
    /**
     * Initializes the controller class.
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> incrementTime()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
       user_name_display.setText(user_name1);
        System.out.println("Phone"+phone_number1);
        System.out.println("The Phone Number Passed in second page is "+no);
        
    }    
      private void incrementTime() {
        time = time.plusSeconds(1);
        timerLabel.setText(time.format(dtf));
    }

    }    
    
