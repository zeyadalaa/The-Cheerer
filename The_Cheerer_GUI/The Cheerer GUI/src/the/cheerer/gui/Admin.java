package the.cheerer.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Admin extends Person {
    private final String user="admin";
    
    private final String password="0000";

    public Admin()
    {
        
    }
    
    public Admin(String name) {
        super(name);
    }


    public Boolean adminCheck(String user,String password)
    {
        if (this.user.equals(user)&& this.password.equals(password))
        {
            return true;
        }else
            return false;
        
    }
    
    
    
}
