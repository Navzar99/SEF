package login;

public class Credentials {
    private String username;
    private String password;

    public Credentials(String user, String pwd)
    {
        this.username = user;
        this.password = pwd;
    }

    public Credentials()
    {
        this.username = "";
        this.password = "";
    }

    public void setUsername(String user)
    {
        this.username = user;
    }

    public void setPassword(String pwd)
    {
        this.password = pwd;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
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
        string += "Username: " + this.username + " - Password: " + this.password;
        return string;
    }
}
