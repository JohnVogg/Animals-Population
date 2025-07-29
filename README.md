# Predator-Prey Simulation in Java 🦊🐰

This project simulates the evolution of a population of predators (foxes) and prey (rabbits) within a 2D grid using Java.

## Description

The simulation is based on a 20×20 two-dimensional grid where each cell can contain **at most one animal** (either a fox or a rabbit). Time progresses in discrete steps, and each animal performs certain actions during each step.

### Animal Behavior

#### 🐰 Rabbits

- **Movement:**  
  In each step, a rabbit chooses a random neighboring cell (up, down, left, right). If the cell is empty, it moves there; otherwise, it stays in its current position.

- **Reproduction:**  
  Every 3 steps of survival, a rabbit attempts to reproduce by creating a new rabbit in an adjacent empty cell.  
  - If no empty neighboring cell is available, the reproduction fails.
  - Regardless of success, the next reproduction attempt occurs after 3 more steps.

#### 🦊 Foxes

- **Movement & Hunting:**  
  In each step:
  - If there is a rabbit in a neighboring cell, the fox moves to that cell and **eats the rabbit**.
  - If not, the fox moves like a rabbit (to a random adjacent empty cell, if any).

- **Reproduction:**  
  Every 8 steps of survival, a fox attempts to reproduce in the same way as rabbits.

- **Starvation:**  
  If a fox fails to eat a rabbit for **3 consecutive steps**, it **dies of starvation** and is removed from the grid.

## Rules Summary

| Behavior        | Rabbit        | Fox                          |
|----------------|---------------|-------------------------------|
| Movement        | Random empty neighbor | Towards rabbit or random empty neighbor |
| Reproduction    | Every 3 steps | Every 8 steps                |
| Death           | Die from a fox            | After 3 steps of not eating  |

## Implementation Details

- The simulation runs in discrete time steps.
- Grid size is fixed at 20x20.
- Animals cannot leave the grid.
- Only one animal per grid cell.
- Neighboring cells are those directly adjacent (not diagonal).

## Technologies

- Java
- Object-Oriented Programming

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/animals-population.git
   cd animals-population
