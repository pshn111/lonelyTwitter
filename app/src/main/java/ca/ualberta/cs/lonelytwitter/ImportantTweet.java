package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by spei on 9/13/17.
 *
 * Represents a ImportantTweer
 *
 * @author team X
 * @version  1.5
 * @see Tweet
 * @since 1.0
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet(String message){
        super(message);
    }

    public ImportantTweet(String message, Date date){
        super(message,date);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
