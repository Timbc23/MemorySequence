package com.example.memorysequence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Timer;
import com.example.lib.Sequence;

/**
 * Class which operates the actual game.
 * Needs to:
 * 1. Show the user what the sequence to be memorized is.
 * 2. Allow for the user to respond to each sequence with the buttons
 *      a. Each button should add to a list or check directly with the sequence for accuracy
 * 3. Tell when the game is over and if it is, tell the user
 * 4. Keep track of player score
 * 5. API use???
 */
public class GameActivity extends AppCompatActivity {
    public static String TAG = "Game Activity";
    public static String logM;

    public final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    public final Timer timer = new Timer();

    /**
     * Declaration of Buttons.
     */
    private Button buttonA;
    private Button buttonB;
    private Button buttonC;
    private Button buttonD;

    /**
     * Declaration of ImageViews.
     */
    private ImageView seqDisplayBase;
    private ImageView seqDisplayA1;
    private ImageView seqDisplayB1;
    private ImageView seqDisplayC1;
    private ImageView seqDisplayD1;

    private ImageView seqDisplayA2;
    private ImageView seqDisplayB2;
    private ImageView seqDisplayC2;
    private ImageView seqDisplayD2;

    private ImageView seqDisplayA3;
    private ImageView seqDisplayB3;
    private ImageView seqDisplayC3;
    private ImageView seqDisplayD3;

    private ImageView seqDisplayA4;
    private ImageView seqDisplayB4;
    private ImageView seqDisplayC4;
    private ImageView seqDisplayD4;

    private TextView gameOverDisplay;

    /**
     * Declaration of the Sequence instance for this game.
     */
    private Sequence gameSeq;

    private List<Integer> inputSeq;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameSeq = new Sequence();

        inputSeq = new ArrayList<>();

        buttonA = findViewById(R.id.ButtonA);
        buttonB = findViewById(R.id.ButtonB);
        buttonC = findViewById(R.id.ButtonC);
        buttonD = findViewById(R.id.ButtonD);

        seqDisplayBase = findViewById(R.id.seqViewBase);
        seqDisplayBase.setVisibility(View.VISIBLE);
        seqDisplayA1 = findViewById(R.id.seqViewA1);
        seqDisplayA1.setVisibility(View.INVISIBLE);
        seqDisplayB1 = findViewById(R.id.seqViewB1);
        seqDisplayB1.setVisibility(View.INVISIBLE);
        seqDisplayC1 = findViewById(R.id.seqViewC1);
        seqDisplayC1.setVisibility(View.INVISIBLE);
        seqDisplayD1 = findViewById(R.id.seqViewD1);
        seqDisplayD1.setVisibility(View.INVISIBLE);

        seqDisplayA2 = findViewById(R.id.seqViewA2);
        seqDisplayA2.setVisibility(View.INVISIBLE);
        seqDisplayB2 = findViewById(R.id.seqViewB2);
        seqDisplayB2.setVisibility(View.INVISIBLE);
        seqDisplayC2 = findViewById(R.id.seqViewC2);
        seqDisplayC2.setVisibility(View.INVISIBLE);
        seqDisplayD2 = findViewById(R.id.seqViewD2);
        seqDisplayD2.setVisibility(View.INVISIBLE);

        seqDisplayA3 = findViewById(R.id.seqViewA3);
        seqDisplayA3.setVisibility(View.INVISIBLE);
        seqDisplayB3 = findViewById(R.id.seqViewB3);
        seqDisplayB3.setVisibility(View.INVISIBLE);
        seqDisplayC3 = findViewById(R.id.seqViewC3);
        seqDisplayC3.setVisibility(View.INVISIBLE);
        seqDisplayD3 = findViewById(R.id.seqViewD3);
        seqDisplayD3.setVisibility(View.INVISIBLE);

        seqDisplayA4 = findViewById(R.id.seqViewA4);
        seqDisplayA4.setVisibility(View.INVISIBLE);
        seqDisplayB4 = findViewById(R.id.seqViewB4);
        seqDisplayB4.setVisibility(View.INVISIBLE);
        seqDisplayC4 = findViewById(R.id.seqViewC4);
        seqDisplayC4.setVisibility(View.INVISIBLE);
        seqDisplayD4 = findViewById(R.id.seqViewD4);
        seqDisplayD4.setVisibility(View.INVISIBLE);
        // By default, A,B,C,D are set to INVISIBLE

        gameOverDisplay = findViewById(R.id.GameOverView);
        gameOverDisplay.setVisibility(View.GONE);

        setSeqDisplay();

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSeq.add(1);
                Log.i(logM, "Button A Pressed");
                if (inputSeq.size() == 4) {
                    if (gameSeq.compareSeq(gameSeq.getSeq(), inputSeq)) {
                        Log.i(logM, "Sequence entered correctly!");
                        gameSeq.nextSeq();
                        inputSeq = new ArrayList<>();
                        setSeqDisplay();

                    } else {
                        Log.i(logM, "Sequence entered incorrectly!");
                        gameOverDisplay.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSeq.add(2);
                Log.i(logM, "Button B Pressed");
                if (inputSeq.size() == 4) {
                    if (gameSeq.compareSeq(gameSeq.getSeq(), inputSeq)) {
                        Log.i(logM, "Sequence entered correctly!");
                        gameSeq.nextSeq();
                        inputSeq = new ArrayList<>();
                        setSeqDisplay();
                    } else {
                        Log.i(logM, "Sequence entered incorrectly!");
                        gameOverDisplay.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSeq.add(3);
                Log.i(logM, "Button C Pressed");
                if (inputSeq.size() == 4) {
                    if (gameSeq.compareSeq(gameSeq.getSeq(), inputSeq)) {
                        Log.i(logM, "Sequence entered correctly!");
                        gameSeq.nextSeq();
                        inputSeq = new ArrayList<>();
                        setSeqDisplay();
                    } else {
                        Log.i(logM, "Sequence entered incorrectly!");
                        gameOverDisplay.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSeq.add(4);
                Log.i(logM, "Button D Pressed");
                if (inputSeq.size() == 4) {
                    if (gameSeq.compareSeq(gameSeq.getSeq(), inputSeq)) {
                        Log.i(logM, "Sequence entered correctly!");
                        gameSeq.nextSeq();
                        inputSeq = new ArrayList<>();
                        setSeqDisplay();
                    } else {
                        Log.i(logM, "Sequence entered incorrectly!");
                        gameOverDisplay.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        Log.i(TAG, "Game successfully started.");
    }

    public void choseSeqDisplay(int curIndex) {
        if (curIndex == 0) {
            if (gameSeq.getSeq().get(curIndex).equals(1)) {
                seqDisplayA1.setVisibility(View.VISIBLE);
                seqDisplayA2.setVisibility(View.INVISIBLE);
                seqDisplayA3.setVisibility(View.INVISIBLE);
                seqDisplayA4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to A1");
            } else if (gameSeq.getSeq().get(curIndex).equals(2)) {
                seqDisplayA1.setVisibility(View.INVISIBLE);
                seqDisplayA2.setVisibility(View.VISIBLE);
                seqDisplayA3.setVisibility(View.INVISIBLE);
                seqDisplayA4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to A2");
            } else if (gameSeq.getSeq().get(curIndex).equals(3)) {
                seqDisplayA1.setVisibility(View.INVISIBLE);
                seqDisplayA2.setVisibility(View.INVISIBLE);
                seqDisplayA3.setVisibility(View.VISIBLE);
                seqDisplayA4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to A3");
            } else {
                seqDisplayA1.setVisibility(View.INVISIBLE);
                seqDisplayA2.setVisibility(View.INVISIBLE);
                seqDisplayA3.setVisibility(View.INVISIBLE);
                seqDisplayA4.setVisibility(View.VISIBLE);
                Log.i(logM, "Display set to A4");
            }
        }
        if (curIndex == 1) {
            if (gameSeq.getSeq().get(curIndex).equals(1)) {
                seqDisplayB1.setVisibility(View.VISIBLE);
                seqDisplayB2.setVisibility(View.INVISIBLE);
                seqDisplayB3.setVisibility(View.INVISIBLE);
                seqDisplayB4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to B1");
            } else if (gameSeq.getSeq().get(curIndex).equals(2)) {
                seqDisplayB1.setVisibility(View.INVISIBLE);
                seqDisplayB2.setVisibility(View.VISIBLE);
                seqDisplayB3.setVisibility(View.INVISIBLE);
                seqDisplayB4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to B2");
            } else if (gameSeq.getSeq().get(curIndex).equals(3)) {
                seqDisplayB1.setVisibility(View.INVISIBLE);
                seqDisplayB2.setVisibility(View.INVISIBLE);
                seqDisplayB3.setVisibility(View.VISIBLE);
                seqDisplayB4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to B3");
            } else {
                seqDisplayB1.setVisibility(View.INVISIBLE);
                seqDisplayB2.setVisibility(View.INVISIBLE);
                seqDisplayB3.setVisibility(View.INVISIBLE);
                seqDisplayB4.setVisibility(View.VISIBLE);
                Log.i(logM, "Display set to B4");
            }
        }
        if (curIndex == 2) {
            if (gameSeq.getSeq().get(curIndex).equals(1)) {
                seqDisplayC1.setVisibility(View.VISIBLE);
                seqDisplayC2.setVisibility(View.INVISIBLE);
                seqDisplayC3.setVisibility(View.INVISIBLE);
                seqDisplayC4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to C1");
            } else if (gameSeq.getSeq().get(curIndex).equals(2)) {
                seqDisplayC1.setVisibility(View.INVISIBLE);
                seqDisplayC2.setVisibility(View.VISIBLE);
                seqDisplayC3.setVisibility(View.INVISIBLE);
                seqDisplayC4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to C2");
            } else if (gameSeq.getSeq().get(curIndex).equals(3)) {
                seqDisplayC1.setVisibility(View.INVISIBLE);
                seqDisplayC2.setVisibility(View.INVISIBLE);
                seqDisplayC3.setVisibility(View.VISIBLE);
                seqDisplayC4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to C3");
            } else {
                seqDisplayC1.setVisibility(View.INVISIBLE);
                seqDisplayC2.setVisibility(View.INVISIBLE);
                seqDisplayC3.setVisibility(View.INVISIBLE);
                seqDisplayC4.setVisibility(View.VISIBLE);
                Log.i(logM, "Display set to C4");
            }
        }
        if (curIndex == 3) {
            if (gameSeq.getSeq().get(curIndex).equals(1)) {
                seqDisplayD1.setVisibility(View.VISIBLE);
                seqDisplayD2.setVisibility(View.INVISIBLE);
                seqDisplayD3.setVisibility(View.INVISIBLE);
                seqDisplayD4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to D1");
            } else if (gameSeq.getSeq().get(curIndex).equals(2)) {
                seqDisplayD1.setVisibility(View.INVISIBLE);
                seqDisplayD2.setVisibility(View.VISIBLE);
                seqDisplayD3.setVisibility(View.INVISIBLE);
                seqDisplayD4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to D2");
            } else if (gameSeq.getSeq().get(curIndex).equals(3)) {
                seqDisplayD1.setVisibility(View.INVISIBLE);
                seqDisplayD2.setVisibility(View.INVISIBLE);
                seqDisplayD3.setVisibility(View.VISIBLE);
                seqDisplayD4.setVisibility(View.INVISIBLE);
                Log.i(logM, "Display set to D3");
            } else {
                seqDisplayD1.setVisibility(View.INVISIBLE);
                seqDisplayD2.setVisibility(View.INVISIBLE);
                seqDisplayD3.setVisibility(View.INVISIBLE);
                seqDisplayD4.setVisibility(View.VISIBLE);
                Log.i(logM, "Display set to D4");
            }
        }
    }
    public void setSeqDisplay() {
        for (int i = 0; i < gameSeq.getSeq().size(); i++) {
            choseSeqDisplay(i);
            /*
            final int index = i;
            executorService.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    choseSeqDisplay(index);
                }
            }, 1, 3, TimeUnit.SECONDS);
            */
        }
    }
}
