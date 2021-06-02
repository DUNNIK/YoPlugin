package icons;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class YoBackgrounds {
    private static final String WALL_BACKGROUND_PATH = "/Backgrounds/bricks.png";
    private static final String GRASS_BACKGROUND_PATH = "/Backgrounds/grass.png";
    private static final String MOUNTAIN_BACKGROUND_PATH = "/Backgrounds/mountains.png";
    private static final String RAINBOW_BACKGROUND_PATH = "/Backgrounds/rainbow.png";
    private static final String GREY_BACKGROUND_PATH = "/Backgrounds/gray.png";
    private static final String LIGHTGREY_BACKGROUND_PATH = "/Backgrounds/lightGray.png";
    private static String userBackgroundPath;

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

    public static void setUserBackgroundPath(String userBackgroundPath) {
        YoBackgrounds.userBackgroundPath = userBackgroundPath;
    }

    public static String getUserBackgroundPath() {
        return userBackgroundPath;
    }

    /*public static BufferedImage getLoadImage(String name){

    }*/

    private static BufferedImage resizeImage(BufferedImage image) {
        return Scalr.resize(image, 32);
    }

    public static BufferedImage getUserBackground(String path) {
        BufferedImage image = null;
        try {
            image = read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = resizeImage(image);
        return image;
    }
}
