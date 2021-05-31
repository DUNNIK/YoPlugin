package icons;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class YoBackgrounds {
    private static final String WALL_BACKGROUND_PATH = "/Backgrounds/bricks.png";
    private static final String GRASS_BACKGROUND_PATH = "/Backgrounds/grass.png";
    private static final String MOUNTAIN_BACKGROUND_PATH = "/Backgrounds/mountains.png";
    private static final String RAINBOW_BACKGROUND_PATH = "/Backgrounds/rainbow.png";
    private static final String GREY_BACKGROUND_PATH = "/Backgrounds/gray.png";
    private static final String LIGHTGREY_BACKGROUND_PATH = "/Backgrounds/lightGray.png";

    private YoBackgrounds() { throw new IllegalStateException("Utility class"); }

    public static String getWallBackgroundPath() {
        return WALL_BACKGROUND_PATH;
    }

    public static String getGrassBackgroundPath() {
        return GRASS_BACKGROUND_PATH;
    }

    public static String getMountainBackgroundPath() {
        return MOUNTAIN_BACKGROUND_PATH;
    }

    public static String getRainbowBackgroundPath() {
        return RAINBOW_BACKGROUND_PATH;
    }

    public static String getGreyBackgroundPath() {
        return GREY_BACKGROUND_PATH;
    }

    public static String getLightgreyBackgroundPath() {
        return LIGHTGREY_BACKGROUND_PATH;
    }

    private static BufferedImage resizeImage(BufferedImage image) {
        return Scalr.resize(image, 15, 21);
    }

    public static BufferedImage getUserBackground() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("путь юзера"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = resizeImage(image);
        return image;
    }
}
