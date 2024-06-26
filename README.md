This project is a simulation of an island ecosystem with various animals and plants. The island consists of a grid of locations (e.g., 100x20 cells) filled with plants and animals. Animals can:

Eat plants and/or other animals (if suitable food is available in their location),
Move to adjacent locations,
Reproduce (if a mate is available in the location),
Die of starvation or be eaten.
Features
Object-Oriented Programming (OOP)
Animal Hierarchy: All animal species are derived from an abstract class Animal, which contains common behavior for all animals. Specific species override methods for unique behaviors related to feeding, reproduction, and movement.
Plant Class: Represents plants on the island.
Multithreading
Scheduled Thread Pool: Used for periodically executing tasks such as plant growth, animal life cycles, and system statistics display.
Thread Pool: Used for executing animal life cycle tasks.
Simulation Parameters
Animal Characteristics: Each species has unique characteristics such as weight, maximum population per cell, movement speed, and food requirements.
Predation Probabilities: Animals have specific probabilities of eating other animals or plants, defined in a probability table.
The simulation runs in the console, displaying the state of the island at each simulation step, including the number of animals and plants in each location.
Optional Features
Custom Parameters: All parameters are centralized in a configuration file for easy simulation management.
Graphical Output: Optionally, implement graphical output using JavaFX or Swing for a more visual representation of the simulation.
Additional Factors: Expand the simulation with more animal species, different plant types, custom animal behaviors, and terrain features like rivers that affect movement.
