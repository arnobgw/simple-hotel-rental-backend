package simple.rental.api.controllers;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simple.rental.api.Errors;
import simple.rental.api.ResponseGenerator;
import simple.rental.api.entities.Property;
import simple.rental.api.entities.URL;
import simple.rental.api.entities.User;
import simple.rental.api.services.PropertyService;
import simple.rental.api.session.Session;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    private Session session = Session.getInstance();

    @GetMapping("/properties")
    public ResponseEntity getAllProperties(@RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.getPropertyList());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @GetMapping("/properties/{id}")
    public ResponseEntity getPropertyById(@PathVariable("id") long id, @RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {

            Optional<Property> recordedProperty = propertyService.getPropertyById(id);

            if (!recordedProperty.isPresent()) {
                return ResponseGenerator.failNotFound(Errors.PROPERTY_NOT_FOUND);
            }

            return ResponseGenerator.success(recordedProperty.get());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @GetMapping("/properties/available")
    public ResponseEntity getAllAvailableProperties(@RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.getAvailablePropertyList());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @GetMapping("/properties/rent")
    public ResponseEntity getAllRentProperties(@RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.getRentPropertyList());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @GetMapping("/properties/purchase")
    public ResponseEntity getAllPurchaseProperties(@RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.getPurchasePropertyList());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @GetMapping("/properties/venue")
    public ResponseEntity getAllVenueProperties(@RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.getVenuePropertyList());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @GetMapping("/properties/rent/available")
    public ResponseEntity getAllAvailableRentProperties(@RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.getAvailableRentPropertyList());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @GetMapping("/properties/purchase/available")
    public ResponseEntity getAllAvailablePurchaseProperties(@RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.getAvailablePurchasePropertyList());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @GetMapping("/properties/venue/available")
    public ResponseEntity getAllAvailableVenueProperties(@RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.getAvailableVenuePropertyList());
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @PostMapping("/properties")
    public ResponseEntity addProperty(@RequestBody() Property property, @RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getAdmin(sessionId);

        property.setId(null);
        UrlValidator urlValidator = new UrlValidator();
        for (String str : property.getPictureUrls()) {
            if (!urlValidator.isValid(str)) {
                return ResponseGenerator.failInvalid(Errors.INVALID_IMAGE_URL);
            }
        }

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.saveProperty(property));
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @PatchMapping("/properties/{id}")
    public ResponseEntity updateProperty(@PathVariable("id") long id, @RequestBody() Property property, @RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getAdmin(sessionId);

        Optional<Property> recordedProperty = propertyService.getPropertyById(id);

        if (!recordedProperty.isPresent()) {
            return ResponseGenerator.failNotFound(Errors.PROPERTY_NOT_FOUND);
        }

        UrlValidator urlValidator = new UrlValidator();
        if (property.getPictureUrls() != null) {
            for (String str : property.getPictureUrls()) {
                if (!urlValidator.isValid(str)) {
                    return ResponseGenerator.failInvalid(Errors.INVALID_IMAGE_URL);
                }
            }
        }

        recordedProperty.get().setValuesFromProperty(property);

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.saveProperty(recordedProperty.get()));
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @PostMapping("/properties/url/{id}")
    public ResponseEntity addUrl(@PathVariable("id") long id, @RequestBody() URL url, @RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getAdmin(sessionId);

        Optional<Property> recordedProperty = propertyService.getPropertyById(id);

        if (!recordedProperty.isPresent()) {
            return ResponseGenerator.failNotFound(Errors.PROPERTY_NOT_FOUND);
        }

        UrlValidator urlValidator = new UrlValidator();
        if (!urlValidator.isValid(url.getUrl())) {
            return ResponseGenerator.failInvalid(Errors.INVALID_IMAGE_URL);
        }

        recordedProperty.get().getPictureUrls().add(url.getUrl());

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.saveProperty(recordedProperty.get()));
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @DeleteMapping("/properties/url/{id}")
    public ResponseEntity deleteUrl(@PathVariable("id") long id, @RequestBody() URL url, @RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getAdmin(sessionId);

        Optional<Property> recordedProperty = propertyService.getPropertyById(id);

        if (!recordedProperty.isPresent()) {
            return ResponseGenerator.failNotFound(Errors.PROPERTY_NOT_FOUND);
        }

        if (!recordedProperty.get().getPictureUrls().contains(url.getUrl())) {
            return ResponseGenerator.failNotFound(Errors.URL_NOT_FOUND);
        }

        recordedProperty.get().getPictureUrls().remove(url.getUrl());

        if (user.isPresent()) {
            return ResponseGenerator.success(propertyService.saveProperty(recordedProperty.get()));
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity deleteProperty(@PathVariable("id") long id, @RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getAdmin(sessionId);

        Optional<Property> recordedProperty = propertyService.getPropertyById(id);

        if (!recordedProperty.isPresent()) {
            return ResponseGenerator.failNotFound(Errors.PROPERTY_NOT_FOUND);
        }

        if (!(recordedProperty.get().getUserName() == null || recordedProperty.get().getUserName().isEmpty())) {
            return ResponseGenerator.failConflict(Errors.PROPERTY_BOOKED_BY_USER);
        }

        if (user.isPresent()) {
            propertyService.deleteProperty(id);

            return ResponseGenerator.success("ok");
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }

    @PostMapping("/properties/{id}/assign/{date}")
    public ResponseEntity assignUser(@PathVariable("id") long id, @PathVariable("date") long date, @RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        Optional<Property> recordedProperty = propertyService.getPropertyById(id);

        if (!recordedProperty.isPresent()) {
            return ResponseGenerator.failNotFound(Errors.PROPERTY_NOT_FOUND);
        }

        Date endDate = new Date(date);

        if (date != 0) {
            if (date <= new Date().getTime()) {
                return ResponseGenerator.failConflict(Errors.INVALID_END_DATE);
            }
        }

        if (recordedProperty.get().getUserName() != null && !recordedProperty.get().getUserName().isEmpty()) {
            return ResponseGenerator.failConflict(Errors.PROPERTY_BOOKED_BY_USER);
        }


        if (user.isPresent()) {
            recordedProperty.get().setUserName(user.get().getUserName());
            recordedProperty.get().setLeaseStartDate(new Date().getTime());
            recordedProperty.get().setLeaseEndDate(date);

            return ResponseGenerator.success(propertyService.saveProperty(recordedProperty.get()));
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }


    @PatchMapping("/properties/{id}/release")
    public ResponseEntity assignUser(@PathVariable("id") long id, @RequestHeader("session-id") UUID sessionId) {
        Optional<User> user = session.getUser(sessionId);

        Optional<Property> recordedProperty = propertyService.getPropertyById(id);

        if (!recordedProperty.isPresent()) {
            return ResponseGenerator.failNotFound(Errors.PROPERTY_NOT_FOUND);
        }

        if (recordedProperty.get().getUserName() != null && !recordedProperty.get().getUserName().isEmpty()) {
            if (!recordedProperty.get().getUserName().equals(user.get().getUserName())) {
                return ResponseGenerator.failForbidden(Errors.PROPERTY_BOLONGS_TO_ANOTHER_USER);
            }
        }

        if (user.isPresent()) {
            recordedProperty.get().setUserName(null);
            recordedProperty.get().setLeaseStartDate(null);
            recordedProperty.get().setLeaseEndDate(null);
            return ResponseGenerator.success(propertyService.saveProperty(recordedProperty.get()));
        } else {
            return ResponseGenerator.failForbidden(Errors.SESSION_TIMEOUT);
        }
    }


}
