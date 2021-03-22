package simple.rental.api.properties;

public enum TimeUnits {
    NONE(0),
    DAY(1),
    WEEK(2),
    MONTH(3),
    YEAR(4);

    public final int type;

    private TimeUnits(int type) {
        this.type = type;
    }
}
