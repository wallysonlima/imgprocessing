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
    
     public void convertToDarken(int value, String type) throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-1/darkenImage" + type + ".pgm");
            
            ps.println("P3");
            ps.println("#Darken " + type);
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( type.equalsIgnoreCase("R") ) {
                        if ( (red[r][c] - value) > 0 )
                            ps.print(String.valueOf(red[r][c] - value)  + " ");    
                        else
                            ps.print(String.valueOf(0)  + " ");
                    }
                    else if ( type.equalsIgnoreCase("G") ) {
                        if ( (green[r][c] - value) > 0 )
                            ps.print(String.valueOf(green[r][c] - value)  + " ");    
                        else
                            ps.print(String.valueOf(0)  + " ");
                    }
                    else {
                        if ( (blue[r][c] - value) > 0 )
                            ps.print(String.valueOf(blue[r][c] - value)  + " ");    
                        else
                            ps.print(String.valueOf(0)  + " ");
                    }
                        
            
            ps.close();
        }
     
     // Image to Lighten by add Value
        public void convertToLightenByAddValue(int value) throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-9/ligthenImageByAddValue.pgm");
            
            ps.println("P2");
            ps.println("#Lighten By Add value");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( pixels[r][c] + value < 255 )
                        ps.print(String.valueOf( pixels[r][c] + value ) + " ");
                    else
                        ps.print("255 ");
                    
            ps.close();
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
