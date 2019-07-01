package the.cheerer.gui;

import java.io.BufferedReader;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
 
public class Quotes extends Content {
 
    File happy = new File("Happy Quotes.txt");
    ArrayList<String> Sad = new ArrayList<>();// arraylist of strings to store quotes
    ArrayList<String> Happy = new ArrayList<>();// arraylist of strings to store quotes
    BufferedReader x;
 
    public Quotes() {
        // Sad Intitalization
 
        try {
            x = new BufferedReader(new FileReader("SadQuotes.txt"));
 
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
            x = new BufferedReader(new FileReader("Happy Quotes.txt"));
 
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
 
    public String HappyQuote() {
        try {
            x = new BufferedReader(new FileReader("Happy Quotes.txt"));
            String quote = null; // string to store a quote
            int i = 0; // counter for file lines
            String temp; // temp tsring for line jump
            temp = x.readLine();
 
            while (temp != null) {
                i++;
                temp = x.readLine();
 
            }
 
            Random rand = new Random();
            
            int n = rand.nextInt(i);
            if (n>=i-1)
            n--;
            else
            n++;
            i = 1;
            x = new BufferedReader(new FileReader("Happy Quotes.txt"));
            temp = x.readLine();
 
            while (temp != null) {
                if (n == i) {
                    quote = x.readLine();
 
                }
                i++;
                temp = x.readLine();
 
            }
            x.close();
            return quote;
        } catch (Exception ex) {
            return "Error" + ex.getMessage();
        }
    }
 
    public String SadQuote() {
        try {
            x = new BufferedReader(new FileReader("SadQuotes.txt"));
            String quote = null; // string to store a quote
            int i = 0; // counter for file lines
            String temp; // temp tsring for line jump
            temp = x.readLine();
 
            while (temp != null) {
                i++;
                temp = x.readLine();
 
            }
 
            Random rand = new Random();
            int n = rand.nextInt(i );
            if (n>=i-1)
            n--;
            else
            n++;
            i = 0;
            x = new BufferedReader(new FileReader("Happy Quotes.txt"));
            temp = x.readLine();
 
            while (temp != null) {
                if (n == i) {
                    quote = x.readLine();
 
                }
                i++;
                temp = x.readLine();
 
            }
            x.close();
            return quote;
        } catch (Exception ex) {
            return "Error" + ex.getMessage();
        }
    }
 
    public void addHappyQuote(String quote)
    {
        try{
        FileWriter writeInFile = new FileWriter("Happy Quotes.txt",true);
        writeInFile.write("\n"+quote);
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
    public void addSadQuote(String quote) 
    {
        try{
 
        FileWriter writeInFile = new FileWriter("SadQuotes.txt",true);
        writeInFile.write("\n"+quote);
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
 
    /*public ArrayList<String> allSad() {
        ArrayList<String> tempreturn = new ArrayList<>();
        try {
            x = new BufferedReader(new FileReader("SadQuotes.txt"));
            ArrayList<String> quotes = new ArrayList<>(); // arraylist of strings to store quotes
            String temp; // temp tsring for line jump
            temp = x.readLine();
 
            while (temp != null) {
                quotes.add(x.readLine());
                temp = x.readLine();
            }
            x.close();
            return quotes;
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
            return tempreturn;
        }
    }
 
    public ArrayList<String> printData(int i) {
        ArrayList<String> tempreturn = new ArrayList<>();
        try {
            x = new BufferedReader(new FileReader("Happy Quotes.txt"));
            ArrayList<String> quotes = new ArrayList<>(); // arraylist of strings to store quotes
            String temp; // temp tsring for line jump
            temp = x.readLine();
 
            while (temp != null) {
                quotes.add(x.readLine());
                temp = x.readLine();
            }
            x.close();
            return quotes;
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
            return tempreturn;
        }
    }*/
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
}