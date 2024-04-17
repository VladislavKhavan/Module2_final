package enum_list;

public enum EnumList {
    BEAR, BOA, WOLF, HORSE, GRASS, SHEEP, DUCK, RABBIT, MOUSE, FOX, EAGLE, BOAR, DEER, GOAT, BUFFALO, WORM;

    public boolean isPredator() {
        return this == BEAR || this == WOLF || this == BOA || this == FOX || this == EAGLE || this == BOAR;
    }

    public boolean isVictimType() {
        return this == HORSE || this == SHEEP || this == MOUSE || this == DUCK || this == RABBIT ||
                this == BOA || this == FOX || this == DEER || this == GOAT;
    }
    public boolean isHerbivoreType(){
        return this == HORSE || this == SHEEP || this == MOUSE || this == DUCK || this == RABBIT || this == DEER ||
                this == BUFFALO || this == WORM;
    }
}