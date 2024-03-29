package entity.organism.plant;

import entity.organism.Organism;
import enum_list.EnumList;

public class Grass extends Plant {
    public Grass(EnumList model) {
        super(model);
    }
    @Override
    public Organism reproduce() {
        return null;
    }
}
