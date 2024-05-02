package entity.organism.plant;

import entity.organism.Organism;
import enum_list.EnumList;

public class Grass extends Plant {
    public static final String ICON = "🌱";
    public static final int weight = 1;
    @Override
    public String getIcon() {
        return ICON;
    }

    public Grass(EnumList model) {
        super(model);
    }

}

