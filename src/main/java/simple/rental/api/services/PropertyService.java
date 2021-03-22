package simple.rental.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simple.rental.api.entities.Property;
import simple.rental.api.repositories.PropertyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    public List<Property> getPropertyList() {
        return propertyRepository.findAll();
    }

    public List<Property> getAvailablePropertyList() {
        return propertyRepository.findAllAvailableProperties();
    }

    public List<Property> getAvailableRentPropertyList() {
        return propertyRepository.findAllAvailableRentProperties();
    }

    public List<Property> getAvailablePurchasePropertyList() {
        return propertyRepository.findAllAvailablePurchaseProperties();
    }

    public List<Property> getAvailableVenuePropertyList() {
        return propertyRepository.findAllAvailableVenueProperties();
    }

    public List<Property> getRentPropertyList() {
        return propertyRepository.findAllRentProperties();
    }

    public List<Property> getPurchasePropertyList() {
        return propertyRepository.findAllPurchaseProperties();
    }

    public List<Property> getVenuePropertyList() {
        return propertyRepository.findAllVenueProperties();
    }

    public void updateProperty(Property property) {
        propertyRepository.save(property);
    }

    public Property saveProperty(Property property) {
        Property toReturn = propertyRepository.save(property);
        return toReturn;
    }

    public void deleteProperty(long id) {
        propertyRepository.deleteById(id);
    }
}
