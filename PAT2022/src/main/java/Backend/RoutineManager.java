/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ryang
 */
public class RoutineManager
{

    //array of routines
    //getexercisesincurrentRoutine
    //AddToExerciseInCurrentRoutine(Exercise, Sets, Reps)
    private ArrayList<Routine> routines;
    private Routine currentRoutine = new Routine();

    public RoutineManager()
    {
    }

    public ArrayList<String> getExercisesInCurrentRoutine()
    {
        ArrayList<String> out = new ArrayList<>();
        for (ExerciseWithSet e : currentRoutine.getExerciseWithSet())
        {
            out.add(e.getName() + ", " + e.getSets() + " sets " + e.getReps() + " reps");
        }
        return out;
    }

    public void addToExerciseInCurrentRoutine(ExerciseWithSet e)
    {
        currentRoutine.addToArray(e);
    }

}
