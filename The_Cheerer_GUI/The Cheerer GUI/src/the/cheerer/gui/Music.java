package the.cheerer.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
 
public class Music extends Content {
    File happy = new File ("HappySongs.txt");
     ArrayList<String> Sad = new ArrayList<>();// arraylist of strings to store quotes
    ArrayList<String> Happy = new ArrayList<>();// arraylist of strings to store quotes
    BufferedReader x;
    public Music() {
        // Sad Intitalization
        try {
            x = new BufferedReader(new FileReader("SadSongs.txt"));
 
            String temp; // temp tsring for line jump
            temp = x.readLine();
 
            while (temp != null) {
                Sad.add(temp);
                temp = x.readLine();
            }
            x.close();
 
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
 
        }
 
        // Happy Intitalization
        try {
            x = new BufferedReader(new FileReader("HappySongs.txt"));
 
            String temp; // temp tsring for line jump
            temp = x.readLine();
 
            while (temp != null) {
                Happy.add(temp);
                temp = x.readLine();
            }
            x.close();
 
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
 
        }
    }
    public String HappySongs()
   {
       try{
           x = new BufferedReader(new FileReader("HappySongs.txt"));
           String songId = null; // string to store a quote
       int i=0; // counter for file lines
        String temp; // temp tsring for line jump
        temp = x.readLine();
 
       while (temp!=null)
       {
           i++;            
            temp = x.readLine();
 
       }
 
       Random rand = new Random();
       int n = rand.nextInt(i);
       if (n>=i-1)
            n--;
            else
            n++;
       
 
       i=1;
       x = new BufferedReader(new FileReader("HappySongs.txt"));
       temp = x.readLine();
 
       while (temp!=null)
       {
           if (n == i)
           { 
               songId = x.readLine();
 
           }
                i++;
               temp = x.readLine();
 
 
 
       }
       x.close();
       return songId;
       }
 
       catch (Exception ex)
       {
           return "Error"+ex.getMessage();
       }
   }
   public String SadSongs()
   {
       try{
           x = new BufferedReader(new FileReader("SadSongs.txt"));
           String songId = null; // string to store a quote
       int i=0; // counter for file lines
        String temp; // temp tsring for line jump
        temp = x.readLine();
 
       while (temp!=null)
       {
           i++;            
            temp = x.readLine();
 
       }
 
       Random rand = new Random();
       int n = rand.nextInt(i);
       if (n>=i-1)
            n--;
            else
            n++;
       
       i=1;
       x = new BufferedReader(new FileReader("SadSongs.txt"));
       temp = x.readLine();
 
       while (temp!=null)
       {
           if (n == i)
           { 
               songId = x.readLine();
 
           }
                i++;
               temp = x.readLine();
 
 
 
       }
       x.close();
       return songId;
       }
 
       catch (Exception ex)
       {
           return "Error"+ex.getMessage();
       }
   }
    public void addHappySong(String song) 
    {
        try{
        FileWriter writeInFile = new FileWriter("HappySongs.txt",true);
        writeInFile.write("\n"+song);
        writeInFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(""+e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    public void addSadSong(String song) 
    {
        try{
 
        FileWriter writeInFile = new FileWriter("SadSongs.txt",true);
        writeInFile.write("\n"+song);
        writeInFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(""+e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
   @Override
    public ArrayList<String> printData(int feeling)
    {
        if (feeling == 1)
        {
            return Happy;
        }
        else if (feeling == 2)
        {
            return Sad;
        }
        else 
            return null;
    }
    public String HappyDemo()
   {
       try{
           x = new BufferedReader(new FileReader("HappyDemoSongs.txt"));
           String songId = null; // string to store a quote
       int i=0; // counter for file lines
        String temp; // temp tsring for line jump
        temp = x.readLine();
 
       while (temp!=null)
       {
           i++;            
            temp = x.readLine();
 
       }
 
       Random rand = new Random();
       int n = rand.nextInt(i);
       if (n>=i-1)
            n--;
            else
            n++;
       
 
       i=1;
       x = new BufferedReader(new FileReader("HappyDemoSongs.txt"));
       temp = x.readLine();
 
       while (temp!=null)
       {
           if (n == i)
           { 
               songId = x.readLine();
 
           }
                i++;
               temp = x.readLine();
 
 
 
       }
       x.close();
       return songId;
       }
 
       catch (Exception ex)
       {
           return "Error"+ex.getMessage();
       }
   }
   public String SadDemo()
   {
       try{
           x = new BufferedReader(new FileReader("SadDemoSongs.txt"));
           String songId = null; // string to store a quote
       int i=0; // counter for file lines
        String temp; // temp tsring for line jump
        temp = x.readLine();
 
       while (temp!=null)
       {
           i++;            
            temp = x.readLine();
 
       }
 
       Random rand = new Random();
       int n = rand.nextInt(i);
       if (n>=i-1)
            n--;
            else
            n++;
       
       i=1;
       x = new BufferedReader(new FileReader("SadDemoSongs.txt"));
       temp = x.readLine();
 
       while (temp!=null)
       {
           if (n == i)
           { 
               songId = x.readLine();
 
           }
                i++;
               temp = x.readLine();
 
 
 
       }
       x.close();
       return songId;
       }
 
       catch (Exception ex)
       {
           return "Error"+ex.getMessage();
       }
   }
}