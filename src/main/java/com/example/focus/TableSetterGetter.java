package com.example.focus;

import javafx.scene.control.CheckBox;

public class TableSetterGetter {
    public TableSetterGetter(String name, int streak, CheckBox markasDone) {
        Name = name;
        Streak = streak;
        MarkasDone=markasDone;
    }
    public TableSetterGetter(String name, int streak, String markasDone) {
        Name = name;
        Streak = streak;
        Desc=markasDone;
    }
    String Name;
    int Streak;
    CheckBox MarkasDone;
    String Desc;
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStreak() {
        return Streak;
    }

    public void setStreak(int streak) {
        Streak = streak;
    }

    public CheckBox getMarkasDone() {
        return MarkasDone;
    }

    public void setMarkasDone(CheckBox markasDone) {
        MarkasDone = markasDone;
    }



}
