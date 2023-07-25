package LMS2.LibraryMS.Entity;

import LMS2.LibraryMS.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private int age;
    @Column(unique = true)
    private  String email;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LibraryCard card;


}
