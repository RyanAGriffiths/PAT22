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
public class ExerciseManager {

    private ArrayList<Exercise> exercises = new ArrayList<>();
    private ArrayList<Exercise> upper = new ArrayList<>();
    private ArrayList<Exercise> core = new ArrayList<>();
    private ArrayList<Exercise> lower = new ArrayList<>();
    //exercises that the user made
    private ArrayList<ExerciseWithSet> userExercises = new ArrayList<>();
    //exercises shown in UI
    private ArrayList<ExerciseWithSet> visibleExercises = new ArrayList<>();

    public ExerciseManager() {
        try {
            DB db = new DB();
            String query = "SELECT * FROM ryangDB.tblexercise;";

            ResultSet rs = db.query(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String muscleGroup = rs.getString(3);
                String difficulty = rs.getString(4);
                String desc = rs.getString(5);

                exercises.add(new Exercise(id, name, muscleGroup, difficulty, desc));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Exercise e : exercises) {
            addToArray(e);
        }

        try {
            DB db = new DB();
            //query
            String query = "SELECT * FROM ryangDB.tblroutine_exercise;";

            ResultSet rs = db.query(query);
            while (rs.next()) {
                int exerciseID = rs.getInt(1);
                int routineID = rs.getInt(2);
                int sets = rs.getInt(3);
                int reps = rs.getInt(4);
                int completedSets = rs.getInt(5);
                int completedReps = rs.getInt(6);
                Exercise ex = this.getExerciseByID(exerciseID);

                userExercises.add(new ExerciseWithSet(routineID, sets, reps, completedSets, completedReps, ex.getId(), ex.getName(), ex.getMuscleGroup(), ex.getDifficulty(), ex.getDesc()));

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Exercise getUpperExercise(int i) {
        return upper.get(i);

    }

    public Exercise getCoreExercise(int i) {
        return core.get(i);
    }

    public Exercise getLowerExercise(int i) {
        return lower.get(i);
    }

    public ArrayList<String> getExerciseNames() {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : exercises) {
            output.add(exercise.getName());
        }
        return output;
    }

    public ArrayList<ExerciseWithSet> getUserExercises() {
        return userExercises;
    }

    public ArrayList<String> getUpperNames() {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : upper) {
            output.add(exercise.getName());
        }
        return output;
    }

    public ArrayList<String> getCoreNames() {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : core) {
            output.add(exercise.getName());
        }
        return output;
    }

    public ArrayList<String> getLowerNames() {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : lower) {
            output.add(exercise.getName());
        }
        return output;
    }

    private Exercise getExerciseByID(int ID) {
        for (Exercise e : exercises) {
            if (e.getId() == ID) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Exercise> getExercises() {
        ArrayList<Exercise> output = new ArrayList<>();

        for (Exercise exercise : exercises) {
            output.add(exercise);
        }
        return output;
    }

    public ArrayList<ExerciseWithSet> getExercisesByRoutineID(int routineID) {
        visibleExercises.clear();
        for (ExerciseWithSet e : userExercises) {
            if (e.getRoutineID() == routineID) {
                visibleExercises.add(e);
            }
        }
        return visibleExercises;
    }

    public ExerciseWithSet getVisibleExercise(int index) {
        return visibleExercises.get(index);
    }

    public ArrayList<String> getMuscleGroup() {
        ArrayList<String> output = new ArrayList<>();

        for (Exercise exercise : exercises) {
            output.add(exercise.getMuscleGroup());
        }
        return output;
    }

    public int updateCompletedSetsReps() {
        int routineID = -1;
        for (ExerciseWithSet e : visibleExercises) {
            try {
                DB db = new DB();
                db.update("UPDATE ryangDB.tblroutine_exercise SET completedSets = " + e.getCompletedSets() + ", completedReps = " + e.getCompletedReps() + "\n" + "WHERE routineID = " + e.getRoutineID() + ";");
                routineID = e.getRoutineID();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ExerciseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return routineID;
    }

    @Override
    public String toString() {
        String output = "";
        for (Exercise exercise : exercises) {
            output += exercise.toString() + "\n";
        }
        return output;
    }

    public void addToUserExercises(ArrayList<ExerciseWithSet> ex) {
        userExercises.addAll(ex);
    }

    public void addToArray(Exercise e) {

        switch (e.getMuscleGroup()) {
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
