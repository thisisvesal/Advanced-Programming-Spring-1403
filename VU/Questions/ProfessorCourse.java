package Questions;

// To be removed later

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import People.Person;
import People.Student;
import Graphics.PlaceholderTextField;

public class ProfessorCourse extends Course {
    public PlaceholderTextField field;

    JLabel CourseNameLabel;
    // JPanel generalPanel, announcementPanel;
    public JPanel courseMaterialPanel, homeWorksPanel, examsPanel, courseNamePanel, announcementPanel, correctionPanel;
    public JLabel lesson;
    JPopupMenu popupMenu;
    JMenuItem[] menuItems = new JMenuItem[8];

    public ProfessorCourse(String name) {
        super(name);
        this.setPreferredSize(new Dimension(940, 790));
        // this.setLayout(null);
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        courseNamePanel = new JPanel();
        courseNamePanel.setBackground(new Color(235, 234, 171));
        courseNamePanel.setPreferredSize(new Dimension(920, 42));

        CourseNameLabel = new JLabel();
        CourseNameLabel.setText("CourseName");
        courseNamePanel.add(CourseNameLabel);
        this.add(courseNamePanel);
        JLabel box = new JLabel();
        box.setPreferredSize(new Dimension(400, 20));
        courseNamePanel.add(box);
        popupMenu = new JPopupMenu();
        setMenuItem();
        JButton addStudents = new JButton();
        addStudents.setBounds(2, 205, 150, 50);
        addStudents.setText("Add Student");
        courseNamePanel.add(addStudents);

        addStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(addStudents, 0, addStudents.getHeight());
            }
        });

        courseMaterialPanel = new JPanel();
        courseMaterialPanel.setBackground(new Color(169, 239, 242));
        courseMaterialPanel.setPreferredSize(new Dimension(920, 142));
        courseMaterialPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(courseMaterialPanel);

        JLabel Lesson = new JLabel();
        Lesson.setText("   Lessons");
        courseMaterialPanel.add(Lesson);

        Lesson = new JLabel();
        Lesson.setIcon(new ImageIcon("icons/video.png"));
        courseMaterialPanel.add(Lesson);

        Lesson = new JLabel();
        Lesson.setIcon(new ImageIcon("icons/add.png"));
        courseMaterialPanel.add(Lesson);

        homeWorksPanel = new JPanel();
        homeWorksPanel.setBackground(new Color(235, 234, 171));
        homeWorksPanel.setPreferredSize(new Dimension(920, 142));
        homeWorksPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(homeWorksPanel);

        JLabel exercises = new JLabel();
        exercises.setText("   exercises");
        homeWorksPanel.add(exercises);

        exercises = new JLabel();
        exercises.setIcon(new ImageIcon("icons/homework.png"));
        homeWorksPanel.add(exercises);

        exercises = new JLabel();
        exercises.setIcon(new ImageIcon("icons/add.png"));
        homeWorksPanel.add(exercises);

        examsPanel = new JPanel();
        examsPanel.setBackground(new Color(169, 239, 242));
        examsPanel.setPreferredSize(new Dimension(920, 142));
        examsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(examsPanel);

        JLabel examLabel = new JLabel();
        examLabel.setText("   exams");
        examsPanel.add(examLabel);

        examLabel = new JLabel();
        examLabel.setIcon(new ImageIcon("icons/quiz.png"));
        examsPanel.add(examLabel);

        examLabel = new JLabel();
        examLabel.setIcon(new ImageIcon("icons/add.png"));
        examsPanel.add(examLabel);

        announcementPanel = new JPanel();
        announcementPanel.setBackground(new Color(235, 234, 171));
        announcementPanel.setPreferredSize(new Dimension(920, 142));
        announcementPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(announcementPanel);

        JLabel announcementLabel = new JLabel();
        announcementLabel.setText("   announcement");
        announcementPanel.add(announcementLabel);

        announcementLabel = new JLabel();
        announcementLabel.setIcon(new ImageIcon("icons/announcement.png"));
        announcementPanel.add(announcementLabel);

        announcementLabel = new JLabel();
        announcementLabel.setIcon(new ImageIcon("icons/add.png"));
        announcementPanel.add(announcementLabel);

        announcementLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                field = new PlaceholderTextField();
                field.setPreferredSize(new Dimension(600, 80));
                field.setPlaceholder("announcement");
                field.setForeground(Color.BLACK);
                field.setBackground(Color.WHITE);
                field.setCaretColor(Color.BLACK);
                announcementPanel.add(field);
                JLabel box = new JLabel();
                box.setPreferredSize(new Dimension(500, 20));
                announcementPanel.add(box);
                JButton submit = new JButton();
                submit.setText("submit");
                submit.setPreferredSize(new Dimension(100, 40));
                // submit.setEnabled(false);
                announcementPanel.add(submit);
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // ProfessorCourse.super.addAnnouncement(field.getText());
                    }
                });
            }
        });

        correctionPanel = new JPanel();
        correctionPanel.setBackground(new Color(169, 239, 242));
        correctionPanel.setPreferredSize(new Dimension(920, 142));
        correctionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(correctionPanel);

        JLabel correctionLabel = new JLabel();
        correctionLabel.setText("   correction");
        correctionPanel.add(correctionLabel);

        correctionLabel = new JLabel();
        correctionLabel.setIcon(new ImageIcon("icons/correction.png"));
        correctionPanel.add(correctionLabel);

        correctionLabel = new JLabel();
        correctionLabel.setIcon(new ImageIcon("icons/add.png"));
        correctionPanel.add(correctionLabel);

    }

    private void setMenuItem() {
        int counter = 1;
        for (Person person : Person.people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                menuItems[counter] = new JMenuItem(person.getID());
                menuItems[counter].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        students.add(student);
                        student.classList.add(new JButton(CourseNameLabel.getText()));
                    }
                });
                counter++;
            }
        }

        for (int i = 1; i < counter - 1; i++) {
            popupMenu.add(menuItems[i]);
        }
    }
}
