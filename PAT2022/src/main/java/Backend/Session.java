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
    private int exerciseID;
    private int routineID;
    private Date date;
    private int weight;

    public Session(int sessionID, int exerciseID, int routineID, Date date, int weight)
    {
        this.sessionID = sessionID;
        this.exerciseID = exerciseID;
        this.routineID = routineID;
        this.date = date;
        this.weight = weight;
    }

    public int getSessionID()
    {
        return sessionID;
    }

    public void setSessionID(int sessionID)
    {
        this.sessionID = sessionID;
    }

    public int getExerciseID()
    {
        return exerciseID;
    }

    public void setExerciseID(int exerciseID)
    {
        this.exerciseID = exerciseID;
    }

    public int getRoutineID()
    {
        return routineID;
    }

    public void setRoutineID(int routineID)
    {
        this.routineID = routineID;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public String getName(int i)
    {
        Routine r = new Routine();
        return r.getName(i);
    }

    @Override
    public String toString()
    {
        return "Session{" + "sessionID=" + sessionID + ", exerciseID=" + exerciseID + ", routineID=" + routineID + ", date=" + date + ", weight=" + weight + "}";
    }

}
