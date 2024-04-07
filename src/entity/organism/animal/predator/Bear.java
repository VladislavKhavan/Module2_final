package entity.organism.animal.predator;

import abstraction.Movable;
import entity.map.GameField;
import enum_list.EnumList;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Predator implements Runnable {
    public static final String ICON = "🐻";

    public static final int PROP_HORSE = 60;

    public void eat(){
        eatBear();
    }

    @Override
    public String getIcon() {
        return ICON;
    }
    public void eatBear(){
        int number = ThreadLocalRandom.current().nextInt(0, 101);
        if(number >= PROP_HORSE){
            super.eat();
        }

    }

    public Bear(EnumList model) {
        super(model);
        this.maxStep = 2;
        this.cellAmount = 5;
        this.weight = 500;
    }
}


