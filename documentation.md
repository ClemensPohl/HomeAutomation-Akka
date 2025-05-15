# Home Automation System – Documentation

## Overview

This project is a distributed, actor-based smart home simulation written in Java using **Akka Typed**, **gRPC**, and **MQTT**.  
It models a smart home with various devices and environments, including a **distributed fridge microservice** with ordering logic and auto-reordering.

---

## 1. Architecture Overview

### Main Components

- **Akka Home Automation App (Monolith):**
    - Orchestrates all devices and environments.
    - Provides a command-line UI for user interaction.

- **Fridge Microservice (gRPC):**
    - Runs as a separate process.
    - Manages fridge contents, order history, and auto-reordering logic.
    - Communicates with the main app via gRPC.

- **Environment Simulation:**
    - **Local Environment**: Simulates temperature and weather locally.
    - **MQTT Environment**: Receives environment updates via MQTT messages.

---

### Class & Actor Diagram

+-------------------+               +---------------------+
| HomeAutomationApp |<--gRPC------->| Fridge Microservice |
| (Akka Typed)      |               | (gRPC, Standalone)  |
+-------------------+               +---------------------+
|
|  (Akka actors)
v
+----------------------+
| HomeAutomationController
|  |
|  +-- AirCondition (Actor)
|  +-- TemperatureSensor (Actor)
|  +-- TemperatureEnvironment (Actor)
|  +-- WeatherSensor (Actor)
|  +-- WeatherEnvironment (Actor)
|  +-- Blinds (Actor)
|  +-- MediaStation (Actor)
|  +-- Fridge (Actor, gRPC Client)
|  +-- UI (Actor)
|  +-- MqttEnvironment (Actor)
+----------------------+

---

## 2. Design Decisions & Patterns

### Actor Model

- Each device/environment is an actor for concurrency and isolation.
- The **UI actor** receives user commands and delegates to the correct device actor.

### Fridge as a Microservice

- The fridge logic (capacity, weight, history, auto-reordering) is **decoupled** from the main app.
- Communication is via **gRPC** for language-agnostic, efficient, and type-safe RPC.

### Environment Switching

- The system can **switch between a simulated local environment and an MQTT-based environment** at runtime via UI commands.
- This is handled by the `env-mode` command and the environment actors.

### Command Pattern

- All device actions are modeled as **commands** (e.g., `AddProduct`, `RemoveProduct`) for strong typing and extensibility.

---

## 3. Interaction Patterns

### User Interaction

- The user interacts via a **command-line UI**.
- Commands are parsed and dispatched to the relevant actor.

### Device Coordination

- Actors communicate via **typed messages** (commands).
- The **Fridge actor** communicates with the **gRPC microservice** for all fridge operations.

### Environment Handling

- The environment can be set to:
    - `INTERNAL` (local simulation)
    - `EXTERNAL` (MQTT)
    - `OFF`
- Actors subscribe to environment updates and adjust device behavior accordingly.

---

## 4. Fridge Microservice Logic

- **Add Product**:  
  Checks capacity and weight before adding. Records order history.

- **Remove Product**:  
  Removes a product. If none remain, auto-reorders (adds) the product if possible.

- **List Products**:  
  Returns all products currently in the fridge.

- **Order History**:  
  Returns all products ever ordered (including auto-reorders).