
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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class DemoController implements Initializable {

    @FXML WebView loginWebView;
    Stage stage ;
    String link,id;
    Spotify s = new Spotify();
    Person p = new Person();
    Music m = new Music();
    int feeling = p.getFeeling();
    
    @FXML
    private void Back(ActionEvent event)
    {
        Parent homepageparent;
         try {
            homepageparent = FXMLLoader.load(getClass().getResource("MusicView.fxml"));
            Scene homepagescene=new Scene(homepageparent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepagescene);
        window.show();        
        } catch (IOException ex) {
            System.out.println("Cant load new window" + ex.getMessage());
            }catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (feeling == 1)
        {
            id = m.HappyDemo();
            System.out.println(id);
            s.setID(id);           
            s.getAccessToken();
            link = s.getTrack_Demo();
        }
           else if (feeling == 2)
        {
            id = m.SadDemo();
            s.setID(id);            
            s.getAccessToken();
            link = s.getTrack_Demo();
            System.out.println(link);           
        }
        final WebEngine webEngine = loginWebView.getEngine();
 
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
        });
    }    
    
}
