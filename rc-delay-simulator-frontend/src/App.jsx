
import React, { useState } from 'react';
import './App.css';

function App() {
  const [params, setParams] = useState({
    lengthMicrons: 100.0,
    widthMicrons: 0.07,
    thicknessMicrons: 0.14,
    resistivity: 0.022,
    dielectricConstant: 3.0,
    dielectricHeight: 0.14,
    driverResistance: 1000.0,
    numSegments: 4
  });

  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleChange = (e) => {
    setParams({ ...params, [e.target.name]: parseFloat(e.target.value) });
  };

  const handleSimulate = async (e) => {
    e.preventDefault();
    setLoading(true);
    setError(null);

    try {
      const response = await fetch('http://localhost:8080/api/simulate', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(params),
      });

      if (!response.ok) throw new Error('rc-delay-simulator backend error.');

      const data = await response.json();
      setResult(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="simulator-container">
      <header className="simulator-header">
        <div>
          <h1>RC Wire Delay Simulator</h1>
          <p>VLSI Interconnect Modeling & Elmore Delay Analysis</p>
        </div>
        <div style={{ fontSize: '0.75rem', color: '#94a3b8', fontStyle: 'italic', fontFamily: 'monospace' }}>
          Engine: [React] &lt;-&gt; [Spring Boot (Java)]
        </div>
      </header>

      <div className="simulator-body">
        <form onSubmit={handleSimulate} className="panel">
          <h3>Parameters</h3>
          <div className="input-grid">

            <div className="input-group">
              <label>Wire Length (microns)</label>
              <input type="number" step="any" name="lengthMicrons" value={params.lengthMicrons} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Wire Width (microns)</label>
              <input type="number" step="any" name="widthMicrons" value={params.widthMicrons} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Wire Thickness (microns)</label>
              <input type="number" step="any" name="thicknessMicrons" value={params.thicknessMicrons} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Material Resistivity (Ohm-micron)</label>
              <input type="number" step="any" name="resistivity" value={params.resistivity} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Dielectric Constant</label>
              <input type="number" step="any" name="dielectricConstant" value={params.dielectricConstant} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Dielectric Height (microns)</label>
              <input type="number" step="any" name="dielectricHeight" value={params.dielectricHeight} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Driver Resistance (Ohms)</label>
              <input type="number" step="any" name="driverResistance" value={params.driverResistance} onChange={handleChange} />
            </div>

            <div className="input-group">
              <label>Num of Segments</label>
              <input type="number" step="1" name="numSegments" value={params.numSegments} onChange={handleChange} />
            </div>

            <button type="submit" className="simulate-btn" style={{ gridColumn: '1 / -1' }}>
              {loading ? 'Calculating...' : 'Calculate Signal Propagation Delay'}
            </button>
          </div>
        </form>

        <div className="panel" style={{ justifyContent: 'space-between' }}>
          <div>
            <h3>Propagation Delay Analysis</h3>
            {error && <p style={{ color: '#f87171', fontSize: '0.85rem' }}>{error}</p>}

            <div className="metrics-box">
              {result ? (
                <>
                  <div className="metric-row">
                    <span>Total Resistance (R):</span>
                    <span>{result.totalResistance.toFixed(2)} Ω</span>
                  </div>
                  <div className="metric-row">
                    <span>Total Capacitance (C):</span>
                    <span>{result.totalCapacitance.toFixed(2)} fF</span>
                  </div>
                  <div className="metric-row metric-highlight">
                    <span>Elmore Delay (Td):</span>
                    <span>{result.elmoreDelay.toFixed(2)} ps</span>
                  </div>
                </>
              ) : (
                <div style={{ color: '#64748B', textAlign: 'center', padding: '10px', fontSize: '0.85rem' }}>
                  Awaiting simulation execution...
                </div>
              )}
            </div>
          </div>

          {result && result.segments && (
            <div>
              <h3 style={{ marginBottom: '8px', fontSize: '0.85rem' }}>Segment Breakdown</h3>
              <ul className="voltage-list">
                {result.segments.map((seg, idx) => (
                  <li key={idx}>
                    <span>Node {seg.nodeIndex}</span>
                    <span style={{ color: '#38bdf8' }}>{seg.delay.toFixed(2)} ps</span>
                  </li>
                ))}
              </ul>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default App;