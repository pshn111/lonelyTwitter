package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by spei on 9/14/17.
 */

public abstract class Mood {
    private Date date;

    public Mood(){
        this.date = new Date();
    }

    public Mood(Date date){
        this.date = date;
    }

    public abstract String mood();

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
