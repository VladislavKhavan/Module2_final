package app;

import entity.map.GameField;
import entity.organism.animal.predator.Bear;
import enum_list.EnumList;

public class Main {
    public static void main(String[] args) {
        GameField gameField = new GameField(10, 10);
        gameField.addOrganism(5);
        gameField.displayField();
    }
}
