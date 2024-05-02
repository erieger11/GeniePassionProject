package com.gamblinggenie.PassionProjectGamblingGenie.Service;

import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import com.gamblinggenie.PassionProjectGamblingGenie.Utilities.ComparisonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SportsService {
    @Autowired
    private UserRepo userRepo;
    ComparisonUtility comparison = new ComparisonUtility();

    public List<MlbSchedule> dataFetch() {
        return userRepo.findAll();
    }
    public String saveSchedule(MlbSchedule schedule) {
        userRepo.save(schedule);
        return "Saved";
    }
    public String updateSchedule(long id,MlbSchedule schedule) {
        MlbSchedule updatedSchedule = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        updatedSchedule.setTeam(schedule.getTeam());
        updatedSchedule.setWins(schedule.getWins());
        updatedSchedule.setLosses(schedule.getLosses());
        userRepo.save(updatedSchedule);
        return "Updated";
    }
    public String deleteSchedule(long id) {
        MlbSchedule deletedSchedule = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        userRepo.delete(deletedSchedule);
        return "Deleted";
    }
    public String compareTeams(String team1, String team2) {
        MlbSchedule team1Schedule = userRepo.findByTeam(team1);
        MlbSchedule team2Schedule = userRepo.findByTeam(team2);
        return comparison.compareTeams(team1Schedule, team2Schedule, team1, team2);
    }
    public MlbSchedule findByTeam(String team) {
        return userRepo.findByTeam(team);
    }
    public List standings(){
        return null;
    }

}
