/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Date;

/**
 *
 * @author Ryang
 */
public class Routine extends Exercise
{
    
    private int sets;
    private int reps;
    private Date length;
    private String typeOfExercise;
    
    public Routine(String muscleGroup, String difficulty, int targetAge, float targetWeight, int inSets, int inReps, Date inLength, String inType)
    {
        super(muscleGroup, difficulty, targetAge, targetWeight);
        this.sets = inSets;
        this.reps = inReps;
        this.length = inLength;
        this.typeOfExercise = inType;
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

    public Date getLength()
    {
        return length;
    }

    public void setLength(Date length)
    {
        this.length = length;
    }

    public String getTypeOfExercise()
    {
        return typeOfExercise;
    }

    public void setTypeOfExercise(String typeOfExercise)
    {
        this.typeOfExercise = typeOfExercise;
    }
    
    
}
