/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author wlima
 */
public class PpmImage {
    private int[][] pixels;
    private int[][] red;
    private int[][] green;
    private int[][] blue;
    private int cols, rows, maxValue;

    // constructor that loads ppm image from a file
    public PpmImage(String filename) {
            pixels = null;
            readPPM(filename);
    }
    
    // Dark the colored image, only the Canal R or G or B.
    public void convertToDarken(int value, String type) throws IOException {
            PrintStream ps = new PrintStream("../darkenImage" + type + ".ppm");
            
            ps.println("P3");
            ps.println("#Darken " + type);
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( type.equalsIgnoreCase("R") ) {
                        if ( (red[r][c] - value) > 0 )
                            ps.println(String.valueOf(red[r][c] - value)  + " ");    
                        else
                            ps.println(String.valueOf(0)  + " ");
                        
                         ps.println(String.valueOf(green[r][c]));
                         ps.println(String.valueOf(blue[r][c]));
                        
                    }
                    else if ( type.equalsIgnoreCase("G") ) {
                         ps.println(String.valueOf(red[r][c]));
                        
                        if ( (green[r][c] - value) > 0 )
                            ps.println(String.valueOf(green[r][c] - value)  + " ");    
                        else
                            ps.println(String.valueOf(0)  + " ");
                        
                        ps.println(String.valueOf(blue[r][c]));
                    }
                    else {
                        ps.println(String.valueOf(red[r][c]));
                        ps.println(String.valueOf(green[r][c]));
                        
                        if ( (blue[r][c] - value) > 0 )
                            ps.println(String.valueOf(blue[r][c] - value)  + " ");    
                        else
                            ps.println(String.valueOf(0)  + " ");
                    }
                        
            
            ps.close();
        }
     
    // Lighten the colored image, only the Canal R or G or B.
    public void convertToLighten(int value, String type) throws IOException {
        PrintStream ps = new PrintStream("../ligthenImage" + type + ".ppm");

        ps.println("P3");
        ps.println("#Lighten By Add value");
        ps.println(cols + " " + rows);
        ps.println(maxValue);

        for( int r = 0; r < rows; r++ )
            for ( int c = 0; c < cols; c++ )
                if ( type.equalsIgnoreCase("R") ) {
                    if ( (red[r][c] + value) < 255 )
                        ps.println(String.valueOf(red[r][c] + value)  + " ");    
                    else
                        ps.println(String.valueOf(255)  + " ");

                    ps.println(String.valueOf(green[r][c]));
                    ps.println(String.valueOf(blue[r][c]));
                }
                else if ( type.equalsIgnoreCase("G") ) {
                    ps.println(String.valueOf(red[r][c]));

                    if ( (green[r][c] + value) < 255 )
                        ps.println(String.valueOf(green[r][c] + value)  + " ");    
                    else
                        ps.println(String.valueOf(255)  + " ");

                    ps.println(String.valueOf(blue[r][c]));
                }
                else {
                    ps.println(String.valueOf(red[r][c]));
                    ps.println(String.valueOf(green[r][c]));

                    if ( (blue[r][c] + value) < 255 )
                        ps.println(String.valueOf(blue[r][c] + value)  + " ");    
                    else
                        ps.println(String.valueOf(255)  + " ");
                }

        ps.close();
    }
    
    // Alter colors, mix RGB
    public void mixColors(String option) throws IOException {
        PrintStream ps = new PrintStream("../mixColor(" + option + ").ppm");

        ps.println("P3");
        ps.println("#Mix Color");
        ps.println(cols + " " + rows);
        ps.println(maxValue);
        
        for( int r = 0; r < rows; r++)
            for( int c = 0; c < cols; c++)
                if ( option.equalsIgnoreCase("RBG") ) {
                    ps.println(String.valueOf(red[r][c]));
                    ps.println(String.valueOf(blue[r][c]));
                    ps.println(String.valueOf(green[r][c]));
                } else if ( option.equalsIgnoreCase("GRB") ) {
                    ps.println(String.valueOf(green[r][c]));
                    ps.println(String.valueOf(red[r][c]));
                    ps.println(String.valueOf(blue[r][c]));
                } else if ( option.equalsIgnoreCase("GBR") ) {
                    ps.println(String.valueOf(green[r][c]));
                    ps.println(String.valueOf(blue[r][c]));
                    ps.println(String.valueOf(red[r][c]));
                } else if ( option.equalsIgnoreCase("BRG") ){
                    ps.println(String.valueOf(blue[r][c]));
                    ps.println(String.valueOf(red[r][c]));
                    ps.println(String.valueOf(green[r][c]));
                } else {
                    ps.println(String.valueOf(blue[r][c]));
                    ps.println(String.valueOf(green[r][c]));
                    ps.println(String.valueOf(red[r][c]));
                }
        
        ps.close();
    }
    
    // Change RGB to CMY format
    public void converto2Cmy() throws IOException {
       PrintStream ps = new PrintStream("../colorCMY.ppm");

       ps.println("P3");
       ps.println("#CMY Color format");
       ps.println(cols + " " + rows);
       ps.println(maxValue);
       
       for(int r = 0; r < rows; r++)
           for(int c = 0; c < cols; c++) {
                ps.println(String.valueOf(255 - red[r][c]));
                ps.println(String.valueOf(255 - green[r][c]));
                ps.println(String.valueOf(255 - blue[r][c]));
           }
               
       ps.close();
    }
    
    public void extractChanells() throws IOException {
       PrintStream rd = new PrintStream("../red.pgm");
       PrintStream gr = new PrintStream("../green.pgm");
       PrintStream bl = new PrintStream("../blue.pgm");

       rd.println("P2");
       rd.println("#RED Color format");
       rd.println(cols + " " + rows);
       rd.println(maxValue);
       
       gr.println("P2");
       gr.println("#GREEN Color format");
       gr.println(cols + " " + rows);
       gr.println(maxValue);
       
       bl.println("P2");
       bl.println("#BLUE Color format");
       bl.println(cols + " " + rows);
       bl.println(maxValue);
       
       for(int r = 0; r < rows; r++)
           for(int c = 0; c < cols; c++) {
                rd.println(String.valueOf(red[r][c]));
                gr.println(String.valueOf(green[r][c]));
                bl.println(String.valueOf(blue[r][c]));
           }
               
       rd.close();
       gr.close();
       bl.close();
    }
    
    // load gray scale pixel values from a PPM format image
    public void readPPM(String filename){
            try {                        		    
                Scanner infile = new Scanner(new FileReader(filename));
                // process the top 4 header lines
                String filetype=infile.nextLine();
                if (!filetype.equalsIgnoreCase("p3")) {
                    System.out.println("[readPPM]Cannot load the image type of "+filetype);
                    return;
                }
                    infile.nextLine();	   	   	   
                    cols = infile.nextInt();
                    rows = infile.nextInt();
                    maxValue = infile.nextInt();	        
                    red = new int[rows][cols];
                    green = new int[rows][cols];
                    blue = new int[rows][cols];
                    System.out.println("Reading in image from " + filename + " of size " + rows + " by " + cols);
                    // process the rest lines that hold the actual pixel values
                    for (int r=0; r<rows; r++) 
                            for (int c=0; c<cols; c++) {
                                red[r][c] = (int)(infile.nextInt()*255.0/maxValue);
                                green[r][c] = (int)(infile.nextInt()*255.0/maxValue);
                                blue[r][c] = (int)(infile.nextInt()*255.0/maxValue);
                            }

                    infile.close();
        } catch(FileNotFoundException fe) {
            System.out.println("Had a problem opening a file.");
        } catch (Exception e) {
            System.out.println(e.toString() + " caught in readPPM.");
            e.printStackTrace();
        }
    }
}
