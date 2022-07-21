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
    //private Routine currentRoutine = new Routine();

    public RoutineManager()
    {
    }

    public ArrayList<String> getExercisesInCurrentRoutine()
    {
        //return currentRoutine.getExerciseNames();
    }

    public void AddToExerciseInCurrentRoutine(String e, int sets, int reps) throws ClassNotFoundException, SQLException
    {
        Scanner sc = new Scanner(e).useDelimiter(":");
        String name = sc.next();
        sc.close();
        DB db = new DB();
        ResultSet rs = db.query("SELECT * FROM tblexercise, WHERE `Name` = " + name);
        
    }

}
