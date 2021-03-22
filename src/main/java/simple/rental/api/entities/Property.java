package simple.rental.api.entities;

import simple.rental.api.properties.LeaseTypes;
import simple.rental.api.properties.PropertyTypes;
import simple.rental.api.properties.TimeUnits;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Property {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private PropertyTypes propertyType;
    private LeaseTypes leaseType;
    private String address;
    private String contactPerson;
    private String contactPhone;
    private String userName;
    private Long leaseStartDate;
    private Long leaseEndDate;
    private String cost;
    private TimeUnits timeUnit;

    @ElementCollection
    private List<String> pictureUrls;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyTypes getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyTypes propertyType) {
        this.propertyType = propertyType;
    }

    public LeaseTypes getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(LeaseTypes leaseType) {
        this.leaseType = leaseType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public TimeUnits getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnits timeUnit) {
        this.timeUnit = timeUnit;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(Long leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public Long getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(Long leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public void setValuesFromProperty(Property property) {
        if (property.name != null) name = property.name;
        if (property.propertyType != null) propertyType = property.propertyType;
        if (property.leaseType != null) leaseType = property.leaseType;
        if (property.address != null) address = property.address;
        if (property.contactPerson != null) contactPerson = property.contactPerson;
        if (property.contactPhone != null) contactPhone = property.contactPhone;
        if (property.userName != null) userName = property.userName;
        if (property.leaseStartDate != null) leaseStartDate = property.leaseStartDate;
        if (property.leaseEndDate != null) leaseEndDate = property.leaseEndDate;
        if (property.cost != null) cost = property.cost;
        if (property.timeUnit != null) timeUnit = property.timeUnit;
        if (property.pictureUrls != null) pictureUrls = property.pictureUrls;
    }
}
