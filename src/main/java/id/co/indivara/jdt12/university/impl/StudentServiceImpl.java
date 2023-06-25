package id.co.indivara.jdt12.university.impl;


import id.co.indivara.jdt12.university.entity.Student;
import id.co.indivara.jdt12.university.exception.CanNotFindException;
import id.co.indivara.jdt12.university.repo.StudentRepository;
import id.co.indivara.jdt12.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer idStudent){
        return studentRepository.findById(idStudent)
                .orElseThrow(()->new CanNotFindException("ID Tidak Ditemukan"));
    }

    @Override
    public Student updateStudent (Student student, Integer idStudent){
        Student stuDB=studentRepository.findById(idStudent).get();
        if (Objects.nonNull(student.getNim()) && !"".equalsIgnoreCase(String.valueOf(student.getNim()))){
            stuDB.setNim(student.getNim());
        }
        if (Objects.nonNull(student.getNama()) && !"".equalsIgnoreCase(student.getNama())){
            stuDB.setNama(student.getNama());
        }
        if (Objects.nonNull(student.getJenisKelamin()) && !"".equalsIgnoreCase(student.getJenisKelamin())){
            stuDB.setJenisKelamin(student.getJenisKelamin());
        }
        if (Objects.nonNull(student.getEmail()) && !"".equalsIgnoreCase(student.getEmail())){
            stuDB.setEmail(student.getEmail());
        }
        if (Objects.nonNull(student.getTahunMasuk()) && !"".equalsIgnoreCase(String.valueOf(student.getTahunMasuk()))){
            stuDB.setTahunMasuk(student.getTahunMasuk());
        }
        return studentRepository.save(stuDB);
    }

    @Override
    public void deleteStudentById(Integer idStudent){
        studentRepository.deleteById(idStudent);
    }
}
