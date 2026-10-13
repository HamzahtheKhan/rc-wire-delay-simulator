package edu.hamzah.rc_delay_simulator.model;

public class SimulationRequest {

    private double lengthMicrons;
    private double widthMicrons;
    private double thicknessMicrons;
    private double resistivity;
    private double dielectricConstant;
    private double dielectricHeight;
    private double driverResistance;
    private int numSegments;

    // 1. Default constructor (Required for JSON deserialization)
    public SimulationRequest() {
    }

    // 2. All-args constructor
    public SimulationRequest(double lengthMicrons, double widthMicrons, double thicknessMicrons,
                             double resistivity, double dielectricConstant, double dielectricHeight,
                             double driverResistance, int numSegments) {
        this.lengthMicrons = lengthMicrons;
        this.widthMicrons = widthMicrons;
        this.thicknessMicrons = thicknessMicrons;
        this.resistivity = resistivity;
        this.dielectricConstant = dielectricConstant;
        this.dielectricHeight = dielectricHeight;
        this.driverResistance = driverResistance;
        this.numSegments = numSegments;
    }

    // 3. Getters and Setters
    public double getLengthMicrons() {
        return lengthMicrons;
    }

    public void setLengthMicrons(double lengthMicrons) {
        this.lengthMicrons = lengthMicrons;
    }

    public double getWidthMicrons() {
        return widthMicrons;
    }

    public void setWidthMicrons(double widthMicrons) {
        this.widthMicrons = widthMicrons;
    }

    public double getThicknessMicrons() {
        return thicknessMicrons;
    }

    public void setThicknessMicrons(double thicknessMicrons) {
        this.thicknessMicrons = thicknessMicrons;
    }

    public double getResistivity() {
        return resistivity;
    }

    public void setResistivity(double resistivity) {
        this.resistivity = resistivity;
    }

    public double getDielectricConstant() {
        return dielectricConstant;
    }

    public void setDielectricConstant(double dielectricConstant) {
        this.dielectricConstant = dielectricConstant;
    }

    public double getDielectricHeight() {
        return dielectricHeight;
    }

    public void setDielectricHeight(double dielectricHeight) {
        this.dielectricHeight = dielectricHeight;
    }

    public double getDriverResistance() {
        return driverResistance;
    }

    public void setDriverResistance(double driverResistance) {
        this.driverResistance = driverResistance;
    }

    public int getNumSegments() {
        return numSegments;
    }

    public void setNumSegments(int numSegments) {
        this.numSegments = numSegments;
    }

    @Override
    public String toString() {
        return "SimulationRequest{" +
                "lengthMicrons=" + lengthMicrons +
                ", widthMicrons=" + widthMicrons +
                ", thicknessMicrons=" + thicknessMicrons +
                ", resistivity=" + resistivity +
                ", dielectricConstant=" + dielectricConstant +
                ", dielectricHeight=" + dielectricHeight +
                ", driverResistance=" + driverResistance +
                ", numSegments=" + numSegments +
                '}';
    }
}