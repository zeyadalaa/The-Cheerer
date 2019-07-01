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
 * FXML Controller class
 *
 * @author zeyad
 */
public class HomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */        @FXML
    private Button btn;
        @FXML
    private void Enter(ActionEvent event) 
    {
         try {
             AuthorizationCodeUri login =new AuthorizationCodeUri();
             Desktop desktop = Desktop.getDesktop();
             desktop.browse(new URI( login.authorizationCodeUri_Sync()));
         } catch (URISyntaxException e) {
                 System.out.println("Error: " + e.getCause().getMessage());
         } catch (IOException e) {
                 System.out.println("Error: " + e.getCause().getMessage());
         }

        /*      GetAudioAnalysisForTrack z= new GetAudioAnalysisForTrack();
        z.getAccessToken();
        z.getAudioFeaturesForTrack_Sync();*/
        Parent homepageparent;
         try {
             homepageparent = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
            Scene homepagescene=new Scene(homepageparent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(homepagescene);
            window.show();
         } catch (IOException e) {
                 System.out.println("Error: " + e.getMessage());
        }catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
                
      
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
