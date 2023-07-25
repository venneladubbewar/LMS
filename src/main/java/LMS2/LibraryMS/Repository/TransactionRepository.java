package LMS2.LibraryMS.Repository;

import LMS2.LibraryMS.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
