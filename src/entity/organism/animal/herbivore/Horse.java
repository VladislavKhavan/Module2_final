package entity.organism.animal.herbivore;

import entity.organism.Organism;
import enum_list.EnumList;

public class Horse extends Herbivore{
    public static final String ICON = "🐎";
    public Horse(EnumList model) {
        super(model);
    }
    @Override
    public Organism reproduce() {
        return null;
    }
}
