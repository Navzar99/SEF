import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class LoginScreen extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user, password, errorMessage;
    JTextField userText;
    JPasswordField passwordText;
    JButton submit, cancel;
    LoginScreen() {
        // Username Label
        user = new JLabel();
        user.setText("User Name :");
        userText = new JTextField();
        // Password Label
        password = new JLabel();
        password.setText("Password :");
        passwordText = new JPasswordField();
        // Submit
        submit = new JButton("SUBMIT");
        panel = new JPanel(new GridLayout(3, 2));
        panel.add(user);
        panel.add(userText);
        panel.add(password);
        panel.add(passwordText);
        errorMessage = new JLabel();
        panel.add(errorMessage);
        panel.add(submit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Login");
        setSize(450,350);
        setVisible(true);
    }
    public static void main(String[] args) {
        new LoginScreen();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String userName = userText.getText();
        char[] password = passwordText.getPassword();
        char[] testPassword = {'a', 'd', 'm', 'i', 'n'};
        if (userName.trim().equals("admin") && Arrays.equals(password, testPassword)) {
            errorMessage.setText(" Hello " + userName + "");
        } else {
            errorMessage.setText(" Invalid user.. ");
        }
    }
}