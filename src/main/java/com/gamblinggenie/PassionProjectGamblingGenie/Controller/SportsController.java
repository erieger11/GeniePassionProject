package com.gamblinggenie.PassionProjectGamblingGenie.Controller;

import com.gamblinggenie.PassionProjectGamblingGenie.Models.TeamData;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import com.gamblinggenie.PassionProjectGamblingGenie.Service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SportsController {

    @Autowired
    private SportsService sportsService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getData")
    public List<TeamData> dataFetch() {
        return sportsService.dataFetch();
    }
    @PostMapping("/save")
    public String saveSchedule(@RequestBody TeamData schedule) {
        return sportsService.saveSchedule(schedule);
    }
    @PutMapping("/update/{id}")
    public String updateSchedule(@PathVariable long id, @RequestBody TeamData schedule) {
        return sportsService.updateSchedule(id, schedule);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable long id) {
        return sportsService.deleteSchedule(id);
    }
    @GetMapping("/compare/{team1}/{team2}")
    public String compareTeams(@PathVariable String team1, @PathVariable String team2) {
        return sportsService.compareTeams(team1, team2);
    }
    @GetMapping("/findTeam/{team}")
    public TeamData findByTeam(@PathVariable String team) {
        //try {
            return sportsService.findByTeam(team);
//        }catch (Exception e) {
//            return new ResponseEntity<Object>(
//                    "Internal error", new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT
//            );
//        }

    }
    @GetMapping("/mlbstandings")
    public List<String> mlbStandings(){
     return sportsService.mlbstandings();
    }
    @GetMapping("/mlbstandings/league")
    public Map<String, List<String>> mlbStandingsByLeague(){
        return sportsService.mlbstandingsByLeague();
    }
    @GetMapping("/mlbstandings/league/division")
    public Map<String, Map<String, List<String>>> mlbStandingsByDivision(){
        return sportsService.mlbstandingsByDivision();
    }



}
