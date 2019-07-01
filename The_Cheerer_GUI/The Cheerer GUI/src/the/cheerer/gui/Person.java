package the.cheerer.gui;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Person {

    private static int feeling=0;
    private String name;
    private int age;
    private String country;
    
    Person()
    {
        
    }
    
    Person(String name,String Country)
    {
        setName(name);
        setAge(0);
        setCountry(country);
        
    }
    Person(String name,int age)
    {
        setName(name);
        setAge(age);
        setCountry(null);
        
    }
    Person(String name,int age,String country)
    {
        setName(name);
        setAge(age);
        setCountry(country);
        
    }
    Person(String name)
    {
        setName(name);

    }
    
    public int getFeeling() {
        return feeling;
    }

    public void setFeeling(int feeling) {
        this.feeling = feeling;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    public void storeData()
    {
        
        FileWriter f = null;
        try{
         f = new FileWriter("User Data.txt",true);
        f.write("\n"+name+"\t\t"+age+"\t\t"+country); // stores data in a file
        f.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error");
        }
    }
    public ArrayList<String> getData()
    {
        ArrayList<String> data = new ArrayList<>(); 
        Scanner s;
        try{
            s = new Scanner(new File("User Data.txt"));
            while (s.hasNextLine())
            {
                data.add(s.nextLine());
            }
        }
        catch (Exception ex)
        {
             System.out.println("Error");
        }
        return data;
    }    
}
