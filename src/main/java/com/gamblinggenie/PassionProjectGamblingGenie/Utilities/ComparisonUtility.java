package com.gamblinggenie.PassionProjectGamblingGenie.Utilities;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.TeamData;


public class ComparisonUtility {
    public String compareTeams(TeamData team1Schedule, TeamData team2Schedule) {
        if (team1Schedule.getTeam() == null || team2Schedule.getTeam() == null) {
            return "One or both teams not found";
        }
        String result = "";
        if (team1Schedule.getWins() > team2Schedule.getWins()) {
            result = team1Schedule.getTeam() + " has more wins than " + team2Schedule.getTeam();
        } else if (team1Schedule.getWins() < team2Schedule.getWins()) {
            result = team2Schedule.getTeam() + " has more wins than " + team1Schedule.getTeam();
        } else {
            result = team1Schedule.getTeam() + " and " + team2Schedule.getTeam() + " have the same number of wins";
        }
        return result;
    }

}
