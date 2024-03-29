package entity.organism.animal;

import abstraction.Eatable;
import abstraction.Movable;
import abstraction.Reproducible;
import entity.organism.Organism;
import enum_list.EnumList;

public abstract class Animal extends Organism implements Movable, Reproducible, Eatable {

    public Animal(EnumList model) {
        super(model);
    }
    public void move(){

    }
    public Organism reproduce(){
        return null;
    }
    public void eat(){

    }

}


