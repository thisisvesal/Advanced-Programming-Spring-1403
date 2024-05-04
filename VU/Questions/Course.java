package Questions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Frames.CoursePage;
import Frames.ExamPage;
import Frames.HomeWorkPage;
import Frames.MainFrame;
import People.Student;

public class Course extends JPanel {
    public final ArrayList<Student> students = new ArrayList<>();
    public final ArrayList<HomeWork> homeWorks = new ArrayList<>();
    public final ArrayList<Exam> exams = new ArrayList<>();
    JLabel CourseNameLabel;
    JPanel generalPanel, announcementPanel;
    public JPanel courseMaterialPanel, homeWorksPanel, examsPanel, courseNamePanel;
    public JLabel lesson;

    public Course() {
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setPreferredSize(new Dimension(940, 790));

        courseNamePanel = new JPanel();
        courseNamePanel.setBackground(new Color(235, 234, 171));
        courseNamePanel.setPreferredSize(new Dimension(920, 42));

        CourseNameLabel = new JLabel();
        CourseNameLabel.setText("CourseName");
        courseNamePanel.add(CourseNameLabel);
        this.add(courseNamePanel);

        courseMaterialPanel = new JPanel();
        courseMaterialPanel.setBackground(new Color(169, 239, 242));
        courseMaterialPanel.setPreferredSize(new Dimension(920, 150));
        courseMaterialPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(courseMaterialPanel);

        JLabel Lesson = new JLabel();
        Lesson.setText("   Lessons");
        courseMaterialPanel.add(Lesson);

        Lesson = new JLabel();
        Lesson.setIcon(new ImageIcon("icons/video.png"));
        courseMaterialPanel.add(Lesson);

        homeWorksPanel = new JPanel();
        homeWorksPanel.setBackground(new Color(235, 234, 171));
        homeWorksPanel.setPreferredSize(new Dimension(920, 270));
        homeWorksPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(homeWorksPanel);

        JLabel exercises = new JLabel();
        exercises.setText("   exercises");
        homeWorksPanel.add(exercises);

        for (HomeWork homeWork : homeWorks) {
            homeWorksPanel.add(homeWork.homeWorkIcon);
        }

        examsPanel = new JPanel();
        examsPanel.setBackground(new Color(169, 239, 242));
        examsPanel.setPreferredSize(new Dimension(920, 265));
        examsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(examsPanel);

        JLabel examLabel = new JLabel();
        examLabel.setText("   exams");
        examsPanel.add(examLabel);

        for (Exam exam : exams) {
            examsPanel.add(exam.examIcon);
        }

        CoursePage.getInstance().addCourse(this);
    }

    public void addExam(Exam exam) {
        this.exams.add(exam);
        ExamPage.getInstance().examPanel.add(exam);
        this.examsPanel.add(exam.examIcon);
    }

    public void addHomeWork(HomeWork homeWork) {
        this.homeWorks.add(homeWork);
        HomeWorkPage.getInstance().homeWorkPanel.add(homeWork);
        this.homeWorksPanel.add(homeWork.homeWorkIcon);
    }

}
