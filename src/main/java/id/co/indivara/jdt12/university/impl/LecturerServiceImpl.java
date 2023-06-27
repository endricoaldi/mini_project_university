package id.co.indivara.jdt12.university.impl;

import id.co.indivara.jdt12.university.entity.Lecturer;
import id.co.indivara.jdt12.university.entity.Student;
import id.co.indivara.jdt12.university.exception.CanNotFindException;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.repo.LecturerRepository;
import id.co.indivara.jdt12.university.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public Lecturer saveLecturer(Lecturer lecturer){
        return lecturerRepository.save(lecturer);
    }
    @Override
    public List<Lecturer> fetchLecturerList(){
        return lecturerRepository.findAll();
    }
    @Override
    public Lecturer findById(Integer idLecturer){
        return lecturerRepository.findById(idLecturer)
                .orElseThrow(()->new CanNotFindException("ID tidak ditemukan"));
    }

    @Override
    public Lecturer updateLecturer(Lecturer lecturer, Integer idLecturer){
        Lecturer lectDB=lecturerRepository.findById(idLecturer).get();
        if (Objects.nonNull(lecturer.getNip()) && !"".equalsIgnoreCase(String.valueOf(lecturer.getNip()))){
            lectDB.setNip(lecturer.getNip());
        }
        if (Objects.nonNull(lecturer.getNama()) && !"".equalsIgnoreCase(lecturer.getNama())){
            lectDB.setNama(lecturer.getNama());
        }
        if (Objects.nonNull(lecturer.getJenisKelamin()) && !"".equalsIgnoreCase(lecturer.getJenisKelamin())){
            lectDB.setJenisKelamin(lecturer.getJenisKelamin());
        }
        if (Objects.nonNull(lecturer.getEmail()) && !"".equalsIgnoreCase(lecturer.getEmail())){
            lectDB.setEmail(lecturer.getEmail());
        }
        return lecturerRepository.save(lectDB);
    }

    @Override
    public Message deleteLecturerById(Integer idLecturer){
        Lecturer lecturer = lecturerRepository.findById(idLecturer)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID Tidak Ditemukan"));

        lecturerRepository.deleteById(idLecturer);
        return new Message(200,"Lecturer Berhasil Dihapus");
    }
}
