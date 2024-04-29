package com.gamblinggenie.PassionProjectGamblingGenie.Service;
import com.gamblinggenie.PassionProjectGamblingGenie.Models.MlbSchedule;
import com.gamblinggenie.PassionProjectGamblingGenie.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MLBservices {
    @Autowired
    private  UserRepo userRepo;

    public List<MlbSchedule> fetchData(){
        return userRepo.findAll();
    }
}
