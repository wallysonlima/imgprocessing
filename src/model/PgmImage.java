/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author wlima
 */
public class PgmImage extends Component {
    // image buffer for graphical display
	private BufferedImage img;
	// image buffer for plain gray-scale pixel values
	private int[][] pixels;
        private int cols, rows, maxValue;
	
	// translating raw gray scale pixel values to buffered image for display
	private void pix2img() {
		int g;
		img = new BufferedImage( pixels[0].length, pixels.length, BufferedImage.TYPE_INT_ARGB );
		// copy the pixels values
		for(int row=0; row<pixels.length; ++row)
			for(int col=0; col<pixels[row].length; ++col){
				g = pixels[row][col];
				img.setRGB(col, row, ((255<<24) | (g << 16) | (g <<8) | g));		
			}
	}
        
        //Convert To Negative
        public void convertToNegative() throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/negativeImage.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    ps.print(String.valueOf(255 - pixels[r][c]) + " "); 
            
            ps.close();
        }
        
        //Image To Darken I
        public void convertToDarkenI(int value) throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/darkenImageI.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( (pixels[r][c] - value) > 0 )
                        ps.print(String.valueOf(pixels[r][c] - value)  + " ");    
                    else
                        ps.print(String.valueOf(0)  + " ");
            
            ps.close();
        }
        
         //Image To Darken I
        public void convertToDarkenII(int value) throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/darkenImageII.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( value > 0 )
                        ps.print(String.valueOf(Math.round(pixels[r][c] / (float)value))  + " ");
            
            ps.close();
        }
        
        // Image to Lighten by add Value
        public void convertToLightenByAddValue(int value) throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/ligthenImageByAddValue.pgm");
            
            ps.println("P2");
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
        
        // Image to Lighten by multiplicate value
        public void convertToLightenByMultValue(int value) throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/ligthenImageByMultValue.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( pixels[r][c] * value < 255 )
                        ps.print(String.valueOf( pixels[r][c] * value ) + " ");
                    else
                        ps.print("255 ");
                    
            ps.close();
        }
        
        private static void getTranspose(int[][] matrix) {
            for(int i = 0; i < matrix.length; i++){
                for(int j = i+1; j < matrix.length ; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        private static void rotateAlongMidRow(int[][] matrix) {
            int len = matrix.length ;
            for(int i = 0; i < len/2; i++){
                for(int j = 0;j < len; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[len-1 -i][j];
                    matrix[len -1 -i][j] = temp;
                }
            }
        }
        
        private static void rotateAlongDiagonal(int[][] matrix) {
            int len = matrix.length;
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len - 1 - i ; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[len -1 - j][len-1-i];
                    matrix[len -1 - j][len-1-i] = temp;
                }
            }
        }
        
         // Rotate image right (90º)
        public void rotateRight()  throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/rotateRight.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            rotateAlongDiagonal(pixels);
            rotateAlongMidRow(pixels);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    ps.print(String.valueOf(pixels[r][c]) + " "); 
                
            ps.close();
        }
        
        // Rotate image left (-90º)
        public void rotateLeft()  throws IOException {
            int[][] aux = new int[rows][cols];
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/rotateLeft.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
           
            getTranspose(pixels);
            rotateAlongMidRow(pixels);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    ps.print(String.valueOf(pixels[r][c]) + " "); 
            
            ps.close();
        }
        
        // Rotate image horizontal (180º)
        public void rotateHorizontal()  throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/rotateHorizontal.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            getTranspose(pixels);
            rotateAlongDiagonal(pixels);
            rotateAlongMidRow(pixels);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    ps.print(String.valueOf(pixels[r][c]) + " ");
            
            ps.close();
        }
        
        // Rotate image vertical (180º)
        public void rotateVertical()  throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-07-03/rotateVertical.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            getTranspose(pixels);
            getTranspose(pixels);
            rotateAlongMidRow(pixels);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    ps.print(String.valueOf(pixels[r][c]) + " ");
            
            ps.close();
        }
        
        // Binarization the image
        public void binarization(int value) throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-14-03/binarization.pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( pixels[r][c] >= value )
                        ps.print("255 ");
                    else
                        ps.print("0 ");
            
            ps.close();
        }
        
        // Reduction the image of 16, 8, 4, 2
        public void reduction(int value) throws IOException {
            PrintStream ps = new PrintStream("/home/wlima/Documents/PDI/aula-14-03/reduction" + value + ".pgm");
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                   ps.print(String.valueOf(pixels[r][c] % value) + " ");
            
            ps.close();
        }
        
	// default constructor with a 3 by 4 image
	public PgmImage(){
		int[][] defaultPixels = {{0, 1, 2, 3}, {4, 5, 6, 7},{8, 9, 10, 11}};
		pixels = new int[defaultPixels.length][defaultPixels[0].length];
		for(int row=0; row < pixels.length; ++row)
			for(int col=0; col < pixels[0].length; ++col)
				pixels[row][col] = (int)(defaultPixels[row][col] * 255.0/12);
		pix2img();
	}
	
	// constructor that loads pgm image from a file
	public PgmImage(String filename) {
		pixels = null;
		readPGM(filename);
		if (pixels != null)
			pix2img();
	}
        
        // Save PGM image
        public void savePGM(String filename) throws FileNotFoundException {
            PrintStream ps = new PrintStream(filename);
            
            ps.println("P2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ ) {
                for( int c = 0; c < cols; c++)
                    ps.print(String.valueOf(pixels[r][c] + " "));
            }
            
            ps.close();
        }

	// load gray scale pixel values from a PGM format image
	public void readPGM(String filename){
		try {                        		    
		    Scanner infile = new Scanner(new FileReader(filename));
		    // process the top 4 header lines
		    String filetype=infile.nextLine();
		    if (!filetype.equalsIgnoreCase("p2")) {
		    	System.out.println("[readPGM]Cannot load the image type of "+filetype);
		    	return;
		    }
	   	   	infile.nextLine();	   	   	   
	   	   	cols = infile.nextInt();
	   	   	rows = infile.nextInt();
	   	   	maxValue = infile.nextInt();	        
	   	   	pixels = new int[rows][cols];	   	       
	   	   	System.out.println("Reading in image from " + filename + " of size " + rows + " by " + cols);
	   	   	// process the rest lines that hold the actual pixel values
	   	   	for (int r=0; r<rows; r++) 
	   	   		for (int c=0; c<cols; c++)
	   	   			pixels[r][c] = (int)(infile.nextInt()*255.0/maxValue);
	   	   	infile.close();
	    } catch(FileNotFoundException fe) {
	    	System.out.println("Had a problem opening a file.");
	    } catch (Exception e) {
	    	System.out.println(e.toString() + " caught in readPPM.");
	    	e.printStackTrace();
	    }
	}
	// overrides the paint method of Component class
	public void paint(Graphics g) {
		// simply draw the buffered image
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	// overrides the method in Component class, to determine the window size
	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100, 100);
		} else {			
			// make sure the window is not two small to be seen
			return new Dimension(Math.max(100, img.getWidth(null)), 
						Math.max(100, img.getHeight(null)));
		}
	}
	
	/**
	 * flipH: Flip the image in horizontal direction
	 */
	public void flipH(){
		int tmp, sym;
		for(int row=0; row < pixels.length; ++row){
			for(int col=0; col < pixels[row].length/2; ++col){
				// find the column index of the horizontally symmetric pixel
				sym = pixels[row].length-1 - col;
				// swap the pixel value between the two
				tmp = pixels[row][col];
				pixels[row][col] = pixels[row][sym];
				pixels[row][sym] = tmp;
			}
		}
		this.pix2img();
	}

        /*
	// The main method that will load and process a pgm image, and display the result.
	public static void main(String[] args) {
		// instantiate the PgmImage object according to the 
		//  command line argument
		PgmImage img;
		String filename ="default";
		String operation = "none";
		if (args.length>0){
			filename = args[0];
			img = new PgmImage(filename);
		} else { 
			img = new PgmImage();
			filename = "default";
		}
		/***************************************************
		 * Apply preferred image processing here:
		 *************************************************
		if (operation.equalsIgnoreCase("fliph"))
			img.flipH();
			
		// set up the GUI for display the PgmImage object 
		JFrame f = new JFrame("PGM Image: "+filename+" Image Operation: " + operation);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.add(img);
		f.pack();
		f.setVisible(true);
	}
*/
}
