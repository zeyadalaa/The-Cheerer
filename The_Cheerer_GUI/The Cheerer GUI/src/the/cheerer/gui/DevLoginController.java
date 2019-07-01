/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zeyad
 */
public class DevLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField usertext;

    @FXML
    private TextField paswordtext;

    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    private Label label;
        @FXML
    private Button addData;
    @FXML
    private void btnNext(ActionEvent event)   
    {
        Admin admin=new Admin();
        
        if(admin.adminCheck(usertext.getText(), paswordtext.getText()))
        {
        Parent homepageparent;
            try {
                homepageparent = FXMLLoader.load(getClass().getResource("DevMode.fxml"));
                Scene homepagescene=new Scene(homepageparent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(homepagescene);
                window.show();
            } catch (IOException e) {
                 System.out.println("Error: " + e.getMessage());
            }
        
        }
        else
        {
            label.setText("Check your user or password");
        }
        
    }
    @FXML
    private void btnAddData(ActionEvent event)   
    {
        Admin admin=new Admin();
        
        if(admin.adminCheck(usertext.getText(), paswordtext.getText()))
        {
        Parent homepageparent;
            try {
                homepageparent = FXMLLoader.load(getClass().getResource("DevWrite.fxml"));
                Scene homepagescene=new Scene(homepageparent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(homepagescene);
                window.show();
            } catch (IOException e) {
                 System.out.println("Error: " + e.getMessage());
            }

        }
        else
        {
            label.setText("Check your user or password");
        }
        
    }
    
    @FXML
    private void btnBack(ActionEvent event) 
    {
        Parent homepageparent;
        try {
            homepageparent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
            Scene homepagescene=new Scene(homepageparent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(homepagescene);
            window.show();
        } catch (IOException e) {
                 System.out.println("Error: " + e.getMessage());
            }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
