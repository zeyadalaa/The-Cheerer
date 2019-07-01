/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Track;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import org.apache.http.HttpException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Ahmed
 */

public class MusicViewController implements Initializable {
public final  Spotify S=new Spotify();
Person feeling = new Person();
    Stage stage;  
    @FXML
    private Label sss;
     @FXML
    private ListView<String> listview;
     
     @FXML
     private RadioButton drake;
     @FXML
     private RadioButton taylorswiift;
     @FXML
     private RadioButton sia;

    /**
     * Initializes the controller class.
     */ 
     @FXML
    private void TopMusic(ActionEvent event)
    {
       
       
        String id = "5WUlDfRSoLAfcVSX1WnrxN";
        
        Spotify s = new Spotify();
        s.setArtistId(id);
        s.setAccessTokenArtist();
        
         Track[] tracks = s.getArtistsTopTracks_Sync();
         
        s.setAccessTokenArtist();
        for (int i =0;i<tracks.length;i++)
        {   
            
           System.out.println(tracks[i].getName());
         }
        
            
        
        
        
    }
    
    @FXML
    private void Back(ActionEvent event)
    {
        Parent homepageparent;
         try {
            homepageparent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene homepagescene=new Scene(homepageparent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepagescene);
        window.show();        
        } catch (IOException ex) {
            System.out.println("Cant load new window" + ex.getMessage());
        }
    }
    @FXML
    private void nextSong(ActionEvent event)
    {
        String id=null;
         Music m = new Music();
         Person p = new Person();
        String link = "https://open.spotify.com/track/";
        if (p.getFeeling()==1)
         id = m.HappySongs();
        else if (p.getFeeling()==2)
            id = m.SadSongs();
        link = link+id;
        
        Desktop desktop = Desktop.getDesktop();
        try{
            desktop.browse(new URI(link));
        }
        catch (Exception e)
        {
            System.out.println(""+ e.getMessage());
        }
        S.setID(id);
        S.getAccessToken();
        String name = S.getTrack_Sync();
        sss.setText(name);
       
    }
    @FXML
    private void Demo(ActionEvent event)
    {
        Parent homepageparent;
         try {
            homepageparent = FXMLLoader.load(getClass().getResource("Demo.fxml"));
            Scene homepagescene=new Scene(homepageparent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepagescene);
        window.show();        
        } catch (IOException ex) {
            System.out.println("Cant load new window" + ex.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    /*
        String id=null;
         Music m = new Music();
         Person p = new Person();
        String link = "https://open.spotify.com/track/";
        if (p.getFeeling()==1)
         id = m.HappySongs();
        else if (p.getFeeling()==2)
            id = m.SadSongs();
        link = link+id;
        
        Desktop desktop = Desktop.getDesktop();
        try{
            desktop.browse(new URI(link));
        }
        catch (Exception e)
        {
            System.out.println(""+ e.getMessage());
        }
        */
        /*final WebEngine webEngine = loginWebView.getEngine();
 
        // LOad the Start-Page
        webEngine.load(link);
         
        // Update the stage title when a new web page title is available
        webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() 
        {
            public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) 
            {
                if (newState == State.SUCCEEDED) 
                {
                    //stage.setTitle(webEngine.getLocation());
                    stage.setTitle(webEngine.getTitle());
                }
            }
        });*/
    }    
    
}
