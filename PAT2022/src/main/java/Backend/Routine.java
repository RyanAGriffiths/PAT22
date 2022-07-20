/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Ryang
 */
public class Routine 
{
    private ArrayList<ExerciseWithSet> ews = new ArrayList<>();

    public Routine()
    {
        
    }
    
    public ArrayList<String> getExerciseNames(){
        ArrayList<String> out = new ArrayList<>();
        for(ExerciseWithSet e: ews){
            out.add(e.getName() + e.getSets() + " sets" + e.getReps() + " reps");
        }
        return out;
    }

}