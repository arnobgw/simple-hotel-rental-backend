package simple.rental.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple.rental.api.Errors;
import simple.rental.api.ResponseGenerator;
import simple.rental.api.entities.User;
import simple.rental.api.services.UserService;
import simple.rental.api.session.Session;
import simple.rental.api.session.SessionBean;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    private Session session = Session.getInstance();

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody() User userCred) {
        User user = userService.findByUserNameAndPassword(userCred.getUserName(), userCred.getPassword());

        if (user != null) {
            HttpHeaders responseHeaders = new HttpHeaders();
            SessionBean sessionBean = session.create(user);
            responseHeaders.add("session-id", sessionBean.getSessionId().toString());
            if (user.getUserName().toLowerCase().equals("admin")) {
                responseHeaders.add("is-admin", "true");

            }

            return ResponseGenerator.success(user, responseHeaders);
        } else {
            return ResponseGenerator.failNotFound(Errors.INVALID_CREDENTIALS);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("session-id") UUID sessionId) {
        session.invalidate(sessionId);
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody() User user) {
        if (!isValidUserName(user.getUserName())) {
            return ResponseGenerator.failInvalid(Errors.INVALID_USER_NAME);
        }
        if (user.getEmail().trim().equals("")) {
            return ResponseGenerator.failInvalid(Errors.BLANK_EMAIL);
        }
        if (user.getPassword().trim().equals("")) {
            return ResponseGenerator.failInvalid(Errors.BLANK_PASSWORD);
        }

        Optional<User> optional = userService.getUserByEmail(user.getEmail());

        if (optional.isPresent()) {
            return ResponseGenerator.failConflict(Errors.DUPLICATE_EMAIL);
        }

        optional = userService.getUserById(user.getUserName());

        if (optional.isPresent()) {
            return ResponseGenerator.failConflict(Errors.DUPLICATE_USER_NAME);
        } else {
            userService.register(user);
            return ResponseGenerator.success(user);
        }
    }

    public static boolean isValidUserName(String name) {
        String regex = "^[a-zA-Z_$][a-zA-Z_$0-9]*$";
        Pattern p = Pattern.compile(regex);

        if (name == null) {
            return false;
        }

        Matcher m = p.matcher(name);
        return m.matches();
    }
}