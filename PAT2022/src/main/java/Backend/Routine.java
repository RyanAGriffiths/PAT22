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
 * @author Ryang
 */
public class Routine
{

    private ArrayList<ExerciseWithSet> ews = new ArrayList<>();

    public Routine()
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

                ews.add(new ExerciseWithSet(sets, reps, exID, name, muscleGroup, difficulty, desc));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Routine.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Routine.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public void addToArray(ExerciseWithSet e)
    {
        ews.add(e);
    }
}
