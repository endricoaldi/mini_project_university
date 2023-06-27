package id.co.indivara.jdt12.university.controller;


import id.co.indivara.jdt12.university.entity.Student;

import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/findall")
    List<Student> findAllStudent(){
        return studentService.fetchStudentList();
    }
    @PostMapping("/create")
    Student createStudent(@RequestBody Student student) {
       return studentService.saveStudent(student);
    }

    @GetMapping("/find/{idStudent}")
    Student findById(@PathVariable("idStudent") Integer idStudent){
        return studentService.findById(idStudent);
    }

    @PutMapping("/update/{idStudent}")
    Student updateStudent(@RequestBody Student student, @PathVariable ("idStudent") Integer idStudent){
        return studentService.updateStudent(student, idStudent);
    }

    @DeleteMapping("/delete/{idStudent}")
    public Message deleteStudent(@PathVariable("idStudent") Integer idStudent){
        studentService.deleteStudentById(idStudent);
        return new Message(200,"Student Berhasil Dihapus") ;
    }
}