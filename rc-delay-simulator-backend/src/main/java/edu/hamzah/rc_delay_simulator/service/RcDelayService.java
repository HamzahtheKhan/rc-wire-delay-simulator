package edu.hamzah.rc_delay_simulator.service;

import edu.hamzah.rc_delay_simulator.model.SimulationRequest;
import edu.hamzah.rc_delay_simulator.model.SimulationResponse;
import edu.hamzah.rc_delay_simulator.model.SegmentResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RcDelayService {

    public SimulationResponse calculateDelay(SimulationRequest request) {
        int n = Math.max(request.getNumSegments(), 1);

        // Resistance R = rho * (L / (W * T)) [Ohms]
        double crossSectionArea = request.getWidthMicrons() * request.getThicknessMicrons();
        double totalResistance = request.getResistivity() * (request.getLengthMicrons() / crossSectionArea);

        // Capacitance C = epsilon_0 * epsilon_r * (L * W) / dielectricHeight [Base unit: Farads]
        double epsilon0 = 8.854e-18;
        double totalCapacitanceFarads = epsilon0 * request.getDielectricConstant()
                * (request.getLengthMicrons() * request.getWidthMicrons()) / request.getDielectricHeight();

        // In femtofarads (fF)
        double totalCapacitanceFf = totalCapacitanceFarads * 1e15;

        // Calculation of Segment values
        double rSeg = totalResistance / n;
        double cSegFarads = totalCapacitanceFarads / n;

        // Elmore Delay Calculation (Ohms * Farads = Seconds)
        double cumulativeDelaySeconds = request.getDriverResistance() * totalCapacitanceFarads;

        List<SegmentResult> segments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            double capacitanceBeyondNode = totalCapacitanceFarads - ((i + 0.5) * cSegFarads);
            cumulativeDelaySeconds += rSeg * capacitanceBeyondNode;

            int nodeIndex = i + 1;
            double nodeDelayPs = cumulativeDelaySeconds * 1e12; // Convert to picoseconds

            // Pass 0.0 or omit voltage since we aren't simulating transient voltage drop
            segments.add(new SegmentResult(nodeIndex, 0.0, nodeDelayPs));
        }

        // Total Elmore delay in picoseconds
        double totalDelayPs = cumulativeDelaySeconds * 1e12;

        return new SimulationResponse(totalResistance, totalCapacitanceFf, totalDelayPs, segments);
    }
}