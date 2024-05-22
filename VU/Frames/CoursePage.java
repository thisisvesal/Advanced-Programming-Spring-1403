package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Clock.ClockPane;
import Questions.Course;

public class CoursePage extends JPanel {
    private static CoursePage instance;
    JPanel generalPanel, announcementPanel;
    private Course currentVisibleCourse;
    public final JPanel coursePanel = new JPanel(new CardLayout());

    private CoursePage() {
        super();
        this.setPreferredSize(new Dimension(1184, 800));
        this.setLayout(null);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));


        // this.setUpGeneralPanelFor(Person.getCurrentUser());
        coursePanel.setPreferredSize(new Dimension(1184, 795));
        coursePanel.setOpaque(false);
        coursePanel.setLayout(new CardLayout());
        coursePanel.setBackground(MainFrame.themeColor);

        this.add(coursePanel);
    }

    public static CoursePage getInstance() {
        if (instance == null) {
            instance = new CoursePage();
        }
        return instance;
    }

    public void addCourse(Course course) {
        this.coursePanel.add(course);
    }

    public void setCurrentVisibleCourse(Course course) {
        if (currentVisibleCourse != null) {
            this.currentVisibleCourse.setVisible(false);
        }
        this.currentVisibleCourse = course;
        course.setVisible(true);
    }

    public Course getCurrentVisibleCourse() {
        return currentVisibleCourse;
    }

}