import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageViewer {
    JFrame frame;
    JLabel imageLabel;
    public static void main(String[] args) {
        ImageViewer viewer = new ImageViewer();
        viewer.go();
    }
    
    public void go() {
        frame = new JFrame("Simple Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem menuOpen = new JMenuItem("Open Image");
        menuOpen.addActionListener(new OpenImageListener());
        menuFile.add(menuOpen);
        menuBar.add(menuFile);
        frame.setJMenuBar(menuBar);
        imageLabel = new JLabel("Tidak ada gambar", SwingConstants.CENTER);
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
    
    public class OpenImageListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image Files", "jpg", "png", "gif", "jpeg");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                ImageIcon icon = new ImageIcon(file.getPath());
                imageLabel.setText("");
                imageLabel.setIcon(icon);
            }
        }
    }
}
