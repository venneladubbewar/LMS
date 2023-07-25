package LMS2.LibraryMS.Service;

import LMS2.LibraryMS.DTO.StudentRequestDto;
import LMS2.LibraryMS.DTO.StudentResponseDto;
import LMS2.LibraryMS.DTO.StudentUpdateEmailRequestDto;
import LMS2.LibraryMS.Entity.LibraryCard;
import LMS2.LibraryMS.Entity.Student;
import LMS2.LibraryMS.Enum.CardStatus;
import LMS2.LibraryMS.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student)
    {
        studentRepository.save(student);
    }

    public Student findStudentByEmail(String email){
        Student student=studentRepository.findByEmail(email);
        return student;
    }

    public StudentResponseDto updateStudentEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        Student student=studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());
        studentRepository.save(student);
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setName(student.getName());
        return studentResponseDto;
    }
    public StudentResponseDto addStudentByDto(@RequestBody StudentRequestDto studentRequestDto){
        Student student= new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        LibraryCard card=new LibraryCard();
        card.setStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        StudentResponseDto studentResponseDto= new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setId(student.getId());
        return studentResponseDto;

    }

}
