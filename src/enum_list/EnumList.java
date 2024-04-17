package enum_list;

public enum EnumList {
    BEAR, BOA, WOLF, HORSE, GRASS, SHEEP, DUCK, RABBIT, MOUSE, FOX, EAGLE, BOAR;

    public boolean isPredator() {
        return this == BEAR || this == WOLF || this == BOA || this == FOX || this == EAGLE || this == BOAR;
    }

    public boolean isVictimType() {
        return this == EnumList.HORSE || this == SHEEP || this == MOUSE || this == DUCK || this == RABBIT ||
                this == EnumList.BOA || this == EnumList.FOX;
    }
    public boolean isHerbivoreType(){
        return this == EnumList.HORSE || this == SHEEP || this == MOUSE || this == DUCK || this == RABBIT;
    }
}