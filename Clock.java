import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Clock {

    private static final int DEFAULT_TIMER_DELAY_MS = 300; // tick delay

    private final JFrame frame;
    private final JLabel label;
    private final ClockDisplay clock;      // internal 24-hour model
    private final Timer swingTimer;
    private boolean use12HourFormat = false; // GUI format flag

    public Clock() {
        clock = new ClockDisplay();
        frame = new JFrame("Clock");
        label = new JLabel(clock.getTime(), SwingConstants.CENTER);

        // Swing timer runs on EDT and advances the model one minute per tick
        swingTimer = new Timer(DEFAULT_TIMER_DELAY_MS, e -> {
            clock.timeTick();
            updateLabel();
        });
        swingTimer.setRepeats(true);

        makeFrame();
    }

    /* ----------------- Actions ----------------- */

    private void start() {
        if (!swingTimer.isRunning()) {
            swingTimer.start();
        }
    }

    private void stop() {
        if (swingTimer.isRunning()) {
            swingTimer.stop();
        }
    }

    private void step() {
        clock.timeTick();
        updateLabel();
    }

    /**
     * Update the label text according to the chosen display format.
     * Does not modify the underlying clock model.
     */
    private void updateLabel() {
        String time24 = clock.getTime(); // "HH:MM"
        if (!use12HourFormat) {
            label.setText(time24);
            return;
        }

        // convert HH:MM -> h:MM AM/PM
        try {
            String hh = time24.substring(0, 2);
            String mm = time24.substring(3, 5);
            int hour = Integer.parseInt(hh);
            int minute = Integer.parseInt(mm);

            String period = (hour < 12) ? "AM" : "PM";
            int hour12 = hour % 12;
            if (hour12 == 0) hour12 = 12;

            // show hour without leading zero, minutes 2-digits, then AM/PM
            String text = String.format("%d:%02d %s", hour12, minute, period);
            label.setText(text);
        } catch (Exception ex) {
            // fallback to 24-hour string if parsing fails for any reason
            label.setText(time24);
        }
    }

    private void showAbout() {
        JOptionPane.showMessageDialog(
            frame,
            "Clock Version 1.0\nA simple interface for the 'Objects First' clock display project\n(Display format can be toggled between 24-hour and 12-hour (AM/PM))",
            "About Clock",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void quit() {
        if (swingTimer.isRunning()) swingTimer.stop();
        frame.dispose();
        System.exit(0);
    }

    /* ----------------- UI Construction ----------------- */

    private void makeFrame() {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(10, 60, 10, 60));
        contentPane.setLayout(new BorderLayout(12, 12));

        // Label formatting
        Font displayFont = label.getFont().deriveFont(96.0f);
        label.setFont(displayFont);
        contentPane.add(label, BorderLayout.CENTER);

        // Toolbar buttons
        JPanel toolbar = new JPanel(new GridLayout(1, 0, 6, 0));
        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> start());
        toolbar.add(startButton);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> stop());
        toolbar.add(stopButton);

        JButton stepButton = new JButton("Step");
        stepButton.addActionListener(e -> step());
        toolbar.add(stepButton);

        JPanel flow = new JPanel();
        flow.add(toolbar);
        contentPane.add(flow, BorderLayout.SOUTH);

        // Menu bar with View -> 12-hour toggle
        makeMenuBar(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 240));
        frame.pack();
        centerFrame(frame);
        frame.setVisible(true);

        // initialize label text
        updateLabel();
    }

    private void makeMenuBar(JFrame frame) {
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // File menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        JMenuItem aboutItem = new JMenuItem("About Clock...");
        aboutItem.addActionListener(e -> showAbout());
        fileMenu.add(aboutItem);

        fileMenu.addSeparator();

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        quitItem.addActionListener(e -> quit());
        fileMenu.add(quitItem);

        // View menu with 12-hour toggle
        JMenu viewMenu = new JMenu("View");
        menubar.add(viewMenu);

        JCheckBoxMenuItem toggle12Hour = new JCheckBoxMenuItem("12-hour (AM/PM)");
        toggle12Hour.addActionListener(e -> {
            use12HourFormat = toggle12Hour.isSelected();
            updateLabel();
        });
        viewMenu.add(toggle12Hour);
    }

    private void centerFrame(Window w) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        w.setLocation(d.width / 2 - w.getWidth() / 2, d.height / 2 - w.getHeight() / 2);
    }

    /* ----------------- Main ----------------- */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Clock());
    }
}