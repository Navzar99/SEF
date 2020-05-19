/****************************************************************************
 * Once instantiated, login must be completed                               *
 *                                                                          *
 * To check situation of the logged in account, use following methods:      *
 * int getAccountType()                                                     *
 * boolean isGuest()                                                        *
 * boolean isUser()                                                         *
 * boolean isAdmin()                                                        *
 *                                                                          *
 * To check if logged in, use the following method:                         *
 * boolean isLoggedIn()                                                     *
 ****************************************************************************/

package login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user, password, errorMessage;
    JTextField userText;
    JPasswordField passwordText;
    JButton submit;

    ArrayList<Credentials> credentials;
    private int accountType = 0;
    private boolean loggedIn = false;

    public boolean isLoggedIn()
    {
        if(loggedIn)
            return true;
        else
            return false;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public boolean isGuest() {
        if (this.accountType == 0)
            return true;
        else
            return false;
    }

    public boolean isUser() {
        if (this.accountType == 1)
            return true;
        else
            return false;
    }

    public boolean isAdmin() {
        if (this.accountType == 2)
            return true;
        else
            return false;
    }

    private int getFileLineNumber(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        int nr = 0;
        while (scan.hasNextLine()) {
            scan.nextLine();    // consume line
            nr++;
        }

        scan.close();
        return nr;
    }

    private void readCredentialFile() {
        try {
            File credFile = new File("passwords.txt");
            Scanner scan = new Scanner(credFile);
            int credNumber = getFileLineNumber(credFile) / 2;  // each credential has 2 lines (user, pwd)
            credentials = new ArrayList<Credentials>(credNumber);
            Credentials newCredential;

            while (scan.hasNextLine()) {
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
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file\n");
        }
    }

    Login() {
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
        setSize(450, 350);
        setVisible(true);

        readCredentialFile();
    }

    public static String byteArrayToHexString(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }

    private String sha256(String string)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] byteHash = md.digest(string.getBytes(StandardCharsets.UTF_8));

            return byteArrayToHexString(byteHash);
        }catch (NoSuchAlgorithmException e)
        {
            System.out.println("Algorithm does not exist");
            return "";
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String user = userText.getText();
        String pwd = passwordText.getText();

        if(user.equals("") && pwd.equals(""))
        {
            // guest user
            accountType = 0;
            System.out.println("Logged in as guest");
            this.loggedIn = true;
            setVisible(false);
            return;
        }

        String pwdHash = sha256(pwd);

        Credentials inputCredential = new Credentials(user, pwdHash);
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
            this.accountType = matchingCredential.getType();
            this.loggedIn = true;
            //System.out.println("Logged in with type " + this.accountType);

            setVisible(false);
        }
        else
        {
            errorMessage.setText("Invalid username or password");
        }
    }
}