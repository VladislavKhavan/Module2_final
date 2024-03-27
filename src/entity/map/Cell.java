package entity.map;

import entity.organism.Organism;

import java.util.Map;
import java.util.Set;
import java.lang.reflect.Type;

public class Cell {
    private final Map<Type, Set<Organism>> residents;
    public Cell(Map<Type, Set<Organism>> residents){
        this.residents = residents;
    }

    public Map<Type, Set<Organism>> getResidents() {
        return residents;
    }
}
