/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Ryang
 */
public class Exercise
{

    private String muscleGroup;
    private String difficulty;
    private int targetAge;
    private float targetWeight;

    public Exercise(String muscleGroup, String difficulty, int targetAge, float targetWeight)
    {
        this.muscleGroup = muscleGroup;
        this.difficulty = difficulty;
        this.targetAge = targetAge;
        this.targetWeight = targetWeight;
    }

    public String getMuscleGroup()
    {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup)
    {
        this.muscleGroup = muscleGroup;
    }

    public String getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(String difficulty)
    {
        this.difficulty = difficulty;
    }

    public int getTargetAge()
    {
        return targetAge;
    }

    public void setTargetAge(int targetAge)
    {
        this.targetAge = targetAge;
    }

    public float getTargetWeight()
    {
        return targetWeight;
    }

    public void setTargetWeight(float targetWeight)
    {
        this.targetWeight = targetWeight;
    }

    public boolean withinTargetAge(int age)
    {
        if (age < targetAge - 10 || age > targetAge + 10)
        {
            return false;
        } else
        {
            return true;
        }
    }
    
     public boolean withinTargetWeight(float weight)
    {
        if (weight < targetWeight - 15 || weight > targetWeight + 15)
        {
            return false;
        } else
        {
            return true;
        }
    }
     
     
}
