package LMS2.LibraryMS.Controller;

import LMS2.LibraryMS.DTO.BookRequestDto;
import LMS2.LibraryMS.DTO.BookResponseDto;
import LMS2.LibraryMS.Entity.Book;
import LMS2.LibraryMS.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

//    @PostMapping("/add")
//    public String addBook(@RequestBody Book book){
//        try{
//            bookService.addBook(book);
//        }catch (Exception e){
//            throw new RuntimeException(e.getMessage()+" Book not added");
//        }
//
//        return book.getTitle()+" Added successfully";

    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto);
    }
}
