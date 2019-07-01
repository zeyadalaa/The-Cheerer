package the.cheerer.gui;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VideosLinks extends Content {

    private File VideoHappy=new File("VideosHappy.txt");
    
    private File videoSad =new File("VideosSad.txt");
    
    private ArrayList<String> HappyLinks=new ArrayList<>();  
    
    private ArrayList<String> SadLinks=new ArrayList<>();  

    
    public VideosLinks() {
        Scanner readFromFile = null;
         
        try{
            readFromFile=new Scanner(videoSad);
        
        }catch(FileNotFoundException ex)
        {
            System.out.println("File not Found");
        }
        
        while(readFromFile.hasNextLine())
        {
            SadLinks.add(readFromFile.nextLine());
            
        }
       
        try{
            readFromFile=new Scanner(VideoHappy);
        
        }catch(FileNotFoundException ex)
        {
            System.out.println("File not Found");
        }
        
        while(readFromFile.hasNextLine())
        {
            HappyLinks.add(readFromFile.nextLine());
            
        }
        
    }
    
  
    public String GetSadLink() 
    {
         
        Random rand = new Random();

        // Obtain a number between [0 - max lines in file VideosLinks].
        int n = rand.nextInt(SadLinks.size());
        
        return SadLinks.get(n);
    }
    public String GetHappyLink() 
    {
         
        Random rand = new Random();

        // Obtain a number between [0 - max lines in file VideosLinks].
        int n = rand.nextInt(HappyLinks.size());
        
        return HappyLinks.get(n);
    }
    public void AddHappyVideo(String VideoLink) 
    {
        try{
        FileWriter writeInFile = new FileWriter(VideoHappy,true);
        writeInFile.write("\n"+VideoLink);
        writeInFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found");
        }catch (IOException e){
            System.out.println("file not found");
        }
    }
    public void AddSadVideo(String VideoLink) 
    {
        try{
        FileWriter writeInFile = new FileWriter(videoSad,true);
        writeInFile.write("\n"+VideoLink);
        writeInFile.close();
         }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found");
        }catch (IOException e){
            System.out.println("file not found");
        }
    }
    

    @Override
    public ArrayList<String> printData(int feeling) {
        if(feeling==1) // happy
             return HappyLinks;
        else if(feeling==2)
             return SadLinks;
        else 
            return null;
    }
}
