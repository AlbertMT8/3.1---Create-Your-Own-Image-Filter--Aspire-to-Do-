# Image Processing with FilterPicture

This project demonstrates a basic image processing tool using Java, where images can be loaded and modified with custom filters. The `FilterPicture` class extends the `Picture` class to provide methods for manipulating pixel values, including removing blue tones and applying a warm filter effect to an image.

## Project Overview

The program includes:
1. **`Picture`**: A base class for loading, displaying, and saving images.
2. **`FilterPicture`**: A subclass of `Picture` with additional methods for applying specific filters.
3. **`Pixel`**: A helper class to manage individual pixel colors within an image.

### Key Features

- **Zero Blue Filter**: Sets the blue component of all pixels to zero, effectively removing blue tones from the image.
- **Warm Filter**: Adjusts color tones to create a "warm" effect by increasing red and green values while slightly decreasing blue.

## Class Descriptions

### 1. FilterPicture

The `FilterPicture` class extends `Picture` to add custom image filters.

- **Constructor**:
  - `FilterPicture(String fileName)`: Loads an image from the specified file name.

- **Methods**:
  - `zeroBlue()`: Removes the blue component from each pixel in the image.
  - `warmFilter()`: Applies a warm filter by adjusting red, green, and blue values.

### 2. Picture

The `Picture` class handles loading, displaying, and saving image files.

- **Constructor**:
  - `Picture(String fileName)`: Loads an image from a file.
  - `Picture(int width, int height)`: Creates a blank image with specified dimensions.
  - Additional constructors for `BufferedImage` input and color-filled images.

- **Methods**:
  - `getPixels2D()`: Returns a 2D array of `Pixel` objects for pixel manipulation.
  - `write(String fileName)`: Saves the image to a file.

### 3. Pixel

The `Pixel` class represents an individual pixel within a `Picture`.

- **Attributes**: Stores RGB values and position in the image.
- **Methods**:
  - `getRed()`, `getGreen()`, `getBlue()`: Get RGB values of the pixel.
  - `setRed(int value)`, `setGreen(int value)`, `setBlue(int value)`: Set RGB values of the pixel.
  - `setColor(Color color)`: Sets a pixel’s color based on a `Color` object.

## Code Example

The following example demonstrates the `warmFilter` method in `FilterPicture`:

```java
public void warmFilter() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
        for (Pixel pixelObj : rowArray) {
            int red = pixelObj.getRed();
            int green = pixelObj.getGreen();
            int blue = pixelObj.getBlue();

            red = Math.min(255, (int) (red * 1.2));
            green = Math.min(255, (int) (green * 1.1));
            blue = Math.max(0, (int) (blue * 0.9));

            pixelObj.setRed(red);
            pixelObj.setGreen(green);
            pixelObj.setBlue(blue);
        }
    }
}
