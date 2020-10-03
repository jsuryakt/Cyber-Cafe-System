/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author hp
 */
public class Admin extends Application {
    
    @Override
    public void start(Stage stage1) throws Exception {
        Pane root = FXMLLoader.load(getClass().getResource("AdminController.fxml")); 
        Scene scene = new Scene(root);
        stage1.setTitle("Admin Settings");
        stage1.getIcons().add(new Image("file:resources/images/c.png"));
        stage1.resizableProperty().setValue(Boolean.FALSE);
        stage1.initStyle(StageStyle.UTILITY);
        stage1.setScene(scene);
        stage1.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
