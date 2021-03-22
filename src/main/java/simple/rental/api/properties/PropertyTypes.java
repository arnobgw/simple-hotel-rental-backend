package simple.rental.api.properties;

public enum PropertyTypes {
    HOUSE(0),
    FLAT(1),
    FLAT_SUBLET(2),
    APARTMENT(3),
    PLOT(4),
    HOSTEL(5),
    OFFICE(6),
    SHOP(7),
    BUSINESS(8),
    COMMUNITY_CENTER(9),
    SHOPPING_MALL(10);

    public final int type;

    private PropertyTypes(int type) {
        this.type = type;
    }
}
