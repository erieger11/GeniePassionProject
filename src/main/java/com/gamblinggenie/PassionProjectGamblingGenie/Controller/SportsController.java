package com.gamblinggenie.PassionProjectGamblingGenie.Controller;

import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import com.gamblinggenie.PassionProjectGamblingGenie.Service.Comparison;
import com.gamblinggenie.PassionProjectGamblingGenie.Service.MLBservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SportsController {

    @Autowired
    private MLBservices mlbServices;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/mlbschedule")
    public List<MlbSchedule> getSchedule() {
        return userRepo.findAll();
    }

    @PostMapping("/save")
    public String saveSchedule(@RequestBody MlbSchedule schedule) {
        userRepo.save(schedule);
        return "Saved";
    }

    @PutMapping("/update/{id}")
    public String updateSchedule(@PathVariable long id, @RequestBody MlbSchedule schedule) {
        MlbSchedule updatedSchedule = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        updatedSchedule.setTeam(schedule.getTeam());
        updatedSchedule.setWins(schedule.getWins());
        updatedSchedule.setLosses(schedule.getLosses());
        userRepo.save(updatedSchedule);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable long id) {
        MlbSchedule deletedSchedule = userRepo.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        userRepo.delete(deletedSchedule);
        return "Deleted";
    }

    @GetMapping("/getData")
    public List<MlbSchedule> dataFetch() {
        return mlbServices.fetchData();
    }

    @Autowired
    private Comparison comparison;

    @GetMapping("/compare/{team1}/{team2}")
    public String compareTeams(@PathVariable String team1, @PathVariable String team2) {
        return comparison.compareTeams(team1, team2);
    }

    @GetMapping("/findTeam/{team}")
    public MlbSchedule grabTeam(@PathVariable String team) {
        return userRepo.findByTeam(team);
        //this will be changed to incorporate the date
    }
}
