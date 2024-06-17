package FileHandling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public abstract class SerializableActionListener implements ActionListener, Serializable {

    @Override
    public abstract void actionPerformed(ActionEvent e);
}