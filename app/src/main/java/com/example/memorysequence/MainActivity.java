package com.example.memorysequence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

/**
 * Main menu which allows the user to enter the game.
 * Needs to:
 * 1. Have a start game button
 *      a. potentially have higher difficulties
 * 2. API ??? (allow players to view all-time high scores?)
 */
public class MainActivity extends AppCompatActivity {
    public static String TAG = "Main Activity";
    public static String logM;

    /**
     * Declaring main buttons
     */
    private Button startButton;
    private Button instructionButton;
    private Button randomPicButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        startButton = findViewById(R.id.StartButton);
        instructionButton = findViewById(R.id.InstructionButton);
        randomPicButton = findViewById(R.id.WebButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame(v);
                Log.i(logM, "Game started!");
            }
        });
        instructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInstruction(v);
                Log.i(logM, "Loaded Instructions.");
            }
        });
        randomPicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPic(v);
                Log.i(logM, "Look, a cool picture!");
            }
        });

        Log.i(TAG, "Application successfully started.");
    }

    /**
     * Method to start Game Activity
     * @param view
     */
    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    /**
     * Method to start Instruction Activity
     * @param view
     */
    public void startInstruction(View view) {
        Intent intent = new Intent(this, InstructionActivity.class);
        startActivity(intent);
    }
    /**
     * Method to start Random Picture Activity
     * @param view
     */
    public void startPic(View view) {
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
    }
}
