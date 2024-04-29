package com.gamblinggenie.PassionProjectGamblingGenie.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import com.gamblinggenie.PassionProjectGamblingGenie.Service.Comparison;
import com.gamblinggenie.PassionProjectGamblingGenie.Service.MLBservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SportsController {
    @Autowired
    private MLBservices mlbServices;

    @Autowired
    private UserRepo userRepo;
    @GetMapping("/login")
    public String loginScreen() {
        return "login";
    }
    @GetMapping("/homepage")
    public String home() {
        return "homePage";
    }
    @GetMapping("/profile")
    public String profilePage() {
        return "profile";
    }
    @GetMapping("/history")
    public String historyPage() {
        return "history";
    }
    @GetMapping("/selectedgame")
    public String selectedGamePage() {
        return "selectedGame";
    }


    @GetMapping("/mlbschedule")
    public List<MlbSchedule> getSchedule(){
        return userRepo.findAll();
    }
    @PostMapping("/save")
    public String saveSchedule(@RequestBody MlbSchedule schedule){
        userRepo.save(schedule);
        return "Saved";
    }
    @PutMapping("/update/{id}")
    public String updateSchedule(@PathVariable long id, @RequestBody MlbSchedule schedule){
        MlbSchedule updatedSchedule = userRepo.findById(id).get();
//        if (updatedSchedule == null) {
//            return "Schedule not found";
//        }

        updatedSchedule.setTeam(schedule.getTeam());
        updatedSchedule.setWins(schedule.getWins());
        updatedSchedule.setLosses(schedule.getLosses());
        userRepo.save(updatedSchedule);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable long id){
        MlbSchedule deletedSchedule = userRepo.findById(id).get();
        userRepo.delete(deletedSchedule);
        return "Deleted";
    }

    @GetMapping("/getData")
    public List<MlbSchedule> dataFetch(){
        return mlbServices.fetchData();
    }
    @Autowired
    private Comparison comparison;

    @GetMapping("/compare/{team1}/{team2}")
    public String compareTeams(@PathVariable String team1, @PathVariable String team2) {
        return comparison.compareTeams(team1, team2);
    }
}
