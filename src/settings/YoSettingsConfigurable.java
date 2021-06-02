// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package settings;

import com.intellij.openapi.options.Configurable;
import handler.YoCommand;
import handler.YoHandler;
import org.h2.util.StringUtils;
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
    var settings = YoSettingsState.getInstance();
    yoSettingsComponent = new YoSettingsComponent(settings.getAllIcons());
    return yoSettingsComponent.getPanel();
  }

  @Override
  public boolean isModified() {
    var settings = YoSettingsState.getInstance();
    return !yoSettingsComponent.getCurrentButtonText().equals(settings.getCurrentIcon())
            || !yoSettingsComponent.getCustomPath().equals(settings.getCustomPath());
  }

  @Override
  public void apply() {
    if (isNotImpossibleToCustom()){
      JOptionPane.showMessageDialog(null, "It's not impossible to custom");
      reset();
      return;
    }
    var settings = YoSettingsState.getInstance();
    settings.setCurrentIcon(yoSettingsComponent.getCurrentButtonText());
    settings.setCustomPath(yoSettingsComponent.getCustomPath());

    var changeDesign = new YoHandler(new YoCommand(settings.getCurrentIcon(), settings.getCustomPath()));
    changeDesign.toDo();
  }
  private boolean isNotImpossibleToCustom() {
    return StringUtils.isWhitespaceOrEmpty(yoSettingsComponent.getCustomPath()) && yoSettingsComponent.getCurrentButtonText().equals("Custom");
  }
  @Override
  public void reset() {
    var settings = YoSettingsState.getInstance();
    yoSettingsComponent.setCurrentButton(settings.getCurrentIcon());
    yoSettingsComponent.setUserIconPath(settings.getCustomPath());
  }

  @Override
  public void disposeUIResources() {
    yoSettingsComponent = null;
  }

}
