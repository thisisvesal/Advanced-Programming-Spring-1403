package Questions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Frames.*;

import Graphics.ButtonLayout;
import People.Person;
import People.Professor;

public class Home extends GeneralPage {
    // To be added from left to right
    public final JPanel classList = new JPanel();
    public final JPanel taskPanel = new JPanel();
    public final GridBagConstraints constraints = new GridBagConstraints();

    public Home(Person person) {
        super();
        classList.setBackground(MainFrame.themeColor);
        classList.setPreferredSize(new Dimension(470, 790));
        classList.setLayout(new ButtonLayout(ButtonLayout.Alignment.VERTICAL, ButtonLayout.Anchor.LEADING));

        classList.add(new JLabel("CLASS LIST"));

        taskPanel.setBackground(MainFrame.themeColor);
        taskPanel.setPreferredSize(new Dimension(470, 790));

        this.setLayout(new FlowLayout(FlowLayout.LEADING));

        this.add(classList);
        this.add(taskPanel);
        this.setBackground(Color.white);

        setUpPageFor(Person.getCurrentUser());
        HomePage.getInstance().add(this);
    }

    public void setUpPageFor(Person person) {
        setUpGeneralPanelFor(person);
        if (person instanceof Professor) {
            JLabel addCourseLabel = new JLabel(new ImageIcon("icons/add.png"));
            addCourseLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    // Add course
                    // Create a JDialog
                    JDialog dialog = new JDialog();
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    dialog.setLocationRelativeTo(null);
                    dialog.setSize(300, 150);
                    dialog.setLayout(new FlowLayout());

                    // Create a JTextField
                    JTextField textField = new JTextField(20);
                    dialog.add(textField);

                    // Create a JButton
                    JButton submitButton = new JButton("Submit");
                    submitButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Store the input in a String variable
                            String coursename = textField.getText();
                            Course newCourse = new Course(coursename);
                            CoursePage.getInstance().addCourse(newCourse);
                            JButton courseButton = new JButton(coursename);
                            courseButton.setBackground(Color.white);
                            courseButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    newCourse.refresh();
                                    HomePage.getInstance().setVisible(false);
                                    CoursePage.getInstance().setCurrentVisibleCourse(newCourse);
                                    CoursePage.getInstance().setVisible(true);
                                }
                            });
                            person.classList.add(courseButton);
                            classList.add(courseButton);
                            dialog.dispose();
                        }
                    });
                    dialog.add(submitButton);
                    dialog.setIconImage(new ImageIcon("icons/appIcon.png").getImage());

                    // Display the dialog
                    dialog.setVisible(true);
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
            classList.add(addCourseLabel);
        }
        // TODO: remove the sample taskbox, add an actual mechanism
        // sample checkbox:
        // person.taskBoxes.add(new JCheckBox("Your task"));
        for (JCheckBox taskBox : person.taskBoxes) {
            taskBox.setFocusable(false);
            taskBox.setBackground(Color.white);
            taskBox.setOpaque(true);
            taskBox.setIcon(new ImageIcon("icons/checkboxes/unchecked.png"));
            taskBox.setSelectedIcon(new ImageIcon("icons/checkboxes/checked.png"));
            taskBox.setFont(new Font(getFont().getName(), Font.PLAIN, 20));
            taskPanel.add(taskBox);
        }
        for (JButton button : person.classList) {
            button.setBackground(Color.white);
            button.setFocusable(false);
            classList.add(button);
        }
    }
}