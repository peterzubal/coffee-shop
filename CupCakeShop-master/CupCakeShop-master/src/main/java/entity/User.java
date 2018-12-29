package entity;

public class User
{

    private String username;
    private String password;
    private int balance;
    private boolean admin;

    public User()
    {
    }

    public User(String username, String password, boolean admin)
    {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }
    
    
    public User(String username, String password, int balance, boolean admin)
    {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.admin = admin;
    }

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isAdmin()
    {
        return admin;
    }

    public void setAdmin(boolean admin)
    {
        this.admin = admin;
    }


}
