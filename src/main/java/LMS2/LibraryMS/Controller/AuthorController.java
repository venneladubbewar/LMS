package LMS2.LibraryMS.Controller;

import LMS2.LibraryMS.DTO.AuthorRequestDto;
import LMS2.LibraryMS.DTO.AuthorResponseDto;
import LMS2.LibraryMS.Entity.Author;
import LMS2.LibraryMS.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto)
    {
        return authorService.addAuthor(authorRequestDto);














    }
}
