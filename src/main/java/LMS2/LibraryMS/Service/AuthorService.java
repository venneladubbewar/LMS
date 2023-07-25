package LMS2.LibraryMS.Service;

import LMS2.LibraryMS.DTO.AuthorRequestDto;
import LMS2.LibraryMS.DTO.AuthorResponseDto;
import LMS2.LibraryMS.Entity.Author;
import LMS2.LibraryMS.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto)
    {
        Author author=new Author();

        author.setName(authorRequestDto.getName());
        author.setMobNo(authorRequestDto.getMobNo());
        author.setAge(authorRequestDto.getAge());
        author.setEmail(authorRequestDto.getEmail());

        authorRepository.save(author);

        AuthorResponseDto authorResponseDto=new AuthorResponseDto();

        authorResponseDto.setMobNo(author.getMobNo());
        authorResponseDto.setName(author.getName());

        return authorResponseDto;
    }
}
