package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mTwoPointButton;
    private Button mThreePointButton;
    private Button mFreeThrowButton;

    private static final String KEY_SCORE_TEAM_A = "team_a_score";
    private static final String KEY_SCORE_TEAM_B = "team_b_score";

    int mScoreTeamA = 0;
    int mScoreTeamB = 0;

    TextView mScoreValueTeamA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mScoreTeamA = savedInstanceState.getInt(KEY_SCORE_TEAM_A, 0);
            mScoreTeamB = savedInstanceState.getInt(KEY_SCORE_TEAM_B, 0);

            TextView scoreView = (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(mScoreTeamA));

            TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
            scoreViewB.setText(String.valueOf(mScoreTeamB));
        } else {
            displayForTeamA(mScoreTeamA);
            displayForTeamB(mScoreTeamB);
        }
    }

    public void addOneForTeamA(View v) {
        displayForTeamA(1);
    }

    public void addTwoForTeamA(View v) {
        displayForTeamA(2);
    }

    public void addThreeForTeamA(View v) {
        displayForTeamA(3);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(mScoreTeamA + score));
        mScoreTeamA = mScoreTeamA + score;
    }

    public void addOneForTeamB(View v) {
        displayForTeamB(1);
    }

    public void addTwoForTeamB(View v) {
        displayForTeamB(2);
    }

    public void addThreeForTeamB(View v) {
        displayForTeamB(3);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(mScoreTeamB + score));
        mScoreTeamB = mScoreTeamB + score;
    }

    /**
     * Reset the score
     */
    public void resetScore(View v) {
        mScoreTeamA = 0;

        TextView scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(mScoreTeamA));

        mScoreTeamB = 0;

        TextView scoreViewB = (TextView) findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(mScoreTeamB));
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_SCORE_TEAM_A, mScoreTeamA);
        savedInstanceState.putInt(KEY_SCORE_TEAM_B, mScoreTeamB);
    }
}
