package com.gamblinggenie.PassionProjectGamblingGenie.Repo;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.TeamData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<TeamData,Long> {
    TeamData findByTeam(String team);
    List<TeamData> findAllByOrderByWinsDesc();




//    List<TeamData> findByLeague();
//    List<TeamData> findByDivision();
//




}
