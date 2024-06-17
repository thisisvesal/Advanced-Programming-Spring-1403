package Questions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import Clock.ClockPane;
import FileHandling.SerializableActionListener;
import FileHandling.SerializableMouseAdapter;
import FileHandling.SerializableMouseListener;
import Frames.*;
import Graphics.PlaceholderTextField;
import People.Person;
import People.Professor;
import People.Student;

public class Course extends JPanel {
    public final ArrayList<Student> students = new ArrayList<>();
    public final ArrayList<HomeWork> homeWorks = new ArrayList<>();
    public final ArrayList<Exam> exams = new ArrayList<>();
    private PlaceholderTextField field = new PlaceholderTextField();
    public final DefaultListModel<String> announcementList = new DefaultListModel<>();
    public final JList<String> AnnouncementPanel = new JList<>(announcementList);
    JLabel CourseNameLabel;
    public final ArrayList<JPanel> mainQuestions = new ArrayList<>();
    public JPanel courseMaterialPanel, homeWorksPanel, examsPanel, courseNamePanel, generalPanel, announcementPanel;
    public JLabel lesson;
    JPanel CoursePanel;
    public int HomeWorkCounter;
    private boolean isAnnouncementFieldVisible;
    {
        field.setPreferredSize(new Dimension(600, 80));
        field.setPlaceholder("announcement");
        field.setForeground(Color.BLACK);
        field.setBackground(Color.WHITE);
        field.setCaretColor(Color.BLACK);
    }
    public JPopupMenu popupMenu = new JPopupMenu();
    Course currentCourse;

    public Course(String name) {
        System.out.println("\nMaking a course");
        this.setPreferredSize(new Dimension(1184, 790));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.WHITE);

        // this.setLayout(new FlowLayout(FlowLayout.CENTER));
        generalPanel = new JPanel();
        generalPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        generalPanel.setPreferredSize(new Dimension(244, 790));
        generalPanel.setBackground(Color.WHITE);
        generalPanel.add(new ClockPane());
        // announcementPanel = new JPanel();
        AnnouncementPanel.setPreferredSize(new Dimension(244, 640));
        AnnouncementPanel.setBackground(MainFrame.themeColor);
        // announcementList.addElement("This is an announcement");

        generalPanel.add(AnnouncementPanel);

        JButton homeButton = new JButton("Home");
        homeButton.setPreferredSize(new Dimension(244, 60));
        homeButton.setFocusable(false);
        homeButton.setBackground(Color.white);
        generalPanel.add(homeButton);

        homeButton.addActionListener(new SerializableActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getMainFrame().coursePage.setVisible(false);
                MainFrame.getMainFrame().homePage.setVisible(true);
            }
        });
        generalPanel.setOpaque(false);
        // generalPanel.setPreferredSize(new Dimension(244, 800));
        this.add(generalPanel);
        CoursePanel = new JPanel();
        CoursePanel.setPreferredSize(new Dimension(930, 790));
        CoursePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        CoursePanel.setBackground(Color.LIGHT_GRAY);
        currentCourse = this;
        CoursePage.getInstance().addCourse(this);
        System.out.println("Course created");
        System.out.println("Course was added to coursepage");
    }

    public void addExam(Exam exam) {
        this.exams.add(exam);
        ExamPage.getInstance().examPanel.add(exam);
        this.examsPanel.add(exam.examIcon);
        System.out.println("An exam was added to course's exampanel");
    }

    public void addHomeWork(HomeWork homeWork) {
        this.homeWorks.add(homeWork);
        HomeWorkPage.getInstance().homeWorkPanel.add(homeWork);
        this.homeWorksPanel.add(homeWork.homeWorkIcon);
        System.out.println("Added a homework to course's homeworkpanel");
    }

    public void CommonDesign() {
        System.out.println("\nDesigning course");
        courseNamePanel = new JPanel();
        courseNamePanel.setBackground(new Color(235, 234, 171));
        courseNamePanel.setPreferredSize(new Dimension(940, 42));
        courseNamePanel.setLayout(new BorderLayout());

        CourseNameLabel = new JLabel();
        CourseNameLabel.setText("CourseName");
        // TODO: Forged..
        CourseNameLabel.setText("Math");
        courseNamePanel.add(CourseNameLabel, BorderLayout.CENTER);
        CoursePanel.add(courseNamePanel);

        courseMaterialPanel = new JPanel();
        courseMaterialPanel.setBackground(new Color(169, 239, 242));
        courseMaterialPanel.setPreferredSize(new Dimension(940, 150));
        courseMaterialPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        CoursePanel.add(courseMaterialPanel);

        JLabel Lesson = new JLabel();
        Lesson.setText("   Lessons");
        courseMaterialPanel.add(Lesson);

        homeWorksPanel = new JPanel();
        homeWorksPanel.setBackground(new Color(235, 234, 171));
        homeWorksPanel.setPreferredSize(new Dimension(940, 270));
        homeWorksPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        CoursePanel.add(homeWorksPanel);

        JLabel exercises = new JLabel();
        exercises.setText("   Homeworks");
        homeWorksPanel.add(exercises);

        for (HomeWork homeWork : homeWorks) {
            homeWorksPanel.add(homeWork.homeWorkIcon);
        }

        examsPanel = new JPanel();
        examsPanel.setBackground(new Color(169, 239, 242));
        examsPanel.setPreferredSize(new Dimension(940, 265));
        examsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        CoursePanel.add(examsPanel);

        JLabel examLabel = new JLabel();
        examLabel.setText("   Exams");
        examsPanel.add(examLabel);

        for (Exam exam : exams) {
            examsPanel.add(exam.examIcon);
        }
        Lesson = new JLabel();
        Lesson.setIcon(new ImageIcon("src/icons/video.png"));
        courseMaterialPanel.add(Lesson);
        this.add(CoursePanel);
        System.out.println("Course design finished");
    }

    public void arrangePageForStudent() {
        CoursePanel.removeAll();
        CommonDesign();
        System.out.println("Course was arranged for student");
    }

    public void arrangePageForProffesor() {
        CoursePanel.removeAll();
        CommonDesign();
        courseMaterialPanel.setPreferredSize(new Dimension(940, 170));
        homeWorksPanel.setPreferredSize(new Dimension(940, 170));
        examsPanel.setPreferredSize(new Dimension(940, 170));
        announcementPanel = new JPanel();
        announcementPanel.setBackground(new Color(235, 234, 171));
        announcementPanel.setPreferredSize(new Dimension(940, 170));
        announcementPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        CoursePanel.add(announcementPanel);

        popupMenu.removeAll();
        ArrayList<JMenuItem> menuItems = setMenuItem();
        for (JMenuItem menuItem : menuItems) {
            popupMenu.add(menuItem);
        }

        JButton addStudents = new JButton();
        addStudents.setBounds(2, 205, 150, 50);
        addStudents.setText("Add Student");
        addStudents.setFocusable(false);
        addStudents.setBackground(Color.white);
        addStudents.addActionListener(new SerializableActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(addStudents, 0, addStudents.getHeight());
            }
        });
        courseNamePanel.add(addStudents, BorderLayout.EAST);

        JLabel addHomeworkLabel = new JLabel();
        addHomeworkLabel.setIcon(new ImageIcon("src/icons/add.png"));
        this.homeWorksPanel.add(addHomeworkLabel);

        JLabel addExamLabel = new JLabel();
        addExamLabel.setIcon(new ImageIcon("src/icons/add.png"));
        this.examsPanel.add(addExamLabel);

        JLabel addLessonLabel = new JLabel();
        addLessonLabel.setIcon(new ImageIcon("src/icons/add.png"));
        this.courseMaterialPanel.add(addLessonLabel);

        JLabel announcementLabel = new JLabel();
        announcementLabel.setText("   Announcements");
        announcementPanel.add(announcementLabel);

        JLabel addAnnouncementLabel = new JLabel();
        addAnnouncementLabel.setIcon(new ImageIcon("src/icons/add.png"));
        this.announcementPanel.add(addAnnouncementLabel);

        JLabel box = new JLabel();
        box.setPreferredSize(new Dimension(500, 20));
        JButton submit = new JButton();
        submit.setText("submit");
        submit.setBackground(Color.white);
        submit.setFocusable(false);
        submit.setPreferredSize(new Dimension(100, 40));
        submit.addActionListener(new SerializableActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // announcements.add(field.getText());
                announcementList.addElement(field.getText());
                field.setText("");
                // ProfessorCourse.super.addAnnouncement(field.getText());
            }
        });
        announcementPanel.add(field);
        announcementPanel.add(box);
        announcementPanel.add(submit);
        field.setVisible(false);
        submit.setVisible(false);

        addHomeworkLabel.addMouseListener(new SerializableMouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                CoursePage.getInstance().setVisible(false);
                HomeWork homeWork = new HomeWork(Course.this);
                // System.out.println("main111="+homeWork.mainQuestions);
                homeWork.arrangePageForProffesor();
                HomeWorkPage.getInstance().addHomeWork(homeWork);
                HomeWorkPage.getInstance().setVisible(true);
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
            }
        });

        addAnnouncementLabel.addMouseListener(new SerializableMouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (!isAnnouncementFieldVisible) {
                    isAnnouncementFieldVisible = true;
                    field.setVisible(true);
                    submit.setVisible(true);
                    return;
                }
                field.setVisible(false);
                submit.setVisible(false);
                isAnnouncementFieldVisible = false;
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
            }
        });

    }

    public void refresh() {
        if (Person.getCurrentUser() instanceof Professor) {
            popupMenu.removeAll();
            ArrayList<JMenuItem> menuItems = setMenuItem();
            for (JMenuItem menuItem : menuItems) {
                popupMenu.add(menuItem);
            }
        }
        System.out.println("Refreshed course");
    }

    private ArrayList<JMenuItem> setMenuItem() {
        System.out.println("\nSetting menu items");
        ArrayList<JMenuItem> menuItems = new ArrayList<>();
        int counter = 0;
        System.out.println("Iterating in people");
        for (Person person : Person.people) {
            if (person instanceof Student) {
                System.out.println("Current person: Student");
                Student student = (Student) person;
                menuItems.add(new JMenuItem(person.getID()));
                System.out.println("Added student id to menu items");
                menuItems.get(counter).addActionListener(new SerializableActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (student.getHome() == null) {
                            student.setHome(new Home(student));
                        }
                        students.add(student);
                        JButton studentClass = new JButton(CourseNameLabel.getText());
                        studentClass.setBackground(Color.white);
                        studentClass.setFocusable(false);
                        studentClass.setVisible(true);
                        studentClass.setOpaque(true);
                        student.classList.add(studentClass);
                        student.getHome().classList.add(studentClass);
                        System.out.println("A course button was added to " + student.getFullName() + "'s classlist at: course, setmenuitem");
                        // int i=0; ////////////////////////////////////////////////////////////////////
                        student.courses.add(currentCourse);
                        System.out.println("PROBLEMATIC: current course added to student courses");

                        System.out.println("Adding an action listener to the new course button");
                        studentClass.addActionListener(new SerializableActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Course newCourse = new Course(CourseNameLabel.getText());
                                System.out.println("A course button was pressed");
                                if (Person.getCurrentUser() instanceof Student) {
                                    arrangePageForStudent();
                                }
                                boolean courseInPage = false;
                                for (Component component : CoursePage.getInstance().getComponents()) {
                                    if (component instanceof Course) {
                                        courseInPage = true;
                                        break;
                                    }
                                }
                                if (!courseInPage) {
                                    CoursePage.getInstance().addCourse(Course.this);
                                }
                                HomePage.getInstance().setVisible(false);
                                CoursePage.getInstance().setVisible(true);
                            }
                        });
                    }
                });
                counter++;
            }
        }

        System.out.println("Menu items set\n");

        return menuItems;
    }

}