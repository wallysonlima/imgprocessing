/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.IUMain;

/**
 *
 * @author wlima
 */
public class PgmImage extends Component {
    // image buffer for graphical display
	private BufferedImage img;
	// image buffer for plain gray-scale pixel values
	private int[][] pixels;
        private int[][] red;
        private int[][] green;
        private int[][] blue;
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
            PrintStream ps = new PrintStream("../negativeImage.pgm");
            
            ps.println("P2");
            ps.println("#Negative");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    ps.print(String.valueOf(255 - pixels[r][c]) + " "); 
            
            ps.close();
        }
        
        //Image To Darken I
        public void convertToDarkenI(int value) throws IOException {
            PrintStream ps = new PrintStream("../darkenImageI.pgm");
            
            ps.println("P2");
            ps.println("#Darken I");
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
            PrintStream ps = new PrintStream("../darkenImageII.pgm");
            
            ps.println("P2");
             ps.println("#Darken II");
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
            PrintStream ps = new PrintStream("../ligthenImageByAddValue.pgm");
            
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
        
        // Image to Lighten by multiplicate value
        public void convertToLightenByMultValue(int value) throws IOException {
            PrintStream ps = new PrintStream("../ligthenImageByMultValue.pgm");
            
            ps.println("P2");
            ps.println("#Lighten By Mult");
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
        
        // Transpose matrix
        private int[][] getTranspose(int[][] matrix) {
            int[][] trans_arr = new int[cols][rows];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    trans_arr[j][i] = matrix[i][j];
            
            return trans_arr;
        }
        
        private int[][] horizontalFlip(int[][] matrix)
        {
            int temp;
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length/2; j++) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                    matrix[i][matrix[i].length - 1 - j] = temp;
                }
            
            return matrix;
        }
        
        public int[][] verticalFlip(int[][] matrix) {
            for(int i = 0; i < (matrix.length / 2); i++) {
                int[] temp = matrix[i];
                matrix[i] = matrix[matrix.length - i - 1];
                matrix[matrix.length - i - 1] = temp;
            }
            
            return matrix;
        }
        
         // Rotate image right (90º)
        public void rotateRight()  throws IOException {
            PrintStream ps = new PrintStream("../rotateRight.pgm");
            
            int[][] temp = getTranspose(pixels);
            int[][] matrix = horizontalFlip(temp);
            
            ps.println("P2");
            ps.println("#Rotate Right");
            ps.println(matrix[0].length + " " + matrix.length);
            ps.println(maxValue);
            
            for( int r = 0; r < matrix.length; r++ )
                for ( int c = 0; c < matrix[0].length; c++ )
                    ps.print(String.valueOf(matrix[r][c]) + " "); 
                
            ps.close();
        }
        
        // Rotate image left (-90º)
        public void rotateLeft()  throws IOException {
            int[][] aux = new int[rows][cols];
            PrintStream ps = new PrintStream("../rotateLeft.pgm");
            
            int[][] temp = getTranspose(pixels);
            int[][] matrix = verticalFlip(temp);
            
            ps.println("P2");
            ps.println("#Rotate Left");
            ps.println(matrix[0].length + " " + matrix.length);
            ps.println(maxValue);
            
            for( int r = 0; r < matrix.length; r++ )
                for ( int c = 0; c < matrix[0].length; c++ )
                    ps.print(String.valueOf(matrix[r][c]) + " "); 
            
            ps.close();
        }
        
        // Rotate image horizontal (180º)
        public void rotateHorizontal()  throws IOException {
            PrintStream ps = new PrintStream("../rotateHorizontal.pgm");
            
            int[][] matrix = horizontalFlip(pixels);
            //int[][] matrix = verticalFlip(temp);
            
            ps.println("P2");
            ps.println("#Rotate Horizontal");
            ps.println(matrix[0].length + " " + matrix.length);
            ps.println(maxValue);
            
            for( int r = 0; r < matrix.length; r++ )
                for ( int c = 0; c < matrix[0].length; c++ )
                    ps.print(String.valueOf(matrix[r][c]) + " ");
            
            ps.close();
        }
        
        // Rotate image vertical (180º)
        public void rotateVertical()  throws IOException {
            PrintStream ps = new PrintStream("../rotateVertical.pgm");
            
            int[][] matrix = verticalFlip(pixels);
            
            ps.println("P2");
            ps.println("#Rotate Vertical");
            ps.println(matrix[0].length + " " + matrix.length);
            ps.println(maxValue);
            
            for( int r = 0; r < matrix.length; r++ )
                for ( int c = 0; c < matrix[0].length; c++ )
                    ps.print(String.valueOf(matrix[r][c]) + " ");
            
            ps.close();
        }
        
        // Binarization the image
        public void binarization(int value) throws IOException {
            PrintStream ps = new PrintStream("../binarization.pgm");
            
            ps.println("P2");
            ps.println("#Binary");
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
            PrintStream ps = new PrintStream("../reduction" + value + ".pgm");
            
            ps.println("P2");
            ps.println("#Reduction");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                   ps.print(String.valueOf(pixels[r][c] % value) + " ");
            
            ps.close();
        }
        
        // Highlights transformation range A and B and reduces all other intensities to a lower level
        public void highlightsTransformation(int a, int b, int gLevel1, int gLevel2) throws IOException {
            PrintStream ps = new PrintStream("../highlight1.pgm");
            
            ps.println("P2");
            ps.println("#Highlights Transformation");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( pixels[r][c] < a || pixels[r][c] > b )
                        ps.print(String.valueOf( gLevel1 ) + " ");
                    else
                        ps.print(String.valueOf( gLevel2 ) + " ");
                   
            ps.close();
        }
        
        // Highlights transformation up values between A and B 
        public void highlightsTransformation2(int a, int b, int greyLevel) throws IOException {
            PrintStream ps = new PrintStream("../highlight2.pgm");
            
            ps.println("P2");
            ps.println("#Highlights Transformation 2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( pixels[r][c] >= a && pixels[r][c] <= b )
                        ps.print(String.valueOf( greyLevel ) + " ");
                    else
                        ps.print(String.valueOf(pixels[r][c]) + " ");
                   
            ps.close();
        } 
        
        public void subtraction1(int a, int b, int glevel1, int glevel2) throws IOException {
            PrintStream ps = new PrintStream("../subtraction.pgm");
            int[][] matrix = new int[rows][cols];
            
            ps.println("P2");
            ps.println("#Subtraction 1");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( pixels[r][c] < a || pixels[r][c] > b )
                        matrix[r][c] = glevel1;
                    else
                        matrix[r][c] = glevel2;
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ ) {
                    int value = pixels[r][c] - matrix[r][c];
                    
                    if ( value > 0 )
                        ps.print(String.valueOf(value) + " ");
                    else
                        ps.print("0 ");             
                }
                    
            ps.close();
        }
        
        public void subtraction2(int a, int b, int greyLevel) throws IOException {
            PrintStream ps = new PrintStream("../subtraction2.pgm");
            int[][] matrix = new int[rows][cols];
            
            ps.println("P2");
            ps.println("#Subtraction 2");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ )
                    if ( pixels[r][c] >= a && pixels[r][c] <= b )
                        matrix[r][c] = greyLevel;
                    else
                        matrix[r][c] = pixels[r][c];
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ ) {
                    int value = pixels[r][c] - matrix[r][c];
                    
                    if ( value > 0 )
                        ps.print(String.valueOf(value) + " ");
                    else
                        ps.print("0 ");             
                }
                    
            ps.close();
        }
        
         //Transform Image by Power
        public void transformPower(float power) throws IOException {
            int p = Math.round(power * 10);
            PrintStream ps = new PrintStream("../transformPower" + p + ".pgm");
            float temp = 0.0f;
            int value = 0;
            
            ps.println("P2");
            ps.println("#Transform Power");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int r = 0; r < rows; r++ )
                for ( int c = 0; c < cols; c++ ) {
                    temp = pixels[r][c] / (float)255;
                    temp = (float) Math.pow(temp, power);
                    value = (int)(temp * 255);
                    
                    ps.print(String.valueOf(value) + " ");
                }
            
            ps.close();
        }
        
        // Zoom-in the image
        public void zoomIn(int n) throws IOException {
            PrintStream ps = new PrintStream("../zoomIn" + n + ".pgm");
            int h = n * img.getHeight();
            int w = n * img.getWidth();
            int[][] matrix = new int[h][w];
            
            ps.println("P2");
             ps.println("#Zoom In Image");
            ps.println(w + " " + h);
            ps.println(maxValue);
            
            for( int i = 0; i < h; i++)
                for( int j = 0; j < w; j++ )
                    ps.print(String.valueOf(pixels[i/n][j/n]) + " ");
            
            ps.close();
        }
        
        // Zoom-out the image
        public void zoomOut(int n) throws IOException {
            PrintStream ps = new PrintStream("../zoomOut" + n + ".pgm");
            int h = pixels.length / n;
            int w = pixels[0].length / n;
            int size = pixels.length * n;
            int[][] matrix = new int[h][w];
            
            ps.println("P2");
            ps.println("#Zoom Out Image");
            ps.println(w + " " + h);
            ps.println(maxValue);
            int l, c;
                      
            for( int i = 0; i < h; i++ )
                for( int j = 0; j < w; j++ ) {
                    l = i * n;
                    c = j * n;
                    matrix[i][j] = Math.round((pixels[l][c] + pixels[l+1][c] + pixels[l][c+1] + pixels[l+1][c+1]) / 4);    
            }  
            
            for( int i = 0; i < h; i++)
                for( int j = 0; j < w; j++ )
                    ps.print(String.valueOf(Math.round(matrix[i][j])) + " ");
                    
            ps.close();
        }
        
        // Get level grayScale of histogram
        public void getHistogram(int[] histogram) {
            for( int c = 0; c < histogram.length; c++)
                 histogram[c] = 0;
             
             for( int i = 0; i < pixels.length; i++)
                 for( int j = 0; j < pixels[0].length; j++)
                     histogram[ pixels[i][j] ]++;
        }
        
        // Save qtde pixels in with grey level Histogram in a vector
        public void saveHistogram() throws IOException {
             PrintStream ps = new PrintStream("../Histogram.txt");
             final int MAX = 256; 
             int[] histogram = new int[MAX];
             
             getHistogram(histogram);
             
             for( int c = 0; c < MAX; c++)
                   ps.println(c + " " + histogram[c]);
             
             ps.close();
        }
        
        // Equalize histogram image using local Equalization
        public void localEqualization() throws IOException {
            PrintStream ps = new PrintStream("../localEqualizationImage.pgm");
            final int L = 256;
            int[] histogram = new int[L];
            int[] acumulative = new int[L];
            int size = pixels.length * pixels[0].length; 
            int sum = 0;
            
            ps.println("P2");
            ps.println("#Local Equalization");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
             
            getHistogram(histogram);
            
            // Acumulate the histogram and create lookup
            for( int i = 0; i < L; i++) {
                sum += histogram[i];
                acumulative[i] = sum * (L-1) / size;
            }
            
            // Change befores values to new values
            for( int i = 0; i < pixels.length; i++)
                for( int j = 0; j < pixels[0].length; j++ )
                    ps.print(String.valueOf(acumulative[pixels[i][j]]) + " ");
            
             ps.close();
        }
        
        public void statisticalEqualization() throws IOException {
            PrintStream ps = new PrintStream("../statisticalEqualizationImage.pgm");
            final int L = 256;
            int[] histogram = new int[L];
            int[] position = new int[L];
            int[] acumulative = new int[L];
            int[] result = new int[L];
            int size = pixels.length * pixels[0].length; 
            float sumSt = 0;
            int sum = 0;
            
            ps.println("P2");
            ps.println("#Statistical Equalization");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
             
            getHistogram(histogram);
            
            // Acumulate the histogram and create lookup
            for( int i = 0; i < L; i++) {
                sumSt += histogram[i] / (float) size;
                position[i] = Math.round(sumSt * (L-1));
                
                sum += histogram[i];
                acumulative[i] = sum * (L-1) / size;
            }
            
            for( int i = 0; i < L; i++)
                result[i] = acumulative[position[i]];
            
            // Change befores values to new values
            for( int i = 0; i < pixels.length; i++)
                for( int j = 0; j < pixels[0].length; j++ )
                    ps.print(String.valueOf(result[pixels[i][j]]) + " ");
            
            ps.close();
        }
        
        // Spacial filter using Generic nxn filter
        public void spacialFilter(int dim) throws IOException {
            PrintStream ps = new PrintStream("../spacialfilter" + dim + "x" + dim + ".pgm");
            int size = dim * dim;
            float sum;
            int ini;
            int temp;
            
            ps.println("P2");
            ps.println("#Spacial Filter");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int i = 0; i < pixels.length; i++ )
                for( int j = 0; j < pixels[0].length; j++ ) {
                    ini = -(dim/2);
                    sum = 0;
                    
                    for( int r = ini; r < dim + ini; r++)
                        for( int c = ini; c < dim + ini; c++ )
                            if ( (i + r) >= 0 && (j + c) >= 0 && (i + r) < pixels.length && (j + c) < pixels[0].length )
                                sum += pixels[i + r][j + c];
                    
                    if ( (temp = Math.round(sum / (float) size)) > 255 )
                        temp = 255;
                    
                    ps.print(String.valueOf(temp) + " ");
                }
           
            ps.close();
        }
        
        public void spacialFilter16(int dim) throws IOException {
            PrintStream ps = new PrintStream("../spacialfilter16-" + dim + "x" + dim + ".pgm");
            int size = 16;
            int[][] filter = {{1,2,1}, {2,4,2}, {1,2,1}};
            float sum;
            int ini;
            int temp;
            
            ps.println("P2");
            ps.println("#Spacial Filter 16");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int i = 0; i < pixels.length; i++)
                for( int j = 0; j < pixels[0].length; j++ ) {
                    ini = -1;
                    sum = 0;
                    
                    for( int r = ini; r < dim + ini; r++)
                        for( int c = ini; c < dim + ini; c++ )
                            if ( (i + r) >= 0 && (j + c) >= 0 && (i + r) < pixels.length && (j + c) < pixels[0].length )
                                sum += pixels[i + r][j + c] * filter[r+1][c+1];
                    
                    if ( (temp = Math.round(sum / (float) size)) > 255 )
                        temp = 255;
                    
                    ps.print(String.valueOf(temp) + " ");
                }
           
            ps.close();
        }
        
        // Filter laplace mask 4
        public void laplaceFilter4(int dim) throws IOException {
            PrintStream ps = new PrintStream("../laplaceFilter4.pgm");
            int[][] filter = {{0,-1,0}, {-1,4,-1}, {0,-1,0}};
            int [][] laplace = new int[pixels.length][pixels[0].length];
            int sum;
            int ini;
            int temp;
            
            ps.println("P2");
            ps.println("#Laplace Filter 4");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int i = 0; i < pixels.length; i++)
                for( int j = 0; j < pixels[0].length; j++ ) {
                    ini = -1;
                    sum = 0;
                    
                    for( int r = ini; r < dim + ini; r++)
                        for( int c = ini; c < dim + ini; c++ )
                            if ( (i + r) >= 0 && (j + c) >= 0 && (i + r) < pixels.length && (j + c) < pixels[0].length )
                                sum += pixels[i + r][j + c] * filter[r+1][c+1];
                    
                    if ( sum >= 0 && sum <= 255 )
                        laplace[i][j] = sum;                        
                    else if ( sum > 255 )
                        laplace[i][j] = 255;
                    else if ( sum < 0 )
                        laplace[i][j] = 0;
                }
            
            for( int i = 0; i < pixels.length; i++)
                for( int j = 0; j < pixels[0].length; j++ ) {
                    temp = pixels[i][j] + laplace[i][j];
                    
                    if ( temp > 255 )
                        temp = 255;
                    else if ( temp < 0 )
                        temp = 0;
                    
                    ps.print(String.valueOf(temp) + " ");
                }
            
            ps.close();
        }
        
        public void laplaceFilter8(int dim) throws IOException {
            PrintStream ps = new PrintStream("../laplaceFilter8.pgm");
            int[][] filter = {{-1,-1,-1}, {-1,8,-1}, {-1,-1,-1}};
            int [][] laplace = new int[pixels.length][pixels[0].length];
            int sum;
            int ini;
            int temp;
            
            ps.println("P2");
            ps.println("#Laplace Filter 4");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int i = 0; i < pixels.length; i++)
                for( int j = 0; j < pixels[0].length; j++ ) {
                    ini = -1;
                    sum = 0;
                    
                    for( int r = ini; r < dim + ini; r++)
                        for( int c = ini; c < dim + ini; c++ )
                            if ( (i + r) >= 0 && (j + c) >= 0 && (i + r) < pixels.length && (j + c) < pixels[0].length )
                                sum += pixels[i + r][j + c] * filter[r+1][c+1];
                    
                    if ( sum >= 0 && sum <= 255 )
                        laplace[i][j] = sum;                        
                    else if ( sum > 255 )
                        laplace[i][j] = 255;
                    else if ( sum < 0 )
                        laplace[i][j] = 0;
                }
            
            for( int i = 0; i < pixels.length; i++)
                for( int j = 0; j < pixels[0].length; j++ ) {
                    temp = pixels[i][j] + laplace[i][j];
                    
                    if ( temp > 255 )
                        temp = 255;
                    else if ( temp < 0 )
                        temp = 0;
                    
                    ps.print(String.valueOf(temp) + " ");
                }
            
            ps.close();
        }
        
          public void spacialMedian(int dim) throws IOException {
            PrintStream ps = new PrintStream("../medianFilter" + dim + "x" + dim + ".pgm");
            int size = dim * dim;
            ArrayList<Integer> values = new ArrayList<>();
            float sum;
            int ini;
            int temp;
            
            ps.println("P2");
            ps.println("#Median Filter");
            ps.println(cols + " " + rows);
            ps.println(maxValue);
            
            for( int i = 0; i < pixels.length; i++ )
                for( int j = 0; j < pixels[0].length; j++ ) {
                    ini = -(dim/2);
                    sum = 0;
                    
                    for( int r = ini; r < dim + ini; r++)
                        for( int c = ini; c < dim + ini; c++ )
                            if ( (i + r) >= 0 && (j + c) >= 0 && (i + r) < pixels.length && (j + c) < pixels[0].length )
                                values.add(pixels[i + r][j + c]);
                    
                    ps.print(String.valueOf(getMedian(values)) + " ");
                }
           
            ps.close();
        }
          
        public Integer getMedian(ArrayList<Integer> values) {
            Collections.sort(values);
            int middle = values.size() / 2;
            middle = middle % 2 == 0? middle - 1 : middle;
            return values.get(middle);
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
