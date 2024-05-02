package com.gamblinggenie.PassionProjectGamblingGenie.Utilities;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;


public class ComparisonUtility {
    public String compareTeams(MlbSchedule team1Schedule, MlbSchedule team2Schedule, String team1, String team2) {
        if (team1 == null || team2 == null) {
            return "One or both teams not found";
        }
        String result = "";
        if (team1Schedule.getWins() > team2Schedule.getWins()) {
            result = team1 + " has more wins than " + team2;
        } else if (team1Schedule.getWins() < team2Schedule.getWins()) {
            result = team2 + " has more wins than " + team1;
        } else {
            result = team1 + " and " + team2 + " have the same number of wins";
        }
        return result;
    }

}
