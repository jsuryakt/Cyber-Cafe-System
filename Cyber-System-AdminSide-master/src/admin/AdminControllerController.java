/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AdminControllerController implements Initializable {

    @FXML
    private JFXTextField admin_name;
    @FXML
    private JFXPasswordField admin_pass;
    @FXML
    private JFXButton login_button;
    @FXML
    private Label forgot_pass;

    @FXML
    public void forgot_password(MouseEvent me)
    {
        forgot_pass.setTextFill(Color.web("#ff0000"));
    }
    
    @FXML
    public void keyReleased(KeyEvent ai) throws SQLException
    {
         String name=admin_name.getText();
            String password=admin_pass.getText();
            boolean isDisabled=(name.isEmpty()|| name.trim().isEmpty())||( password.isEmpty() || password.trim().isEmpty());
            login_button.setDisable(isDisabled);
            try {
             name= admin_name.getText();
             password = admin_pass.getText();
       
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection abc =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");
                String statem="select * from admin where admin_name=? and admin_password=?";
                  PreparedStatement xyz=abc.prepareStatement(statem);
                   xyz.setString(1, name);
                xyz.setString(2, password);
                 ResultSet rs =xyz.executeQuery();
                    if(!rs.next()){
                        login_button.setDisable(true);
             
            }else{
                        login_button.setDisable(false);
           
            } 
                     }catch (ClassNotFoundException ex) {
                
            } catch (SQLException ex) {
                
            }
            }
      
    
    
    @FXML
    public void admin_login(ActionEvent ae) throws IOException
    {
        ((Node)ae.getSource()).getScene().getWindow().hide();
        Stage stage2=new Stage();
         Pane root = FXMLLoader.load(getClass().getResource("Adminnext.fxml"));
        Scene scene = new Scene(root);
        stage2.setTitle("Admin Controls");
          stage2.getIcons().add(new Image("file:resources/images/c.png"));
        stage2.setScene(scene);
        stage2.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     login_button.setDisable(true);
    }    
    
}
