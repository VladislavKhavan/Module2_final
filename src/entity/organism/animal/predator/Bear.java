package entity.organism.animal.predator;

import abstraction.Movable;
import entity.map.GameField;
import enum_list.EnumList;

import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator implements Runnable {
    public static final String ICON = "🐻";

    @Override
    public String getIcon() {
        return ICON;
    }

    public Bear(EnumList model) {
        super(model);
        this.maxStep = 2;
        this.maxAmount = 5;
    }
}


