import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.imageio.ImageIO;

public class ColoraAnalyzer {
	public void getCompressedImage(String inputFile, String outputFile)
			throws IOException {
		ImageCompressor im = new ImageCompressor();
		im.compress(inputFile, outputFile);
	}

	public void analyzeHSB(String file) throws IOException {
		PrintStream out = new PrintStream(new FileOutputStream(
				"C:\\Users\\arnav\\Desktop\\output.txt"));

		System.setOut(out);
		BufferedImage image = ImageIO.read(new File(file));
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < height; i++) {

			for (int j = 0; j < width; j++) {
				Color c = new Color(image.getRGB(i, j));
				// System.out.println(c.getRed()+"  "+c.getGreen()+"  "+c.getBlue());
				HSLoutputer(c);
			}
		}
	}

	private void HSLoutputer(Color c) {
		float hue = 0, sat = 0, lum = 0;
		float redPer = (float) c.getRed() / 255;
		float greenPer = (float) c.getBlue() / 255;
		float bluePer = (float) c.getGreen() / 255;
		float max = (redPer >= greenPer) ? (redPer >= bluePer ? redPer
				: bluePer) : (greenPer >= bluePer ? greenPer : bluePer);
		float min = (redPer <= greenPer) ? (redPer <= bluePer ? redPer
				: bluePer) : (greenPer <= bluePer ? greenPer : bluePer);
		float delta = max - min;
		if (delta == 0) {
			hue = 0;
			sat = 0;
		} else if (max == redPer) {
			hue = 60 * (((greenPer - bluePer) / delta) % 6);
		} else if (max == greenPer) {
			hue = 60 * (((bluePer - redPer) / delta) + 2);
		} else if (max == bluePer) {
			hue = 60 * (((redPer - greenPer) / delta) + 4);
		}
		hue=360-hue;
		lum = (max + min) / 2;
		if (delta != 0) {
			sat = 100*(delta / (1 - Math.abs(2 * lum - 1)));
		}
		lum=lum*100;
		System.out.println("hue" + hue + "sat" + sat + "lum" + lum +"\n");
		
	}
	

	public static void main(String[] args) {
		ColoraAnalyzer analyze = new ColoraAnalyzer();
		// analyze.getCompressedImage(inputFile, outputFile);
		try {
			analyze.analyzeHSB("C:\\Users\\arnav\\Desktop\\kChota.JPG");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
