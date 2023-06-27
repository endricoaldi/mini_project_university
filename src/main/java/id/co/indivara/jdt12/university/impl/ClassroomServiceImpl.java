package id.co.indivara.jdt12.university.impl;

import id.co.indivara.jdt12.university.entity.Classroom;
import id.co.indivara.jdt12.university.entity.Lecturer;
import id.co.indivara.jdt12.university.entity.Student;
import id.co.indivara.jdt12.university.entity.Subject;
import id.co.indivara.jdt12.university.exception.CanNotFindException;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.repo.ClassroomRepository;
import id.co.indivara.jdt12.university.repo.LecturerRepository;
import id.co.indivara.jdt12.university.repo.SubjectRepository;
import id.co.indivara.jdt12.university.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Classroom saveClass(Classroom classroom) throws CanNotFindException{
        Lecturer lecturer = lecturerRepository.findById(classroom.getIdLecturer()).orElseThrow(()-> new CanNotFindException("ID Lecturer Tidak ditemukan"));
        Subject subject = subjectRepository.findById(classroom.getIdSubject()).orElseThrow(()->new CanNotFindException("ID Subject Tidak Ditemukan"));
        classroom.setLecturer(lecturer);
        classroom.setSubject(subject);
        return classroomRepository.save(classroom);
    }
    @Override
    public List<Classroom> fetchClassList(){
        return classroomRepository.findAll();
    }
    @Override
    public Classroom findById(Integer idClass){
        return classroomRepository.findById(idClass)
                .orElseThrow(()->new CanNotFindException("ID Tidak Ditemukan"));
    }
    @Override
    public Classroom updateClass(Classroom classroom, Integer idClass){
        Classroom classDB=classroomRepository.findById(idClass).get();
        if (Objects.nonNull(classroom.getIdLecturer()) && !"".equalsIgnoreCase(String.valueOf(classroom.getIdLecturer()))){
            classDB.setIdLecturer(classroom.getIdLecturer());
        }
        if (Objects.nonNull(classroom.getIdSubject()) && !"".equalsIgnoreCase(String.valueOf(classroom.getIdSubject()))){
            classDB.setIdSubject(classroom.getIdSubject());
        }
        if (Objects.nonNull(classroom.getPeriod()) && !"".equalsIgnoreCase(classroom.getPeriod())){
            classDB.setPeriod(classroom.getPeriod());
        }
        return classroomRepository.save(classDB);
    }
    @Override
    public Message deleteClassById(Integer idClass){
        Classroom classroom = classroomRepository.findById(idClass)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID Tidak Ditemukan"));

        classroomRepository.deleteById(idClass);
        return new Message(200,"Classroom Berhasil Dihapus");
    }
}
