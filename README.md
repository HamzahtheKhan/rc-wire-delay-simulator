# RC Wire Delay Simulator

The RC Wire Delay Simulator is a full-stack tool that calculates signal propagation delay through a wire using the **Elmore delay model**. It allows users to analyze how physical wire dimensions and material properties impact circuit speed.

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
The RC Wire Delay Simulator is a full-stack tool that calculates signal propagation delay through a wire using the Elmore delay model. 
It allows users to analyze how physical wire dimensions and material properties impact circuit speed.

---

## 🎛️ Input & Output Specifications

### Inputs
* **Wire Dimensions:** Length, width, and thickness (in microns).
* **Material Properties:** Material Resistivity (Ohm-micron), relative dielectric constant, and Dielectric Height (microns).
* **Circuit Parameters:** Driver Resistance (Ohms) and the number of split segments for the RC ladder.

### Outputs
* **Core Metrics:** Total wire resistance (ohm), total capacitance (femtofarads), and the final Elmore delay (picoseconds).
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
