package com.gamblinggenie.PassionProjectGamblingGenie.Repo;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<MlbSchedule,Long> {
    List<MlbSchedule> findByTeam(String team);
}
