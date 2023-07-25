package LMS2.LibraryMS.Service;

import LMS2.LibraryMS.DTO.BookRequestDto;
import LMS2.LibraryMS.DTO.BookResponseDto;
import LMS2.LibraryMS.Entity.Author;
import LMS2.LibraryMS.Entity.Book;
import LMS2.LibraryMS.Repository.AuthorRepository;
import LMS2.LibraryMS.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    @Autowired
    AuthorRepository authorRepository;

//    public void addBook(Book book){
//        Author author;
//        try{
//            author= authorRepository.findById(book.getAuthor().getId()).get();
//
//        } catch (Exception e){
//            throw new RuntimeException(e.getMessage()+"Author not found, Book not added");
//        }
//
//        List<Book> writtenBooks = author.getBooks();
//        writtenBooks.add(book);
//
//        authorRepository.save(author);


    public BookResponseDto addBook(BookRequestDto bookRequestDto){
        Book book=new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIssued(false);

        Author author =authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);

        author.getBooks().add(book);
        authorRepository.save(author);

        BookResponseDto bookResponseDto=new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setTitle(book.getTitle());

        return bookResponseDto;


    }

}
