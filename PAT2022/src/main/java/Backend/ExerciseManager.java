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
 * @author Ryang
 */
public class ExerciseManager
{

    private ArrayList<Exercise> exercises = new ArrayList<>();
    private ArrayList<Exercise> upper = new ArrayList<>();
    private ArrayList<Exercise> core = new ArrayList<>();
    private ArrayList<Exercise> lower = new ArrayList<>();

    public ExerciseManager()
    {
        try
        {
            DB db = new DB();
            //query
            String query = "SELECT * FROM tblexercise;";

            ResultSet rs = db.query(query);
            while (rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String muscleGroup = rs.getString(3);
                String difficulty = rs.getString(4);
                String desc = rs.getString(5);

                exercises.add(new Exercise(id, name, muscleGroup, difficulty, desc));

            }
        } catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Exercise e : exercises)
        {
            addToArray(e);
        }
    }

    public Exercise getUpperExercise(int i)
    {
        return upper.get(i);

    }

    public Exercise getCoreExercise(int i)
    {
        return core.get(i);
    }

    public Exercise getLowerExercise(int i)
    {
        return lower.get(i);
    }

    public ArrayList<String> getExerciseNames()
    {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : exercises)
        {
            output.add(exercise.getName());
        }
        return output;
    }

    public ArrayList<String> getUpperNames()
    {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : upper)
        {
            output.add(exercise.getName());
        }
        return output;
    }

    public ArrayList<String> getCoreNames()
    {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : core)
        {
            output.add(exercise.getName());
        }
        return output;
    }

    public ArrayList<String> getLowerNames()
    {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : lower)
        {
            output.add(exercise.getName());
        }
        return output;
    }

    public ArrayList<Exercise> getExercises()
    {
        ArrayList<Exercise> output = new ArrayList<>();

        for (Exercise exercise : exercises)
        {
            output.add(exercise);
        }
        return output;
    }

    public ArrayList<String> getMuscleGroup()
    {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : exercises)
        {
            output.add(exercise.getMuscleGroup());
        }
        return output;
    }

    @Override
    public String toString()
    {
        String output = "";
        for (Exercise exercise : exercises)
        {
            output += exercise.toString() + "\n";
        }
        return output;
    }

    public void addToArray(Exercise e)
    {

        switch (e.getMuscleGroup())
        {
            case "upper":
                upper.add(e);
                break;
            case "core":
                core.add(e);
                break;
            case "lower":
                lower.add(e);
                break;
            default:
                System.out.println("unrecognised muscle group");
                break;
        }
    }
}
