/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AdminnextController implements Initializable {

    @FXML
    private TableView<userstats> usertable;
    @FXML
    private TableColumn<userstats, String> userid;
    @FXML
    private TableColumn<userstats, String> username;
    @FXML
    private TableColumn<userstats, String> usagetime;
    @FXML
    private TableColumn<userstats, String> billamount;
    @FXML
    private TableColumn<userstats, String> extraamount;
    @FXML
    private TableColumn<userstats, String> totalamount;
    @FXML
    private JFXTextField admin_name;
    @FXML
    private JFXPasswordField admin_pass;
    @FXML
    private JFXButton signup_button;
    
    ObservableList<userstats> oblist=FXCollections.observableArrayList();
    @FXML
    private TableColumn<userstats, String> firstvisit;
    @FXML
    private TableColumn<userstats, String> likelihoodtoreturn;
    @FXML
    private TableColumn<userstats, String> feedback;

     static int upper=0,lower=0,digit=0;
     public static String id;
    static String name;
    static String password;
    static int hi=0;
    @FXML
    private JFXTextField extra;
    /**
     * Initializes the controller class.
     */
    

     @FXML
    public void keyReleased2(KeyEvent ai)
    {
      //  boolean upper=true;
       
          name=admin_name.getText();
             password=admin_pass.getText();
            char [] c_arr=password.toCharArray();
            boolean isvalid=(password.length()<8 || name.isEmpty() || name.trim().isEmpty());
           signup_button.setDisable(isvalid);
            
            for(int i=0; i<c_arr.length;i++)
            {
                if(Character.isUpperCase(c_arr[i]))
                {upper++;}
            }
            for(int j=0; j<c_arr.length;j++)
            {
                if(Character.isLowerCase(c_arr[j]))
                  {lower++;}
            }
            for(int k=0; k<c_arr.length;k++)
            {
                if(Character.isDigit(c_arr[k]))
                  {digit++;}
            }
            
            if(upper>=1 && lower>=1 && digit>=1 && password.length()>8)
            {
                signup_button.setDisable(false);
            } 
            else
            {
                 signup_button.setDisable(true);
            }
           
    
    }
    
    @FXML
    public void get_user_id(MouseEvent me)
    {
        AdminnextController.id=usertable.getSelectionModel().getSelectedItem().getUserid1();
    }
    @FXML
    public void create_new_admin(ActionEvent ae)
    {
          name=admin_name.getText();
             password=admin_pass.getText();
           
             admin_name.clear();
             String ad_name=admin_name.getText();
            admin_pass.clear();
             String ad_pass=admin_pass.getText();
            // System.out.println(password);
              if(ad_name.isEmpty() && ad_name.trim().isEmpty() && ad_pass.isEmpty() && ad_pass.trim().isEmpty())
            {
                                signup_button.setDisable(true);
            }

            try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");            
            Statement xyz=con.createStatement();
                System.out.println("Before"+name+password);
            xyz.executeQuery("insert into admin (admin_name,admin_password) values('"+name+"','"+password+"')");
        } catch (ClassNotFoundException ex) {
             System.out.println("Class not found");
            } catch (SQLException ex) {
                 hi=1;
              System.out.println("SQL Exception!!!");
                Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Admin already exists!");
            alert.setHeaderText(null);
            alert.setTitle("FAIL");
            alert.show();
            }
            if(hi==0){
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Admin Added Successfully!");
            alert.setHeaderText(null);
            alert.setTitle("SUCCESS");
            alert.show();
            }
    }
    @FXML
    public void extra_enter(ActionEvent ae) throws ClassNotFoundException, SQLException
    {
     String extra_bill=extra.getText();
        System.out.println("Extra and user_id"+extra_bill+id);
     try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");  
                Statement xyz=con.createStatement();
              xyz.executeQuery("update charges set extra_amount='"+extra_bill+"' where user_id=('"+id+"')"); 
              xyz.executeQuery("begin chargesproc; end;");
        } catch (ClassNotFoundException ex) {
             System.out.println("Class not found"); 
            } catch (SQLException ex) {
              System.out.println("SQL Exception!!!");
            }
      oblist.clear();
         userid.setCellValueFactory(new PropertyValueFactory<>("userid1"));
                        username.setCellValueFactory(new PropertyValueFactory<>("username1"));
                        usagetime.setCellValueFactory(new PropertyValueFactory<>("usagetime1"));
                        billamount.setCellValueFactory(new PropertyValueFactory<>("billamount1"));
                        extraamount.setCellValueFactory(new PropertyValueFactory<>("extraamount1"));
                        totalamount.setCellValueFactory(new PropertyValueFactory<>("totalamount1"));
                        firstvisit.setCellValueFactory(new PropertyValueFactory<>("firstvisit1"));
                        likelihoodtoreturn.setCellValueFactory(new PropertyValueFactory<>("likelihoodtoreturn1"));
                        feedback.setCellValueFactory(new PropertyValueFactory<>("feedback1"));
            usertable.setItems(oblist);
            usertable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            usertable.getSelectionModel().setCellSelectionEnabled(true);
            signup_button.setDisable(true);
            
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");
                String sql="select u.*,i.user_name,f.first_visit,f.likelihood_to_return,f.feedback_received from charges u,users i,feedback f where u.user_id=i.user_id and u.user_id=f.user_id order by u.user_id desc";
                PreparedStatement xyz=con.prepareStatement(sql);
                ResultSet rs=xyz.executeQuery();
                while(rs.next())
                {
                    oblist.add(new userstats(rs.getString("user_id"), rs.getString("user_name"),rs.getString("usage_time") , rs.getString("bill_amount"), rs.getString("extra_amount"), rs.getString("total_amount"),rs.getString("first_visit"),rs.getString("likelihood_to_return"),rs.getString("feedback_received")));
                }
    }
    
           // signup_button.setDisable(upper);
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                        userid.setCellValueFactory(new PropertyValueFactory<>("userid1"));
                        username.setCellValueFactory(new PropertyValueFactory<>("username1"));
                        usagetime.setCellValueFactory(new PropertyValueFactory<>("usagetime1"));
                        billamount.setCellValueFactory(new PropertyValueFactory<>("billamount1"));
                        extraamount.setCellValueFactory(new PropertyValueFactory<>("extraamount1"));
                        totalamount.setCellValueFactory(new PropertyValueFactory<>("totalamount1"));
                        firstvisit.setCellValueFactory(new PropertyValueFactory<>("firstvisit1"));
                        likelihoodtoreturn.setCellValueFactory(new PropertyValueFactory<>("likelihoodtoreturn1"));
                        feedback.setCellValueFactory(new PropertyValueFactory<>("feedback1"));
            usertable.setItems(oblist);
            usertable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            usertable.getSelectionModel().setCellSelectionEnabled(true);
            signup_button.setDisable(true);
            try{
                 Class.forName("oracle.jdbc.driver.OracleDriver");
                 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cyber","cyber");
                String sql="select u.*,i.user_name,f.first_visit,f.likelihood_to_return,f.feedback_received from charges u,users i,feedback f where u.user_id=i.user_id and u.user_id=f.user_id order by u.user_id desc";
                PreparedStatement xyz=con.prepareStatement(sql);
                ResultSet rs=xyz.executeQuery();
                while(rs.next())
                {
                    oblist.add(new userstats(rs.getString("user_id"), rs.getString("user_name"),rs.getString("usage_time") , rs.getString("bill_amount"), rs.getString("extra_amount"), rs.getString("total_amount"),rs.getString("first_visit"),rs.getString("likelihood_to_return"),rs.getString("feedback_received")));
                }
             
                con.close();
 
            } catch (ClassNotFoundException ex) {
                System.out.println("Exception in class");
        } catch (SQLException ex) {
                System.out.println("Exception in SQL");
        }
                    
    }    
    
}
