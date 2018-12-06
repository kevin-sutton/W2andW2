///////////////////////////////////////////////////////////////////////////
//
//  Name: W2andW2
//  Author: Kevin Sutton
//  Description: This class is the main file for the program. It runs the
//  functions neccesary to run the program.
//
//  Fields:
//  Functions:  static void main(String[] args)
//  Parent:
//  Children:
//
///////////////////////////////////////////////////////////////////////////
package w2andw2;

import java.io.File;

/**
 *
 * @author Kevin
 */
public class W2andW2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        mailOut.sendOut("test", "hope this works");
        htmlReader on = new htmlReader(htmlReader.getFile("htmlText"));
        
    }
    
}
