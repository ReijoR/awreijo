



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.reijo.techniques.files;

import java.io.*;

/**
 *
 * @author Reijo
 */
public class FileTests {
    
    /**
     *
     * @throws java.lang.Exception
     */
    public static void createFiles() throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    try {
	String s = bf.readLine();
	       System.out.println("Kirjoitit: " + s);
    }
        catch(IOException ex) {
	           System.out.println("Ei ole");
        }
        try (PrintWriter writer = new PrintWriter("Testi.txt", "UTF-8")) {
            writer.println("Tekstiä");
            writer.println("kivaa ja hauskaa");
        }
    }
    public static void readFiles() throws Exception
    {
        File file = new File ("C:\\Users\\Reijo\\Documents\\Päivä 1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);
        
        File file2 = new File ("C:\\javatraining\\awreijo\\Techniques\\Testi.txt"); 
        BufferedReader br2 = new BufferedReader(new FileReader(file2));
        String string;
            while((string = br2.readLine()) != null)
                System.out.println(string);
               
    }       
    public static void simpleLineEditor()throws Exception{
        BufferedReader bf2 = new BufferedReader(new InputStreamreader(System.in));
    }
            
}
