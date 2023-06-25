package id.co.indivara.jdt12.university.service;

import id.co.indivara.jdt12.university.entity.Student;

import java.util.List;

public interface StudentService {
    //POST : /student
    Student saveStudent(Student student);
    //GET : /student
    List<Student> fetchStudentList();
    //GET : /student/find/{idStudent}
    Student findById(Integer idStudent);
    //PUT : /student/{idStudent}
    Student updateStudent(Student student, Integer idStudent);
    //DELETE : /student/{idStudent}
    void deleteStudentById(Integer idStudent);
}
