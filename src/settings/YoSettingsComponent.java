// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package settings;

import com.intellij.ui.components.JBCheckBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Supports creating and managing a {@link JPanel} for the Settings Dialog.
 */
public class YoSettingsComponent {

  private final JPanel myMainPanel;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private final JPanel panelRadio = new JPanel();
  private JRadioButton currentButton = new JRadioButton();
  private List<JRadioButton> buttonList = new ArrayList<>();

  public YoSettingsComponent() {
    initializeRadioPanel();
    myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(new JBLabel("Choose the design of the loader panel"), panelRadio, 1, true)
            .addComponentFillVertically(new JPanel(), 0)
            .getPanel();
  }
  public JPanel getPanel() {
    return myMainPanel;
  }

  private void initializeRadioPanel() {
    String[] names = { "Mario", "Pikachu", "Sonic", "Nyan Cat"};
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


  public JRadioButton getCurrentButton() {
    return currentButton;
  }

  public String getCurrentButtonText() {
    return currentButton.getText();
  }
  public void setCurrentButton(String currentButtonName) {
    var button = searchButtonInAllButtons(currentButtonName);
    this.currentButton = button;
    this.currentButton.setSelected(true);
  }

  private JRadioButton searchButtonInAllButtons(String text){
    JRadioButton result = null;
    for (var button : buttonList) {
      if (button.getText() == text){
        result = button;
      }
    }
    return result;
  }
  public JPanel getPanelRadio() {
    return panelRadio;
  }
}
