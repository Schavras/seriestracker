package buttons;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconButton extends JButton {
	  Image image;
	    ImageObserver imageObserver;


	    public IconButton(String filename) {
	            super();
	            ImageIcon icon = new ImageIcon(filename);
	            image = icon.getImage();
	            imageObserver = icon.getImageObserver();
	        }

	     public void paint( Graphics g ) {
	            super.paint( g );
	            g.drawImage(image,  0 , 0 , getWidth() , getHeight() , imageObserver);
	        }
}
