package com.gamblinggenie.PassionProjectGamblingGenie.Controller;
import com.gamblinggenie.PassionProjectGamblingGenie.Service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimulationController {
    @Autowired
    private SimulationService simulationService;

    @GetMapping("/StartInning")
    public String pitchResult() {
        return simulationService.baseballGameInning();
    }

}
