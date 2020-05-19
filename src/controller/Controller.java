package controller;
import login.*;

import java.util.concurrent.TimeUnit;

public class Controller
{
    Login account;

    private void printHelp()
    {
        System.out.print("You are logged in with an account of type: ");
        if(account.isAdmin())
        {
            System.out.println("admin");
        }
        if(account.isUser())
        {
            System.out.println("user");
        }
        if(account.isGuest())
        {
            System.out.println("guest");
        }

        System.out.println("If you need help, type 'help'");
    }

    public static void clearScreen()
    {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        printHelp();
    }

    private void readCommand()
    {

    }

    public static void main(String args[])
    {
        Controller controller = new Controller;
        Login account = new Login();
        while(account.isLoggedIn() == false)
        {
            // wait for loggin credentials
            try
            {
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
                System.out.println("Error occured");
            }
        }

        System.in.read(new byte[System.in.available()]);    // read any remaining data from terminal
        clearScreen();



    }
}
