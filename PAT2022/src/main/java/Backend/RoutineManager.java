/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;

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
    
    public ArrayList<String> getExercisesInCurrentRoutine()
    {
        return currentRoutine.getExerciseNames();
    }

    public void AddToExerciseInCurrentRoutine(Exercise e, int sets, int reps)
    {
        
    }

}
