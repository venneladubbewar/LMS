package LMS2.LibraryMS.Repository;

import LMS2.LibraryMS.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
