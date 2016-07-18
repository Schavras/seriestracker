package core.types;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Poster {

	public static BufferedImage resizeImage(BufferedImage originalImage, int width, int height){
	     int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
			
		return resizedImage;
	    }
	
	public static BufferedImage getPoster(String path,int width, int height){
		
		BufferedImage image = null;
		
        URL url;
        
		try {
			url = new URL(path);
			image = ImageIO.read(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resizeImage(image, width,height);
	}
}
