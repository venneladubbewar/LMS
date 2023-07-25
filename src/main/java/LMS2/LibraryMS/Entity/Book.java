package LMS2.LibraryMS.Entity;

import LMS2.LibraryMS.Enum.Genre;
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

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String title;

    private  int price;
    private  boolean isIssued;

    @Enumerated(EnumType.STRING)
    Genre genre;

    @ManyToOne
    @JoinColumn
    Author author;

    @ManyToOne
    @JoinColumn
    LibraryCard card;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions=new ArrayList<>();

}
