package ca.ualberta.cs.lonelytwitter;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 * Modified by dmhamilt on 10/06/16.
 * Tweet is an abstract class intended to hold a message.
 *
 * @see NormalTweet
 * @see ImportantTweet
 */
public abstract class Tweet  implements Tweetable, Comparable<Tweet> {
    protected String message;
    private Date date;


    /**
     * Sort Tweets.
     *
     * @param Tweet o1
     */
    public int compareTo(Tweet o1) {
        return this.getDate().compareTo(o1.getDate());
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();



    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }
}
