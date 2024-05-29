package com.gamblinggenie.PassionProjectGamblingGenie.Controller;

import com.gamblinggenie.PassionProjectGamblingGenie.Service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SimulationController {
    @Autowired
    private SimulationService simulationService;

    @GetMapping("/StartGame")
    public SseEmitter simulateBaseballGame() {
        SseEmitter emitter = new SseEmitter();

        new Thread(() -> {
            try {
                while (!simulationService.isGameOver()) {
                    emitter.send(simulationService.baseballGameInning());
                    Thread.sleep(400);
                }
                emitter.send(simulationService.baseballGameInning());
                emitter.complete();
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        }).start();

        return emitter;
    }
}
