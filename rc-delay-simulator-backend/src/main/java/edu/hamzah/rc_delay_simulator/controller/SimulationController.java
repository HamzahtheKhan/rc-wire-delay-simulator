package edu.hamzah.rc_delay_simulator.controller;

import edu.hamzah.rc_delay_simulator.model.SimulationRequest;
import edu.hamzah.rc_delay_simulator.model.SimulationResponse;
import edu.hamzah.rc_delay_simulator.service.RcDelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"}) // Supports standard React/Vite dev ports
public class SimulationController {

    private final RcDelayService rcDelayService;

    @Autowired
    public SimulationController(RcDelayService rcDelayService) {
        this.rcDelayService = rcDelayService;
    }

    @PostMapping("/simulate")
    public ResponseEntity<SimulationResponse> simulateWireDelay(@RequestBody SimulationRequest request) {
        System.out.println("Request: " + request.toString());
        SimulationResponse response = rcDelayService.calculateDelay(request);
        return ResponseEntity.ok(response);
    }
}