package com.gamblinggenie.PassionProjectGamblingGenie.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimulationService {

    static int outs = 0;
    static int strikes = 0;
    static int balls = 0;

    public String baseballGameInning() {
        String pitchOutcome = pitchResult();
        String atBatOutcome = atBatResult();
        return pitchOutcome + " " + atBatOutcome;
    }

    public String atBatResult() {
        if (strikes == 3) {
            strikes = 0;
            balls = 0;
            outs++;
            return "Strikeout!";
        }
        if (balls == 4) {
            strikes = 0;
            balls = 0;
            return "Batter walked!";
        }
        return "";
    }

    public String pitchResult() {
        Random rand = new Random();
        int number = rand.nextInt(2);
        if (number == 0) {
            balls++;
            return "Pitch was a ball. Pitch count is " + balls + "-" + strikes + " " + outs + " outs";
        }
        strikes++;
        return "Pitch was a strike. Pitch count is " + balls + "-" + strikes+ " " + outs + " outs";
    }
}
