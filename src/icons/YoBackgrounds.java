package icons;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import static javax.imageio.ImageIO.read;

public class YoBackgrounds {
    private static final String WALL_BACKGROUND_PATH = "/Backgrounds/bricks.png";
    private static final String GRASS_BACKGROUND_PATH = "/Backgrounds/grass.png";
    private static final String MOUNTAIN_BACKGROUND_PATH = "/Backgrounds/mountains.png";
    private static final String RAINBOW_BACKGROUND_PATH = "/Backgrounds/rainbow.png";
    private static final String GREY_BACKGROUND_PATH = "/Backgrounds/gray.png";
    private static final String LIGHTGREY_BACKGROUND_PATH = "/Backgrounds/lightGray.png";
    private static final URL WALL_BACKGROUND_URL = YoBackgrounds.class.getResource("/Backgrounds/bricks.png");
    private static final URL GRASS_BACKGROUND_URL = YoBackgrounds.class.getResource("/Backgrounds/grass.png");
    private static final URL MOUNTAIN_BACKGROUND_URL = YoBackgrounds.class.getResource("/Backgrounds/mountains.png");
    private static final URL RAINBOW_BACKGROUND_URL = YoBackgrounds.class.getResource("/Backgrounds/rainbow.png");
    private static final URL GREY_BACKGROUND_URL = YoBackgrounds.class.getResource("/Backgrounds/gray.png");

    private YoBackgrounds() { throw new IllegalStateException("Utility class"); }

    public static String getWallBackgroundPath() {
        return WALL_BACKGROUND_PATH;
    }

    public static String getMountainBackgroundPath() {
        return MOUNTAIN_BACKGROUND_PATH;
    }

    public static String getGrassBackgroundPath() {
        return GRASS_BACKGROUND_PATH;
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

    public static URL getWallBackgroundUrl() {
        return WALL_BACKGROUND_URL;
    }

    public static URL getRainbowBackgroundUrl() {
        return RAINBOW_BACKGROUND_URL;
    }

    public static URL getMountainBackgroundUrl() {
        return MOUNTAIN_BACKGROUND_URL;
    }

    public static URL getGreyBackgroundUrl() {
        return GREY_BACKGROUND_URL;
    }

    public static URL getGrassBackgroundUrl() {
        return GRASS_BACKGROUND_URL;
    }

    private static BufferedImage resizeImage(BufferedImage image) {
        return Scalr.resize(image, 32);
    }

    public static BufferedImage loadBackground(URL url) {
        BufferedImage image = null;
        try {
            image = read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = resizeImage(image);
        return image;
    }
}
