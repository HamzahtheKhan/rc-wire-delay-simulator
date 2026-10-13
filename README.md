# RC Wire Delay Simulator

A full-stack VLSI interconnect modeling tool that calculates signal propagation delay through a wire using the **Elmore delay model**. It allows users to analyze how physical wire dimensions and material properties impact circuit speed.

---

## 📸 Presentation & Screenshots

### Frontend UI
<img width="1797" height="1017" alt="image" src="https://github.com/user-attachments/assets/ee5e55ba-4eea-47d6-8845-d5b43bdb988a" />

Code frontend running:
<img width="1810" height="991" alt="image" src="https://github.com/user-attachments/assets/393e9403-3286-46d2-a1da-f6e75b57ec76" />


### Backend Execution
<img width="1862" height="1007" alt="image" src="https://github.com/user-attachments/assets/1ebd1967-3798-4d7d-85f5-9e0ef5426dcc" />


---

## 🎯 About the Project
The RC Wire Delay Simulator bridges circuit theory and physical layout parameters. By modeling wires as distributed RC networks (using an RC ladder approach), it gives accurate insights into signal degradation and propagation delay in modern integrated circuits.

---

## 🎛️ Input & Output Specifications

### Inputs
* **Wire Dimensions:** Length, width, and thickness (in microns).
* **Material Properties:** Resistivity, relative dielectric constant, and oxide thickness.
* **Circuit Parameters:** Driver resistance and the number of split segments for the RC ladder.

### Outputs
* **Core Metrics:** Total wire resistance ($\Omega$), total capacitance ($fF$), and the final Elmore delay ($ps$). *(Note: units rendered plainly as ohms, femtofarads, and picoseconds for readability)*
* **Segment Breakdown:** A node-by-node list showing the delay progression across each individual segment of the wire.

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot (Java)
* **Frontend:** React, TypeScript, Vite

---

## 🚀 Getting Started & Installation

### Prerequisites
Make sure you have the following installed on your system:
* **Node.js** (v18+ recommended) & npm
* **Java Development Kit (JDK)** (v17 or v21 recommended)
* **Maven**

---

### 1. Clone the Repository
```bash
git clone [https://github.com/HamzahtheKhan/rc-wire-delay-simulator.git](https://github.com/HamzahtheKhan/rc-wire-delay-simulator.git)
cd rc-wire-delay-simulator
cd rc-wire-delay-simulator-backend

# Build the project
mvn clean install

# Run the Spring Boot application
mvn spring-boot:run

Run frontend:
cd rc-wire-delay-simulator-frontend

# Install dependencies
npm install

# Start the development server
npm run dev

The frontend client will open on http://localhost:5173 (or your configured Vite local port).
