package gfx;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

//IMAGE LOADER CLASS, I FIND THIS USELESS BUT IN THE TUTORIAL I WATCHED SAID IT WILL BE USEFULL
public class ImageLoader {
    public static BufferedImage loadImage (String path) {
        if(path.contains("ma")) {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        }
        try {
            return ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}