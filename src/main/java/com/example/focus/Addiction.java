package com.example.focus;

import java.time.LocalDate;

public class Addiction {
    private int soft_target;
    private String name;
    private String description;
    private int streak;
    private LocalDate lastModified;
    private LocalDate startDate;


    public int getSoft_target() {
        return soft_target;
    }

    public void setSoft_target(int soft_target) {
        this.soft_target = soft_target;
    }

    public Addiction(String name, String description, int streak, LocalDate lastModified, LocalDate startDate) {
        this.name = name;
        this.description = description;
        this.streak = streak;
        this.lastModified = lastModified;
        this.startDate = startDate;
    }

    public Addiction(String name, String description, int streak) {
        this.name=name;
        this.description=description;
        this.streak=streak;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public LocalDate getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDate lastModified) {
        this.lastModified = lastModified;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
