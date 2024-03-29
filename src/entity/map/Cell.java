package entity.map;

import entity.organism.Organism;
import entity.organism.animal.herbivore.Horse;
import entity.organism.animal.predator.Bear;
import enum_list.EnumList;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cell {
    private final Map<EnumList, Set<Organism>> residents;

    public Cell(Map<EnumList, Set<Organism>> residents){
        this.residents = residents;
    }

    public void addOrganism(Organism organism){
        EnumList model = organism.getModel();
        if(!residents.containsKey(model)){
            residents.put(model, new HashSet<>());
        }
        residents.get(model).add(organism);
    }
    public String display(){
        if(residents.isEmpty()){
            return ".";
        }
        else{
            EnumList enumList = residents.keySet().iterator().next();
                switch (enumList){
                    case BEAR:
                        return Bear.ICON;
                    case HORSE:
                        return Horse.ICON;
                    default:
                        return null;
                }
        }
    }

    public Map<EnumList, Set<Organism>> getResidents() {
        return residents;
    }
}
