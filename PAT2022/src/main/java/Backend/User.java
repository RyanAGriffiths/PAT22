/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


/**
 *
 * @author Ryang
 */
public class User
{
    private int ID;
    private String username;
    private String password;

    public User(int ID, String username, String password)
    {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
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

    @Override
    public String toString()
    {
        return "User{" + "ID=" + ID + ", username=" + username + ", password=" + password + '}';
    }
}
