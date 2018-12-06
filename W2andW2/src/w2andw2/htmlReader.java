///////////////////////////////////////////////////////////////////////////
//
//  Name: htmlReader
//  Author: Kevin Sutton
//  Description: This Class reads in html page data and displays it
//  to the screen
//
//  Fields: Scanner inStream
//  Functions:  htmlReader(String[] stylesheet, String[] htmlpage
//              htmlReader(String[] htmlpage)
//              static String[] getFile(String input)
//  Parent:
//  Children:
//
///////////////////////////////////////////////////////////////////////////
package w2andw2;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.CENTER;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author Kevin
 */
public class htmlReader {
    
    private static Scanner inStream = null;
    
    ///////////////////////////////////////////////////////////////////////////////
    //  Description: This function serves as the constructor for an html reader
    //  object.
    //
    //  Inputs: A string array containing the lines for a css style sheet
    //          A string array containing the lines for an html page
    //
    //  Outputs: A window on screen displaying the html page.
    ///////////////////////////////////////////////////////////////////////////////
    public htmlReader(String[] stylesheet, String[] htmlpage)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                JEditorPane jeditpane = new JEditorPane();
                
                jeditpane.setEditable(false);
                
                JScrollPane scrollpane = new JScrollPane(jeditpane);
                
                HTMLEditorKit editkit = new HTMLEditorKit();
                jeditpane.setEditorKit(editkit);
                
                StyleSheet styleSheet = editkit.getStyleSheet();
                int i = 0;
                while (i < stylesheet.length)
                {
                    styleSheet.addRule(stylesheet[i]);
                    i++;
                }
                
                String htmlContents = "";
                i = 0;
                while (i < htmlpage.length)
                {
                    htmlContents += htmlpage[i];
                    i++;
                }
                
                Document doc = editkit.createDefaultDocument();
                jeditpane.setDocument(doc);
                jeditpane.setText(htmlContents);
                
                JFrame frame = new JFrame("W2andW2 - in developement");
                frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(300,200));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //  Description: This function serves as the constructor for an html reader
    //  object.
    //
    //  Inputs: A string array containing the lines for an html page
    //
    //  Outputs: A window on screen displaying the html page.
    ///////////////////////////////////////////////////////////////////////////////
    public htmlReader(String[] htmlpage)
    {
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                JEditorPane jeditpane = new JEditorPane();
                
                jeditpane.setEditable(false);
                
                JScrollPane scrollpane = new JScrollPane(jeditpane);
                
                HTMLEditorKit editkit = new HTMLEditorKit();
                jeditpane.setEditorKit(editkit);
                
                String htmlContents = "";
                int i = 0;
                while (i < htmlpage.length)
                {
                    htmlContents += htmlpage[i];
                    System.out.println(htmlpage[i]);
                    i++;
                }
                
                Document doc = editkit.createDefaultDocument();
                jeditpane.setDocument(doc);
                jeditpane.setText(htmlContents);
                
                JFrame frame = new JFrame("W2andW2 - in developement");
                frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(new Dimension(1000,1000));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                
            }
        });
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //  Description: This function reads in information from external files.
    //
    //  Inputs: A string containing the name of the file to be read in. This file 
    //  must be a .txt file.
    //
    //  Outputs: A String array containing the lines in the file.
    ///////////////////////////////////////////////////////////////////////////////
    public static String[] getFile(String input)
    {
        File in = new File(input + ".txt");
        int count = 0;
        
        try
        {
            inStream = new Scanner(in);
            System.out.println("File opened successfully");
            
            BufferedReader reader = new BufferedReader(new FileReader(in));
            while(reader.readLine() != null)
            {
                count++;
            }
            reader.close();
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println("There is no such file " + input + ".txt");
            System.out.println(e);
        }
        catch(IOException e)
        {
            System.out.println("Error in reading lines");
            System.out.println(e);
        }
        
        String[] contents = new String[count];
        
        count = 0;
        while(count < contents.length)
        {
            if(inStream.hasNextLine())
            {
                contents[count] = inStream.nextLine();
                System.out.println(contents[count]);
            }
            count++;
        }
        
        inStream.close();
        System.out.println("Stream Closed");
        
        return contents;
    }
    
}
