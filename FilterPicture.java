/**
 * The FilterPicture class extends the Picture class and provides methods 
 * to apply specific filters, such as removing blue from the image or applying 
 * a warm filter.
 */
public class FilterPicture extends Picture {

  /**
   * Constructor that takes a file name and creates the picture.
   * 
   * @param fileName the name of the file to create the picture from
   */
  public FilterPicture(String fileName) {
      // The load method will initialize the fileName,
      // bufferedImage, and extension instance variables.
      super(fileName);
  }

  /**
   * Method to set the blue component of all pixels in the image to 0.
   * This method effectively removes all blue tones from the picture.
   */
  public void zeroBlue() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels) {
          for (Pixel pixelObj : rowArray) {
              pixelObj.setBlue(0);
          }
      }
  }

  /**
   * Method to apply a warm filter to the image by increasing 
   * the red and green components of the pixels while slightly decreasing 
   * the blue component. This creates a warmer color tone in the picture.
   */
  public void warmFilter() {
      Pixel[][] pixels = this.getPixels2D();
      for (Pixel[] rowArray : pixels) {
          for (Pixel pixelObj : rowArray) {
              int red = pixelObj.getRed();
              int green = pixelObj.getGreen();
              int blue = pixelObj.getBlue();

              // Increase red and green components
              red = Math.min(255, (int) (red * 1.2));
              green = Math.min(255, (int) (green * 1.1));

              // Slightly decrease blue component
              blue = Math.max(0, (int) (blue * 0.9));

              pixelObj.setRed(red);
              pixelObj.setGreen(green);
              pixelObj.setBlue(blue);
          }
      }
  }
}
