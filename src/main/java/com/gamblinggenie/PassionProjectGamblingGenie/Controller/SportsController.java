package com.gamblinggenie.PassionProjectGamblingGenie.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SportsController {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ObjectMapper objectMapper;

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


    @GetMapping("/mlbschedule")
    public List<MlbSchedule> getSchedule(){
        return userRepo.findAll();
    }
    @PostMapping("/save")
    public String saveSchedule(MlbSchedule schedule){
        userRepo.save(schedule);
        return "Saved";
    }
    @PutMapping("/update/{id}")
    public String updateSchedule(@PathVariable long id, @RequestBody MlbSchedule schedule){
        MlbSchedule updatedSchedule = userRepo.findById(id).get();
//        if (updatedSchedule == null) {
//            return "Schedule not found";
//        }

        updatedSchedule.setGamePk(schedule.getGamePk());
        updatedSchedule.setGameGuid(schedule.getGameGuid());
        updatedSchedule.setLink(schedule.getLink());
        updatedSchedule.setGameType(schedule.getGameType());
        updatedSchedule.setSeason(schedule.getSeason());
        updatedSchedule.setGameDate(schedule.getGameDate());
        updatedSchedule.setOfficialDate(schedule.getOfficialDate());
        updatedSchedule.setAbstractGameState(schedule.getAbstractGameState());
        updatedSchedule.setCodedGameState(schedule.getCodedGameState());
        updatedSchedule.setDetailedState(schedule.getDetailedState());
        updatedSchedule.setStatusCode(schedule.getStatusCode());
        updatedSchedule.setStartTimeTBD(schedule.isStartTimeTBD());
        updatedSchedule.setAbstractGameCode(schedule.getAbstractGameCode());

        updatedSchedule.setAwayWins(schedule.getAwayWins());
        updatedSchedule.setAwayLosses(schedule.getAwayLosses());
        updatedSchedule.setAwayPct(schedule.getAwayPct());
        updatedSchedule.setAwayTeamId(schedule.getAwayTeamId());
        updatedSchedule.setAwayTeamName(schedule.getAwayTeamName());
        updatedSchedule.setAwaySplitSquad(schedule.isAwaySplitSquad());
        updatedSchedule.setAwaySeriesNumber(schedule.getAwaySeriesNumber());

        updatedSchedule.setHomeWins(schedule.getHomeWins());
        updatedSchedule.setHomeLosses(schedule.getHomeLosses());
        updatedSchedule.setHomePct(schedule.getHomePct());
        updatedSchedule.setHomeTeamId(schedule.getHomeTeamId());
        updatedSchedule.setHomeTeamName(schedule.getHomeTeamName());
        updatedSchedule.setHomeSplitSquad(schedule.isHomeSplitSquad());
        updatedSchedule.setHomeSeriesNumber(schedule.getHomeSeriesNumber());

        updatedSchedule.setVenueId(schedule.getVenueId());
        updatedSchedule.setVenueName(schedule.getVenueName());
        updatedSchedule.setVenueLink(schedule.getVenueLink());
        updatedSchedule.setContentLink(schedule.getContentLink());
        updatedSchedule.setGameNumber(schedule.getGameNumber());
        updatedSchedule.setPublicFacing(schedule.isPublicFacing());
        updatedSchedule.setDoubleHeader(schedule.getDoubleHeader());
        updatedSchedule.setGamedayType(schedule.getGamedayType());
        updatedSchedule.setTiebreaker(schedule.getTiebreaker());
        updatedSchedule.setCalendarEventID(schedule.getCalendarEventID());

        updatedSchedule.setSeasonDisplay(schedule.getSeasonDisplay());
        updatedSchedule.setDayNight(schedule.getDayNight());
        updatedSchedule.setScheduledInnings(schedule.getScheduledInnings());
        updatedSchedule.setReverseHomeAwayStatus(schedule.isReverseHomeAwayStatus());
        updatedSchedule.setInningBreakLength(schedule.getInningBreakLength());
        updatedSchedule.setGamesInSeries(schedule.getGamesInSeries());
        updatedSchedule.setSeriesGameNumber(schedule.getSeriesGameNumber());
        updatedSchedule.setSeriesDescription(schedule.getSeriesDescription());
        updatedSchedule.setRecordSource(schedule.getRecordSource());
        updatedSchedule.setIfNecessary(schedule.getIfNecessary());
        updatedSchedule.setIfNecessaryDescription(schedule.getIfNecessaryDescription());

        userRepo.save(updatedSchedule);
        return "Updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSchedule(@PathVariable long id){
        MlbSchedule deletedSchedule = userRepo.findById(id).get();
        userRepo.delete(deletedSchedule);
        return "Deleted";
    }
}
