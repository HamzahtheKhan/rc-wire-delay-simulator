package edu.hamzah.rc_delay_simulator.model;
public class SegmentResult {
    private int nodeIndex;
    private double voltage;
    private double delay;

    public SegmentResult(int nodeIndex, double voltage, double delay) {
        this.nodeIndex = nodeIndex;
        this.voltage = voltage;
        this.delay = delay;
    }

    public int getNodeIndex() { return nodeIndex; }
    public double getVoltage() { return voltage; }
    public double getDelay() { return delay; }
}