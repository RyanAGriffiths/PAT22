/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryang
 */
public class UserManager
{

    ArrayList<User> users = new ArrayList<>();

    public UserManager()
    {
        try
        {
            DB db = new DB();
            ResultSet rs = db.query("SELECT * FROM tblusers;");
            while (rs.next())
            {
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                users.add(new User(id, username, password));
                System.out.println(users.toString());
            }
        } catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int registerUser(String username, String password)
    {
        try
        {
            int c = users.size() + 1;
            DB db = new DB();
            db.update("INSERT INTO ryangDB.tblusers (`userID`, `Username`, `Password`)" + "\n " + " VALUES (" + c + ", " + username + ", " + password + ");");
            return c;
        } catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean doesUserExist(String username)
    {
        boolean out = false;
        for (int i = 0; i < users.size(); i++)
        {
            User u = users.get(i);
            if (u.getUsername().compareTo(username) != 0)
            {
                out = false;
            } else
            {
                out = true;
                break;
            }
        }
        return out;
    }

}
