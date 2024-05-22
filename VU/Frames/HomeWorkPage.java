package Frames;

import Questions.HomeWork;

import javax.swing.*;

import Graphics.PlaceholderTextField;
import People.Person;

import java.awt.*;

public class HomeWorkPage extends GeneralPage {
    private static HomeWorkPage instance;
    public PlaceholderTextField[] field = new PlaceholderTextField[5];
    public final JPanel homeWorkPanel = new JPanel(new CardLayout());

    private HomeWorkPage() {
        super();
        //this.setUpGeneralPanelFor(Person.getCurrentUser());
        homeWorkPanel.setPreferredSize(new Dimension(950, 795));
        homeWorkPanel.setOpaque(false);
        homeWorkPanel.setLayout(new CardLayout());
        homeWorkPanel.setBackground(MainFrame.themeColor);
        this.add(homeWorkPanel);
    }

    public static HomeWorkPage getInstance() {
        if (instance == null) {
            instance = new HomeWorkPage();
        }
        return instance;
    }

    public void addHomeWork(HomeWork homeWork) {
        homeWorkPanel.add(homeWork);
    }
}