package simple.rental.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simple.rental.api.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}