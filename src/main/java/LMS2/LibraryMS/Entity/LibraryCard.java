package LMS2.LibraryMS.Entity;

import LMS2.LibraryMS.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private String validTill;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @OneToOne
    @JoinColumn
    Student student;


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> books=new ArrayList<>();


    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transaction =new ArrayList<>();

}
