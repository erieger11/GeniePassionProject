package com.gamblinggenie.PassionProjectGamblingGenie.Controller;

import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import com.gamblinggenie.PassionProjectGamblingGenie.Service.SportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class SportsController {

    @Autowired
    private SportsService sportsService;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getData")
    public List<MlbSchedule> dataFetch() {
        return sportsService.dataFetch();
    }
    @PostMapping("/save")
    public String saveSchedule(@RequestBody MlbSchedule schedule) {
        return sportsService.saveSchedule(schedule);
    }
    @PutMapping("/update/{id}")
    public String updateSchedule(@PathVariable long id, @RequestBody MlbSchedule schedule) {
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
    public MlbSchedule findByTeam(@PathVariable String team) {
        //try {
            return sportsService.findByTeam(team);
//        }catch (Exception e) {
//            return new ResponseEntity<Object>(
//                    "Internal error", new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT
//            );
//        }

    }


}
