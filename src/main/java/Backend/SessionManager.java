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
public class SessionManager {

    ArrayList<Session> sessions = new ArrayList<>();

    public SessionManager() {
    }

    public void updateArray(int currentLoggedIn) {
        try {
            DB db = new DB();
            ResultSet rs = db.query("SELECT * FROM ryangDB.tblsession WHERE userID = " + currentLoggedIn + ";");
            while (rs.next()) {
                int sessionID = rs.getInt(1);
                int routineID = rs.getInt(2);
                int userID = rs.getInt(3);
                Date date = rs.getDate(4);

                sessions.add(new Session(sessionID, routineID, userID, date));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Session getSessionByIndex(int index) {
        return sessions.get(index);
    }

    public void addNewSession(int routineID, int userID, Date date) {
        try {
            int c = sessions.size() + 1;
            sessions.add(new Session(c, routineID, userID, date));

            DB db = new DB();                                                                                                                                   //date also has to be in ''s ._.
            db.update("INSERT INTO ryangDB.tblsession (`SessionID`, `RoutineID`, `userID`, `Date`)" + "\n" + "VALUES (" + c + ", " + routineID + ", " + userID + ", '" + date + "');");

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getSessionNames() {
        ArrayList<String> sessionNames = new ArrayList<>();
        for (Session s : sessions) {
            sessionNames.add(s.getDate().toString());
        }
        return sessionNames;
    }

}
