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
    private static final String DEADPOOL_BACKGROUND_PATH = "/Backgrounds/deadpoolBackground.png";
    private static final String SONIC_BACKGROUND_PATH = "/Backgrounds/sonicBackground.png";
    private static final String HOMER_BACKGROUND_PATH = "/Backgrounds/пончики.png";
    private static final String DARK_FOREST_BACKGROUND_PATH = "/Backgrounds/darkForest.png";
    private static final String LIGHT_FOREST_BACKGROUND_PATH = "/Backgrounds/lightForest.png";
    private static final String GREY_WALL_BACKGROUND_PATH = "/Backgrounds/wall.png";
    private static final String MINECRAFT_BACKGROUND_PATH = "/Backgrounds/minecraft.png";
    private static final String CAVE_BACKGROUND_PATH = "/Backgrounds/cave.png";
    private static final String NARUTO_BACKGROUND_PATH = "/Backgrounds/Naruto.png";
    private static final String NARUTO_YELLOW_BACKGROUND_PATH = "/Backgrounds/narutoYellow.png";

    private YoBackgrounds() { throw new IllegalStateException("Utility class"); }

    public static String getNarutoYellowBackgroundPath() {
        return NARUTO_YELLOW_BACKGROUND_PATH;
    }

    public static String getNarutoBackgroundPath() {
        return NARUTO_BACKGROUND_PATH;
    }

    public static String getCaveBackgroundPath() {
        return CAVE_BACKGROUND_PATH;
    }

    public static String getMinecraftBackgroundPath() {
        return MINECRAFT_BACKGROUND_PATH;
    }

    public static String getGreyWallBackgroundPath() {
        return GREY_WALL_BACKGROUND_PATH;
    }

    public static String getLightForestBackgroundPath() {
        return LIGHT_FOREST_BACKGROUND_PATH;
    }

    public static String getDarkForestBackgroundPath() {
        return DARK_FOREST_BACKGROUND_PATH;
    }

    public static String getHomerBackgroundPath() {
        return HOMER_BACKGROUND_PATH;
    }

    public static String getDeadpoolBackgroundPath() {
        return DEADPOOL_BACKGROUND_PATH;
    }

    public static String getSonicBackgroundPath() {
        return SONIC_BACKGROUND_PATH;
    }

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
