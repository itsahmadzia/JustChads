package com.example.focus;

import java.util.Date;
public class Streak {

    private Date startDate ;
    private Date lastmodifiedDate ;
    private int streak_score ;

    public void setLastmodifiedDate(Date lastmodifiedDate) {
        this.lastmodifiedDate = lastmodifiedDate;
    }

    public void setStreak_score(int streak_score) {
        this.streak_score = streak_score;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getStreak_score() {
        return streak_score;
    }

    public Date getLastmodifiedDate() {
        return lastmodifiedDate;
    }
}
