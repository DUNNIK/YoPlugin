package icons;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class YoIcons {
    private static final String MARIO_PATH = "/Gifs/mario.gif";
    private static final String SONIC_PATH = "/Gifs/соник.gif";
    private static final String NYAN_CAT_PATH = "/Gifs/NyanCat.gif";
    private static final String NARUTO_PATH = "/Gifs/narutoRun.gif";
    private static final String MINECRAFT_PATH = "/Gifs/minecraft.gif";
    private static final String SASUKE_PATH = "/Gifs/saske.gif";

    private YoIcons() {throw new IllegalStateException("Utility class"); }

    public static String getSasukePath() {
        return SASUKE_PATH;
    }

    public static String getMinecraftPath() {
        return MINECRAFT_PATH;
    }

    public static String getNarutoPath() {
        return NARUTO_PATH;
    }

    public static String getMarioPath() {
        return MARIO_PATH;
    }

    public static String getSonicPath() {
        return SONIC_PATH;
    }

    public static String getNyanCatPath() {
        return NYAN_CAT_PATH;
    }

    private static void resizeImage(ImageIcon image) {
        var height = 20;
        image.setImage(image.getImage().getScaledInstance(20, height, Image.SCALE_DEFAULT));
    }
    @NotNull
    @Contract("_ -> new")
    public static ImageIcon loadIcon(URL url) {
        return new ImageIcon(url);
    }
}
