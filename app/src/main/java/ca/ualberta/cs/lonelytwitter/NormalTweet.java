package ca.ualberta.cs.lonelytwitter;

/**
* Created by watts1 on 9/15/16.
* Modified by dmhamilt on 10/06/16.
* A version of Tweet, flagged fo different handling.
* @see Tweet
*/
public class NormalTweet extends Tweet implements Tweetable {

    /**
    * Instantiates a new Normal tweet.
    *
    * @param message the message
    */
    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
   }
}
