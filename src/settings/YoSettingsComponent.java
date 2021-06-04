// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package settings;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class YoSettingsComponent {

  private final JPanel myMainPanel;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private final JPanel panelRadio = new JPanel(new GridLayout(5,0));
  private JRadioButton currentButton = new JRadioButton();
  private final List<JRadioButton> buttonList = new ArrayList<>();
  private final JBTextField userIconPath = new JBTextField();
  private final JPanel panelForCustom = new JPanel();

  public YoSettingsComponent(List<String> names) {
    initializeRadioPanel(names);
    initializeCustomPanel();
    myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(new JBLabel("Choose the design of the loader panel"), panelRadio, 1, true)
            .addLabeledComponent(new JBLabel("Add your custom Icon"), panelForCustom)
            .addComponentFillVertically(new JPanel(), 0)
            .getPanel();
  }
  public JPanel getPanel() {
    return myMainPanel;
  }

  private void initializeRadioPanel(@NotNull List<String> names) {
    for (String s : names) {
      var radio = new JRadioButton(s);
      radio.addItemListener(e -> {
        if (radio.isSelected()){
          currentButton = radio;
        }
      });
      panelRadio.add(radio);
      buttonGroup.add(radio);
      buttonList.add(radio);
    }
  }

  private void initializeCustomPanel() {
    panelForCustom.add(userIconPath);
    var button = new JButton("...");
    addButtonAction(button);
    panelForCustom.add(button);
  }

  private void addButtonAction(@NotNull JButton button) {
    var fileChooser = new JFileChooser();
    var filter = new FileNameExtensionFilter(
            "Images", "gif", "png", "jpg");
    fileChooser.addChoosableFileFilter(filter);

    button.addActionListener(e -> {
      fileChooser.setDialogTitle("Choose file");
      fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      int ret = fileChooser.showDialog(null, "Open file");
      if (ret == JFileChooser.APPROVE_OPTION) {
        var file = fileChooser.getSelectedFile();
        userIconPath.setText(file.getPath());
      }
    });
  }

  public JRadioButton getCurrentButton() {
    return currentButton;
  }

  public String getCurrentButtonText() {
    return currentButton.getText();
  }
  public void setCurrentButton(String currentButtonName) {
    this.currentButton = searchButtonInAllButtons(currentButtonName);
    if (currentButton != null){
      this.currentButton.setSelected(true);
    }
  }
  public String getCustomPath() {
    return userIconPath.getText();
  }

  public void setUserIconPath(String iconPath) {
    userIconPath.setText(iconPath);
  }

  private JRadioButton searchButtonInAllButtons(String text){
    JRadioButton result = null;
    for (var button : buttonList) {
      if (button.getText().equals(text)){
        result = button;
      }
    }
    return result;
  }
}
