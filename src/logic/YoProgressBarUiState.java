package logic;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import icons.YoBackgrounds;
import icons.YoIcons;
import org.jetbrains.annotations.NotNull;

@State(
        name = "org.intellij.sdk.logic.YoProgressBarUiState",
        storages = {@Storage("YoProgressBarUiState.xml")}
)
public class YoProgressBarUiState implements PersistentStateComponent<YoProgressBarUiState> {
    private String currentIconPath = YoIcons.getMarioPath();
    private String currentBackgroundPath = YoBackgrounds.getWallBackgroundPath();

    public String getCurrentIconPath() {
        return currentIconPath;
    }

    public String getCurrentBackgroundPath() {
        return currentBackgroundPath;
    }

    public void setCurrentIconPath(String currentIconPath) {
        this.currentIconPath = currentIconPath;
    }

    public void setCurrentBackgroundPath(String currentBackgroundPath) {
        this.currentBackgroundPath = currentBackgroundPath;
    }

    @Override
    public YoProgressBarUiState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull YoProgressBarUiState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static YoProgressBarUiState getInstance() {
        return ServiceManager.getService(YoProgressBarUiState.class);
    }
}
