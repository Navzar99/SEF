package login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginScreen extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user, password, errorMessage;
    JTextField userText;
    JPasswordField passwordText;
    JButton submit;

    ArrayList<Credentials> credentials;
    private int accountType = 0;

    public int getAccountType()
    {
        return this.accountType;
    }

    private int getFileLineNumber(File file)    throws FileNotFoundException
    {
        Scanner scan = new Scanner(file);
        int nr = 0;
        while(scan.hasNextLine())
        {
            scan.nextLine();    // consume line
            nr++;
        }

        scan.close();
        return nr;
    }

    private void readCredentialFile() {
        try
        {
            File credFile = new File("passwords.txt");
            Scanner scan = new Scanner(credFile);
            int credNumber = getFileLineNumber(credFile) / 2;  // each credential has 2 lines (user, pwd)
            credentials = new ArrayList<Credentials>(credNumber);
            Credentials newCredential;

            while(scan.hasNextLine())
            {
                newCredential = new Credentials();
                newCredential.setUsername(scan.nextLine());
                newCredential.setPassword(scan.nextLine());
                String typeStr = scan.nextLine();
                int typeInt = Integer.parseInt(typeStr);
                newCredential.setType(typeInt);
                credentials.add(newCredential);
            }
            System.out.println(credentials);

            scan.close();
        } catch(FileNotFoundException e)
        {
            System.out.println("Could not open file\n");
        }
    }

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

        readCredentialFile();
    }
    public static void main(String[] args) {
        new LoginScreen();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String user = userText.getText();
        String pwd = passwordText.getText();

        if(user.equals("") && pwd.equals(""))
        {
            // guest user
            accountType = 0;
            return;
        }

        Credentials inputCredential = new Credentials(user, pwd);
        Credentials matchingCredential = new Credentials();
        boolean foundMatch = false;
        for (Credentials aux : credentials)
        {
            if(inputCredential.equals(aux))
            {
                foundMatch = true;
                matchingCredential = aux;
                break;
            }
        }
        if(foundMatch)
        {
            accountType = matchingCredential.getType();
        }
        else
        {
            errorMessage.setText("Invalid username or password");
        }
    }
}