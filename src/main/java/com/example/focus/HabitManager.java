package com.example.focus;

import  java.util.Vector;

public class HabitManager {
    private Vector<Habit> hm;
    public void addHabit( Habit name ){
hm.add(name);
    }
public void deleteHabit(Habit name ) {
        hm.remove(name);
}
public void editHabit(Habit name ) {
}
public void displayHabit( Habit name) {

    }
public Vector<Habit>getAllHabits() {
        return hm;
}
public void show_all_data(){}
/*public Habit selectHabit(Habit name){
        Habit h  = new Habit();
        for(int i = 0 ;i < hm.size(); i++ ){
            if(hm.get(i)==name){
                return hm.get(i);
            }
        }
        return h;
}*/

}
