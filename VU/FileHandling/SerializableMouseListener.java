package FileHandling;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public abstract class SerializableMouseListener implements MouseListener, Serializable {

    @Override
    public abstract void mouseClicked(MouseEvent e);

    @Override
    public abstract void mouseEntered(MouseEvent e);

    @Override
    public abstract void mouseExited(MouseEvent e);

    @Override
    public abstract void mousePressed(MouseEvent e);

    @Override
    public abstract void mouseReleased(MouseEvent e);
    
}
