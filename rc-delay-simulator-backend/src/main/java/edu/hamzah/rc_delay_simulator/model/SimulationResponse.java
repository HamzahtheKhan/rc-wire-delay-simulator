package edu.hamzah.rc_delay_simulator.model;
import java.util.List;

public class SimulationResponse {
    private double totalResistance;
    private double totalCapacitance;
    private double elmoreDelay; // Matches frontend
    private List<SegmentResult> segments; // Replaces voltageProfile

    // Constructors, Getters, and Setters
    public SimulationResponse(double totalResistance, double totalCapacitance, double elmoreDelay, List<SegmentResult> segments) {
        this.totalResistance = totalResistance;
        this.totalCapacitance = totalCapacitance;
        this.elmoreDelay = elmoreDelay;
        this.segments = segments;
    }

    public double getTotalResistance() { return totalResistance; }
    public double getTotalCapacitance() { return totalCapacitance; }
    public double getElmoreDelay() { return elmoreDelay; }
    public List<SegmentResult> getSegments() { return segments; }
}