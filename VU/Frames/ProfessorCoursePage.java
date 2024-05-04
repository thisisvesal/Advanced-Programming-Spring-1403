package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorCoursePage extends GeneralPage {
    private static ProfessorCoursePage instance;
    public JPanel courseName, panel, CorrectionPanel, Actionpanel;
    private JButton questions, Correction, announcement, submit;
    public JLabel Name;
    public QuestionPage questionPage;
    public boolean SwCorrectionPanel = false, SwAnnouncement = false;
    public String[] announcementList = new String[50];
    public int announcementCounter;
    PlaceholderTextField field;

    private ProfessorCoursePage() {
        this.setPreferredSize(new Dimension(1220, 800));
        this.setLayout(null);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(955, 800));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setOpaque(false);

        courseName = new JPanel();
        courseName.setBackground(new Color(235, 234, 171));
        courseName.setPreferredSize(new Dimension(959, 42));

        Name = new JLabel();
        Name.setText("CourseName");
        courseName.add(Name);
        panel.add(courseName);

        JPanel box = new JPanel();
        box.setPreferredSize(new Dimension(190, 50));
        box.setOpaque(false);
        panel.add(box);

        questions = new JButton();
        questions.setPreferredSize(new Dimension(150, 100));
        questions.setText("questions");
        panel.add(questions);
        Correction = new JButton();
        Correction.setPreferredSize(new Dimension(150, 100));
        Correction.setText("Correction");
        panel.add(Correction);
        announcement = new JButton();
        announcement.setPreferredSize(new Dimension(150, 100));
        announcement.setText("announcement");
        panel.add(announcement);
        submit = new JButton();
        submit.setText("submit");
        submit.setPreferredSize(new Dimension(150, 100));
        submit.setEnabled(false);
        panel.add(submit);

        box = new JPanel();
        box.setPreferredSize(new Dimension(600, 50));
        box.setOpaque(false);
        panel.add(box);

        Actionpanel = new JPanel();
        Actionpanel.setPreferredSize(new Dimension(955, 800));
        Actionpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Actionpanel.setOpaque(false);

        questions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getMainFrame().professorCoursePage.setVisible(false);
                MainFrame.getMainFrame().questionPage.setVisible(true);
            }
        });
        Correction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit.setEnabled(false);
                CorrectionPanel = new JPanel();
                CorrectionPanel.setPreferredSize(new Dimension(955, 440));
                CorrectionPanel.setBackground(Color.LIGHT_GRAY);
                Actionpanel.add(CorrectionPanel);
            }
        });
        announcement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit.setEnabled(true);
                field = new PlaceholderTextField();
                field.setPreferredSize(new Dimension(945, 100));
                field.setPlaceholder("announcement");
                field.setForeground(Color.BLACK);
                field.setBackground(Color.WHITE);
                field.setCaretColor(Color.BLACK);
                Actionpanel.add(field);
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // announcementList[announcementCounter]=field.getText();
                ProfessorCoursePage.super.addAnnouncement(field.getText());
            }
        });

        panel.add(Actionpanel);
        this.add(panel);
    }

    public static ProfessorCoursePage getInstance() {
        if (instance == null) {
            instance = new ProfessorCoursePage();
        }
        return instance;
    }
}
