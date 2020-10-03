/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cybercafe;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Jayasurya
 */
public class FeedbackController implements Initializable {

    @FXML
    private JFXRadioButton visit_yes;
    @FXML
    private ToggleGroup visit_group;
    @FXML
    private JFXRadioButton visit_no;
    @FXML
    private ToggleGroup return_likelihood;
    @FXML
    private JFXTextArea feedback_field;
    @FXML
    private JFXRadioButton unlikely;
    @FXML
    private JFXRadioButton slightly_likely;
    @FXML
    private JFXRadioButton moderately_likely;
    @FXML
    private JFXRadioButton very_likely;
    @FXML
    private JFXRadioButton extremely_likely;
    
    String phone_number=MainController.phone_number;
   // int phone2=MainController.phone2;
    String user_name=MainController.user_name;
    
    @FXML
    public void feedback_received(ActionEvent fr) throws IOException, SQLException{
    
    //    if(usr_name.getText().equals("surya") && phone_no.getText().equals("9110258479"))
     ((Node)fr.getSource()).getScene().getWindow().hide();
  Pane root = FXMLLoader.load(getClass().getResource("session_bill.fxml"));
        Scene scene = new Scene(root);
         Stage stage=new Stage();
          stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UTILITY);
        stage.setOnCloseRequest(e -> e.consume());
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
       // scene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Bill Amount");
      String feedback=  feedback_field.getText();
        System.out.println(feedback);
         RadioButton selectedRadioButton_visit = (RadioButton) visit_group.getSelectedToggle();
    String visit_toggle=selectedRadioButton_visit.getText();
    RadioButton selectedRadioButton_return = (RadioButton) return_likelihood.getSelectedToggle();
    String return_toggle=selectedRadioButton_return.getText();
        System.out.println("Visit : "+visit_toggle);
            System.out.println("Return : "+return_toggle);
             try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection abc=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","jayasurya","4196");
                String statem="select user_id from user_info where user_phone=?";
                PreparedStatement xyz=abc.prepareStatement(statem);
               // xyz.setString(1, user_name);
               // int phoneno1=Integer.valueOf(phone_number);
                System.out.println("Phone Number before executing"+phone_number);
                xyz.setString(1, phone_number);
                ResultSet rs =xyz.executeQuery();
                                String user_id="";
                                while(rs.next())
                                {
                         user_id=rs.getString(1);
                                }
               
               //  System.out.println(user_id);
                 System.out.println("Phone and ID"+phone_number+user_id);
               xyz.executeUpdate("insert into feedback (USER_ID,user_name,first_visit,likelihood_to_return,feedback_received) values('"+user_id+"','"+user_name+"','"+visit_toggle+"','"+return_toggle+"','"+feedback+"')");
    }
           catch(ClassNotFoundException | SQLException ce)
                   {
                       System.out.println("Exception!!!!!!");
                   }
    }
//    @FXML
//    public void feedback()
//    RadioButton first_visit=(RadioButton) visit_group.getSelectedToggle();
//    String first_visit_value=first_visit.getText();
//   public void myGroupAction(ActionEvent action)
//  {
//    visit_group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
//    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
//
//         if (visit_group.getSelectedToggle() != null) {
//
//             System.out.println(visit_group.getSelectedToggle().getUserData().toString());
//             // Do something here with the userData of newly selected radioButton
//         }
//    }
//});}
//   RadioButton selectedRadioButton = (RadioButton) visit_group.getSelectedToggle();
//    String value=selectedRadioButton.getText();
   
//     public void myGroupAction(ActionEvent action)
//    {
////        RadioButton chk = (RadioButton)visit_group.getSelectedToggle().getUserData(); // Cast object to radio button
////        RadioButton selectedRadioButton = (RadioButton) visit_group.getSelectedToggle();
  //  String value=selectedRadioButton.getText();
//////        System.out.println("FIRST VISIT ="+visit_group.getSelectedToggle().getUserData().toString());
//////        System.out.println("FIRST VISIT ="+return_likelihood.getSelectedToggle().getUserData().toString());
//    }
 // String toogleGroupValue=  visit_group.getSelectedToggle().getUserData().toString();
//String toogleGroupValue = selectedRadioButton.getText();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //   Stage stage3=new Stage();
        // Group hi=new Group();
         //stage3.setScene(hi); 
         //System.out.println(extremely_likely.getText());

    }    
    
}
