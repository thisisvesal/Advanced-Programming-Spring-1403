package Questions;

import Clock.ClockCountdown;
import FileHandling.SerializableActionListener;
import FileHandling.SerializableMouseAdapter;
import Frames.*;
import People.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import Graphics.PlaceholderTextField;
import People.Professor;
import People.Student;

public class HomeWork extends JPanel {
    public final ArrayList<Question> questions = new ArrayList<>();
    public ArrayList<JPanel> homeWorkForStudent = new ArrayList<>();
    private JPanel homeWorkStatus, deadLine, scoreStatus, courseName;
    public JLabel homeWorkIcon, status, score, Name;
    public Object[][] answers = new Object[60][];
    public JPopupMenu popupMenu = new JPopupMenu();
    public JPanel panel;
    private HomeWork currentObject;
    public static int SwCorrection = 1;
    public String StudentScore;
    public Course currentCourse;
    public JPanel mainQuestions;

    public HomeWork(Course course) {
        currentCourse = course;
        this.setPreferredSize(new Dimension(940, 790));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(MainFrame.themeColor);
        this.setOpaque(true);

        this.homeWorkIcon = new JLabel();
        this.homeWorkIcon.setIcon(new ImageIcon("src/icons/homework.png"));
        this.homeWorkIcon.addMouseListener(new SerializableMouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("\n\nCURRENT PERSON: ");
                if (Person.getCurrentUser() instanceof Professor) {
                    arrangePageForProffesor();
                    System.out.println("PROFESSOR\n\n");
                } else {
                    arrangePageForStudent(Person.getCurrentUser().getID());
                    System.out.println("STUDENT\n\n");
                }

                MainFrame.getMainFrame().coursePage.setVisible(false);
                HomeWorkPage.getInstance().addHomeWork(HomeWork.this);
                MainFrame.getMainFrame().homeWorkPage.setVisible(true);
            }
        });
        courseName = new JPanel();
        courseName.setBackground(new Color(235, 234, 171));
        courseName.setPreferredSize(new Dimension(940, 42));

        Name = new JLabel();
        Name.setText("CourseName");
        courseName.add(Name);
        this.add(courseName);

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        panel.setPreferredSize(new Dimension(940, 790));
        panel.setBackground(MainFrame.themeColor);
        currentObject = this;

        course.addHomeWork(this);
        this.add(panel);
    }

    public void addQuestion(Question question) {
        questions.add(question);
        QuestionPage.getInstance().addQuestion(question);
    }

    private ArrayList<JMenuItem> setMenuItem() {
        ArrayList<JMenuItem> menuItems = new ArrayList<>();
        int counter = 0;
        for (Person person : Person.people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                menuItems.add(new JMenuItem(person.getID()));
                menuItems.get(counter).addActionListener(new SerializableActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SwCorrection = 0;
                        HomeWorkPage.getInstance().setVisible(false);
                        MainFrame.getMainFrame().add(QuestionPage.getInstance());

                        JDialog dialog = new JDialog();
                        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        dialog.setLocationRelativeTo(null);
                        dialog.setSize(300, 150);
                        dialog.setLayout(new FlowLayout());

                        // Create a PlaceholderTextField
                        PlaceholderTextField textField = new PlaceholderTextField(20);
                        textField.setPlaceholder("Enter Score...");
                        dialog.add(textField);
                        JButton submitButton = new JButton("Submit");
                        submitButton.addActionListener(new SerializableActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO courses.get i should only get index 0, the for loop is basically
                                // redundant and was only desiged to throw an exception
                                // if you believe :))
                                try {
                                    for (int i = 0; i < student.courses.size() + 1; i++) {
                                        if (i >= student.courses.size()) {
                                            throw new IndexOutOfBoundsException();
                                        }
                                        student.courses.get(i).homeWorks.get(i).StudentScore = textField.getText();
                                        dialog.dispose();
                                    }
                                } catch (IndexOutOfBoundsException exception) {
                                    System.out.println(exception.getMessage());
                                    exception.printStackTrace();

                                }
                            }
                        });
                        dialog.add(submitButton);
                        QuestionPage.getInstance().setVisible(true);
                        dialog.setVisible(true);
                    }
                });
                counter++;
            }
        }

        return menuItems;
    }

    public void arrangePageForProffesor() {
        panel.removeAll();
        JButton viewQuestionsButton = new JButton("View questions");
        viewQuestionsButton.setFocusable(false);
        viewQuestionsButton.setBackground(Color.white);
        viewQuestionsButton.addActionListener(new SerializableActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainQuestions != null) {
                    QuestionPage.questionPanel.removeAll();
                    QuestionPage.questionPanel.add(mainQuestions);
                }
                System.out.println("PROFESSOR HERE");
                SwCorrection = 1;
                Question.makeQuestion(currentObject);
                HomeWorkPage.getInstance().setVisible(false);
                MainFrame.getMainFrame().add(QuestionPage.getInstance());

                QuestionPage.getInstance().setVisible(true);
            }
        });
        panel.add(viewQuestionsButton, BorderLayout.CENTER);

        popupMenu.removeAll();
        ArrayList<JMenuItem> menuItems = setMenuItem();
        for (JMenuItem menuItem : menuItems) {
            popupMenu.add(menuItem);
        }

        JButton Correction = new JButton();
        Correction.setBounds(2, 205, 150, 50);
        Correction.setText("Correction");
        Correction.setFocusable(false);
        Correction.setBackground(Color.white);
        Correction.addActionListener(new SerializableActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(Correction, 0, Correction.getHeight());
            }
        });
        panel.add(Correction, BorderLayout.EAST);

        JButton button = new JButton("Set Time");
        button.addActionListener(new SerializableActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                dialog.setLayout(new FlowLayout());

                SpinnerModel hourModel = new SpinnerNumberModel(0, 0, 23, 1);
                SpinnerModel minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
                SpinnerModel secondModel = new SpinnerNumberModel(0, 0, 59, 1);

                JSpinner hourSpinner = new JSpinner(hourModel);
                JSpinner minuteSpinner = new JSpinner(minuteModel);
                JSpinner secondSpinner = new JSpinner(secondModel);

                dialog.add(new JLabel("Hour:"));
                dialog.add(hourSpinner);
                dialog.add(new JLabel("Minute:"));
                dialog.add(minuteSpinner);
                dialog.add(new JLabel("Second:"));
                dialog.add(secondSpinner);

                JButton okButton = new JButton("OK");
                okButton.addActionListener(new SerializableActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ClockCountdown.hours = (int) hourSpinner.getValue();
                        ClockCountdown.minutes = (int) minuteSpinner.getValue();
                        ClockCountdown.seconds = (int) secondSpinner.getValue();
                        // System.out.println("Selected time: " + hour + ":" + minute + ":" + second );
                        dialog.dispose();
                    }
                });

                dialog.add(okButton);

                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });

        panel.add(button);
    }

    public void arrangePageForStudent(String ID) {
        panel.removeAll();

        JPanel box = new JPanel();
        box.setPreferredSize(new Dimension(600, 50));
        box.setOpaque(false);
        panel.add(box);

        homeWorkStatus = new JPanel();
        homeWorkStatus.setPreferredSize(new Dimension(600, 50));
        homeWorkStatus.setLayout(new FlowLayout(FlowLayout.LEFT));

        status = new JLabel();
        if (StudentScore == null)
            status.setText("Status: Not loaded");
        else
            status.setText("Status: loaded");
        homeWorkStatus.add(status);
        panel.add(homeWorkStatus);

        scoreStatus = new JPanel();
        scoreStatus.setPreferredSize(new Dimension(600, 50));
        scoreStatus.setLayout(new FlowLayout(FlowLayout.LEFT));

        score = new JLabel();

        if (StudentScore == null)
            StudentScore = "Not graded yet";
        score.setText("Score:" + StudentScore);
        scoreStatus.add(score);
        panel.add(scoreStatus);

        deadLine = new JPanel();
        deadLine.setPreferredSize(new Dimension(600, 50));
        deadLine.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel time = new JLabel();
        time.setText("Remaining time : ");
        deadLine.add(time);

        deadLine.add(ClockCountdown.getInstance());
        panel.add(deadLine);

        box = new JPanel();
        box.setPreferredSize(new Dimension(600, 60));
        box.setOpaque(false);
        panel.add(box);

        for (Question question : questions) {
            QuestionPage.getInstance().addQuestion(question);
        }

        currentObject = this;

        JButton viewQuestionsButton = new JButton("View questions");
        viewQuestionsButton.setFocusable(false);
        viewQuestionsButton.setBackground(Color.white);
        viewQuestionsButton.addActionListener(new SerializableActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Student student : currentCourse.students) {
                    if (student.getID().equals(ID)) {
                        QuestionPage.questionPanel.removeAll();
                        QuestionPage.questionPanel.add(homeWorkForStudent.get(currentCourse.students.indexOf(student)));
                    }
                }
                System.out.println("STUDENT HERE");
                Question.makeQuestion(currentObject);
                SwCorrection = 1;
                HomeWorkPage.getInstance().setVisible(false);
                MainFrame.getMainFrame().add(QuestionPage.getInstance());
                QuestionPage.getInstance().setVisible(true);
            }
        });
        panel.add(viewQuestionsButton, BorderLayout.CENTER);

    }
}