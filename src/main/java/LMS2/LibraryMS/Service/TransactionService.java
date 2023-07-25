package LMS2.LibraryMS.Service;

import LMS2.LibraryMS.DTO.IssuedBookRequestDto;
import LMS2.LibraryMS.DTO.IssuedBookResponseDto;
import LMS2.LibraryMS.DTO.StudentRequestDto;
import LMS2.LibraryMS.DTO.StudentResponseDto;
import LMS2.LibraryMS.Entity.Book;
import LMS2.LibraryMS.Entity.LibraryCard;
import LMS2.LibraryMS.Entity.Transaction;
import LMS2.LibraryMS.Enum.CardStatus;
import LMS2.LibraryMS.Enum.TransactionStatus;
import LMS2.LibraryMS.Repository.BookRepository;
import LMS2.LibraryMS.Repository.CardRepository;
import LMS2.LibraryMS.Repository.TransactionRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    @Autowired
    private JavaMailSender emailSender;
    public IssuedBookResponseDto addIssued(IssuedBookRequestDto issuedBookRequestDto) throws Exception {
        LibraryCard card;
        Book book;
        Transaction transaction = new Transaction();
        transaction.setTransactionNo(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        try{
            card = cardRepository.findById(issuedBookRequestDto.getCardId()).get();
        }catch (Exception e){
            transaction.setIssueOperation(false);
            transaction.setStatus(TransactionStatus.FAILED);
            transaction.setMessage("Card not valid");
            transactionRepository.save(transaction);
            throw  new Exception("Card Not valid");
        }
        try{
            book = bookRepository.findById(issuedBookRequestDto.getBookId()).get();
        }catch (Exception e){
            transaction.setIssueOperation(false);
            transaction.setStatus(TransactionStatus.FAILED);
            transaction.setMessage("Book not valid");
            transactionRepository.save(transaction);
            throw  new Exception("Book Not valid");
        }
        transaction.setBook(book);
        transaction.setCard(card);
        if(card.getStatus() != CardStatus.ACTIVATED){
            transaction.setIssueOperation(false);
            transaction.setStatus(TransactionStatus.FAILED);
            transaction.setMessage("Card not Activated");
            transactionRepository.save(transaction);
            throw  new Exception("Card not Activated");
        }

        if(book.isIssued()){
            transaction.setIssueOperation(false);
            transaction.setStatus(TransactionStatus.FAILED);
            transaction.setMessage("Book not available");
            transactionRepository.save(transaction);
            throw  new Exception("Book Not available");
        }

        transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction successfully completed ");
        book.setIssued(true);
        book.setCard(card);
        book.getTransactions().add(transaction);
        card.getTransaction().add(transaction);
        card.getBooks().add(book);


        cardRepository.save(card);

        IssuedBookResponseDto issuedBookResponseDto=new IssuedBookResponseDto();
        issuedBookResponseDto.setBookName(book.getTitle());
        issuedBookResponseDto.setTransactionId(transaction.getTransactionNo());
        issuedBookResponseDto.setTransactionStatus(transaction.getStatus());

        String text = "Conggo... U have been got Book. ";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kiran.dubbewar18@gmail.com");
        message.setTo(card.getStudent().getEmail());
        message.setSubject("Issued Book Notification");
        message.setText(text);
        emailSender.send(message);

        return issuedBookResponseDto;


    }

}
































