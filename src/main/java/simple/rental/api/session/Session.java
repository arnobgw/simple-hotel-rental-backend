package simple.rental.api.session;

import simple.rental.api.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class Session {
    private static Session singleInstance = null;

    private Map<UUID, SessionBean> sessionBeanMap;

    private Session() {
        sessionBeanMap = new HashMap<>();
    }

    public static Session getInstance() {
        if (singleInstance == null) {
            singleInstance = new Session();
        }
        return singleInstance;
    }

    public void invalidateSession() {
        sessionBeanMap = new HashMap<>();
    }

    public SessionBean create(User user) {
        SessionBean sessionBean = SessionBean.getSessionBean(user);
        sessionBeanMap.put(sessionBean.getSessionId(), sessionBean);
        return sessionBean;
    }

    public void invalidate(UUID uuid) {
        SessionBean sessionBean = sessionBeanMap.get(uuid);
        sessionBean.kill();
        sessionBeanMap.remove(uuid);
    }

    public Optional<User> getUser(UUID sessionId) {
        SessionBean sessionBean = sessionBeanMap.get(sessionId);
        if (sessionBean != null) {
            return sessionBean.getUser();
        }

        return Optional.empty();
    }

    public Optional<User> getAdmin(UUID sessionId) {
        SessionBean sessionBean = sessionBeanMap.get(sessionId);
        if (sessionBean != null && sessionBean.getUser().isPresent() && sessionBean.getUser().get().getUserName().toLowerCase().equals("admin")) {
            return sessionBean.getUser();
        }

        return Optional.empty();
    }
}
