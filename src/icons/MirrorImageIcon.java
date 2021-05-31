package icons;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MirrorImageIcon extends ImageIcon {

    public MirrorImageIcon(String filename) {
        super(filename);
    }

    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(getIconWidth(), 0);
        g2.scale(-1, 1);
        super.paintIcon(c, g2, x, y);
    }
}

