import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    String validUsername = "james3302";
    String validPassword = "pass";
    String msg = " ";
    JTextField txtUsername;
    JPasswordField txtPassword;
    public static void main(String[] args) {
        Login gui = new Login();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame("Aplikasi Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }

    public class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String inputPass = new String(txtPassword.getPassword());
            if (validUsername.equals(txtUsername.getText())) {
                if (validPassword.equals(inputPass)) {
                    msg = "Login Granted!";
                } else {
                    msg = "Login Denied (Wrong Password)";
                }
            } else {
                msg = "Login Denied (User not found)";
            }
            JOptionPane.showMessageDialog(null, msg);
        }
    }

    public class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
    }
}