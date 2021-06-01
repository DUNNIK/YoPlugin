// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Provides controller functionality for application settings.
 */
public class YoSettingsConfigurable implements Configurable {

  private YoSettingsComponent yoSettingsComponent;

  // A default constructor with no arguments is required because this implementation
  // is registered as an applicationConfigurable EP

  @Nls(capitalization = Nls.Capitalization.Title)
  @Override
  public String getDisplayName() {
    return "YoPlugin Settings";
  }

  @Override
  public JComponent getPreferredFocusedComponent() {
    return yoSettingsComponent.getCurrentButton();
  }

  @Nullable
  @Override
  public JComponent createComponent() {
    yoSettingsComponent = new YoSettingsComponent();//ToDo:List из элементов хранимых в state
    return yoSettingsComponent.getPanel();
  }

  @Override
  public boolean isModified() {
    var settings = YoSettingsState.getInstance();
    return !yoSettingsComponent.getCurrentButtonText().equals(settings.designType);
  }

  @Override
  public void apply() {
    var settings = YoSettingsState.getInstance();
    settings.designType = yoSettingsComponent.getCurrentButtonText();
    //ToDo: изменить переменную в загрузчике
  }

  @Override
  public void reset() {
    var settings = YoSettingsState.getInstance();
    yoSettingsComponent.setCurrentButton(settings.designType);
    //ToDo: изменить переменную в загрузчике
  }

  @Override
  public void disposeUIResources() {
    yoSettingsComponent = null;
  }

}
