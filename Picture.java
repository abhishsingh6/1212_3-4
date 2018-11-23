import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; 

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */

public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /* Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /* Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /* Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /* Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /*
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public static void main(String[] args)
  {
    String fileName = FileChooser.pickAFile();
    Picture pictObj = new Picture(fileName);
    pictObj.explore();
  }
  // Program 5
  // Method to decrease red by half in the current picture 
  public void decreaseRed() {
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;
    
    //loop through all the pixels
    while(index < pixelArray.length) {
      // get the current pixel
      pixel = pixelArray[index];
      //get the value
      value = pixel.getRed();
      //decrease the red value by 50%
      value = (int) (value * 0.5);
      //set the red value of current pixel to the new value
      pixel.setRed(value);
      //increament the index
      index++;
    }
  }
  // Program 6
  // Method to increase the amount of red by 30% 
  public void increaseRed() {
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0; 
    
    //loop through all the pixels
    while(index < pixelArray.length) {
      // get the current pixel
      pixel = pixelArray[index];
      //get the value
      value = pixel.getRed();
      //changes the value 1.3 time what it was
      value = (int) (value * 1.3);
      //set the red value to 1.3 time what it was
      pixel.setRed(value);
      //increament the index
      index++;
    }   
  }
  // Program 7
  // Method to clear the blue from the picture 
  public void clearBlue() {
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int index = 0; 
    
    //loop through all the pixels
    while(index < pixelArray.length) {
      // get the current pixel
      pixel = pixelArray[index];
      //set the blue on pixel to 0
      pixel.setBlue(0);
      //increament the index
      index++;
    } 
  }
  public void clearGreen(){
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int index = 0; 
    
    //loop through all the pixels
    while(index < pixelArray.length) {
      // get the current pixel
      pixel = pixelArray[index];
      //set the blue on pixel to 0
      pixel.setGreen(0);
      //increament the index
      index++;
    } 
    
    
  }
  
  
  public void clearRed(){
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int index = 0; 
    
    //loop through all the pixels
    while(index < pixelArray.length) {
      // get the current pixel
      pixel = pixelArray[index];
      //set the blue on pixel to 0
      pixel.setRed(0);
      //increament the index
      index++;
    } 
    
    
  }
  
  // Lab 7
  // Method to decrease blue by a parameter amount 
  public void decreaseBlue(double amount) {
    if (amount < 0.0){
      System.out.println("Error! Parameter less than zero.");
      return;
    }
    if (amount > 1.0) {
      System.out.println("Error! Parameter greater than one.");
      return;
    }
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;
    
    //loop through all the pixels
    while(index < pixelArray.length) {
      // get the current pixel
      pixel = pixelArray[index];
      //get the value
      value = pixel.getBlue();
      //decrease the blue value by amount%
      value = (int) (value * amount);
      //set the blue value of current pixel to the new value
      pixel.setBlue(value);
      //increament the index
      index++;
    }
  }
  // Method that changes the green in a picture by a specified percentage 
  public void modifyGreen(double amount, double portion) {
    if (amount < 0.0){
      System.out.println("Error! Parameter less than zero.");
      return;
    }
    if (amount > 2.0) {
      System.out.println("Error! Parameter greater than two.");
      return;
    }
    if (portion < 0.0){
      System.out.println("Error! Portion less than zero.");
      return;
    }
    if (portion > 1.0) {
      System.out.println("Error! Portion greater than one.");
      return;
    }
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;
    
    //loop through all the pixels
    while(index < (int)(pixelArray.length * portion)) {
      // get the current pixel
      pixel = pixelArray[index];
      //get the value
      value = pixel.getGreen();
      //decrease the green value by amount%
      value = value -((int) (value * amount));
      //set the green value of current pixel to the new value
      pixel.setGreen(value);
      //increament the index
      index++;
    }
  }
  // Method that will modify a horizontal part of the image 
  public void modifyRed(double amount, double startPortion, double endPortion) {
    if (amount < 0.0){
      System.out.println("Error! Parameter less than zero.");
      return;
    }
    if (amount > 2.0) {
      System.out.println("Error! Parameter greater than two.");
      return;
    }
    if (startPortion < 0.0){
      System.out.println("Error! First portion less than zero.");
      return;
    }
    if (startPortion > 1.0) {
      System.out.println("Error! First portion greater than one.");
      return;
    }
    if (endPortion < 0.0){
      System.out.println("Error! Second portion less than zero.");
      return;
    }
    if (endPortion > 1.0) {
      System.out.println("Error! Second portion greater than one.");
      return;
    }
    if (startPortion > endPortion) {
      System.out.println("Error! First portion comes after second portion.");
      return;
    }
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = (int)(pixelArray.length * startPortion);
    
    //loop through all the pixels
    while(index < (int)(pixelArray.length * endPortion)) {
      // get the current pixel
      pixel = pixelArray[index];
      //get the value
      value = pixel.getRed();
      //increase the red value by amount%
      value = value + ((int) (value * amount));
      //set the red value of current pixel to the new value
      pixel.setRed(value);
      //increament the index
      index++;
    }
  }
  public void reportRGB() {
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    
    int redPixel = 0;
    int greenPixel = 0;
    int bluePixel = 0;
    
    int minRed = 255;
    int minGreen = 255;
    int minBlue = 255;
    
    int maxRed = 0;
    int maxGreen = 0;
    int maxBlue = 0;
    
    int totalRed  = 0;
    int totalGreen  = 0;
    int totalBlue  = 0;
    
    int index = 0;
    
    //loop through all the pixels
    while(index < pixelArray.length) {
      // get the current pixel
      pixel = pixelArray[index];
      //gets the value of each color pixel
      redPixel = pixel.getRed();
      greenPixel = pixel.getGreen();
      bluePixel = pixel.getBlue();
      //Adds total for each color 
      totalRed = totalRed + redPixel;
      totalGreen = totalGreen + greenPixel;
      totalBlue = totalBlue + bluePixel;
      //Check minimum and maximum red pixels 
      if (redPixel < minRed) {
        minRed = redPixel;
      }     
      if (redPixel > maxRed) {
        maxRed = redPixel;
      }     
      //Check minimum and maximum green pixels
      if (greenPixel < minGreen) {
        minGreen = greenPixel;
      }     
      if (greenPixel > maxGreen) {
        maxGreen = greenPixel;
      }     
      //Check minimum and maximum blue pixels
      if (bluePixel < minBlue) {
        minBlue = bluePixel;
      }     
      if (bluePixel > maxBlue) {
        maxBlue = bluePixel;
      }     
      
      index++;
    }
    //Gets averages of each pixel color in a picture
    int averageRed = (totalRed / pixelArray.length);
    int averageGreen = (totalGreen / pixelArray.length);
    int averageBlue = (totalBlue / pixelArray.length);
    
    System.out.println("Average red Value is " + averageRed);
    System.out.println("Average green Value is " + averageGreen);
    System.out.println("Average blue Value is " + averageBlue);
    System.out.println("Minimum red Value is " + minRed);
    System.out.println("Minimum green Value is " + minGreen);
    System.out.println("Minimum blue Value is " + minBlue);
    System.out.println("Maximum red Value is " + maxRed);
    System.out.println("Maximum green Value is " + maxGreen);
    System.out.println("Maximum blue Value is " + maxBlue);
  }
  
  public void invert2(){
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = this.getHeight();
    int width = this.getWidth();
    
    
    for (int x = 0; x < width; x++){
      for (int y = 0; y < height; y++){
        topPixel = getPixel(x, y);
        bottomPixel = getPixel(width -1- x, height -1- y);
        topPixel.setColor(bottomPixel.getColor());
      }
    }
    this.explore();
  }
  // Lab 7 Bonus 
  public void invert(){
    // get pixelArray as usual
    Pixel[] pixelArray = this.getPixels();
    // create a new Picture of the same size (this allocates 
    // the appropriate amount of memory to use for temp storage)
    Picture newPic = new Picture(this.getWidth(), this.getHeight());
    // get a pixelArray for the new picture. Now you can copy pixel 
    // values between the two arrays
    Pixel[] tempArray = newPic.getPixels();
    int index = 0;
    Pixel pixel = null;
    int redPixel = 0;
    int greenPixel = 0;
    int bluePixel = 0;
    int redPixel2 = 0;
    int greenPixel2 = 0;
    int bluePixel2 = 0;
    
    while (index < pixelArray.length) {
      // copy pixelArray values into temp array
      tempArray[index] = pixelArray[index];
      pixel = tempArray[index];
      redPixel = pixel.getRed();
      greenPixel = pixel.getGreen();
      bluePixel = pixel.getBlue();
      //Sets the value of each color pixel
      pixel.setRed(redPixel);
      pixel.setGreen(greenPixel);
      pixel.setBlue(bluePixel);
      index++;
    }
    System.out.println(tempArray[tempArray.length - 1]);
    System.out.println(pixelArray[pixelArray.length - 1]);
    
    index = 0;
    while (index < pixelArray.length){
      //copies tempArray in reverse into pixelArray
      pixelArray[index] = tempArray[pixelArray.length - 1 - index];
      pixel = pixelArray[index];
      redPixel = pixel.getRed();
      greenPixel = pixel.getGreen();
      bluePixel = pixel.getBlue();
      //Sets the value of each color pixel
      pixel.setRed(redPixel);
      pixel.setGreen(greenPixel);
      pixel.setBlue(bluePixel);
      index++;
    }
    
    /* index = 0;
     while (index < pixelArray.length) {
     pixelArray[index];
     pixel
     //Sets the value of each color pixel
     pixel.setRed(redPixel);
     pixel.setGreen(greenPixel);
     pixel.setBlue(bluePixel);
     index++; 
     x++;
     y++;
     }*/
    
    
    
    System.out.println(tempArray[0]);
    System.out.println(pixelArray[pixelArray.length - 1]);
    //newPic.explore();
    this.repaint();
    this.explore();
  }
  
  // Program 9
  // Method to decrease the green in the picture by 30%*/
  public void decreaseGreen(){
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    //loop through all the pixels in the array
    while (i < pixelArray.length) {
      pixel = pixelArray[i];
      value = pixel.getGreen();
      //set the green value to 70% of what is was
      pixel.setGreen((int) (value * .7));
      i++;
    }
  }
  
  // Method to decrease the blue in the picture by 30%
  public void decreaseBlue(){
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    //loop through all the pixels in the array
    while (i < pixelArray.length) {
      pixel = pixelArray[i];
      value = pixel.getBlue();
      //set the blue value to 70% of what is was
      pixel.setBlue((int) (value * .7));
      i++;
    }
  }
  public void makeSunset2(){
    decreaseGreen();
    decreaseBlue();
  }
  // Program 11 
  //Method to change the color of each pixel in a picture obect by passed in amounts 
  public void changeColors(double redAmount, double greenAmount, double blueAmount){
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    //loop through all the pixels in the array
    while (i < pixelArray.length) {
      pixel = pixelArray[i];
      //change the red value
      value = pixel.getRed();
      pixel.setRed((int)(redAmount * value));
      //change the green value
      value = pixel.getGreen();
      pixel.setGreen((int)(greenAmount * value));
      //change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int)(blueAmount * value));
      i++;
    }
  }
  //Program 13
  //  Method to lighten the colors in the picture
  public void lighten(){
    Pixel pixelArray[] = this.getPixels();
    Color color = null;
    Pixel pixel = null;
    
    //loop through all the pixel
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      color = pixel.getColor();
      color = color.brighter();
      pixel.setColor(color);
    }
  }
  //Program 15 
  // Method to negate the picture 
  public void negate() {
    Pixel pixelArray[] = this.getPixels();
    Pixel pixel = null;
    int redValue, blueValue, greenValue = 0;
    
    //loop through all the pixel
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      //Get the current color
      redValue = pixel.getRed();
      greenValue = pixel.getGreen();
      blueValue = pixel.getBlue();
      // Set the pixel's color to the new Color
      pixel.setColor(new Color(255 - redValue,255 - greenValue,255 - blueValue));
    }
  }
  //Lab 8 
  public void fade() {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      
      pixel.setRed((int)(pixel.getRed()*.8));
      pixel.setGreen((int)(pixel.getGreen()*.8));
      pixel.setBlue((int)(pixel.getBlue()*.8));
    }
  }
  //copies the pixels from another image into the current image.
  public void copyPixelsFromSource(Picture source) {
    Pixel [] pixelArray = this.getPixels();
    Pixel [] sourceArray = source.getPixels();
    
    Pixel pixel1 = null;
    Pixel pixel2 = null;
    
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    
    if (this.getWidth() != source.getWidth() || this.getHeight() != source.getHeight()){
      System.out.println("Error! Source image size is not the same as this image."); 
      return;
    }
    
    for (int i = 0; i < sourceArray.length;i++){
      pixel1 = sourceArray[i];
      redValue = pixel1.getRed();
      greenValue = pixel1.getGreen();
      blueValue = pixel1.getBlue();
      
      pixel2 = pixelArray[i];
      pixel2.setRed(redValue);
      pixel2.setGreen(greenValue);
      pixel2.setBlue(blueValue);
      
      
    }
  }
  /* Copies the pixels from another image into the current image.
   * Averages the red, blue and green components from the two pictures 
   * and copy them back into the main picture object (not into the source 
   * picture that is passed in as a parameter). */
  public void averageWithSource (Picture source) {
    Pixel [] pixelArray = this.getPixels();
    Pixel [] sourceArray = source.getPixels();
    
    Pixel pixel1 = null;
    Pixel pixel2 = null;
    
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int redValue2 = 0;
    int greenValue2 = 0;
    int blueValue2 = 0;
    
    int totalRed  = 0;
    int totalGreen  = 0;
    int totalBlue  = 0; 
    
    if (this.getWidth() != source.getWidth() || this.getHeight() != source.getHeight()){
      System.out.println("Error! Source image size is not the same as this image."); 
      return;
    }
    
    for (int i = 0; i < sourceArray.length;i++){
      pixel1 = sourceArray[i];
      redValue = pixel1.getRed();
      greenValue = pixel1.getGreen();
      blueValue = pixel1.getBlue();
      
      pixel2 = pixelArray[i];
      redValue2 = pixel2.getRed();
      greenValue2 = pixel2.getGreen();
      blueValue2 = pixel2.getBlue();
      
      //Adds total for each color 
      totalRed = redValue2 + redValue;
      totalGreen = greenValue2 + greenValue;
      totalBlue = blueValue2 + blueValue;
      
      int averageRed = (totalRed / 2);
      int averageGreen = (totalGreen / 2);
      int averageBlue = (totalBlue / 2);
      
      pixel2.setRed(averageRed);
      pixel2.setGreen(averageGreen);
      pixel2.setBlue(averageBlue);  
    }
  }
  /* Copies the pixels from another image into the current image.
   * Averages the red, blue and green components from the two pictures  
   * average of the two images, instead of a regular average */
  public void weightedAverageWithSource (Picture source, double sourcePercent) {
    Pixel [] pixelArray = this.getPixels();
    Pixel [] sourceArray = source.getPixels();
    
    Pixel pixel1 = null;
    Pixel pixel2 = null;
    
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int redValue2 = 0;
    int greenValue2 = 0;
    int blueValue2 = 0;
    
    double sPercent = 1 - sourcePercent;
    
    if (this.getWidth() != source.getWidth() || this.getHeight() != source.getHeight()){
      System.out.println("Error! Source image size is not the same as this image."); 
      return;
    }
    
    if (sourcePercent < 0.0){
      System.out.println("Error! sourcePercent is below 0.0");
      return;
    }
    
    if (sourcePercent > 1.0){
      System.out.println("Error! sourcePercent is above 1.0");
      return;
    }
    
    for (int i = 0; i < sourceArray.length;i++){
      pixel1 = sourceArray[i];
      redValue = pixel1.getRed();
      greenValue = pixel1.getGreen();
      blueValue = pixel1.getBlue();
      
      pixel2 = pixelArray[i];
      redValue2 = pixel2.getRed();
      greenValue2 = pixel2.getGreen();
      blueValue2 = pixel2.getBlue();
      
      int averageRed = (int)(redValue * sourcePercent) + (int)(redValue2 * sPercent);
      int averageGreen = (int)(greenValue * sourcePercent) + (int)(greenValue2 * sPercent);
      int averageBlue = (int)(blueValue * sourcePercent) + (int)(blueValue2 * sPercent);
      
      pixel2.setRed(averageRed);
      pixel2.setGreen(averageGreen);
      pixel2.setBlue(averageBlue);
    }
  }
  /* Method to lighten the colors in the picture */
  // Program 18
  public void lighten2() {
    Color color = null;
    Pixel pixel = null;
    
    //loop through the colums (x direction)
    for (int x = 0; x < getWidth(); x++) {
      //loop through the rows (y direction)
      for (int y = 0; y < getHeight(); y++) {
        pixel = getPixel(x, y);
        color = pixel.getColor();
        color = color.brighter();
        pixel.setColor(color);
      }
    }
  }
  
  /* Method to mirror around a vertical line in the middle of the picture 
   * based on the width
   */
  // Program 19
  public void mirrorVertical() {
    int width = this.getWidth();
    int mirrorPoint = width / 2;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    // loop through all the rows
    for (int y = 0; y < getHeight(); y++) {
      // loop from 0 to the middle (mirror point)
      for (int x = 0; x < mirrorPoint; x++) {
        leftPixel = getPixel(x, y);
        rightPixel = getPixel(width - 1 - x, y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  /* Method to mirror around a horizontal line in the middle based on the
   * height. It copies the top mirrored to the bottom
   */
  //Program 20
  public void mirrorHorizontal() {
    int height = this.getHeight();
    int mirrorPoint = height / 2;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    //loop through the columns
    for (int x = 0; x < getWidth(); x++) {
      //loop from 0 to just before the mirror point
      for (int y = 0; y < mirrorPoint; y++) {
        topPixel = getPixel(x, y);
        bottomPixel = getPixel(x, height - 1 - y);
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  /* Method to mirror part of the temple picture around a
   * vertical line a mirror point
   */
  // program 22
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    // loop through the rows
    for (int y = 27; y < 97; y++)
    {
      // loop from 1 to just before the mirror point
      for (int x = 13; x < mirrorPoint; x++)
      {
        leftPixel = getPixel(x, y);
        rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  // Assignment #3
  // Part 1 Methods
  public void tintRed() {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      
      //sets pixels to red
      pixel.setRed((int)(pixel.getRed()*2));
      pixel.setGreen((int)(pixel.getGreen()*1));
      pixel.setBlue((int)(pixel.getBlue()*1));
    }
  }
  
  public void tintGreen() {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      
      //sets pixels to green
      pixel.setRed((int)(pixel.getRed()*0));
      pixel.setGreen((int)(pixel.getGreen()*2));
      pixel.setBlue((int)(pixel.getBlue()*0));
    }
  }
  
  public void tintBlue() {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    for (int i = 0; i < pixelArray.length; i++) {
      pixel = pixelArray[i];
      
      //sets pixels to blue
      pixel.setRed((int)(pixel.getRed()*0));
      pixel.setGreen((int)(pixel.getGreen()*1));
      pixel.setBlue((int)(pixel.getBlue()*2));
    }
  }
  
  
  // Part 3 Method to blur picture
  public void averagePixelsHorizontally() {  
    Pixel[] pixelArray = this.getPixels();
    Pixel this_pixel = null;
    Pixel prev_pixel = null;
    Pixel next_pixel = null;
    int index = 0;
    int red;
    int green;
    int blue;
    
    
    while (index < pixelArray.length) {
      if (index == 0) {
        
        // special case, first pixel, no prev_pixel to average
        System.out.println("special case, first pixel");
        
        this_pixel = pixelArray[index];
        next_pixel = pixelArray[index + 1];
        
        // Red pixel average
        red = (this_pixel.getRed() + next_pixel.getRed())/2;
        this_pixel.setRed(red);
        
        // Green pixel average
        green = (this_pixel.getGreen() + next_pixel.getGreen())/2;
        this_pixel.setGreen(green);
        
        // Blue pixel average
        blue = (this_pixel.getBlue() + next_pixel.getBlue())/2;
        this_pixel.setBlue(blue);
      } else 
        
        if (index == pixelArray.length - 1) {
        
        // special case, last pixel, no next_pixel to average
        System.out.println("special case, last pixel");
        
        prev_pixel = pixelArray[index - 1];
        this_pixel = pixelArray[index];
        
        // Red pixel average
        red = (prev_pixel.getRed() + this_pixel.getRed())/2;
        this_pixel.setRed(red);
        
        // Green pixel average
        green = (prev_pixel.getGreen() + this_pixel.getGreen())/2;
        this_pixel.setGreen(green);
        
        // Blue pixel average
        blue = (prev_pixel.getBlue() + this_pixel.getBlue())/2;
        this_pixel.setBlue(blue);
      } 
      
      else {
        
        prev_pixel = pixelArray[index - 1];
        this_pixel = pixelArray[index];
        next_pixel = pixelArray[index + 1];
        
        // Red pixel average
        red = (prev_pixel.getRed() + this_pixel.getRed() + next_pixel.getRed())/3;
        this_pixel.setRed(red);
        
        // Green pixel average
        green = (prev_pixel.getGreen() + this_pixel.getGreen() + next_pixel.getGreen())/3;
        this_pixel.setGreen(green);
        
        // Blue pixel average
        blue = (prev_pixel.getBlue() + this_pixel.getBlue() + next_pixel.getBlue())/3;
        this_pixel.setBlue(blue);      
      } 
      index++;
    } 
  }
  // Lab #9 part 1
  public void quatrefoil(){
    this.mirrorHorizontal();
    this.mirrorVertical();
  }
  
  
  
// Program 23
  public void copyKatie()
  {
    String sourceFile = FileChooser.getMediaPath("KatieFancy.jpg");
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the columns
    for (int sourceX = 0,  targetX=0;sourceX < sourcePicture.getWidth();sourceX++, targetX++){
      // loop through the rows
      for (int sourceY = 0 ,targetY =0;sourceY < sourcePicture.getHeight(); sourceY++, targetY++){
        // set the target pixel color to the source pixel color
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
// Program 25
  public void copyKatiesFace() {
    String sourceFile = FileChooser.getMediaPath("katieFancy.jpg");
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the columns
    for(int sourceX = 70, targetX = 100; sourceX < 135; sourceX++, targetX++) {
      // loop through the rows
      for(int sourceY = 3, targetY = 100; sourceY < 80; sourceY++, targetY++) {
        // set the target pixel color to the source pixel color
        sourcePixel  = sourcePicture.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
  /** Method that will copy all of the passed source picture into the current picture
    * object starting with the left corner given by xStart. It will put the sourcePicture
    * at 5 pixels from bottom of this picture
    * @param sourcePicture the picture obj. to copy
    * @param xStart the x position to start the copy in the target
    * 
    */ 
  //Program 27
  public void copyPictureTo(Picture sourcePicture, int xStart) {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through columns
    for(int sourceX  = 0, targetX = xStart;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++) {
          // loop through rows
          for(int sourceY = 0,
              targetY = this.getHeight() - sourcePicture.getHeight() - 5;
              sourceY < sourcePicture.getHeight();
              sourceY++, targetY++) {
                // set the target pixel color to the source pixel color
                sourcePixel  = sourcePicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);
                targetPixel.setColor(sourcePixel.getColor());    
              }
        }
  }
  
  public void copyPictureTo(Picture sourcePicture, int xStart, int yStart) {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through columns
    for(int sourceX  = 0, targetX = xStart;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++) {
          // loop through rows
          for(int sourceY = 0,
              targetY = yStart;
              sourceY < sourcePicture.getHeight();
              sourceY++, targetY++) {
                // set the target pixel color to the source pixel color
                sourcePixel  = sourcePicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);
                targetPixel.setColor(sourcePixel.getColor());    
              }
        }
  }
  
  //Method to blend two pictures
  // Program 28
  public void blendPictures() {
    // Create the sister pictures
    Picture katiePicture = new Picture(FileChooser.getMediaPath("katieFancy.jpg"));
    Picture jennyPicture = new Picture(FileChooser.getMediaPath("jenParty.jpg"));
    
    // declare the source and target pixel variables
    Pixel katiePixel = null;
    Pixel jennyPixel = null;
    Pixel targetPixel = null;
    
    int sourceX = 0;
    int targetX = 0;
    
    // copy the first 150 pixels of katie to the canvas
    for(; sourceX < 150; sourceX++, targetX++) {
      for( int sourceY = 0, targetY = 0; sourceY < katiePicture.getHeight(); sourceY++, targetY++) {
        // set the target pixel color to the source pixel color
        katiePixel  = katiePicture.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(katiePixel.getColor()); 
      }
    }
    // Copy 50% of katie and 50% of jenny till the end katie's width
    for(; sourceX <katiePicture.getWidth(); sourceX++, targetX++) {
      for(int sourceY = 0, targetY = 0; sourceY < katiePicture.getHeight(); sourceY++, targetY++) {
        katiePixel = katiePicture.getPixel(sourceX, sourceY);
        jennyPixel = jennyPicture.getPixel(sourceX - 150, sourceY);
        targetPixel = this.getPixel(targetX, targetY);
        targetPixel.setColor(new Color((int) (katiePixel.getRed() * 0.5 + jennyPixel.getRed() * 0.5),
                                       (int) (katiePixel.getGreen() * 0.5 + jennyPixel.getGreen() * 0.5),
                                       (int) (katiePixel.getBlue() * 0.5 + jennyPixel.getBlue() * 0.5)));
      }
    }
    // Copy the rest of Jenny
    sourceX = sourceX - 150;
    for(; sourceX < jennyPicture.getWidth();
        sourceX++, targetX++) {
          for(int sourceY = 0, targetY = 0;
              sourceY < jennyPicture.getHeight();
              sourceY++, targetY++) {
                // set the target pixel color to the source pixel color
                jennyPixel  = jennyPicture.getPixel(sourceX, sourceY);
                targetPixel = this.getPixel(targetX, targetY);
                targetPixel.setColor(jennyPixel.getColor()); 
              }
        } 
  }
  
  //Method to copy the picture of katie but rotate it left 90 degrees
  //Program 29
  public void copyKatieLeftRotation() {
    String sourceFile = FileChooser.getMediaPath("katieFancy.jpg");
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through columns
    for(int sourceX = 0; sourceX < sourcePicture.getWidth(); sourceX++) {
      // loop through rows
      for(int sourceY = 0; sourceY < sourcePicture.getHeight(); sourceY++) {
        // set the target pixel color to the source pixel color
        sourcePixel  = sourcePicture.getPixel(sourceX, sourceY);
        targetPixel = this.getPixel(sourceY, sourcePicture.getWidth() - 1 - sourceX);
        targetPixel.setColor(sourcePixel.getColor()); 
      }
    }
  }
  
  // Method to scale a picture up
  //Program 31
  public void copyFlowerLarger() {
    Picture flowerPicture = new Picture(FileChooser.getMediaPath("rose.jpg"));
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through columns
    for(double sourceX = 0, targetX = 0; sourceX < flowerPicture.getWidth(); sourceX+=0.5, targetX++) {
      // loop through rows
      for(double sourceY = 0, targetY = 0; sourceY < flowerPicture.getHeight(); sourceY+=0.5, targetY++) {
        // set the target pixel color to the source pixel color
        sourcePixel  = flowerPicture.getPixel((int) sourceX, (int) sourceY);
        targetPixel = this.getPixel((int) targetX, (int) targetY);
        targetPixel.setColor(sourcePixel.getColor()); 
      }
    }
  }
  
  // Lab 10 Part A
  private boolean isSameSize(Picture source) {
    if (source.getWidth () == this.getWidth()) {
      if (source.getHeight() == this.getHeight()) {
        return true;
      }
    }
    return false;
  }
  
  // Lab 10 Part B
  private void copyPixel(Picture src, int srcX, int srcY, Picture destPic, int destX, int destY){
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // set the target pixel color to the source pixel color
    sourcePixel  = src.getPixel(srcX, srcY);
    targetPixel = destPic.getPixel(destX, destY);
    targetPixel.setColor(sourcePixel.getColor());    
  }
  
  // Lab 10 Part C
  public void addPic(Picture newPic, int xPos, int yPos) {
    // Check if the newPic is smaller than current pic
    if (newPic.getWidth() > this.getWidth()|| newPic.getHeight() > this.getHeight()){
      System.out.println("Error! The passed in picture is larger than this picture");
      return;
    }
    
    int newWidth = newPic.getWidth();
    int newHeight = newPic.getHeight();
    
    // loop through columns
    for(int x  = 0; x < newWidth; x++) {
      // loop through rows
      for(int y = 0; y < newHeight; y++) {
        // Makes sure that we aren't trying to copy beyond either
        // the left side of this image or the bottom of this image
        if (xPos + x <getWidth() && yPos + y < getHeight()){
          copyPixel(newPic, xPos + x, yPos + y, this, x, y); 
        }
      }
    }
  }
  
  // Lab 10 Part D
  public void crop(int xPos, int yPos, int width, int height){
    Pixel sourcePixel = null;
    // loop through colounms
    for(int sourceX  = 1; sourceX < this.getWidth(); sourceX++) {
      // loop through rows
      for(int sourceY = 1; sourceY <this.getHeight(); sourceY++) {
        if(sourceX < xPos || sourceY < yPos || sourceX > (xPos + width) ||  sourceY > (yPos + height)){
          sourcePixel = this.getPixel(sourceX, sourceY);
          sourcePixel.setColor(Color.white);
        }else{
        }
      }
    }
  }
  
  // Method to turn the brown in a picture into red
  // Program 33
  public void turnBrownIntoRed(){
    Color brown = new Color(42, 25, 15);
    Pixel[] pixels = this.getPixels();
    Pixel pixel = null;
    
    // loop through pixels
    for(int i=0; i<pixels.length; i++){
      // get the current pixel
      pixel = pixels[i];
      
      // check if in distance to brown and if so double the red
      if (pixel.colorDistance(brown) < 50.0){
        pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                 pixel.getGreen(),
                                 pixel.getBlue()));
      }
    }
  }
  
  // Method to turn brown to red inside of a rectangle area
  // Program 34
  public void turnBrownToRedInRectangle() {
    Color brown = new Color(42, 25, 15);
    Pixel pixel = null;
    
    // loop through the x values
    for (int x = 63; x < 125; x++){
      for (int y = 6; y < 76; y++){
        pixel = this.getPixel(x,y);
        // check if in dist to brown and if os double the red
        if (pixel.colorDistance(brown) < 50.0) {
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                   pixel.getGreen(),
                                   pixel.getBlue()));
        }
      }
    }
  }
  
  // Method that replaces color with passed in values
  // Program 35
  public void turnBrownToRedInRectangle(int startX, int endX, int startY, int endY, double distance) {
    Color brown = new Color(42, 25, 15);
    Pixel pixel = null;
    
    // loop through the x values
    for (int x = startX; x < endX; x++){
      for (int y = startY; y < endY; y++){
        pixel = this.getPixel(x,y);
        // check if in dist to brown is less than the passed distance and if so double the red
        if (pixel.colorDistance(brown) < distance) {
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                   pixel.getGreen(),
                                   pixel.getBlue()));
        }
      }
    }
  }
  
  // Method to remove red-eye
  // Program 36
  public void removeRedEye(int startX, int endX, int startY, int endY, Color newColor){
    Pixel pixel = null;
    
    // loop through the x values
    for (int x = startX; x < endX; x++){
      for (int y = startY; y < endY; y++){
        pixel = this.getPixel(x,y);
        
        //if the color is near red then change it
        if (pixel.colorDistance(Color.red) < 167){
          pixel.setColor(newColor);
        }
      }
    }
  }
  
  //Method to replace a color with a new color
  public void replaceColor(Color oldColor, Color newColor, int thresold){
    Pixel pixel = null;
    
    // loop through the x values
    for (int x = 0; x < getWidth(); x++){
      for (int y = 0; y < getHeight(); y++){
        pixel = this.getPixel(x,y);
        
        // if the color is near amount then change it
        if (pixel.colorDistance(oldColor) < thresold){
          pixel.setColor(newColor);
        }
      }
    }
  }
  
  // Method to do simple edge detection by comparing the absolute value of the difference between the color intensities
  // (average of the color values) between a pixel and the pixel below it
  // Program 37
  public void edgeDetection(double amount){
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    int endY = this.getHeight() - 1;
    
    //loop through y values from 0 to height -1 (since compare to below pixel
    for (int y = 0; y < endY; y++){
      // loop through the x values from 0 to width
      for (int x = 0; x < this.getWidth(); x++){
        // get the top and bottom pixels
        topPixel = this.getPixel(x, y);
        bottomPixel = this.getPixel(x, y+1);
        
        // get averages
        topAverage = topPixel.getAverage();
        bottomAverage = bottomPixel.getAverage();
        
        // check if thte absolute value of the difference is less than the amount
        if (Math.abs(topAverage - bottomAverage) < amount){
          topPixel.setColor(Color.white);
          // else set the color to black
        }else{
          topPixel.setColor(Color.black);
        }
      }
    }
  }
  
  //Method to posterize(reduce the number of colors) in the picture
  //Program 39
  public void posterize(){
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    
    // loop through pixels
    for (int x = 0; x < this.getWidth(); x++){
      for (int y = 0; y <this.getHeight() ; y++){
        
        // get current pixel and color
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
        // check for red range and change color
        if (redValue < 64)
          redValue = 31;
        else if (redValue < 128)
          redValue = 95;
        else if (redValue < 192)
          redValue = 159;
        else
          redValue = 223;
        
        // check for green range
        if (greenValue < 64)
          greenValue = 31;
        else if (greenValue < 128)
          greenValue = 95;
        else if (greenValue < 192)
          greenValue = 159;
        else
          greenValue = 223;
        
        // check for blue range
        if (blueValue < 64)
          blueValue = 31;
        else if (blueValue < 128)
          blueValue = 95;
        else if (blueValue < 192)
          blueValue = 159;
        else
          blueValue = 223;
        //set the colors
        pixel.setRed(redValue);
        pixel.setGreen(greenValue);
        pixel.setBlue(blueValue);
      }
    }
  }
  
  // Method to posterize(reduce the number of colors) in the picture
  // @param numLevels the number of color levels to use
  // Program 40
  public void posterize(int numLevels){
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int increment = (int) (256.0 / numLevels);
    int bottomValue, topValue, middleValue = 0;
    
    // loop through pixels
    for (int x = 0; x < this.getWidth(); x++){
      for (int y = 0; y <this.getHeight() ; y++){
        
        // get current pixel and color
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();
        
        // loop through the number of levels
        for (int i = 0; i < numLevels; i++) {
          //compute the bottom,, top, and middle values
          bottomValue = i * increment;
          topValue = (i + 1) * increment;
          middleValue = (int) ((bottomValue + topValue - 1) / 2.0);
          
          /* Check if current values are in the current range and if so set them to
           * the middle value
           */
          if (bottomValue <= redValue && redValue < topValue)
            pixel.setRed(middleValue);
          if (bottomValue <= greenValue && greenValue < topValue)
            pixel.setGreen(middleValue);
          if (bottomValue <= blueValue && blueValue < topValue)
            pixel.setBlue(middleValue);
        }
      }
    }
  }
  
  // Method that highlights extremes
  // Program 41
  public void highlightLightAndDark(double amount, Color replacementColor) {
    Pixel pixel = null; 
    
    // loop through all the pixels in x direction
    for (int x = 0; x < getWidth(); x++) {
      // loop through all the pixel in y direction
      for (int y = 0; y < getHeight(); y++) {
        pixel = getPixel(x,y);
        
        // if the distance from white or black is less than the 
        //passed amount use the replace color instead
        if (pixel.colorDistance(Color.white) < amount || pixel.colorDistance(Color.black) < amount) {
          pixel.setColor(replacementColor); 
        }
      }
    }
  }
  
  // Method to blur pixels.
  // @param the numeber of pixels to average in all
  // Program 42
  public void blur(int numPixels) {
    Pixel pixel = null;
    Pixel samplePixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int count = 0;
    
    // loop through all the pixels in x direction
    for (int x = 0; x < getWidth(); x++) {
      // loop through all the pixel in y direction
      for (int y = 0; y < getHeight(); y++) {
        pixel = getPixel(x,y);
        
        // reset the count and red, green, and blue values
        count = 0;
        redValue = greenValue = blueValue = 0;
        
        // loop through pixel numPixels before x to numPixels after x
        for (int xSample = x-numPixels; xSample <= x+numPixels; xSample++){
          for (int ySample = y-numPixels; ySample <= y + numPixels; ySample++){
            // Check that we are in the range of acceptables pixels
            if (xSample >= 0 && xSample < this.getWidth() && ySample >= 0 && ySample < this.getHeight()) {
              samplePixel = this.getPixel(xSample, ySample);
              redValue = redValue + samplePixel.getRed();
              greenValue = greenValue + samplePixel.getGreen();
              blueValue = blueValue + samplePixel.getBlue();
              count += 1;
            }
          }
        }
        
        // use average color of surounding pixels
        Color newColor = new Color(redValue / count,
                                   greenValue / count,
                                   blueValue / count);
        pixel.setColor(newColor);
      }
    }
  }
  
  // Method to replace the background in the current picture with the background from another picture
  // Program 43 
  public void swapBackground(Picture oldBackground, Picture newBackground){
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;
    
    for (int x=0; x<getWidth(); x++){
      for (int y=0; y<getHeight(); y++){
        currPixel = this.getPixel(x, y);
        oldPixel = oldBackground.getPixel(x,y);
        
        // if the distance between the current pixel color and the old bg pixel 
        // color is less than the 15 then swap in the new bg pixel     
        if (currPixel.colorDistance(oldPixel.getColor()) < 15.0) {
          newPixel = newBackground.getPixel(x, y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  // Method to better replace the background in the current picture with the background from another picture
  // Program 44
  public void swapBackground(Picture oldBackground, Picture newBackground, double thresold){
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;
    
    for (int x=0; x<getWidth(); x++){
      for (int y=0; y<getHeight(); y++){
        currPixel = this.getPixel(x, y);
        oldPixel = oldBackground.getPixel(x,y);
        
        // if the distance between the current pixel color and the old bg pixel 
        // color is less than the 15 then swap in the new bg pixel     
        if (currPixel.colorDistance(oldPixel.getColor()) < thresold) {
          newPixel = newBackground.getPixel(x, y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  // Method to replace the background in the current picture with the background from another picture
  // Program 45
  public void chromakey(Picture newBg){
    Pixel currPixel = null;
    Pixel newPixel = null;
    
    for (int x=0; x<getWidth(); x++){
      for (int y=0; y<getHeight(); y++){
        currPixel = this.getPixel(x, y);
        
        // if the color at the current pixel is mostly blue then us new bg color
        if (currPixel.getRed() + currPixel.getGreen() < currPixel.getBlue()) {
          newPixel = newBg.getPixel(x, y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  // Method to replace the background in the current picture with the background from another picture
  // Program 46
  public void chromakeyBlue(Picture newBg){
    Pixel[] pixelArray = this.getPixels();
    Pixel currPixel = null;
    Pixel newPixel = null;
    
    for (int i=0; i<pixelArray.length; i++){  
      currPixel = pixelArray[i];
      
      // if the color at the current pixel is mostly blue then us new bg color
      if (currPixel.getRed() + currPixel.getGreen() < currPixel.getBlue()) {
        newPixel = newBg.getPixel(currPixel.getX(), currPixel.getY());
        currPixel.setColor(newPixel.getColor());
      }
    }
  }
  
  // Assignment #4
  // Part 1 Method that shrinks images with factors
  public Picture shrink(int factor) {
    Picture newPic = new Picture(this.getWidth() + 1, this.getHeight() + 1);
    
    // Checks if factor is equal to 2, 3, or 4
    if (factor < 2 || factor > 4){
      System.out.println("Error! The parameter should be 2, 3, or 4.");
      return this;
    }
    
    // loops through columns and skips the x values by factor in order to shrink image
    for(int sourceX = 0, targetX = 0; sourceX < this.getWidth(); sourceX+=factor, targetX++){
      // loops through rows and skips the y values by factor in order to shrink image
      for(int sourceY = 0, targetY = 0; sourceY < this.getHeight(); sourceY+=factor, targetY++){
        // sets the target pixel color to the source pixel color
        
        // (Picture src, int srcX, int srcY, Picture destPic, int destX, int destY)
        copyPixel(this, sourceX , sourceY , newPic, targetX, targetY);
      }
    }
    return newPic;
  }
  
  // Assignment #4 
  // Part 2 Method that reveals a picture over another picture
  public void reveal(Picture underPic, double division_height){
    int divideLine = (int)(division_height * this.getHeight());
    Pixel targetPixel = null;
    
    // Checks if the second parameter isn't between 0.0 and 1.0
    if (division_height < 0.0 || division_height > 1.0){
      System.out.println("Error! Second parameter isn't between 0.0 and 1.0!");
      return;
    }
    
    // Checks if underPic is the same size as this pic
    if (!isSameSize(underPic)) {
      System.out.println("Error! The source picture is not the same size.");
      return;
    }
    
    // loops through columns
    for(int sourceX = 0, targetX = 0; sourceX < this.getWidth(); sourceX++, targetX++) {
      // loops through rows and reveals underPic
      for(int sourceY = 0, targetY = 0; sourceY < this.getHeight(); sourceY++, targetY++) {
        if(sourceY < divideLine){
          // Creates a black line with a thickness of 3 between the two pictures
          targetPixel = getPixel(targetX, targetY + 3);
          targetPixel.setColor(Color.black);
          // sets the target pixel color to the source pixel color
          // (Picture src, int srcX, int srcY, Picture destPic, int destX, int destY)
          copyPixel(underPic, sourceX, sourceY, this, targetX, targetY);
        }
      }
    }
  }
  
  // Assignment #4 
  // Part 3 Method that checkerboards a picture
  public void checkerboard(int width, Color c){
    // Checks if the first parameter is more than half the width the picture
    if (width > (int)(this.getWidth() * 0.5)){
      System.out.println("Error! First parameter is more than half the width the picture!");
      return;
    }
    
    Pixel pixel = null;
    
    // loops through the pixels in this picture
    for (int x = 0; x < getWidth(); x++){
      for (int y = 0; y < getHeight(); y++){
        // Creates a square shape every other width and every even row and column
        if (((x/width) % 2 == 0) && ((y/width) % 2 == 0)){
          pixel = getPixel(x ,y);
          pixel.setColor(c);
        }
      } 
    }
    
    // loops through the pixels in this picture
    for (int x = 0; x < getWidth(); x++){
      for (int y = 0; y < getHeight(); y++){
        // Creates a square shape every other width and every odd row and column
        if (((x/width) % 2 == 1) && ((y/width) % 2 == 1)){
          pixel = getPixel(x ,y);
          pixel.setColor(c);
        }
      }
    }
  }
  
  // Assignment #4 
  // Part 4 Method that puts transparency by alpha amount checkerboarded patterns on a picture
  public void checkerboard(int width, int alpha){
    // Checks if the first parameter is more than half of the width of the picture
    if (width > (int)(this.getWidth() * 0.5)){
      System.out.println("Error! First parameter is more than half the width the picture!");
      return;
    }
    
    // Checks if alpha is between 0 and 255
    if (alpha < 0 || alpha > 255){
      System.out.println("Error! Second parameter should be between 0 and 255.");
      return;
    }
    
    Pixel pixel = null;
    
    // loops through the pixels in this picture
    for (int x = 0; x < getWidth(); x++){
      for (int y = 0; y < getHeight(); y++){
        // Creates a square shape every other width and every even row and column
        if (((x/width) % 2 == 0) && ((y/width) % 2 == 0)){
          pixel = getPixel(x ,y);
          pixel.setAlpha(alpha);
        }
      }
    }
    
    // loops through the pixels in this picture
    for (int x = 0; x < getWidth(); x++){
      for (int y = 0; y < getHeight(); y++){
        // Creates a square shape every other width and every odd row and column
        if (((x/width) % 2 == 1) && ((y/width) % 2 == 1)){
          pixel = getPixel(x ,y);
          pixel.setAlpha(alpha);
        }
      }
    }
  }
  
  // Assignment #4 
  // Part 5 Method that uses checkerboarded patterns from one picture and puts it on another picture
  public void checkerboard(int width, Picture pic) {
    // Checks if the width parameter is more than half of the width of the picture
    if (width > (int)(this.getWidth() * 0.5)){
      System.out.println("Error! The first parameter is more than half the width the picture!");
      return;
    }
    
    // Checks if current picture is the same size as the other picture 
    if (!isSameSize(pic)) {
      System.out.println("Error! The source picture is not the same size.");
      return;
    } 
    
    // loops through the pixels in current picture and source picture
    for (int x = 0, srcX = 0; x < getWidth(); srcX++, x++){
      
      for (int y = 0, srcY = 0; y < getHeight();srcY++, y++){
        // Creates a square shape every other width and every even row and column
        
        if (((x/width) % 2 == 0 ) && ((y/width) % 2 == 0)){
          //(Picture src, int srcX, int srcY, Picture destPic, int destX, int destY)
          copyPixel(pic, srcX, srcY, this, x, y);
          
        }
      }
    }
  }
  
  // Lab 11 Part A Privacy Blackout
  public void blackOut(int startX, int startY, int endX, int endY){
    
    if ((startX > this.getWidth()) || (startX < 0) || (startX > endX )|| (endX > this.getWidth())){
      System.out.println("Error: The first and/or second parameter is invalid");
      return; 
    }
    else if (startY > this.getHeight() || startY < 0 || startY > endY || endY > this.getHeight()){
      System.out.println("Error: The first and/or second parameter is invalid");
      return; 
    }
    else{
      
      Pixel pixel = null;
      
      // loop through the x and y values
      for (int x = startX; x < endX; x++){
        for (int y = startY; y < endY; y++){
          pixel = this.getPixel(x,y);
          pixel.setColor(Color.BLACK);
        }
      }
    }
  }
  
  // Lab 11 Part B Privacy Blur
  public void blurArea(int startX, int startY, int endX, int endY, int level){
    if (startX > this.getWidth() || startX < 0 || startX > endX || endX > this.getWidth()){
      System.out.println("Error: The first and/or second parameter is invalid");
      return; 
    }else if (startY > this.getHeight() || startY < 0 || startY > endY || endY > this.getHeight()){
      System.out.println("Error: The first and/or second parameter is invalid");
      return; 
    }else if (level < 1 || level > 10){
      System.out.println("Error: Level parameter is invalid");
    }else{
      
      // loop through the x and y values
      for (int x = startX; x < endX; x++){
        for (int y = startY; y < endY; y++){
          this.blurPixel(x,y,level);
          
        }
      }
    }
  }   
  
  // Blur pixel method
  private void blurPixel(int x, int y, int size) {
    
    Pixel tempPixel = null;
    Pixel pixel = null;
    
    int sumR = 0;
    int sumG = 0;
    int sumB = 0;
    int divisor = 0;
    
    //iterate over the size x size pixels in this area to add up the RGBs
    for (int subx = x-size; subx < x+size + 1; subx++){
      for (int suby = y-size; suby < y + size + 1; suby++){
        //check if this pixel is inside this image
        if (x < this.getWidth() && y < this.getHeight() && (x + size) < this.getWidth() && (y+size) < this.getHeight()) {
          //in range, so get this pixel, add its colors to running average
          tempPixel = this.getPixel(subx, suby);
          sumR += tempPixel.getRed();
          sumG += tempPixel.getGreen();
          sumB += tempPixel.getBlue();
          //increase divisor
          divisor += 1;
        }
      }
    }
    //done adding put all the colors from surrounding pixels so
    // get this pixel and then set it's color to the average RGBs
    //making sure to divide by the divisor (num colors added in)
    pixel = this.getPixel(x,y);
    pixel.setRed((int)(sumR/divisor));
    pixel.setGreen((int)(sumG/divisor));
    pixel.setBlue((int)(sumB/divisor));
  }
  
  //Lab 11 Part C Colorful Edge Detection
  public void colorfulEdgeDetection(double amount, double colorLevel){
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    int endY = this.getHeight() - 1;
    
    if (amount < 0 || colorLevel < 0) {
      System.out.println("Error: parameters must be above zero");
      return;
    }else if(amount > 255 || colorLevel > 255){
      System.out.println("Error: parameters must be below 255");
    }else{
      
      // loop through y values from 0 to height -1 
      for (int y = 0; y < endY; y++){
        // loop through the x values from 0 to width
        for (int x = 0; x < this.getWidth(); x++){
          // get the top and bottom pixels
          topPixel = this.getPixel(x, y);
          bottomPixel = this.getPixel(x, y+1);
          
          // get averages
          topAverage = topPixel.getAverage();
          bottomAverage = bottomPixel.getAverage();
          
          // check if thte absolute value of the difference is less than the amount
          if (Math.abs(topAverage - bottomAverage) < amount && topAverage > colorLevel){
            topPixel.setColor(Color.white);
            // else set the color to black
          }else{
            //topPixel.setColor(Color.black);
          }
        }
      }
    } 
  }
  
  // Program #8
  /**
   * Method to simulate a sunset by decreasing the green
   * and blue
   */
  public void makeSunset()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;
    
    // loop through all the pixels
    while (i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];
      
      // change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (value * 0.7));
      
      // change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (value * 0.7));
      
      // increment the index
      i++;
    }
  }
  
  // Program #12
  /**
   * Method to clear the blue from the picture (set
   * the blue to 0 for all pixels)
   */
  public void clearBlue3()
  {
    Pixel[] pixelArray = this.getPixels();
    
    // loop through all the pixels
    for (int i=0; i < pixelArray.length; i++)
      pixelArray[i].setBlue(0);
  }
  
  // Program #21
  /**
   * Method to mirror around a horizontal line in the middle
   * based on the height of the picture.  It copies the bottom
   * to the top.
   */
  public void mirrorHorizontalBottomToTop()
  {
    int height = this.getHeight();
    int mirrorPoint = height / 2;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    // loop through the columns
    for (int x=0; x < getWidth(); x++)
    {
      // loop from 1 to just before the mirror point
      for (int y=0; y < mirrorPoint; y++)
      {
        topPixel = getPixel(x,y);
        bottomPixel = getPixel(x,height - 1 - y);
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }
  
  // Program #26
  /**
   * Method to copy flower pictures to create a collage.
   * All the flower pictures will be lined up near the
   * bottom of the current picture (5 pixels from the bottom)
   */
  public void copyFlowers()
  {
    
    // create the flower pictures
    Picture flower1Picture =
      new Picture(FileChooser.getMediaPath("flower1.jpg"));
    Picture flower2Picture =
      new Picture(FileChooser.getMediaPath("flower2.jpg"));
    
    // declare the source and target pixel variables
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // save the heights of the two pictures
    int flower1Height = flower1Picture.getHeight();
    int flower2Height = flower2Picture.getHeight();
    
    /* copy the first flower picture to 5 pixels from the bottom
     * left corner of the current picture
     */
    for (int sourceX = 0, targetX = 0;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
    
    // copy the flower2 picture starting with x = 100
    for (int sourceX = 0, targetX = 100;
         sourceX < flower2Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower2Height - 5;
           sourceY < flower2Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower2Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
    flower1Picture.negate();
    for (int sourceX = 0, targetX = 200;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
    
    // clear the blue in flower 2 picture and add at x=300
    flower2Picture.clearBlue();
    for (int sourceX = 0, targetX = 300;
         sourceX < flower2Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower2Height - 5;
           sourceY < flower2Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower2Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
    
    // copy the negated flower 1 to x=400
    for (int sourceX = 0, targetX = 400;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
  // Program #30
  /**
   * Method to copy the picture of Jakita but smaller
   * (half as big) to the current picture
   */
  public void copyJakitaSmaller()
  {
    Picture jakitaPicture =
      new Picture(FileChooser.getMediaPath("jakita.jpg"));
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the columns
    for (int sourceX = 0, targetX=0;
         sourceX < jakitaPicture.getWidth();
         sourceX+=2, targetX++)
    {
      // loop through the rows
      for (int sourceY=0, targetY=0;
           sourceY < jakitaPicture.getHeight();
           sourceY+=2, targetY++)
      {
        sourcePixel = jakitaPicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
    
  }
}