package LMS2.LibraryMS.Controller;

import LMS2.LibraryMS.DTO.IssuedBookRequestDto;
import LMS2.LibraryMS.DTO.IssuedBookResponseDto;
import LMS2.LibraryMS.DTO.StudentRequestDto;
import LMS2.LibraryMS.DTO.StudentResponseDto;
import LMS2.LibraryMS.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue")
    public ResponseEntity addIssued(@RequestBody IssuedBookRequestDto issuedBookRequestDto) throws Exception {

        IssuedBookResponseDto issuedBookResponseDto;
        try {
            issuedBookResponseDto = transactionService.addIssued(issuedBookRequestDto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(issuedBookResponseDto,HttpStatus.ACCEPTED);
    }
}




