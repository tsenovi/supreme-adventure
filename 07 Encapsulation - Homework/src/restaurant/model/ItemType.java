package restaurant.model;

public enum ItemType {
    FOOD, DRINK, NO_TYPE;

    public static ItemType getItemTypeByTextInput(String typeInput) {
        for (ItemType value : ItemType.values()) {
            if(typeInput.equalsIgnoreCase(String.valueOf(value))) return value;
        }
        return NO_TYPE;
    }
}
