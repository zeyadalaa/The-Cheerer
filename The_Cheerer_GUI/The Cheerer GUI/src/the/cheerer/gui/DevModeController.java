/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zeyad
 */
public class DevModeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label label;

    @FXML
    private Button ShowQuotes;

    @FXML
    private Button ShowVideoLinks;

    @FXML
    private Button ShowPhotoLinks;

    @FXML
    private Button ShowMusicID;

    @FXML
    private Button ShowUserData;

    @FXML
    private Button Back;

    @FXML
    private Button Exit;

    @FXML
    private RadioButton sad;

    @FXML
    private RadioButton happy;
    
        @FXML
    private ListView<String> listview;

    int feeling;
     @FXML
    private void btnShowVideosLink(ActionEvent event) 
    {
        Content c=new VideosLinks();
        if(sad.isSelected())
        {
        c.printData(feeling);
            feeling=2;
            ArrayList<String> temp= c.printData(feeling);
            ObservableList<String> items =FXCollections.observableArrayList (temp);
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, 
                    String old_val, String new_val) {
                     
            }
        });
            
        }else if( happy.isSelected())
        {
            c.printData(feeling);
            feeling=1;
            ArrayList<String> temp= c.printData(feeling);
            ObservableList<String> items =FXCollections.observableArrayList (temp);
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, 
                    String old_val, String new_val) {
                     
            }
        });
        }
    }
    @FXML
    private void btnShowPhotosLink(ActionEvent event) 
    {
        Content c=new PhotosLinks();
        if(sad.isSelected())
        {
        c.printData(feeling);
            feeling=2;
            ArrayList<String> temp= c.printData(feeling);
            ObservableList<String> items =FXCollections.observableArrayList (temp);
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, 
                    String old_val, String new_val) {
                     
            }
        });
            
        }else if( happy.isSelected())
        {
            c.printData(feeling);
            feeling=1;
            ArrayList<String> temp= c.printData(feeling);
            ObservableList<String> items =FXCollections.observableArrayList (temp);
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> ov, 
                    String old_val, String new_val) {
                     
            }
        });
        }
    }
    
   @FXML
    private void showMusicIDs(ActionEvent event) 
    {
         if(sad.isSelected())
        {
            feeling=2;
            Content m = new Music();
        ObservableList<String> items =FXCollections.observableArrayList (m.printData(feeling));
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
        });
        
        }
         else if (happy.isSelected())
         {
            feeling=1;
             Content m = new Music();
        ObservableList<String> items =FXCollections.observableArrayList (m.printData(feeling));
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
        });
         }
    }
    @FXML
    private void showUserData(ActionEvent event) 
    {
 
            Person m = new Person();
        ObservableList<String> items =FXCollections.observableArrayList (m.getData());
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
        });
    }
     
    @FXML
    private void showQuotes(ActionEvent event) 
    {
         if(sad.isSelected())
        {
            feeling=2;
            Content m = new Quotes();
        ObservableList<String> items =FXCollections.observableArrayList (m.printData(feeling));
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
        });
        }else if (happy.isSelected())
        {
            feeling=1;
             Content m = new Quotes();
        ObservableList<String> items =FXCollections.observableArrayList (m.printData(feeling));
     listview.setItems(items);
        listview.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
        });
        }
    }
    
    @FXML
    private void btnBack(ActionEvent event) 
    {
        Parent homepageparent;
        try {
            homepageparent = FXMLLoader.load(getClass().getResource("DevLogin.fxml"));
            Scene homepagescene=new Scene(homepageparent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(homepagescene);
            window.show();
        } catch (IOException e) {
                 System.out.println("Error: " + e.getMessage());
        }

    }
    
    @FXML
    private void btnExit(ActionEvent event) 
    {        
        
         Stage stage = (Stage) Exit.getScene().getWindow();
         stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
    
}
