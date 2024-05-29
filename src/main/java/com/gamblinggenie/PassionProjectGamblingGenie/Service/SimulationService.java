package com.gamblinggenie.PassionProjectGamblingGenie.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimulationService {

    private int homeTeamScore = 0;
    private int awayTeamScore = 0;
    private double inning = 1;
    private int outs = 0;
    private int strikes = 0;
    private int balls = 0;
    private boolean pitchContact = false;

    public String baseballGameInning() {
        if (inning >= 10) {
            return "GAME OVER\nHome : " + homeTeamScore + " - " + "Away : " + awayTeamScore;
        }

        pitchContact = false;
        String pitchOutcome = pitchResult();
        String atBatOutcome = atBatResult();
        String hitOutcome = "";

        if (pitchContact) {
            hitOutcome = hitOutcome();
        }

        if (outs == 3) {
            outs = 0;
            inning += 0.5;
        }

        return "Home : " + homeTeamScore + " - " + "Away : " + awayTeamScore + "\n" +
                "Inning : " + inning + "\n" +
                pitchOutcome + "\n" +
                atBatOutcome + "\n" +
                hitOutcome;
    }

    public boolean isGameOver() {
        return inning >= 10;
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
        int number = rand.nextInt(4);

        switch (number) {
            case 0:
                balls++;
                return String.format("Pitch was a ball. Pitch count is %d-%d and %d outs.", balls, strikes, outs);
            case 1:
                strikes++;
                return String.format("Pitch was a strike. Pitch count is %d-%d and %d outs.", balls, strikes, outs);
            case 2:
                if (strikes < 2) {
                    strikes++;
                }
                return String.format("Pitch was a foul ball. Pitch count is %d-%d and %d outs.", balls, strikes, outs);
            case 3:
                pitchContact = true;
                return String.format("Pitch contact was made. Pitch count is %d-%d and %d outs.", balls, strikes, outs);
            default:
                return "Unexpected pitch outcome.";
        }
    }

    public String hitOutcome() {
        Random ballPlacement = new Random();
        int num = ballPlacement.nextInt(100);
        strikes = 0;
        balls = 0;

        if (num <= 4) return recordOut("Fly out to deep left");
        if (num <= 8) return recordOut("Fly out to deep center");
        if (num <= 12) return recordOut("Fly out to deep right");
        if (num <= 16) return recordOut("Fly out to shallow left");
        if (num <= 20) return recordOut("Fly out to shallow center");
        if (num <= 24) return recordOut("Fly out to shallow right");
        if (num <= 27) return recordOut("Fly out behind catcher");
        if (num <= 31) return recordOut("Foul out right");
        if (num <= 35) return recordOut("Foul out left");
        if (num <= 39) return recordOut("Ground out to 1B");
        if (num <= 43) return recordOut("Ground out to 2B");
        if (num <= 47) return recordOut("Ground out to SS");
        if (num <= 51) return recordOut("Ground out to 3B");
        if (num <= 55) return recordOut("Ground out to P");

        if (num <= 60) return "Single to shallow right";
        if (num <= 65) return "Single to shallow center";
        if (num <= 70) return "Single to shallow left";
        if (num <= 75) return "Single to deep right";
        if (num <= 80) return "Single to deep center";
        if (num <= 85) return "Single to deep left";
        if (num <= 88) return "Double to deep right";
        if (num <= 91) return "Double to deep center";
        if (num <= 94) return "Double to deep left";
        if (num <= 96) return "Triple to deep right";
        if (num <= 98) return "Triple to deep center";
        if (num == 99) return "Triple to deep left";

        return "HOMERUN";
    }

    private String recordOut(String outcome) {
        outs++;
        return outcome;
    }
}
