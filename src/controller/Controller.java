package controller;
import login.*;

import java.util.concurrent.TimeUnit;

public class Controller {
    public static void main(String args[])
    {
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

    }
}
