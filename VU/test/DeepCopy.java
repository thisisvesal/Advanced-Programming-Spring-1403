import javax.swing.*;

public class DeepCopy {
    private static void copyComponents(Container original, Container copy) {
        for (Component component : original.getComponents()) {
            if (component instanceof JPanel) {
                JPanel originalPanel = (JPanel) component;
                JPanel copiedPanel = deepCopyPanel(originalPanel);
                copy.add(copiedPanel);
            } else if (component instanceof JLabel) {
                JLabel originalLabel = (JLabel) component;
                JLabel copiedLabel = new JLabel(originalLabel.getText());
                copyProperties(originalLabel, copiedLabel);
                copy.add(copiedLabel);
            } else if (component instanceof JButton) {
                JButton originalButton = (JButton) component;
                JButton copiedButton = new JButton(originalButton.getText());
                copyProperties(originalButton, copiedButton);
                copy.add(copiedButton);
            } else if () {
            }
        }
    }
}