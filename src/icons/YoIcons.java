package icons;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class YoIcons {
    private static final ImageIcon mario = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/соник.gif")));
    private static final ImageIcon sonic = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/соник.gif")));
    private static final ImageIcon zombie = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/зомби.gif")));
    private static final ImageIcon pikachu = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/пикачу.gif")));
    private static final ImageIcon skeletons = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Gifs/Скелеты.gif")));
    private static final ImageIcon nyanCat = new ImageIcon(Objects.requireNonNull(YoIcons.class.getResource("/Images/cat.png")));
    private YoIcons() { throw new IllegalStateException("Utility class"); }

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

    private static BufferedImage resizeImage(BufferedImage image) {
        return Scalr.resize(image, 15, 21);
    }

    public static ImageIcon getUserIcon() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("путь юзера"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = resizeImage(image);
        return new ImageIcon(image);
    }
}
