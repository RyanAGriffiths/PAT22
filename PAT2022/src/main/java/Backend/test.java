/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ryang
 */
public class test
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        DB db = new DB();
        
        String userQuery = "SELECT * FROM ryangDB.tblusers;";
        ResultSet rs = db.query(userQuery);
        
        while(rs.next()){
            int id = rs.getInt("userID");
            String username = rs.getString(2);
            String password = rs.getString(3);
            
            User u = new User(id, username, password);
            System.out.println(u.toString());
        }
        
        String countQuery = "SELECT COUNT(*) FROM ryangDB.tblusers;";
        ResultSet rs2 = db.query(countQuery);
        rs2.next();
        int userCount = rs2.getInt(1);
        
        System.out.println("Num users: " + userCount);
        
        
        ExerciseManager em = new ExerciseManager();
        System.out.println(em.toString());
    }
}
