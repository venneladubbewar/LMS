package LMS2.LibraryMS.DTO;

import LMS2.LibraryMS.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {

    private int price;
    private Genre genre;

    private int authorId;

    private String title;

}
