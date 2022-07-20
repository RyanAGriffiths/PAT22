/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ExerciseManager() throws ClassNotFoundException, SQLException
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
