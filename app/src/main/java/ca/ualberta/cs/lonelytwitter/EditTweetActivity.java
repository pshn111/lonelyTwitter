package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        String message = getIntent().getStringExtra("MESSAGE");
        TextView messageText = (TextView) findViewById(R.id.MessageText);
        messageText.setText(message);
    }
}
