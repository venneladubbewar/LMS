package LMS2.LibraryMS.Repository;

import LMS2.LibraryMS.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {
}
