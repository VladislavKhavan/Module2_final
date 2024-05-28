package app;

import entity.map.GameField;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Bear;
import enum_list.EnumList;
import game_simulation.GameSimulation;

public class Main {
    public static void main(String[] args) {
        GameSimulation simulation = new GameSimulation();
        simulation.startSimulation();
    }

}


