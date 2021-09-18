package edu.cis.pset1_twitteranalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import edu.cis.pset1_twitteranalysis.twitter.TwitterController;
import twitter4j.Twitter;

public class  MainActivity extends AppCompatActivity
{
    TextView resultsView;
    TextView resultsTeacherView;
    TextView resultsTextView;
    EditText inputView;
    EditText teachersView;

    TwitterController myC;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This is not great, for extra credit you can fix this so that network calls happen on a different thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        resultsView = (TextView) this.findViewById(R.id.resultsView);
        inputView = (EditText) this.findViewById(R.id.inputView);
        resultsTextView = (TextView) this.findViewById(R.id.resultsTextView);
        teachersView = (EditText) this.findViewById(R.id.teachersView);
        resultsTeacherView = (TextView) this.findViewById(R.id.resultsTeacherView);

        // TODO 1: Tweet something!
        myC = new TwitterController(this);
//        myC.postTweet("tests"); //this will tweet to your account
//        System.out.println("test");
        //System.out.println(myC.findUserStats(inputView.getText().toString()));
    }
//
    public void testingMethod(View mainScreen)
    {
        String inputVal = inputView.getText().toString();
//
//        System.out.println(inputVal);
////        resultsView.setText(inputVal);
//        myC.postTweet(inputVal);
//        System.out.println(myC.findUserStats(inputVal));
        resultsTextView.setText(myC.findUserStats(inputVal));

    }

    public void teacherMethod(View mainScreen)
    {
        String teachersVal = teachersView.getText().toString();

        System.out.println(teachersVal.toLowerCase());
        resultsTeacherView.setText("You want to find a " + teachersVal.toLowerCase() + " teacher");

    }
}
