package LMS2.LibraryMS.DTO;

import LMS2.LibraryMS.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssuedBookResponseDto {

    private String bookName;
    private String transactionId;

    private TransactionStatus transactionStatus;
}
