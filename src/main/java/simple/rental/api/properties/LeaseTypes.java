package simple.rental.api.properties;

public enum LeaseTypes {
    RENT(0),
    PURCHASE(1),
    VENUE(2);

    public final int type;

    private LeaseTypes(int type) {
        this.type = type;
    }
}
