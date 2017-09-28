/*
 *Tweet
 *
 * Version 1.0
 *
 * Sep 27, 2017
 *
 * Copyright (c) 2017Team X, CMPUT301, University of Alberta-All Rights Reserved
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact spei@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by spei on 9/13/17.
 *
 * Represents a tweet
 *
 * @author team X
 * @version  1.5
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */

public abstract class Tweet implements Tweetable {

    private String message;
    private Date date;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    /**
     * Constructs a Tweet object.
     *
     * @param message tweet message
     */
    public Tweet(String message){
        date = new Date();
        this.message = message;

    }

    /**
     * Constructs a Tweet object.
     *
     *
     * @param message tweet message
     * @param date tweet date
     */
    public Tweet(String message, Date date) {
        this.date = date;
        this.message = message;
    }


    public String getMessage(){
        return message;
    }

    /**
     * Sets the tweet message
     *
     * @param message tweet message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length()<140){
            this.message=message;
        }
        else {
            throw new TweetTooLongException();
        }
    }

    public abstract Boolean isImportant();

    /**
     * add a mood
     * @param mood tweet mood
     */
    public void addMood(Mood mood){
        moodList.add(mood);
    }

    /**
     * set date
     * @param date tweet date
     */
    public void setDate(Date date) {
        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }


}
