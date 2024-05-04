package Frames;

import Questions.HomeWork;

import javax.swing.*;

import People.Person;

import java.awt.*;

public class ExamPage extends GeneralPage {
    private static ExamPage instance;
    public PlaceholderTextField[] field = new PlaceholderTextField[5];
    public final JPanel examPanel = new JPanel(new CardLayout());

    private ExamPage() {
        super();
        this.setUpGeneralPanelFor(Person.getCurrentUser());
        examPanel.setPreferredSize(new Dimension(950, 795));
        examPanel.setOpaque(false);
        examPanel.setLayout(new CardLayout());
        examPanel.setBackground(MainFrame.themeColor);
        this.add(examPanel);
    }

    public static ExamPage getInstance() {
        if (instance == null) {
            instance = new ExamPage();
        }
        return instance;
    }

    public void addHomeWork(HomeWork homeWork) {
        examPanel.add(homeWork);
    }
}
