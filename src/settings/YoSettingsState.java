// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
        name = "org.intellij.sdk.settings.YoSettingsState",
        storages = {@Storage("SdkSettingsPlugin.xml")}
)
public class YoSettingsState implements PersistentStateComponent<YoSettingsState> {

  public List<String> names = Arrays.asList( "Mario", "Pikachu", "Sonic", "Nyan Cat");
  public String designType;

  public static YoSettingsState getInstance() {
    return ServiceManager.getService(YoSettingsState.class);
  }

  @Nullable
  @Override
  public YoSettingsState getState() {
    return this;
  }

  @Override
  public void loadState(@NotNull YoSettingsState state) {
    XmlSerializerUtil.copyBean(state, this);
  }

}
