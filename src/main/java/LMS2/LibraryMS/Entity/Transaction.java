package LMS2.LibraryMS.Entity;

import LMS2.LibraryMS.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionNo;

    @CreatedDate
    private Date trancsactionDate;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @CreationTimestamp
    private Date transactionDate;
    private boolean isIssueOperation;

    private String message;

    @ManyToOne
    @JoinColumn
    LibraryCard card;

    @ManyToOne
    @JoinColumn
    Book book;


}
