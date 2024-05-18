package Questions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import Frames.CoursePage;
import Frames.ExamPage;
import Frames.HomeWorkPage;
import Graphics.PlaceholderTextField;
import People.Person;
import People.Professor;
import People.Student;

public class Course extends JPanel {
    private Course currentObject = this;
    public final ArrayList<Student> students = new ArrayList<>();
    public final ArrayList<HomeWork> homeWorks = new ArrayList<>();
    public final ArrayList<Exam> exams = new ArrayList<>();
    private PlaceholderTextField field = new PlaceholderTextField();
    JLabel CourseNameLabel;
    JPanel announcementPanel = new JPanel();
    public JPanel courseMaterialPanel, homeWorksPanel, examsPanel, courseNamePanel;
    public JLabel lesson;
    private boolean isAnnouncementFieldVisible;
    {
        field.setPreferredSize(new Dimension(600, 80));
        field.setPlaceholder("announcement");
        field.setForeground(Color.BLACK);
        field.setBackground(Color.WHITE);
        field.setCaretColor(Color.BLACK);
    }

    public Course(String name) {
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setPreferredSize(new Dimension(940, 790));

        courseNamePanel = new JPanel();
        courseNamePanel.setBackground(new Color(235, 234, 171));
        courseNamePanel.setPreferredSize(new Dimension(920, 42));
        courseNamePanel.setLayout(new BorderLayout());

        CourseNameLabel = new JLabel();
        CourseNameLabel.setText(name);
        courseNamePanel.add(CourseNameLabel, BorderLayout.CENTER);
        this.add(courseNamePanel);

        courseMaterialPanel = new JPanel();
        courseMaterialPanel.setBackground(new Color(169, 239, 242));
        courseMaterialPanel.setPreferredSize(new Dimension(920, 150));
        courseMaterialPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(courseMaterialPanel);

        JLabel Lesson = new JLabel();
        Lesson.setText("   Lessons");
        courseMaterialPanel.add(Lesson);

        homeWorksPanel = new JPanel();
        homeWorksPanel.setBackground(new Color(235, 234, 171));
        homeWorksPanel.setPreferredSize(new Dimension(920, 270));
        homeWorksPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(homeWorksPanel);

        JLabel exercises = new JLabel();
        exercises.setText("   Homeworks");
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
        examLabel.setText("   Exams");
        examsPanel.add(examLabel);

        for (Exam exam : exams) {
            examsPanel.add(exam.examIcon);
        }

        // CoursePage coursePage = CoursePage.getInstance();
        // coursePage.addCourse(this);

        if (Person.getCurrentUser() instanceof Professor) {
            courseMaterialPanel.setPreferredSize(new Dimension(920, 170));
            homeWorksPanel.setPreferredSize(new Dimension(920, 170));
            examsPanel.setPreferredSize(new Dimension(920, 170));
            announcementPanel.setBackground(new Color(235, 234, 171));
            announcementPanel.setPreferredSize(new Dimension(920, 170));
            announcementPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            this.add(announcementPanel);
            arrangePageForProffesor();
        }
        Lesson = new JLabel();
        Lesson.setIcon(new ImageIcon("icons/video.png"));
        courseMaterialPanel.add(Lesson);
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

    public void arrangePageForProffesor() {
        JPopupMenu popupMenu = new JPopupMenu();
        ArrayList<JMenuItem> menuItems = setMenuItem();
        // menuItems.add(new JMenuItem("somethin"));
        for (JMenuItem menuItem : menuItems) {
            popupMenu.add(menuItem);
        }

        JButton addStudents = new JButton();
        addStudents.setBounds(2, 205, 150, 50);
        addStudents.setText("Add Student");
        addStudents.setFocusable(false);
        addStudents.setBackground(Color.white);
        addStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(addStudents, 0, addStudents.getHeight());
            }
        });
        courseNamePanel.add(addStudents, BorderLayout.EAST);

        JLabel addHomeworkLabel = new JLabel();
        addHomeworkLabel.setIcon(new ImageIcon("icons/add.png"));
        this.homeWorksPanel.add(addHomeworkLabel);

        JLabel addExamLabel = new JLabel();
        addExamLabel.setIcon(new ImageIcon("icons/add.png"));
        this.examsPanel.add(addExamLabel);

        JLabel addLessonLabel = new JLabel();
        addLessonLabel.setIcon(new ImageIcon("icons/add.png"));
        this.courseMaterialPanel.add(addLessonLabel);

        JLabel announcementLabel = new JLabel();
        announcementLabel.setText("   Announcements");
        announcementPanel.add(announcementLabel);

        JLabel addAnnouncementLabel = new JLabel();
        addAnnouncementLabel.setIcon(new ImageIcon("icons/add.png"));
        this.announcementPanel.add(addAnnouncementLabel);

        addHomeworkLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                CoursePage.getInstance().setVisible(false);
                HomeWork homeWork = new HomeWork(currentObject);
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

        JLabel box = new JLabel();
        box.setPreferredSize(new Dimension(500, 20));
        JButton submit = new JButton();
        submit.setText("submit");
        submit.setBackground(Color.white);
        submit.setFocusable(false);
        submit.setPreferredSize(new Dimension(100, 40));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ProfessorCourse.super.addAnnouncement(field.getText());
            }
        });
        announcementPanel.add(field);
        announcementPanel.add(box);
        announcementPanel.add(submit);
        field.setVisible(false);
        submit.setVisible(false);

        addHomeworkLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                // TODO
                // HomeWorkPage.getInstance().setVisible(true);
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

        addAnnouncementLabel.addMouseListener(new MouseAdapter() {
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

    private ArrayList<JMenuItem> setMenuItem() {
        ArrayList<JMenuItem> menuItems = new ArrayList<>();
        int counter = 0;
        for (Person person : Person.people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                menuItems.add(new JMenuItem(person.getID()));
                menuItems.get(counter).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        students.add(student);
                        student.classList.add(new JButton(CourseNameLabel.getText()));
                    }
                });
                counter++;
            }
        }

        return menuItems;
    }

}
