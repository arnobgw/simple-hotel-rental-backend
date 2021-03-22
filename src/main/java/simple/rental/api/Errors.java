package simple.rental.api;

public enum Errors {
    NULL("", 0),
    INVALID_USER_NAME("Invalid user name. spaces and spacial characters are not allowed", 1001),
    DUPLICATE_USER_NAME("User name already exists", 1002),
    DUPLICATE_EMAIL("Email already exists", 1003),
    BLANK_USER_NAME("User name can't be blank", 1004),
    BLANK_PASSWORD("Blank passwords are not allowed", 1005),
    INVALID_CREDENTIALS("Invalid user name or password", 1006),
    BLANK_EMAIL("Email can't be blank", 1007),

    SESSION_TIMEOUT("Invalid session id.", 2001),
    INVALID_IMAGE_URL("Invalid image url.", 2002),
    PROPERTY_NOT_FOUND("Property not found.", 2003),
    URL_NOT_FOUND("Url not found.", 2004),
    PROPERTY_BOOKED_BY_USER("Property used/purchased/rented by user.", 2005),
    INVALID_END_DATE("Invalid end date", 2006),
    PROPERTY_BOLONGS_TO_ANOTHER_USER("Property belongs to another user", 2007);

    public final String message;
    public final Integer code;

    private Errors(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
