package simple.rental.api.session;

import simple.rental.api.entities.User;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class SessionBean {
    private static final Long TIME_OUT = 12000000l;

    private UUID sessionId;
    private User user;
    private Long timeStamp;

    private SessionBean() {
    }

    public static SessionBean getSessionBean(User user) {
        SessionBean sessionBean = new SessionBean();
        sessionBean.sessionId = UUID.randomUUID();
        sessionBean.user = user;
        sessionBean.timeStamp = new Date().getTime();
        return sessionBean;
    }

    public boolean isAlive() {
        Long latestTime = new Date().getTime();
        if (timeStamp + TIME_OUT >= latestTime) {
            timeStamp = latestTime;
            return true;
        }

        return false;
    }

    public void kill() {
        timeStamp = 0l;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public Optional<User> getUser() {
        Optional<User> toReturn = Optional.empty();

        if (isAlive()) {
            toReturn = Optional.of(user);
        }
        return toReturn;
    }
}

