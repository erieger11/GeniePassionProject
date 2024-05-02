package com.gamblinggenie.PassionProjectGamblingGenie.Repo;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<MlbSchedule,Long> {
    MlbSchedule findByTeam(String team);




    //MlbSchedule findAllOrderByWins();

    //MlbSchedule findAllOrderByWinsAC();
}
