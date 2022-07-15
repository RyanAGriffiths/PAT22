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

    private int id;
    private String name;
    private String muscleGroup;
    private String difficulty;
    private String desc;

    public Exercise(int id, String name, String muscleGroup, String difficulty, String desc)
    {
        this.id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.difficulty = difficulty;
        this.desc = desc;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    @Override
    public String toString()
    {
        return "Exercise{" + "id=" + id + ", name=" + name + ", muscleGroup=" + muscleGroup + ", difficulty=" + difficulty + ", desc=" + desc + '}';
    }
}
