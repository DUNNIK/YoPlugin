package handler;

import icons.YoBackgrounds;
import icons.YoIcons;
import logic.YoProgressBarUiState;

public class YoHandler {
    private final YoCommand command;

    public YoHandler(YoCommand command) {
        this.command = command;
    }

   /* public void toDo(){
        switch (command.getCommandName()) {
            case "Mario" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIcon(YoIcons.getMario());
                state.setCurrentBackground(YoBackgrounds.getUserBackground(this.getClass().getResource(YoBackgrounds.getWallBackgroundPath())));
            }
            case "Pikachu" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIcon(YoIcons.getPikachu());
                state.setCurrentBackground(YoBackgrounds.getUserBackground(this.getClass().getResource(YoBackgrounds.getGrassBackgroundPath())));
            }
            case "Sonic" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIcon(YoIcons.getSonic());
                state.setCurrentBackground(YoBackgrounds.getUserBackground(this.getClass().getResource(YoBackgrounds.getGreyBackgroundPath())));
            }
            case "Nyan Cat" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIcon(YoIcons.getNyanCat());
                state.setCurrentBackground(YoBackgrounds.getUserBackground(this.getClass().getResource((YoBackgrounds.getRainbowBackgroundPath()))));
            }
            case "Custom" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIcon(YoIcons.loadUserIcon(command.getUserPath()));
                state.setCurrentBackground(YoBackgrounds.getUserBackground(this.getClass().getResource(YoBackgrounds.getRainbowBackgroundPath())));
            }
            default -> throw new IllegalStateException("Unexpected value: " + command.getCommandName());
        }
    }*/
    public void toDo(){
        switch (command.getCommandName()) {
            case "Mario" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(YoIcons.getMarioPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getWallBackgroundPath());
            }
            case "Pikachu" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(YoIcons.getPikachuPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getGrassBackgroundPath());
            }
            case "Sonic" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(YoIcons.getSonicPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getGreyBackgroundPath());
            }
            case "Nyan Cat" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(YoIcons.getNyanCatPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getRainbowBackgroundPath());
            }
            case "Custom" -> {
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(command.getUserPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getRainbowBackgroundPath());
            }
            default -> throw new IllegalStateException("Unexpected value: " + command.getCommandName());
        }
    }
}
