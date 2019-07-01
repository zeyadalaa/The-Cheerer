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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zeyad
 */
public class DevWriteController implements Initializable {

    @FXML
    private Button addQuotes;

    @FXML
    private Button addVideoLinks;

    @FXML
    private Button addPhotoLinks;

    @FXML
    private Button addMusicID;

    @FXML
    private Button Back;

    @FXML
    private Button Exit;

    @FXML
    private RadioButton sad;

    @FXML
    private ToggleGroup Feelings;

    @FXML
    private RadioButton happy;

    @FXML
    private TextArea txt;

    @FXML
    void btnBack(ActionEvent event) {
             Parent homepageparent;
        try {
            homepageparent = FXMLLoader.load(getClass().getResource("DevLogin.fxml"));
            Scene homepagescene=new Scene(homepageparent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepagescene);
        window.show();
        
        } catch (IOException ex) {
            System.out.println("Cant load new window");
        }
    }

    @FXML
    void btnExit(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
         stage.close();
    }

    @FXML
    void addVideosLink(ActionEvent event) {
        VideosLinks VideoLink= new VideosLinks();
        if(happy.isSelected())
        VideoLink.AddHappyVideo(txt.getText());
        else if (sad.isSelected())
        VideoLink.AddSadVideo(txt.getText());
     
    }
     @FXML
    void addPhotoLink(ActionEvent event) {
       PhotosLinks PhotoLink= new PhotosLinks();
        if(happy.isSelected())
        PhotoLink.AddHappyPhotosURL(txt.getText());
        else if (sad.isSelected())
        PhotoLink.AddSadPhotosURL(txt.getText());
     
    }

@FXML
    private void addQuotes(ActionEvent event) 
    {
        Quotes q = new Quotes();
        if (happy.isSelected())
        q.addHappyQuote(txt.getText());
        else if (sad.isSelected())
        q.addSadQuote(txt.getText());

    }
    @FXML
    private void addMusicID(ActionEvent event) 
    {
        Music q = new Music();
        if (happy.isSelected())
        q.addHappySong(txt.getText());
        else if (sad.isSelected())
        q.addSadSong(txt.getText());

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
