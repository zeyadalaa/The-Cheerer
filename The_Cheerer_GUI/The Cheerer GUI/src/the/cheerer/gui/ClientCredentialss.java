/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

/**
 *
 * @author zeyad
 */

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.http.HttpException;

// to get access token for requests

public class ClientCredentialss {

       static Client client= new Client();
    
  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setClientId(client.getClientId())
          .setClientSecret(client.getClientSecret())
          .build();
  private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
          .build();

  public  String clientCredentials_Sync()  {
    try {
      final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

      // Set access token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(clientCredentials.getAccessToken());
      
      System.out.println("Expires in: " + clientCredentials.getExpiresIn());
    } catch ( IOException e) {
      System.out.println("Error: " + e.getMessage());
    }catch (SpotifyWebApiException e)
    {
      System.out.println("Error: " + e.getMessage());
    }
    return spotifyApi.getAccessToken();
  }


  
}