package entity.organism;

import abstraction.Reproducible;
import entity.map.Cell;
import entity.map.GameField;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Bear;
import enum_list.EnumList;

public abstract class Organism implements Reproducible {
    protected int x;
    protected int maxAmount;
    protected int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    private EnumList model;
    public abstract String getIcon();

    public Organism(EnumList model){
        this.model = model;
    }


    public Organism() {

    }

    public EnumList getModel() {
        return model;
    }

}
