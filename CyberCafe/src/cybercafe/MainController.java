/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cybercafe;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;

/**
 *
 * @author Jayasurya
 */
public class MainController implements Initializable {
    
    @FXML
    private TextField usr_name;
    @FXML
    private TextField phone_no;
    @FXML
    private JFXButton start_button;
    
   public static String user_name;
      public static String phone_number;
     
      public static String phone_number2;
  //    public static  int phone2;

   //name_label.setDisable(true);
    
//    @FXML
//    public void name(MouseEvent me )
//    {
//         name_label.setVisible(true);
//         phone_label.setVisible(false);
//    }
//    
//    @FXML
//    public void phone(MouseEvent me )
//    {
//         phone_label.setVisible(true);
//         name_label.setVisible(false);
//    }
//    
    @FXML
    public void keyReleased(KeyEvent ai) throws Exception
    {
          user_name=usr_name.getText();
       // char a='a';
        phone_number2=phone_no.getText();
//        System.out.println(phone_number2);
         // phone_number=Integer.parseInt(phone_no.getText());
         //   phone2=Integer.parseInt(phone_number);
            boolean isDisabled=(user_name.isEmpty()|| user_name.trim().isEmpty())||( phone_number2.isEmpty() || phone_number2.trim().isEmpty()|| phone_number2.length()!=10);
           start_button.setDisable(isDisabled);
//            String phone="[7-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
//            if(phone!=phone_number)
//            {
//                start_button.setDisable(true);
//            }
//            else
//             start_button.setDisable(false); 
//             char [] c_arr=phone_number.toCharArray();
//             for(int i=0;i<c_arr.length;i++)
//             //c_arr = c_arr[i].getKeyChar();
//                 a=c_arr[i];
//        if(!((a >= '0') && (a <= '9') || (ai.getCode() == KeyCode.BACK_SPACE) || (ai.getCode() == KeyCode.DELETE))){
//            ai.consume();
//    }
    }
    
    @FXML
    public void session_str(ActionEvent event) throws IOException{
    //    if(usr_name.getText().equals("surya") && phone_no.getText().equals("9110258479"))
    ((Node)event.getSource()).getScene().getWindow().hide();
    Stage stage=new Stage();
    FXMLLoader loader=new FXMLLoader();
    Pane root = FXMLLoader.load(getClass().getResource("session.fxml"));
        Scene scene = new Scene(root);
       // scene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("iCafe Session");
        stage.show();
        stage.setResizable(false);
        stage.setOnCloseRequest(e -> e.consume());
         user_name=usr_name.getText();
         phone_number=phone_no.getText();
         SessionController.no=phone_number;
          // String phone_number1=phone_no.getText();
           //phone_number=Integer.parseInt(phone_number1);
      //  stage.close();
        try{
           
           //  user_name=usr_name.getText();
            // phone_number=phone_no.getText();
             
//            System.out.println(user_name);
//            System.out.println(phone_number);
//            SessionController sessionpage=(SessionController)loader.getController();
//            sessionpage.Sessionpass(user_name,phone_number);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jayasurya","4196");
            //PreparedStatement ps=con.prepareStatement("insert into user_info (username,phone_number) values (?)");
            Statement xyz=con.createStatement();
            ResultSet rs=xyz.executeQuery("insert into user_info(user_name,user_phone) values('"+user_name+"','"+phone_number+"')");
            //con.close();
//  xyz.executeUpdate("insert into user_info (username,phone_number) values('"+user_name+"','"+phone_number+"')");
        } catch (ClassNotFoundException ex) {
             System.out.println("Class not found"); //  Logger.getLogger(GUI1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
              System.out.println("Exception Enter only Numbers!!!");//  Logger.getLogger(GUI1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
       // System.out.println("inserted");
       // timeline.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        name_label.setVisible(false);
//        phone_label.setVisible(false);
      start_button.setDisable(true);
      //  stage.hide();
        // TODO
   }    
}
