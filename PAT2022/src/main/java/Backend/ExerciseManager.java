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
            String query = "SELECT * FROM ryangDB.tblexercise";

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
        } catch (SQLException ex)
        {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
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

    public static void addToArray()
    {

    }
}
