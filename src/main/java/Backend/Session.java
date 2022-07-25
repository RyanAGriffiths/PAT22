/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Date;

/**
 *
 * @author ryang
 */
public class Session
{

    private int sessionID;
    private int routineID;
    private int userID;
    private Date date;

    public Session(int sessionID, int routineID, int userID, Date date)
    {
        this.sessionID = sessionID;
        this.routineID = routineID;
        this.userID = userID;
        this.date = date;
    }

    public int getSessionID()
    {
        return sessionID;
    }

    public void setSessionID(int sessionID)
    {
        this.sessionID = sessionID;
    }

    public int getRoutineID()
    {
        return routineID;
    }

    public void setRoutineID(int routineID)
    {
        this.routineID = routineID;
    }
    
    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

}
