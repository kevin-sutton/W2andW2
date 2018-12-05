/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w2andw2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
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
    
    public String[] getFile(File input)
    {
        try
        {
            inStream = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("There is no such file " + input.getName());
            System.out.println(e);
        }
        int count = 0;
        
        while (inStream.hasNextLine())
        {
            count++;
        }
        String[] contents = new String[count];
        count = 0;
        
        while (inStream.hasNextLine())
        {
            contents[count] = inStream.nextLine();
            count++;
        }
        return contents;
       
    }
    
}
