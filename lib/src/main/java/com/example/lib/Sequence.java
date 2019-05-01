package com.example.lib;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Sequence {
    /**
     * Need to:
     * 1. Create a list that holds the current sequence
     *      a. Use a random num generator
     * 2. After each successful round, add to the sequence list
     * 3. Compare actual list to button input list
     * 4. Know when the game is ongoing versus over
     */

    private int gameScore = 0;
    private boolean gameStarted = true;
    private List<Integer> seq = new ArrayList<>();

    public Sequence() {
        seq.add(genRandomSeq());
        seq.add(genRandomSeq());
        seq.add(genRandomSeq());
        seq.add(genRandomSeq());
    }

    public List<Integer> getSeq() {
        return seq;
    }

    /**
     * Generates a new random between 1 and 4.
     * @return a new sequence entry.
     */
    public static Integer genRandomSeq() {
        Random rand = new Random();
        return (Integer) (rand.nextInt(4) + 1);
    }

    /**
     * Generates a new sequence.
     */
    public void nextSeq() {
        if (gameStarted) {
            seq = new ArrayList<>();
            seq.add(genRandomSeq());
            seq.add(genRandomSeq());
            seq.add(genRandomSeq());
            seq.add(genRandomSeq());
        }
    }

    /**
     * Compares the current button input to its counterpart in the sequence list.
     * @param list current sequence.
     * @param index current sequence list index.
     * @param id button input.
     * @return true if they match, false if they don't
     */
    public boolean compareSeq(List<Integer> list, int index, Integer id) {
        if (!gameStarted) {
            return false;
        }
        if (list.get(index).equals(id)) {
            gameScore++;
            nextSeq();
            return true;
        }
        gameStarted = false;
        return false;
    }

    public boolean compareSeq(List<Integer> list, List<Integer> input) {
        if (!gameStarted) {
            return false;
        }
        if (input.size() < 4) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i).equals(input.get(i)))) {
                gameStarted = false;
                return false;
            }
        }
        return true;
    }

    public boolean checkForGame() {
        return gameStarted;
    }
}

