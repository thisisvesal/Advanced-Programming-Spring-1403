package Frames;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class CorrectionPage extends GeneralPage {
    private static CorrectionPage instance;
    public final JPanel correctionPanel = new JPanel();

    private CorrectionPage() {
        super();
        correctionPanel.setPreferredSize(new Dimension(950, 795));
        correctionPanel.setOpaque(false);
        correctionPanel.setLayout(new CardLayout());
        correctionPanel.setBackground(MainFrame.themeColor);
        this.add(correctionPanel);
    }

    public static CorrectionPage getInstance() {
        if (instance == null) {
            instance = new CorrectionPage();
        }
        return instance;
    }
}
