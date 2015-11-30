package Game.Content;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Logo extends Image {
	Image logo;

	public Logo() {
		try {
		URL url = new URL("C:/Users/13t264/git/InfoExpr2/Bong/assets/images/logo.png");
		this.logo = ImageIO.read(url);
		} catch(IOException ex) {
            System.out.println("cant read image file");
        }
	}

	@Override
	public Graphics getGraphics() {
		return null;
	}

	@Override
	public int getHeight(ImageObserver arg0) {
		return 0;
	}

	@Override
	public Object getProperty(String arg0, ImageObserver arg1) {
		return null;
	}

	@Override
	public ImageProducer getSource() {
		return null;
	}

	@Override
	public int getWidth(ImageObserver arg0) {
		return 0;
	}
}
