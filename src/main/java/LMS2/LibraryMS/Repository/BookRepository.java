package LMS2.LibraryMS.Repository;

import LMS2.LibraryMS.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
