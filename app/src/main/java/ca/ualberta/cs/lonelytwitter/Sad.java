/*
 * Copyright (c) 2017Team X, CMPUT301, University of Alberta-All Rights Reserved
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behavior at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact spei@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * create a sad mood
 *
 * @version 1.0
 * @see Mood
 *
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
