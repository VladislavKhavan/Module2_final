package entity.map;

import entity.organism.Organism;
import enum_list.EnumList;

import java.util.Map;
import java.util.Set;

public class Cell {
    private final Map<EnumList, Set<Organism>> residents;
    public Cell(Map<EnumList, Set<Organism>> residents){
        this.residents = residents;
    }
    public void addOrganism(Organism organism){
    }

    public Map<EnumList, Set<Organism>> getResidents() {
        return residents;
    }
}
