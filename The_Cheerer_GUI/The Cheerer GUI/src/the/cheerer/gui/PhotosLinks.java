package the.cheerer.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PhotosLinks extends Content {

    
    
    private File PhotosHappy=new File("PhotosHappy.txt");
    
    private File PhotosSad =new File("PhotosSad.txt");
    
    private ArrayList<String> HappyPhotosLinks=new ArrayList<>();  
    
    private ArrayList<String> SadPhotosLinks=new ArrayList<>();  
    
    public PhotosLinks() {
        Scanner readFromFile = null;
         
        try{
            readFromFile=new Scanner(PhotosSad);
        
        }catch(FileNotFoundException ex)
        {
            System.out.println("File not Found");
        }
        
        while(readFromFile.hasNextLine())
        {
            SadPhotosLinks.add(readFromFile.nextLine());
            
        }
         
        try{
            readFromFile=new Scanner(PhotosHappy);
        
        }catch(FileNotFoundException ex)
        {
            System.out.println("File not Found");
        }
        
        while(readFromFile.hasNextLine())
        {
            HappyPhotosLinks.add(readFromFile.nextLine());
            
        }
    }
    
    public String GetSadLink() 
    {
         
        Random rand = new Random();

        // Obtain a number between [0 - max lines in file videos].
        int n = rand.nextInt(SadPhotosLinks.size());
        
        return SadPhotosLinks.get(n);
    }
    public String GetHappyLink() 
    {
        
        Random rand = new Random();

        // Obtain a number between [0 - max lines in file videos].
        int n = rand.nextInt(HappyPhotosLinks.size());
        
        return HappyPhotosLinks.get(n);
    }
    public void AddHappyPhotosURL(String PhotosLink) 
    {
        try{
        FileWriter writeInFile = new FileWriter(PhotosHappy,true);
        writeInFile.write("\n"+PhotosLink);
        writeInFile.close();
         }
        catch(FileNotFoundException e)
        {
            System.out.println("file not found");
        }catch (IOException e){
            System.out.println("file not found");
        }
    }
    public void AddSadPhotosURL(String PhotosLink)
    {
        try{
        FileWriter writeInFile = new FileWriter(PhotosSad,true);
         writeInFile.write("\n"+PhotosLink);
        writeInFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            
            System.out.println("Error in writing");
        }
       
    }
    @Override
    public ArrayList<String> printData(int feelings) {
        if(feelings==1) // happy
             return HappyPhotosLinks;
        else
             return SadPhotosLinks;
    }
}
