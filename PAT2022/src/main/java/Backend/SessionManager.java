/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryang
 */
public class SessionManager
{

    ArrayList<Session> sessions = new ArrayList<>();

    public SessionManager()
    {
        try
        {
            DB db = new DB();
            ResultSet rs = db.query("SELECT * FROM tblsessions");
            while (rs.next())
            {
                int sessionID = rs.getInt(1);
                int exerciseID = rs.getInt(2);
                int routineID = rs.getInt(3);
                Date date = rs.getDate(4);
                int weight = rs.getInt(5);

                sessions.add(new Session(sessionID, exerciseID, routineID, date, weight));

            }
        } catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getSessionResults()
    {
        ArrayList<String> a = new ArrayList<>();
        for (Session s : sessions)
        {
            a.add(s.getDate().toString() + "\t" + s.getName(a.indexOf(s)));
        }
        return a;
    }
}
