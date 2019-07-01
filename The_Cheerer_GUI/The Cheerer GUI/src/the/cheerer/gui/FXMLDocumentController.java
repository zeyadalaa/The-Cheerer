/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.apache.http.HttpException;

/**
 *
 * @author Ahmed
 */
public class FXMLDocumentController implements Initializable {
    
  
    
    
    @FXML
    private RadioButton sad;

    @FXML
    private RadioButton happy;
       
    @FXML
    private ImageView imageShow;
    
    @FXML
    private Button ShowQuotes;
    
    @FXML
    private Button ListentoMusic;
    
    @FXML
    private Button ShowVideos;

    public final  Spotify S=new Spotify();
    
    
    int feeling;
    @FXML
    private void ShowVideoAction(ActionEvent event)  {
        VideosLinks VideoLink= new VideosLinks();
        try{
        if(sad.isSelected())
        {
            feeling = 2;
            // open link in browser
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(VideoLink.GetHappyLink()));
        }else if(happy.isSelected())
        {
            feeling = 1;
            // open link in browser
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(VideoLink.GetSadLink()));
        }}
        catch(URISyntaxException e){
            System.out.println("Error in URI");
            
        }catch(IOException e)
        {
            System.out.println("Cant load new window");
        }
   //     try{
            
      
        

               
       // }catch(IOException e)
       // {
       //     System.out.println("Cant load Scene");
       // }
        
    }
    @FXML
    private void ShowQuotescAtion(ActionEvent event) {
       Person p= new Person();
      if(happy.isSelected())
          p.setFeeling(1);
        else if (sad.isSelected())
          p.setFeeling(2);
     
        
        
        Parent homepageparent;
        try {
            homepageparent = FXMLLoader.load(getClass().getResource("FXMLQuotes.fxml"));
            Scene homepagescene=new Scene(homepageparent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepagescene);
        window.show();
        
        } catch (IOException ex) {
            System.out.println("Cant load new window");
        }
        
    }
    @FXML
    private void ShowMusicAction(ActionEvent event)  {
        
          Person p= new Person();
      if(happy.isSelected())
          p.setFeeling(1);
        else if (sad.isSelected())
          p.setFeeling(2);
            Parent homepageparent;
             try {
            homepageparent = FXMLLoader.load(getClass().getResource("MusicView.fxml"));
            Scene homepagescene=new Scene(homepageparent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepagescene);
        window.show();        
        } catch (IOException ex) {
            System.out.println("Cant load new window" + ex.getMessage());
        }
           
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        
        
    }    
    
}
