package id.co.indivara.jdt12.university.impl;

import id.co.indivara.jdt12.university.entity.Student;
import id.co.indivara.jdt12.university.entity.Subject;
import id.co.indivara.jdt12.university.exception.CanNotFindException;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.repo.SubjectRepository;
import id.co.indivara.jdt12.university.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject saveSubject(Subject subject){
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> fetchSubjectList(){
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(Integer idSubject){
        return subjectRepository.findById(idSubject)
                .orElseThrow(()->new CanNotFindException("ID tidak ditemukan"));
    }

    @Override
    public Subject updateSubject(Subject subject, Integer idSubject){
        Subject subDB=subjectRepository.findById(idSubject).get();
        if (Objects.nonNull(subject.getNamaSubject()) && !"".equalsIgnoreCase(subject.getNamaSubject())){
            subDB.setNamaSubject(subject.getNamaSubject());
        }
        return subjectRepository.save(subDB);
    }

    @Override
    public Message deleteSubjectById(Integer idSubject){
        Subject subject = subjectRepository.findById(idSubject)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID Tidak Ditemukan"));

        subjectRepository.deleteById(idSubject);
        return new Message(200,"Subject Berhasil Dihapus");
    }
}
