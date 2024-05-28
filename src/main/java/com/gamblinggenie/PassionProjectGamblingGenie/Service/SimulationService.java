package com.gamblinggenie.PassionProjectGamblingGenie.Service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SimulationService {

    static int outs = 0;
    static int strikes = 0;
    static int balls = 0;
    Boolean pitchContact = false;


    public String baseballGameInning() {

        String pitchOutcome = pitchResult();
        String atBatOutcome = atBatResult();
        String hitOutcome = hitOutcome();
        if(pitchContact){
            return pitchOutcome + " " + hitOutcome;
        }
        else{
            return pitchOutcome + " " + atBatOutcome;
        }
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

        if (number == 0) {
            balls++;
            return "Pitch was a ball. Pitch count is " + balls + "-" + strikes + " and " + outs + " outs.";
        } else if (number == 1) {
            strikes++;
            return "Pitch was a strike.  Pitch count is " + balls + "-" + strikes + " and " + outs + " outs.";
        } else if (number == 2){
            pitchContact = true;
            return "Pitch contact was made.  Pitch count is " + balls + "-" + strikes + " and " + outs + " outs.";
        } else {
            if (strikes < 2) {
                strikes++;
            }
            return "Pitch was a foul ball. Pitch count is " + balls + "-" + strikes + " and " + outs + " outs.";
        }
    }

    public String hitOutcome() {
        Random ballPlacement = new Random();
        int num = ballPlacement.nextInt(100);
        strikes = 0;
        balls = 0;
        if (num <= 4) {
            outs++;
            return "Fly out to deep left";
        } else if (num >= 5 && num <= 8) {
            outs++;
            return "Fly out to deep center";
        } else if (num >= 9 && num <= 12) {
            outs++;
            return "Fly out to deep right";
        } else if (num >= 13 && num <= 16) {
            outs++;
            return "Fly out to shallow left";
        } else if (num >= 17 && num <= 20) {
            outs++;
            return "Fly out to shallow center";
        } else if (num >= 21 && num <= 24) {
            outs++;
            return "Fly out to shallow right";
        } else if (num >= 25 && num <= 27) {
            outs++;
            return "Fly out behind catcher";
        } else if (num >= 28 && num <= 31) {
            outs++;
            return "Foul out right";
        } else if (num >= 32 && num <= 35) {
            outs++;
            return "Foul out left";
        } else if (num >= 36 && num <= 39) {
            outs++;
            return "Ground out to 1B";
        } else if (num >= 40 && num <= 43) {
            outs++;
            return "Ground out to 2B";
        } else if (num >= 44 && num <= 47) {
            outs++;
            return "Ground out to SS";
        } else if (num >= 48 && num <= 51) {
            outs++;
            return "Ground out to 3B";
        } else if (num >= 52 && num <= 55) {
            outs++;
            return "Ground out to P";
        } else if (num >= 56 && num <= 60) {
            return "Single to shallow right";
        } else if (num >= 61 && num <= 65) {
            return "Single to shallow center";
        } else if (num >= 66 && num <= 70) {
            return "Single to shallow left";
        } else if (num >= 71 && num <= 75) {
            return "Single to deep right";
        } else if (num >= 76 && num <= 80) {
            return "Single to deep center";
        } else if (num >= 81 && num <= 85) {
            return "Single to deep left";
        } else if (num >= 86 && num <= 88) {
            return "Double to deep right";
        } else if (num >= 89 && num <= 91) {
            return "Double to deep center";
        } else if (num >= 92 && num <= 94) {
            return "Double to deep left";
        } else if (num >= 95 && num <= 96) {
            return "Triple to deep right";
        } else if (num >= 97 && num <= 98) {
            return "Triple to deep center";
        } else if (num == 99) {
            return "Triple to deep left";
        } else {
            return "HOMERUN";
        }
    }


}

