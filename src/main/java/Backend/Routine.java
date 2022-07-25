/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ryang
 */
public class Routine
{

    private ArrayList<ExerciseWithSet> ews = new ArrayList<>();
    private ArrayList<String> routineNames = new ArrayList<>();
    
    private int routineID;
    private String name;

    public Routine(int routineID, String name)
    {
        this.routineID = routineID;
        this.name = name;
    }

    public ArrayList<String> getExerciseNames()
    {
        ArrayList<String> out = new ArrayList<>();
        for (ExerciseWithSet e : ews)
        {
            out.add(e.getName() + " - " + e.getReps() + " reps  " + e.getSets() + " sets");
        }
        return out;
    }

    public ArrayList<ExerciseWithSet> getExerciseWithSet()
    {
        ArrayList<ExerciseWithSet> out = new ArrayList<>();
        for (ExerciseWithSet e : ews)
        {
            out.add(e);
        }
        return out;
    }

    public ArrayList<String> getRoutineNames()
    {
        ArrayList<String> out = new ArrayList<>();
        for (String r : routineNames)
        {
            out.add(r);
        }
        return out;
    }

    public void addToEWSArray(ExerciseWithSet e)
    {
        ews.add(e);
    }

    public String getName(int i)
    {
        return routineNames.get(i);
    } 
    
    public int getRoutineID(){
        return routineID;
    }
    
    public String getName()
    {
        return name;
    } 
   
}
