package Questions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Frames.HomeWorkPage;
import Frames.MainFrame;
import Frames.QuestionPage;
import Graphics.PlaceholderTextField;
import People.Person;
import People.Professor;
import People.Student;

public abstract class Question extends JPanel {
    public final JPanel promptPane = new JPanel();
    public final JPanel answerSheet = new JPanel();
    public Question question;
    JLabel prompt;
    public  JPanel questionPanel;
    private static int questionType = 0;

    public Question(String prompt, HomeWork homeWork) {
        setPrompt(prompt);
        this.prompt.setFont(new Font("Tahoma", Font.PLAIN, 30));

        answerSheet.setBackground(Color.white);
        answerSheet.setPreferredSize(new Dimension(300, 150));
        answerSheet.setLayout(new FlowLayout(FlowLayout.LEADING));
        designAnswerSheet();

        promptPane.setBackground(Color.white);
        promptPane.setPreferredSize(new Dimension(300, 150));
        promptPane.setLayout(new FlowLayout(FlowLayout.LEADING));
        promptPane.add(this.prompt);

        this.add(promptPane);
        this.add(answerSheet);


        Question currentObject = this;

        JButton Next = new JButton("Next");
        Next.setPreferredSize(new Dimension(100, 30));
        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (HomeWork.SwCorrection == 1) {
                    Question.makeQuestion(homeWork);
                    homeWork.addQuestion(currentObject);
                    currentObject.remove(Next);
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Student student : homeWork.currentCourse.students){
                    homeWork.homeWorkForStudent.add(MainFrame.deepCopyPanel(QuestionPage.questionPanel));
                }
                homeWork.mainQuestions = MainFrame.deepCopyPanel(QuestionPage.questionPanel);
                QuestionPage.getInstance().setVisible(false);
                MainFrame.getMainFrame().add(HomeWorkPage.getInstance());
                HomeWorkPage.getInstance().setVisible(true);
            }
        });
        this.add(submitButton);
        this.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 20));
        this.setPreferredSize(new Dimension(945, 255));
        this.setBackground(MainFrame.themeColor);
        if (homeWork.questions.size() < 3) {
            this.add(Next);
        }
        else
            this.add(submitButton);
    }

    public Question(HomeWork homeWork) {
        this("", homeWork);
    }

    public Question(String prompt, Exam exam) {
        setPrompt(prompt);
        this.prompt.setFont(new Font("Tahoma", Font.PLAIN, 30));

        answerSheet.setBackground(Color.white);
        answerSheet.setPreferredSize(new Dimension(910, 520));
        designAnswerSheet();

        promptPane.setBackground(Color.white);
        promptPane.setPreferredSize(new Dimension(910, 170));
        promptPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        promptPane.add(this.prompt);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
        this.setPreferredSize(new Dimension(945, 780));
        this.setBackground(MainFrame.themeColor);
        this.add(promptPane);
        this.add(answerSheet);
    }

    public Question(Exam exam) {
        this("", exam);
    }

    public abstract void designAnswerSheet();

    public void setPrompt(String prompt) {
        this.prompt = new JLabel(prompt);
    }

    public static void makeQuestion(HomeWork currentHomeWork) {
        // if (currentHomeWork.questions.isEmpty()) {
        if (Person.getCurrentUser() instanceof Professor) {
            JDialog dialog = new JDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setLocationRelativeTo(null);
            dialog.setSize(300, 150);
            dialog.setLayout(new FlowLayout());

            // Create a PlaceholderTextField
            PlaceholderTextField textField = new PlaceholderTextField(20);
            textField.setPlaceholder("Enter question...");
            dialog.add(textField);

            JRadioButton LongAnswer = new JRadioButton("LongAnswer");
            LongAnswer.setFont(new Font("Arial", Font.PLAIN, 15));
            LongAnswer.setBounds(110, 560, 100, 20);

            JRadioButton MultipleChoice = new JRadioButton("MultipleChoice");
            MultipleChoice.setFont(new Font("Arial", Font.PLAIN, 15));
            MultipleChoice.setBounds(210, 560, 100, 20);

            ButtonGroup group = new ButtonGroup();
            group.add(LongAnswer);
            group.add(MultipleChoice);

            MultipleChoice.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    questionType = 1;
                }
            });

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                    // Store the input in a String variable
                    String prompt = textField.getText();
                    if (questionType == 0) {
                        LongAnswer longAnswer = new LongAnswer(prompt, currentHomeWork);
                        longAnswer.setPrompt(prompt);
                        currentHomeWork.addQuestion(longAnswer);
                    } else if (questionType == 1) {
                        questionType = 0;
                        MultipleChoice multi = new MultipleChoice(prompt, currentHomeWork);
                        multi.setPrompt(prompt);
                        currentHomeWork.addQuestion(multi);
                        JDialog optionDialog = new JDialog();
                        optionDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        optionDialog.setLocationRelativeTo(null);
                        optionDialog.setSize(300, 400);
                        optionDialog.setLayout(new FlowLayout());

                        // Create a PlaceholderTextField
                        PlaceholderTextField option1 = new PlaceholderTextField(20);
                        option1.setPlaceholder("option1...");
                        optionDialog.add(option1);

                        PlaceholderTextField option2 = new PlaceholderTextField(20);
                        option2.setPlaceholder("option2...");
                        optionDialog.add(option2);

                        PlaceholderTextField option3 = new PlaceholderTextField(20);
                        option3.setPlaceholder("option3...");
                        optionDialog.add(option3);

                        PlaceholderTextField option4 = new PlaceholderTextField(20);
                        option4.setPlaceholder("option4...");
                        optionDialog.add(option4);

                        JButton submitOptions = new JButton("submit");
                        submitOptions.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                optionDialog.dispose();

                                if (option1 != null)
                                    multi.addOption(option1.getText());
                                if (option2 != null)
                                    multi.addOption(option2.getText());
                                if (option3 != null)
                                    multi.addOption(option3.getText());
                                if (option4 != null)
                                    multi.addOption(option4.getText());
                            }
                        });
                        optionDialog.add(submitOptions);
                        optionDialog.setVisible(true);

                    }

                }
            });

            dialog.add(LongAnswer);
            dialog.add(MultipleChoice);
            dialog.add(submitButton);
            dialog.setVisible(true);
        }

    }
}