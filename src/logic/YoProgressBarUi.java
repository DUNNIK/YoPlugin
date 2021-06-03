package logic;

import com.intellij.openapi.ui.GraphicsConfig;
import com.intellij.ui.Gray;
import com.intellij.ui.JBColor;
import com.intellij.ui.scale.JBUIScale;
import com.intellij.util.ui.GraphicsUtil;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;
import icons.YoBackgrounds;
import icons.YoIcons;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;


public class YoProgressBarUi extends BasicProgressBarUI {

    @NotNull
    @Contract("_ -> new")
    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(@NotNull JComponent c) {
        c.setBorder(JBUI.Borders.empty().asUIResource());
        return new YoProgressBarUi();
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(super.getPreferredSize(c).width, JBUIScale.scale(20));
    }

    @Override
    protected void installListeners() {
        super.installListeners();
        progressBar.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
            }
        });//ToDo: попробовать удалить эти методы
    }

    private volatile int offset = 0;
    private volatile int offset2 = 0;
    private volatile int velocity = 1;

    private boolean isNotInstanceOfGraphic2D(Graphics g2d){
        return !(g2d instanceof Graphics2D);
    }

    //Универсальный метод рисования, который должен делать правильные вещи для всех линейных индикаторов выполнения прыгающих ящиков.
    @Override
    protected void paintIndeterminate(Graphics g2d, JComponent component) {
        if (isNotInstanceOfGraphic2D(g2d)) {
            return;
        }

        var graphics2D = (Graphics2D) g2d;
        var areaForBorder = progressBar.getInsets();
        int barRectWidth = progressBar.getWidth() - (areaForBorder.right + areaForBorder.left);
        int barRectHeight = progressBar.getHeight() - (areaForBorder.top + areaForBorder.bottom);
        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }
        graphics2D.setColor(new JBColor(Gray._240.withAlpha(50), Gray._128.withAlpha(50)));
        int cWidth = component.getWidth();
        int cHeight = component.getPreferredSize().height;
        if (isNotEven(component.getHeight() - cHeight)) {
            cHeight++;
        }
        if (component.isOpaque()) {
            graphics2D.fillRect(0, (component.getHeight() - cHeight) / 2, cWidth, cHeight);
        }

        //ToDo: background
        var state = YoProgressBarUiState.getInstance();
        var currentBackground = YoBackgrounds.loadBackground(this.getClass().getResource(state.getCurrentBackgroundPath()));
        if (currentBackground != null) {
            var tp = new TexturePaint(currentBackground, new Rectangle2D.Double(0, 1, cWidth - 2f, cHeight - 2f));
            graphics2D.setPaint(tp);
        }
        //graphics2D.setColor(new JBColor(Gray._165.withAlpha(50), Gray._88.withAlpha(50)));
        final GraphicsConfig config = GraphicsUtil.setupAAPainting(graphics2D);
        graphics2D.translate(0, (component.getHeight() - cHeight) / 2);

        final float R = JBUIScale.scale(8f);
        final float R2 = JBUIScale.scale(9f);

        final var containingRoundRect = new Area(new RoundRectangle2D.Float(1f, 1f, cWidth - 2f, cHeight - 2f, R, R));
        graphics2D.fill(containingRoundRect);
        offset = (offset + 1) % getPeriodLength();
        offset2 += velocity;

        if (offset2 <= 2) {
            offset2 = 2;
            velocity = 1;
        } else if (offset2 >= cWidth - JBUIScale.scale(15)) {
            offset2 = cWidth - JBUIScale.scale(15);
            velocity = -1;
        }
        var area = new Area(new Rectangle2D.Float(0, 0, cWidth, cHeight));
        area.subtract(new Area(new RoundRectangle2D.Float(1f, 1f, cWidth - 2f, cHeight - 2f, R, R)));

        if (component.isOpaque()) {
            graphics2D.fill(area);
        }

        area.subtract(new Area(new RoundRectangle2D.Float(0, 0, cWidth, cHeight, R2, R2)));
        if (component.isOpaque()) {
            graphics2D.fill(area);
        }

        var currentIcon = YoIcons.loadIcon(this.getClass().getResource(state.getCurrentIconPath()));

        currentIcon.paintIcon(progressBar, graphics2D, offset2 - JBUIScale.scale(5), -(component.getHeight() - cHeight) / 2);

        graphics2D.draw(new RoundRectangle2D.Float(1f, 1f, cWidth - 2f - 1f, cHeight - 2f - 1f, R, R));
        graphics2D.translate(0, -(component.getHeight() - cHeight) / 2);

        if (progressBar.isStringPainted()) {
            if (progressBar.getOrientation() == SwingConstants.HORIZONTAL) {
                paintString(graphics2D, areaForBorder.left, areaForBorder.top, barRectWidth, barRectHeight, boxRect.x, boxRect.width);
            } else {
                paintString(graphics2D, areaForBorder.left, areaForBorder.top, barRectWidth, barRectHeight, boxRect.y, boxRect.height);
            }
        }
        config.restore();
    }

    //Универсальный метод рисования, который должен делать правильные вещи почти для всех линейных, определенных индикаторов прогресса.
    @Override
    protected void paintDeterminate(Graphics graphics, JComponent component) {
        if (!(graphics instanceof Graphics2D)) {
            return;
        }

        if (progressBar.getOrientation() != SwingConstants.HORIZONTAL || !component.getComponentOrientation().isLeftToRight()) {
            super.paintDeterminate(graphics, component);
            return;
        }

        final GraphicsConfig config = GraphicsUtil.setupAAPainting(graphics);
        var barInsets = progressBar.getInsets(); // area for border
        int progressBarWidth = progressBar.getWidth();
        int progressBarHeight = progressBar.getPreferredSize().height;
        if (isNotEven(component.getHeight() - progressBarHeight)) {
            progressBarHeight++;
        }

        int barRectWidth = progressBarWidth - (barInsets.right + barInsets.left);
        int barRectHeight = progressBarHeight - (barInsets.top + barInsets.bottom);

        if (barRectWidth <= 0 || barRectHeight <= 0) {
            return;
        }

        int amountFull = getAmountFull(barInsets, barRectWidth, barRectHeight);
        Container parent = component.getParent();
        Color background = parent != null ? parent.getBackground() : UIUtil.getPanelBackground();
        graphics.setColor(background);
        var graphics2D = (Graphics2D) graphics;

        if (component.isOpaque()) {
            graphics.fillRect(0, 0, progressBarWidth, progressBarHeight);
        }

        final float R = JBUIScale.scale(8f);
        final float R2 = JBUIScale.scale(9f);
        final float off = JBUIScale.scale(1f);

        graphics2D.translate(0, (component.getHeight() - progressBarHeight) / 2);
        graphics2D.setColor(progressBar.getForeground());
        graphics2D.fill(new RoundRectangle2D.Float(0, 0, progressBarWidth - off, progressBarHeight - off, R2, R2));
        graphics2D.setColor(background);
        graphics2D.fill(new RoundRectangle2D.Float(off, off, progressBarWidth - 2f * off - off, progressBarHeight - 2f * off - off, R, R));

        var state = YoProgressBarUiState.getInstance();
        var currentBackground = YoBackgrounds.loadBackground(this.getClass().getResource(state.getCurrentBackgroundPath()));
        if (currentBackground != null) {
            var tp = new TexturePaint(currentBackground, new Rectangle2D.Double(0, 1, progressBarHeight - 2f * off - off, progressBarHeight - 2f * off - off));
            graphics2D.setPaint(tp);
        }

        graphics2D.fill(new RoundRectangle2D.Float(2f * off, 2f * off, amountFull - JBUIScale.scale(5f), progressBarHeight - JBUIScale.scale(5f), JBUIScale.scale(7f), JBUIScale.scale(7f)));

        var currentIcon = YoIcons.loadIcon(this.getClass().getResource(state.getCurrentIconPath()));

        currentIcon.paintIcon(progressBar, graphics2D, amountFull - JBUIScale.scale(5), -(component.getHeight() - progressBarHeight) / 2);
        graphics2D.translate(0, -(component.getHeight() - progressBarHeight) / 2);

        if (progressBar.isStringPainted()) {
            paintString(graphics, barInsets.left, barInsets.top,
                    barRectWidth, barRectHeight,
                    amountFull, barInsets);
        }
        config.restore();
    }

    private void paintString(Graphics graphics, int x, int y, int w, int h, int fillStart, int amountFull) {
        if (!(graphics instanceof Graphics2D)) {
            return;
        }

        var graphics2D = (Graphics2D) graphics;
        var progressString = progressBar.getString();
        graphics2D.setFont(progressBar.getFont());
        Point renderLocation = getStringPlacement(graphics2D, progressString,
                x, y, w, h);
        Rectangle oldClip = graphics2D.getClipBounds();

        if (progressBar.getOrientation() == SwingConstants.HORIZONTAL) {
            graphics2D.setColor(getSelectionBackground());
            BasicGraphicsUtils.drawString(progressBar, graphics2D, progressString, renderLocation.x, renderLocation.y);

            graphics2D.setColor(getSelectionForeground());
            graphics2D.clipRect(fillStart, y, amountFull, h);
            BasicGraphicsUtils.drawString(progressBar, graphics2D, progressString, renderLocation.x, renderLocation.y);
        } else {
            graphics2D.setColor(getSelectionBackground());
            var rotate =
                    AffineTransform.getRotateInstance(Math.PI / 2);
            graphics2D.setFont(progressBar.getFont().deriveFont(rotate));
            renderLocation = getStringPlacement(graphics2D, progressString,
                    x, y, w, h);
            BasicGraphicsUtils.drawString(progressBar, graphics2D, progressString, renderLocation.x, renderLocation.y);
            graphics2D.setColor(getSelectionForeground());
            graphics2D.clipRect(x, fillStart, w, amountFull);
            BasicGraphicsUtils.drawString(progressBar, graphics2D, progressString, renderLocation.x, renderLocation.y);
        }
        graphics2D.setClip(oldClip);
    }

    @Override
    protected int getBoxLength(int availableLength, int otherDimension) {
        return availableLength;
    }

    private int getPeriodLength() {
        return JBUIScale.scale(16);
    }

    private static boolean isNotEven(int value) {
        return value % 2 != 0;
    }

}

