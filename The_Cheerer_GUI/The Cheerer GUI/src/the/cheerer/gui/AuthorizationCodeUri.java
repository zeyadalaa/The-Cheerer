/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import java.net.URI;

/**
 *
 * @author zeyad
 */
public class AuthorizationCodeUri {

  private static final URI redirectUri = SpotifyHttpManager.makeUri("http://www.movemypaper.com/images/sucess.png");
   Spotify ss= new Spotify();
static Client client= new Client();
    
  private  final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setClientId(client.getClientId())
          .setClientSecret(client.getClientSecret())
          .setRedirectUri(redirectUri)
          .build();
  private  final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
//          .state("x4xkmn9pu3j6ukrs8n")
//          .scope("user-read-birthdate,user-read-email")
//          .show_dialog(true)
          .build();
    
      public  String authorizationCodeUri_Sync() {
    final URI uri = authorizationCodeUriRequest.execute();

    System.out.println("URI: " + uri.toString());
    return uri.toString();
  }
}
