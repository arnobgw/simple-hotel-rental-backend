package simple.rental.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseGenerator {

    public static <T> ResponseEntity<T> success(T payload) {
        return ResponseEntity.ok().body(payload);
    }

    public static <T> ResponseEntity<T> success(T payload, HttpHeaders responseHeaders) {
        return ResponseEntity.ok().headers(responseHeaders).body(payload);
    }


    public static <T> ResponseEntity<T> failNotFound(Errors error) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("error-code", error.code.toString());
        responseHeaders.set("error-message", error.message);

        return ResponseEntity.notFound().headers(responseHeaders).build();
    }

    public static <T> ResponseEntity<T> failInvalid(Errors error) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("error-code", error.code.toString());
        responseHeaders.set("error-message", error.message);

        return ResponseEntity.badRequest().headers(responseHeaders).build();
    }

    public static ResponseEntity failConflict(Errors error) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("error-code", error.code.toString());
        responseHeaders.set("error-message", error.message);
        return ResponseEntity.status(HttpStatus.CONFLICT).headers(responseHeaders).build();
    }

    public static ResponseEntity failForbidden(Errors error) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("error-code", error.code.toString());
        responseHeaders.set("error-message", error.message);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).headers(responseHeaders).build();
    }
}
