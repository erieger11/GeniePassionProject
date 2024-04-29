package com.gamblinggenie.PassionProjectGamblingGenie.Service;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Comparison {
    @Autowired
    private UserRepo userRepo;

    public String compareTeams(String team1, String team2) {
        MlbSchedule team1Schedule = userRepo.findByTeam(team1);
        MlbSchedule team2Schedule = userRepo.findByTeam(team2);

        if (team1Schedule == null || team2Schedule == null) {
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
