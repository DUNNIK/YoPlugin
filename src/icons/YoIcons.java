package icons;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.net.URL;

public class YoIcons {
    private static final String MARIO_PATH = "/Gifs/mario.gif";
    private static final String DEADPOOL_PATH = "/Gifs/deadpool.gif";
    private static final String SONIC_PATH = "/Gifs/соник.gif";
    private static final String ZOMBIE_PATH = "/Gifs/зомби.gif";
    private static final String PIKACHU_PATH = "/Gifs/picachu.gif";
    private static final String SKELETONS_PATH = "/Gifs/Скелеты.gif";
    private static final String NYAN_CAT_PATH = "/Gifs/NyanCat.gif";
    private static final String HOMER_PATH = "/Gifs/simpson.gif";
    private static final String NARUTO_PATH = "/Gifs/narutoRun.gif";
    private static final String MINECRAFT_PATH = "/Gifs/minecraft.gif";
    private static final String TRAVELER_PATH = "/Gifs/traveler.gif";
    private static final String SASUKE_PATH = "/Gifs/saske.gif";

    public YoIcons() {throw new IllegalStateException("Utility class"); }

    public static String getSasukePath() {
        return SASUKE_PATH;
    }

    public static String getTravelerPath() {
        return TRAVELER_PATH;
    }

    public static String getMinecraftPath() {
        return MINECRAFT_PATH;
    }

    public static String getNarutoPath() {
        return NARUTO_PATH;
    }

    public static String getDeadpoolPath() {
        return DEADPOOL_PATH;
    }

    public static String getHomerPath() {
        return HOMER_PATH;
    }

    public static String getZombiePath() {
        return ZOMBIE_PATH;
    }

    public static String getSonicPath() {
        return SONIC_PATH;
    }

    public static String getSkeletonsPath() {
        return SKELETONS_PATH;
    }

    public static String getPikachuPath() {
        return PIKACHU_PATH;
    }

    public static String getNyanCatPath() {
        return NYAN_CAT_PATH;
    }

    public static String getMarioPath() {
        return MARIO_PATH;
    }


    @NotNull
    @Contract("_ -> new")
    public static ImageIcon loadIcon(URL url) {
        return new ImageIcon(url);
    }
}
