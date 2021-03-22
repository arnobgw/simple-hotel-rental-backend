package simple.rental.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import simple.rental.api.entities.Property;
import simple.rental.api.entities.User;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query(value = "SELECT * FROM property p WHERE p.user_name is null or p.user_name = ''", nativeQuery = true )
    List<Property> findAllAvailableProperties();

    @Query(value = "SELECT * FROM property p WHERE (p.user_name is null or p.user_name = '') and lease_Type = 0", nativeQuery = true )
    List<Property> findAllAvailableRentProperties();

    @Query(value = "SELECT * FROM property p WHERE (p.user_name is null or p.user_name = '') and lease_Type = 1", nativeQuery = true )
    List<Property> findAllAvailablePurchaseProperties();

    @Query(value = "SELECT * FROM property p WHERE (p.user_name is null or p.user_name = '') and lease_Type = 2", nativeQuery = true )
    List<Property> findAllAvailableVenueProperties();

    @Query(value = "SELECT * FROM property p WHERE  lease_Type = 0", nativeQuery = true )
    List<Property> findAllRentProperties();

    @Query(value = "SELECT * FROM property p WHERE  lease_Type = 1", nativeQuery = true )
    List<Property> findAllPurchaseProperties();

    @Query(value = "SELECT * FROM property p WHERE  lease_Type = 2", nativeQuery = true )
    List<Property> findAllVenueProperties();
}
