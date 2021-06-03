package icons;

import org.imgscalr.Scalr;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class YoIcons {
    private static final String marioPath = "/Gifs/mario.gif";
    private static final String sonicPath = "/Gifs/соник.gif";
    private static final String zombiePath = "/Gifs/зомби.gif";
    private static final String pikachuPath = "/Gifs/пикачу.gif";
    private static final String skeletonsPath = "/Gifs/Скелеты.gif";
    private static final String nyanCatPath = "/Gifs/NyanCat.gif";
    private static final URL marioUrl = YoIcons.class.getResource("/Gifs/mario.gif");
    private static final URL sonicUrl = YoIcons.class.getResource("/Gifs/соник.gif");
    private static final URL zombieUrl = YoIcons.class.getResource("/Gifs/зомби.gif");
    private static final URL pikachuUrl = YoIcons.class.getResource("/Gifs/пикачу.gif");
    private static final URL skeletonsUrl = YoIcons.class.getResource("/Gifs/Скелеты.gif");
    private static final URL nyanCatUrl = YoIcons.class.getResource("/Gifs/NyanCat.gif");
    private static final ImageIcon mario = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/mario.gif")));
    private static final ImageIcon sonic = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/соник.gif")));
    private static final ImageIcon zombie = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/зомби.gif")));
    private static final ImageIcon pikachu = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/пикачу.gif")));
    private static final ImageIcon skeletons = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/Скелеты.gif")));
    private static final ImageIcon nyanCat = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/NyanCat.gif")));

    private YoIcons() { throw new IllegalStateException("Utility class"); }

    public static String getZombiePath() {
        return zombiePath;
    }

    public static String getSonicPath() {
        return sonicPath;
    }

    public static String getSkeletonsPath() {
        return skeletonsPath;
    }

    public static String getPikachuPath() {
        return pikachuPath;
    }

    public static String getNyanCatPath() {
        return nyanCatPath;
    }

    public static String getMarioPath() {
        return marioPath;
    }

    public static URL getZombieUrl() {
        return zombieUrl;
    }

    public static URL getSonicUrl() {
        return sonicUrl;
    }

    public static URL getSkeletonsUrl() {
        return skeletonsUrl;
    }

    public static URL getPikachuUrl() {
        return pikachuUrl;
    }

    public static URL getNyanCatUrl() {
        return nyanCatUrl;
    }

    public static URL getMarioUrl() {
        return marioUrl;
    }

    public static ImageIcon getMario() {
        return mario;
    }

    public static ImageIcon getSonic() {
        return sonic;
    }

    public static ImageIcon getZombie() {
        return zombie;
    }

    public static ImageIcon getPikachu() {
        return pikachu;
    }

    public static ImageIcon getSkeletons() {
        return skeletons;
    }

    public static ImageIcon getNyanCat() {
        return nyanCat;
    }


    @NotNull
    @Contract("_ -> new")
    public static ImageIcon loadIcon(URL url) {
        return new ImageIcon(url);
    }
}
