/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Ryang
 */
public class ExerciseWithSet extends Exercise
{
    //Exercise, Sets, Reps
    private int sets;
    private int reps;
    private int completedSets;
    private int completedReps;

    public ExerciseWithSet(int sets, int reps, int id, String name, String muscleGroup, String difficulty, String desc)
    {
        super(id, name, muscleGroup, difficulty, desc);
        this.sets = sets;
        this.reps = reps;
    }
    
    public ExerciseWithSet(int sets, int reps, int completedSets, int completedReps, int id, String name, String muscleGroup, String difficulty, String desc)
    {
        super(id, name, muscleGroup, difficulty, desc);
        this.sets = sets;
        this.reps = reps;
        this.completedSets = this.completedSets;
        this.completedReps = this.completedReps;
    }


    public int getSets()
    {
        return sets;
    }

    public void setSets(int sets)
    {
        this.sets = sets;
    }

    public int getReps()
    {
        return reps;
    }

    public void setReps(int reps)
    {
        this.reps = reps;
    }

    public int getCompletedSets()
    {
        return completedSets;
    }

    public int getCompletedReps()
    {
        return completedReps;
    }
    
    public void setCompletedSets(int completedSets)
    {
        this.completedSets = completedSets;
    }

    public void setCompletedReps(int completedReps)
    {
        this.completedReps = completedReps;
    }

    @Override
    public String toString()
    {
        return "ExerciseWithSet{" + super.getName() + ", sets=" + sets + ", reps=" + reps + '}';
    }
    
    
}
