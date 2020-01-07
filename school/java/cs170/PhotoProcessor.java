//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

import java.awt.Dimension;
import java.io.File;

import javax.swing.JFileChooser;

import acm.graphics.GImage;

import acm.breadboards.BreadboardComboBoxModel;
import acm.breadboards.ComboBoxWithButtonsBreadboard;


public class PhotoProcessor extends ComboBoxWithButtonsBreadboard {
	
	public final int NO_FILTER = 0;
	public final int GRAYSCALE = 1;
	public final int NEGATIVE = 2;
	public final int BLURRED = 3;
	
	GImage originalImage_;
	GImage currentImage_;

	public void run() {
		
		//set up the breadboard with instructions, labels, etc...
		this.getLabel().setText("Filters:");
		
		this.getTextArea().setText("This program will apply one of four filters to an image. " +
		                           "Click 'Load' and select an image file with which to work. " +
				                   "Then select an appropriate filter, and click 'Apply' to see the result.");
		
		String[] options = {"No Filter", "Grayscale", "Negative", "Blurred"};
		BreadboardComboBoxModel model = new BreadboardComboBoxModel(options);
		this.getComboBox().setModel(model);
		
		this.getButton2().setText("Load...");
		
		this.getButton1().setText("Apply Filter");
	}
	
	public void onButton1Click() { //Apply Filter button was clicked...
		
		//remove the old image
		this.remove(currentImage_);
		
		//add the newly filtered image
		switch (this.getComboBox().getSelectedIndex()) {
		case NO_FILTER: this.add(originalImage_);
						currentImage_ = originalImage_;
						break;
		case GRAYSCALE: currentImage_ = makeGrayscale(currentImage_);
						this.add(currentImage_);
						break;
		case NEGATIVE:  currentImage_ = makeNegative(currentImage_);
						this.add(currentImage_);
						break;
		case BLURRED: 	currentImage_ = makeBlurred(currentImage_);
						this.add(currentImage_);
						break;
		}
		
	}
	
	public void onButton2Click() { //Load button was clicked
		
		//get the name of an image file the user has selected
		final JFileChooser fileChooser = new JFileChooser();
		int fileChooserAction = fileChooser.showOpenDialog(this);
		
		if (fileChooserAction == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			String fileName = file.getPath();
			
			//construct GImages for the original picture, and the grayscale, negative, and blurred versions
			originalImage_ = new GImage(fileName);
			currentImage_ = originalImage_;
			this.add(originalImage_);
			
			//adjust the window size so that the central canvas area fits the picture
			int northHeight = this.getRegionPanel(NORTH).getHeight();
			int southHeight = this.getRegionPanel(SOUTH).getHeight();
			this.setSize((int) originalImage_.getWidth(), (int) originalImage_.getHeight() + northHeight + southHeight);
		}
	}
	
	public GImage makeGrayscale(GImage image) {
		
		
		int[][] pixels = image.getPixelArray();
 

		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				int red = GImage.getRed(pixels[i][j]);
				int green = GImage.getGreen(pixels[i][j]);
				int blue = GImage.getBlue(pixels[i][j]);
				int avgColor = (red+green+blue)/3;
				int pixel = GImage.createRGBPixel(avgColor, avgColor, avgColor);
				
				pixels[i][j] = pixel;
				

			} 

		} 
		GImage newImage = new GImage(pixels);
		return newImage;
		

	}
	
	public GImage makeNegative(GImage image) {
		
		int[][] pixels = image.getPixelArray();
		
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				int red = GImage.getRed(pixels[i][j]);
				int green = GImage.getGreen(pixels[i][j]);
				int blue = GImage.getBlue(pixels[i][j]);
				
				int newRed = 255 - red;
				int newGreen = 255 - green;
				int newBlue = 255 - blue;
				int pixel = GImage.createRGBPixel(newRed, newGreen, newBlue);
				pixels[i][j] = pixel;
			}
		}
		GImage newImage = new GImage(pixels);
		return newImage;
	}
	
	public GImage makeBlurred(GImage image) {
		
		int redSum = 0;
		int greenSum = 0;
		int blueSum = 0;
		
		int[][] pixels = image.getPixelArray();
		
		for (int i = 0; i < pixels.length; i++) {
			for (int j = 0; j < pixels[i].length; j++) {
				for (int k = -3; k < 3; k++) { // Need bounds of image since there are no surrounding pixels on the edge
					for (int l = -3; l < 3; l++) { // Assuming begins in center pixel such that 3x3 array and gets RGB values from pixels surrounding center 
						int redPixel = GImage.getRed(pixels[i+k][j+l]);
						redSum += redPixel;
						int greenPixel = GImage.getGreen(pixels[i+j][j+l]);
						greenSum += greenPixel;
						int bluePixel = GImage.getBlue(pixels[i+j][j+l]);
						blueSum += bluePixel;
						int avgRedPixel = redSum / 9;
						int avgGreenPixel = greenSum / 9;
						int avgBluePixel = blueSum / 9;

						int pixel = GImage.createRGBPixel(avgRedPixel, avgGreenPixel, avgBluePixel);
						pixels[i][j] = pixel;
					
					}
				}

				
			}
		}
		GImage newImage = new GImage(pixels);
		return newImage;
		
		
		
	}
}

