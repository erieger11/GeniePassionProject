package com.gamblinggenie.PassionProjectGamblingGenie.Service;

import com.gamblinggenie.PassionProjectGamblingGenie.Models.TeamData;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import com.gamblinggenie.PassionProjectGamblingGenie.Utilities.ComparisonUtility;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SportsService {
    @Autowired
    private UserRepo userRepo;
    ComparisonUtility comparison = new ComparisonUtility();

    public List<TeamData> dataFetch() {
        return userRepo.findAll();
    }
    public String saveSchedule(TeamData schedule) {
        userRepo.save(schedule);
        return "Saved";
    }
    public String updateSchedule(long id, TeamData schedule) {
        TeamData updatedSchedule = userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Schedule with id " + id + " not found"));
        updatedSchedule.setTeam(schedule.getTeam());
        updatedSchedule.setWins(schedule.getWins());
        updatedSchedule.setLosses(schedule.getLosses());
        updatedSchedule.setLeague(schedule.getLeague());
        updatedSchedule.setDivision(schedule.getDivision());
        updatedSchedule.setGamesPlayed(schedule.getGamesPlayed());

        userRepo.save(updatedSchedule);
        return "Updated";
    }
    public String deleteSchedule(long id) {
        TeamData deletedSchedule = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        userRepo.delete(deletedSchedule);
        return "Deleted";
    }

    public String compareTeams(String team1, String team2) {
        TeamData team1Schedule = userRepo.findByTeam(team1);
        TeamData team2Schedule = userRepo.findByTeam(team2);
        return comparison.compareTeams(team1Schedule, team2Schedule);
    }
    public TeamData findByTeam(String team) {
        return userRepo.findByTeam(team);
    }
    public List<String> mlbstandings() {
        List<TeamData> teamObjectStandings = userRepo.findAllByOrderByWinsDesc();
        List<String>  formattedStadnings = new ArrayList<>();
        for(TeamData teams : teamObjectStandings){
            String standing = teams.getTeam() + " : " + teams.getWins() + "-" + teams.getLosses()
                    + " GP:" + (teams.getWins() + teams.getLosses());
            formattedStadnings.add(standing);
        }
        return formattedStadnings;
    }
    public Map<String, List<String>> mlbstandingsByLeague() {
        List<TeamData> teamObjectStandings = userRepo.findAllByOrderByWinsDesc();
        Map<String,List<String>> formattedStadnings = new HashMap<>();

        for (TeamData team : teamObjectStandings) {
            String standing = team.getTeam() + " : " + team.getWins() + "-" + team.getLosses() + " GP:" + (team.getWins() + team.getLosses());
            formattedStadnings.computeIfAbsent(team.getLeague(), k -> new ArrayList<>()).add(standing);
        }
        return formattedStadnings;
    }
    public Map<String, Map<String, List<String>>> mlbstandingsByDivision() {
        List<TeamData> teams = userRepo.findAllByOrderByWinsDesc();
        Map<String, Map<String, List<String>>> standingsByLeagueAndDivision = new HashMap<>();

        for (TeamData team : teams) {
            String standing = team.getTeam() + " : " + team.getWins() + "-" + team.getLosses()
                    + " GP:" + (team.getWins() + team.getLosses());
            standingsByLeagueAndDivision
                    .computeIfAbsent(team.getLeague(), k -> new HashMap<>())
                    .computeIfAbsent(team.getDivision(), k -> new ArrayList<>())
                    .add(standing);
        }

        return standingsByLeagueAndDivision;
    }


}
