/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.cheerer.gui;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;

import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.tracks.GetTrackRequest;

import org.apache.http.HttpException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import  com.wrapper.spotify.model_objects.specification.ExternalUrl;
import  com.wrapper.spotify.model_objects.specification.ExternalUrl.Builder;
import com.wrapper.spotify.requests.data.artists.GetArtistsTopTracksRequest;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zeyad
 */
// get tracks

public class Spotify {
  //  Authorization authorizer; 
    Music m = new Music();
    Person p = new Person();
    
    static Client client= new Client();
    
  static String id;
    GetTrackRequest getTrackRequest ;
    public Builder builder = new Builder();
    public ExternalUrl ur;
  static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setClientId(client.getClientId())
          .setClientSecret(client.getClientSecret())
         
          .build();

 
  public void setID(String id)
  {
      this.id = id;
  }
  public void getAccessToken(){
      
      final  ClientCredentialss CC= new ClientCredentialss();
      final SpotifyApi spotifyApi = new SpotifyApi.Builder()
              .setAccessToken(CC.clientCredentials_Sync())
              .build();
      getTrackRequest = spotifyApi.getTrack(id)
//          .market(CountryCode.SE)
              .build();
      
      
       
  }
  

  public  String getTrack_Sync() {
    try {
      final Track track = getTrackRequest.execute();
      final  ClientCredentialss CC= new ClientCredentialss();
          final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setAccessToken(CC.clientCredentials_Sync())
          .build();
      System.out.println("Name: " + track.getName());
       

      return track.getName();
    } catch (IOException  e) {
      System.out.println("Error: " + e.getMessage());
      return e.getMessage();
    }
    catch ( SpotifyWebApiException e)
    {
       return e.getMessage();
    }
    
  }
  public  String getTrack_Demo() {
    try {
      final Track track = getTrackRequest.execute();
      final  ClientCredentialss CC= new ClientCredentialss();
          final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setAccessToken(CC.clientCredentials_Sync())
          .build();

      System.out.println("Name: " + track.getPreviewUrl());
      
      return track.getPreviewUrl();
    } catch (IOException  e) {
      System.out.println("Error: " + e.getMessage());
      return e.getMessage();
    }
    catch ( SpotifyWebApiException e)
    {
       return e.getMessage();
    }

  }
  private static String artistId ;
  private static final CountryCode countryCode = CountryCode.SE;
  private  static GetArtistsTopTracksRequest getArtistsTopTracksRequest = null;

  public void setArtistId(String id)
  {
      artistId = id;
  }
public void setAccessTokenArtist()
{
    final  ClientCredentialss CC= new ClientCredentialss();
      final SpotifyApi spotifyApi = new SpotifyApi.Builder()
              .setAccessToken(CC.clientCredentials_Sync())
              .build();
   getArtistsTopTracksRequest = spotifyApi
          .getArtistsTopTracks(artistId, countryCode)
          .build();
}


  public Track[] getArtistsTopTracks_Sync() {
     Track[] tracks=null;
     Track[] temp=null;
      try {
        tracks = getArtistsTopTracksRequest.execute();

        return tracks;
    } catch (IOException | SpotifyWebApiException e) {
      System.out.println("Errorrr: " + e.getMessage());
    return tracks;
    }
  }
}
  

  

