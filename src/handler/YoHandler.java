package handler;

import icons.YoBackgrounds;
import icons.YoIcons;
import logic.YoProgressBarUi;

import java.io.IOException;

public class YoHandler {
    private final YoCommand command;

    public YoHandler(YoCommand command) {
        this.command = command;
    }

    public void toDo(){
        switch (command.getCommandName()) {
            case "Mario" -> {
                YoProgressBarUi.setCurrentIcon(YoIcons.getMario());
                YoProgressBarUi.setCurrentBackground(YoBackgrounds.getUserBackground(YoBackgrounds.getWallBackgroundPath()));
            }
            case "Pikachu" -> {
                YoProgressBarUi.setCurrentIcon(YoIcons.getPikachu());
                YoProgressBarUi.setCurrentBackground(YoBackgrounds.getUserBackground(YoBackgrounds.getGrassBackgroundPath()));
            }
            case "Sonic" -> {
                YoProgressBarUi.setCurrentIcon(YoIcons.getSonic());
                YoProgressBarUi.setCurrentBackground(YoBackgrounds.getUserBackground(YoBackgrounds.getGreyBackgroundPath()));
            }
            case "Nyan Cat" -> {
                YoProgressBarUi.setCurrentIcon(YoIcons.getNyanCat());
                YoProgressBarUi.setCurrentBackground(YoBackgrounds.getUserBackground(YoBackgrounds.getRainbowBackgroundPath()));
            }
            case "Custom" -> {
                YoProgressBarUi.setCurrentIcon(YoIcons.loadUserIcon(command.getUserPath()));
                YoProgressBarUi.setCurrentBackground(YoBackgrounds.getUserBackground(YoBackgrounds.getRainbowBackgroundPath()));
            }
            default -> throw new IllegalStateException("Unexpected value: " + command.getCommandName());
        }
    }
}
