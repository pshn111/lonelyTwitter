package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by spei on 9/14/17.
 */

public class Sad extends Mood {
    public Sad(Date date){
        super(date);
    }

    @Override
    public String mood(){
        return "Sad";
    }
}
