/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cybercafe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Jayasurya
 */
public class CyberCafe extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       // (Node)
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
       // scene.getStylesheets().add(getClass().getResource("newCascadeStyleSheet.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("iCafe Manager");
      //  stage.setFullScreen(true);
      stage.initStyle(StageStyle.UTILITY);
      stage.show();
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.setMaximized(true);
        stage.setOnCloseRequest(e -> e.consume());  
         //stage.sizeToScene();
         stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
         //stage.close();
        // stage.hide();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
