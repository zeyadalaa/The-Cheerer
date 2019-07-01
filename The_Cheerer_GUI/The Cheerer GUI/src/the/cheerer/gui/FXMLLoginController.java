/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.stage.Window;

/**
 *
 * @author Ahmed
 */
public class FXMLLoginController implements Initializable {
    
  
    
    @FXML
    private Button devmode;

    @FXML
    private TextField f1;

    @FXML
    private TextField f2;

    @FXML
    private TextField f3;

    @FXML
    private Button enter;

    
    @FXML
    private void btnenter(ActionEvent event) 
    {
        String name,country;
        int age;
        name = f1.getText();
        age = Integer.parseInt(f2.getText());
        country = f3.getText();
        Person p = new Person();
        p.setAge(age);
        p.setCountry(country);
        p.setName(name);
        p.storeData();
        enter.setDisable(true);
        
        Parent homepageparent;
        try {
            homepageparent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene homepagescene=new Scene(homepageparent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(homepagescene);
            window.show();
        } catch (IOException e) {
                 System.out.println("Error: " + e.getMessage());
        }

    }
    
    @FXML
    private void devmode(ActionEvent event) throws Exception
    {
        Parent homepageparent = FXMLLoader.load(getClass().getResource("DevLogin.fxml"));
        Scene homepagescene=new Scene(homepageparent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepagescene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
