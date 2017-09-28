/*
 * Copyright (c) 2017Team X, CMPUT301, University of Alberta-All Rights Reserved
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact spei@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * This class is the main view class in lonelyTweeter class.
 * It deals with user inputs, saves/loads them in/form the File_Name (file.sav).
 * @author spei
 *
 * @since 1.0
 * @see NormalTweet
 * @see java.io.BufferedReader
 * @see Tweet
 */
public class LonelyTwitterActivity extends Activity {

    /**
     * This is the name of the file that is saved in your virtual device.
     * you can access it through Android Device Monitor by selecting your app.
     * then data -> data -> file.sav
     * @see NormalTweet
     * @author spei
     */

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		final Button saveButton = (Button) findViewById(R.id.save);
		final Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				tweets.add(new NormalTweet(text));
				adapter.notifyDataSetChanged();
				saveInFile();
			}


//				Tweet tweet = new ImportantTweet("");
//				Tweet tweet1 = new NormalTweet("Hi");
//				try {
//					tweet.setMessage("Hello");
//				}catch (TweetTooLongException e){
//					//e.printStackTrace();
//				}
//
//
//
//				Date theDate = new Date();
//
//
//				Mood newHappy = new Happy(theDate);
//				Mood newSad = new Sad(theDate);
//				tweet.addMood(newHappy);
//				tweet.addMood(newSad);
//
//
//				ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
//				tweetList.add(tweet);
//				tweetList.add(tweet1);
//
//				//Log.d("","The isImportant method on tweet returns " + tweet.isImportant());
				//Log.d("","The isImportant method on tweet returns " + tweet1.isImportant());
//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();
		});

			clearButton.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					setResult(RESULT_OK);

					tweets.clear();
					adapter.notifyDataSetChanged();
					saveInFile();
				}


		});
	}

    /**
     * Sets up the adapter and refreshes the list whenever the activity is loaded.
     * @see android.widget.ArrayAdapter
     */

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * This mathod loads the json file, generates the tweets from its contents.
     * @throws RuntimeException
     * @exception FileNotFoundException
     */
	private void loadFromFile() {

		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweets = gson.fromJson(in,listType);





		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets =  new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}


    /**
     * Saves tweetList into FILENAME, using Gson
     */
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweets,writer);
			writer.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}