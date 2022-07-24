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

    public Routine()
    {
    }

    public void populateArray()
    {
        try
        {
            DB db = new DB();
            ResultSet rs = db.query("SELECT * FROM tblexercise, tblroutine WHERE tblexercise.`ExerciseID` = tblroutine.`ExerciseID`;");
            while (rs.next())
            {
                int exID = rs.getInt(1);
                String name = rs.getString(2);
                String muscleGroup = rs.getString(3);
                String difficulty = rs.getString(4);
                String desc = rs.getString(5);
                int sets = rs.getInt(8);
                int reps = rs.getInt(9);
                String routineName = rs.getString(10);

                ews.add(new ExerciseWithSet(sets, reps, exID, name, muscleGroup, difficulty, desc));
                routineNames.add(routineName);
                System.out.println(ews + "\n" + routineNames.toString());
            }
        } catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(Routine.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
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
}
