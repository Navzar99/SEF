package login;

public class Credentials {
    private String username;
    private String password;
    private int type;   // 0 - guest, 1 - user, 2 - admin

    public Credentials(String user, String pwd, int t)
    {
        this.username = user;
        this.password = pwd;

        if(t < 0 || t > 2)
            this.type = 0;
        else
            this.type = t;
    }

    public Credentials(String user, String pwd)
    {
        this.username = user;
        this.password = pwd;
        this.type = 0;
    }

    public Credentials()
    {
        this.username = "";
        this.password = "";
        this.type = 0;
    }

    public void setUsername(String user)
    {
        this.username = user;
    }

    public void setPassword(String pwd)
    {
        this.password = pwd;
    }

    public void setType(int t)
    {
        this.type = t;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public int getType()
    {
        return this.type;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Credentials))
        {
            return false;
        }
        Credentials cred = (Credentials)obj;

        if(cred.getUsername().equals(this.username) &&
           cred.getPassword().equals(this.password))
            return true;

        return false;
    }

    public String toString()
    {
        String string = "";
        string += "Username: " + this.username + " - Password: " + this.password + " - Type: ";
        if(this.type == 2)
            string += "Admin";
        else if(this.type == 1)
            string += "User";
        else
            string += "Guest";

        return string;
    }
}
