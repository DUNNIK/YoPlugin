package handler;

import icons.YoBackgrounds;
import icons.YoIcons;
import logic.YoProgressBarUiState;

public class YoHandler {
    private final YoCommand command;

    public YoHandler(YoCommand command) {
        this.command = command;
    }

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
