import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.*;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


 public class ImageReader {
   BufferedImage image;
   int width;
   int height;
   
   public ImageReader() throws IOException {
      
    	  PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\arnav\\Desktop\\output.txt"));
    	  
    	  System.setOut(out);
    	  int max = Integer.MIN_VALUE;
     	  String colo=null;
     	  HashMap<String, Integer> hash = new HashMap<>();
        // File input = new File("C:\\Users\\arnav\\Desktop\\d.JPG");
         // image = ImageIO.read(input);
         BufferedImage image = ImageIO.read(new File("C:\\Users\\arnav\\Desktop\\jChota.JPG"));
        width = image.getWidth();
         height = image.getHeight();
         int count = 0;
         
         for(int i=0; i<height; i++){
         
            for(int j=0; j<width; j++){
            
               Color c = new Color(image.getRGB(j, i));
            c.RGBtoHSB(arg0, arg1, arg2, arg3)
               c.getHSBColor(arg0, arg1, arg2);
               int redi=c.getRed();
               if(redi%10<5)
               {
            	   int mod=redi%10;
            	   redi=redi-(mod);
               }else if(redi%10>=5){
            	   int mod=redi%10;
            	   redi=redi+(10-mod);
               }
             // String red =  String.format("%03d", c.getRed());
              
               String red = ""+c.getRed();

              int greeni=c.getGreen();
              if(greeni%10<5)
              {
           	   int mod=greeni%10;
           	greeni=greeni-(mod);
              }else if(greeni%10>=5){
           	   int mod=greeni%10;
           	greeni=greeni+(10-mod);
              }
          // String green =  String.format("%03d", c.getGreen());
             String green = ""+c.getGreen();

             int bluei=c.getBlue();
             if(bluei%10<5)
             {
          	   int mod=bluei%10;
          	 bluei=bluei-(mod);
             }else if(bluei%10>=5){
          	   int mod=bluei%10;
          	 bluei=bluei+(10-mod);
             }
           // String blue =  String.format("%03d", c.getBlue());
             String blue = ""+c.getBlue();
              String rgbValue=red+green+blue;
              //System.out.println(rgbValue);
              if(!hash.containsKey(rgbValue)){
            	  hash.put(rgbValue, 1);
            	 System.out.println("key"+rgbValue+"  Value"+1);
              }else{
            	  hash.put(rgbValue, hash.get(rgbValue)+1);
            	 System.out.println("key"+rgbValue+"  Value"+hash.get(rgbValue));
              }
              if(hash.get(rgbValue)>max)
              {
            	  max=hash.get(rgbValue);
               colo=rgbValue;
              }
            }
            
         }
         System.out.println(max+"   "+colo);
      } 
   
   
   static public void main(String args[]) throws Exception 
   {
	  
      ImageReader obj = new ImageReader();
	   //System.out.println(String.format("%03d", 1));

   }
   

}