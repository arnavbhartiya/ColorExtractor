import java.io.*;
import java.util.*;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
public class ImageCompressor {

   public void compress(String inputFile, String outputFile) throws IOException {
   
      File input = new File(inputFile);
      BufferedImage image = ImageIO.read(input);
      Image im=image.getScaledInstance(100, 100,Image.SCALE_FAST);
      BufferedImage BufIm=toBufferedImage(im);
      File ImageFile = new File(outputFile);
      ImageIO.write(BufIm, "png", ImageFile);

      
 /*     File compressedImageFile = new File("C:\\Users\\arnav\\Desktop\\whC.jpg");
      OutputStream os =new FileOutputStream(compressedImageFile);

      Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
      ImageWriter writer = (ImageWriter) writers.next();

      ImageOutputStream ios = ImageIO.createImageOutputStream(os);
      writer.setOutput(ios);

      ImageWriteParam param = writer.getDefaultWriteParam();
      
      param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
      param.setCompressionQuality(0.5f);
      writer.write(null, new IIOImage(image, null, null), param);
      
      os.close();
      ios.close();
      writer.dispose();*/
   }
   public BufferedImage toBufferedImage(Image img)
   {
       if (img instanceof BufferedImage)
       {
           return (BufferedImage) img;
       }

       // Create a buffered image with transparency
       BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

       // Draw the image on to the buffered image
       Graphics2D bGr = bimage.createGraphics();
       bGr.drawImage(img, 0, 0, null);
       bGr.dispose();

       // Return the buffered image
       return bimage;
   }
}
