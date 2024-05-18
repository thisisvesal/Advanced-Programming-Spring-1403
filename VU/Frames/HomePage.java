package Frames;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class HomePage extends JPanel {
    private static HomePage instance;

    private HomePage() {
        super();
        this.setPreferredSize(new Dimension(1220, 800));
        this.setLayout(new CardLayout());
        this.setBackground(Color.white);
    }

    // Singleton class instance getter:
    public static HomePage getInstance() {
        if (instance == null) {
            instance = new HomePage();
        }
        return instance;
    }
}