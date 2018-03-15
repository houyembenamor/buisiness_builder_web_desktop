/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfadi;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Meriem
 */
public class TestFadi extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException{
         FXMLLoader loader=new FXMLLoader(getClass().getResource("Interface1.fxml"));// on ajouté notre fichier FXML la première scene
            Parent root= loader.load();//stage =le contenaire vide là ou on va mettre nos scènes
            Scene scene=new Scene(root);// la scène regroupement de tous les éléments graphiques
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
