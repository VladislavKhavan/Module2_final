package entity.organism;

import abstraction.Reproducible;
import enum_list.EnumList;

public abstract class Organism implements Reproducible {
    private EnumList model;

    public Organism(EnumList model){
        this.model = model;
    }

    public EnumList getModel() {
        return model;
    }

}
