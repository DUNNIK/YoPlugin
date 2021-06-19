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
            case "Mario" :
                var state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(YoIcons.getMarioPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getWallBackgroundPath());
                break;
            case "Pikachu" :
                state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(YoIcons.getPikachuPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getGrassBackgroundPath());
                break;
            case "Sonic" :
                state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(YoIcons.getSonicPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getGreyBackgroundPath());
                break;
            case "Nyan Cat" :
                state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(YoIcons.getNyanCatPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getRainbowBackgroundPath());
                break;
            case "Custom" :
                state = YoProgressBarUiState.getInstance();
                state.setCurrentIconPath(command.getUserPath());
                state.setCurrentBackgroundPath(YoBackgrounds.getGreyBackgroundPath());
                break;
            default : throw new IllegalStateException("Unexpected value: " + command.getCommandName());
        }
    }
}
