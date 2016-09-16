package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by spei on 9/15/16.
 */
public abstract class Tweet implements Tweetable {
    private ArrayList<Mood> moodList = new ArrayList<Mood>();
    private String message;
    private Date date;

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }



    public abstract Boolean isImportant();

    public void setMessage(String message) throws TweetToLongException {
        if(message.length() > 140){
            //Do something
            throw new TweetToLongException();
        }
        this.message = message;
    }

    public void addMood(Mood mood){
        moodList.add(mood);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }



}
