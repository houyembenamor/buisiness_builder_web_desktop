/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfadi;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import serviceFadi.InterfaceServiceRemote;

/**
 * FXML Controller class
 *
 * @author Meriem
 */
public class Interface1Controller implements Initializable {

    @FXML
    private TextField input;
    @FXML
    private Button button;
    @FXML
    private Label output;
    
    //variable jee
    private Context context;
    private static String servicePath ="esprit1718b2businessbuilder-ear/esprit1718b2businessbuilder-service/InterfaceService!serviceFadi.InterfaceServiceRemote";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void printName(ActionEvent event) throws NamingException{
    		context = new InitialContext();
			InterfaceServiceRemote  service = (InterfaceServiceRemote) context.lookup(servicePath);
			String name =service.sayHello(input.getText());		
			output.setText(name);  
    }
}
