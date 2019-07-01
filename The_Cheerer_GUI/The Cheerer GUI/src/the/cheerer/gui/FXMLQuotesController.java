/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zeyad
 */
public class FXMLQuotesController implements Initializable {

    
    @FXML
    private Label label1;

    @FXML
    private ImageView imageview;

    @FXML
    private Button back;

    @FXML
    private Button exit;
    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private void BackAction(ActionEvent event)  {
    
         Parent homepageparent;
        try {
            homepageparent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene homepagescene=new Scene(homepageparent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepagescene);
        window.show();
        
        } catch (IOException ex) {
            System.out.println("Cant load new window");
        }
    }
    @FXML
    private void ExitAction(ActionEvent event)  {
    
        Stage stage = (Stage) exit.getScene().getWindow();
         stage.close();
    }
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Person p=new Person();
        
        Quotes q = new Quotes();
        PhotosLinks photosLink= new PhotosLinks();
        if(p.getFeeling()==2)
        {
            
            Image image= new Image(photosLink.GetSadLink());
            imageview.setImage(image);
            label1.setText(q.SadQuote());
        }else if(p.getFeeling()==1)
        {

            // open link in browser
            Image image= new Image(photosLink.GetHappyLink());
            imageview.setImage(image);
            label1.setText(q.HappyQuote());
            
        }
        
        
    }    
    
}
