package Clock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockCountdown extends JPanel {
    private static ClockCountdown instance;
    private int hours = 23;
    private int minutes = 59;
    private int seconds = 59;
    private Timer timer;

    private JLabel clockLabel;

    public ClockCountdown() {
        clockLabel = new JLabel(String.format("%02d:%02d:%02d", hours, minutes, seconds));
        add(clockLabel);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds == 0) {
                    if (minutes == 0) {
                        if (hours == 0) {
                            timer.stop();
                            return;
                        }
                        hours--;
                        minutes = 59;
                    } else {
                        minutes--;
                    }
                    seconds = 59;
                } else {
                    seconds--;
                }

                clockLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            }
        });

        timer.start();
    }

    public static ClockCountdown getInstance() {
        if (instance == null) {
            instance = new ClockCountdown();
        }
        return instance;
    }

    /*
     * SwingUtilities.invokeLater(new Runnable() {
     * 
     * @Override
     * public void run() {
     * new Main().setVisible(true);
     * }
     * });
     */

}
