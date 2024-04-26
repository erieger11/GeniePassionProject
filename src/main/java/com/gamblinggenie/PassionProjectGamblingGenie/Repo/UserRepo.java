package com.gamblinggenie.PassionProjectGamblingGenie.Repo;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<MlbSchedule,Long> {
}
