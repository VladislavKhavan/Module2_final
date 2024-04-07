package entity.organism.animal.herbivore;

import entity.map.GameField;
import entity.organism.Organism;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Horse extends Herbivore implements Runnable {
    public static final String ICON = "🐎";

    @Override
    public String getIcon() {
        return ICON;
    }

    public Horse(EnumList model) {
        super(model);
        this.maxStep = 4;
        this.cellAmount = 20;
        this.weight = 400;
    }
}
