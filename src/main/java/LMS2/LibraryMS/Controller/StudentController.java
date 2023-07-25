package LMS2.LibraryMS.Controller;

import LMS2.LibraryMS.DTO.StudentRequestDto;
import LMS2.LibraryMS.DTO.StudentResponseDto;
import LMS2.LibraryMS.DTO.StudentUpdateEmailRequestDto;
import LMS2.LibraryMS.Entity.Student;
import LMS2.LibraryMS.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return student.getName() +" added successfully";
    }

    @GetMapping("/find_by_email")
    public String findStudentByEmail(@RequestParam("email") String email)
    {
        Student student = studentService.findStudentByEmail(email);
        return student.getName();
    }

    @PutMapping("/update_email")
    public StudentResponseDto updateStudentEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
         return studentService.updateStudentEmail(studentUpdateEmailRequestDto);
    }

    @PostMapping("/addstudent_by_dto")
    public StudentResponseDto addStudentByDto(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentService.addStudentByDto(studentRequestDto);
    }


}
