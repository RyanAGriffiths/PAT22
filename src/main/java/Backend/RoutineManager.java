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
public class RoutineManager {

    //array of routines
    //getexercisesincurrentRoutine
    //AddToExerciseInCurrentRoutine(Exercise, Sets, Reps)
    private ArrayList<Routine> routines = new ArrayList<>();

    public RoutineManager() {
    }

    //updates routine array
    public void updateArray(int userID) {
        //clears everything in routines so that it can be updated with new array of routines
        routines.clear();
        try {
            DB db = new DB();
            ResultSet rs = db.query("SELECT * FROM ryangDB.tblroutine WHERE UserID=" + userID + ";");
            while (rs.next()) {
                int routineID = rs.getInt(1);
                String name = rs.getString(2);
                routines.add(new Routine(routineID, name));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoutineManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Routine getRoutineByIndex(int i) {
        return routines.get(i);
    }

    //creates a new routine in the routine table in database
    public ArrayList<ExerciseWithSet> createNewRoutine(String name, ExerciseWithSet[] exercises, int exercisesSize, int userID) {
        ArrayList<ExerciseWithSet> newExercises = new ArrayList<>();
        try {
            int c = routines.size() + 1;
            routines.add(new Routine(c, name));
            DB db = new DB();
                                                                                                                    //name has to be in ''s? -1hr of my life
            db.update("INSERT INTO ryangDB.tblroutine (`RoutineID`, `Name`, `UserID`)" + "\n " + " VALUES (" + c + ", '" + name + "', " + userID + ");");

            for (int i = 0; i < exercisesSize; i++) {
                newExercises.add(this.addExerciseToRoutine(c, exercises[i]));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoutineManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newExercises;
    }

    //adds a new Exercise to the routine_exercise table in database
    private ExerciseWithSet addExerciseToRoutine(int routineID, ExerciseWithSet e) {
        try {
            DB db = new DB();
            db.update("INSERT INTO ryangDB.tblroutine_exercise (`routineID`, `exerciseID`, `sets`, `reps`)" + "\n " + " VALUES (" + routineID + ", " + e.getId() + ", " + e.getSets() + ", " + e.getReps() + ");");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoutineManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ExerciseWithSet(routineID, e.getSets(), e.getReps(), 0, 0, e.getId(), e.getName(), e.getMuscleGroup(), e.getDifficulty(), e.getDesc());
    }

    //returns names in routine array
    public ArrayList<String> getRoutineNameList() {
        ArrayList<String> routineNames = new ArrayList<>();
        for (Routine r : routines) {
            routineNames.add(r.getName());
        }
        return routineNames;
    }

    //basically a toString
    public ArrayList<String> getExerciseNames(ArrayList<ExerciseWithSet> exercises) {
        ArrayList<String> exerciseNames = new ArrayList<>();
        for (ExerciseWithSet e : exercises) {
            exerciseNames.add(e.getName() + ", sets: " + e.getSets() + ", reps: " + e.getReps());
        }

        return exerciseNames;
    }
    
    //basically a toString
    public ArrayList<String> getSessionExerciseNames(ArrayList<ExerciseWithSet> exercises) {
        ArrayList<String> exerciseNames = new ArrayList<>();
        for (ExerciseWithSet e : exercises) {
            exerciseNames.add(e.getName() + ", sets: " + e.getCompletedSets() + ", reps: " + e.getCompletedReps());
        }

        return exerciseNames;
    }

}
