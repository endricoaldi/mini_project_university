package id.co.indivara.jdt12.university.impl;

import id.co.indivara.jdt12.university.entity.Lecturer;
import id.co.indivara.jdt12.university.entity.RecordAchievement;
import id.co.indivara.jdt12.university.entity.Student;
import id.co.indivara.jdt12.university.entity.Subject;
import id.co.indivara.jdt12.university.exception.CanNotFindException;
import id.co.indivara.jdt12.university.repo.RecordAchievementRepository;
import id.co.indivara.jdt12.university.repo.StudentRepository;
import id.co.indivara.jdt12.university.repo.SubjectRepository;
import id.co.indivara.jdt12.university.service.RecordAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class RecordAchievementServiceImpl implements RecordAchievementService {
    @Autowired
    private RecordAchievementRepository recordAchievementRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public RecordAchievement saveRecord( RecordAchievement recordAchievement) throws CanNotFindException{
        Student student = studentRepository.findById(recordAchievement.getIdStudent()).orElseThrow(()->new CanNotFindException("Student Not Found"));
        Subject subject = subjectRepository.findById(recordAchievement.getIdSubject()).orElseThrow(()->new CanNotFindException("Subject Not Found"));
        int nilai = (recordAchievement.getQuiz() + recordAchievement.getMiddleTest() + recordAchievement.getFinalTest()) / 3;
        Character grade;
        if (nilai >= 85){
            grade = 'A';
        } else if (nilai >=75) {
            grade = 'B';
        } else if (nilai >=65) {
            grade = 'C';
        } else if (nilai >=50) {
            grade = 'D';
        }else {
            grade = 'E';
        }

        recordAchievement.setStudent(student);
        recordAchievement.setSubject(subject);
        recordAchievement.setQuiz(recordAchievement.getQuiz());
        recordAchievement.setMiddleTest(recordAchievement.getMiddleTest());
        recordAchievement.setFinalTest(recordAchievement.getFinalTest());
        recordAchievement.setFinalGrade(grade);
        return recordAchievementRepository.save(recordAchievement);
    }
    @Override
    public List<RecordAchievement> fetchRecordList(){
        return recordAchievementRepository.findAll();
    }
//    }
    @Override
    public RecordAchievement findById(Integer idRecord){
        return recordAchievementRepository.findById(idRecord)
                .orElseThrow(()->new CanNotFindException("ID Tidak Ditemukan"));
    }

    @Override
    public RecordAchievement updateRecord(RecordAchievement recordAchievement, Integer idRecord){
        RecordAchievement recDB = recordAchievementRepository.findById(idRecord).get();
        if (Objects.nonNull(recordAchievement.getQuiz()) && !"" .equalsIgnoreCase(String.valueOf(recordAchievement.getQuiz()))){
            recDB.setQuiz(recordAchievement.getQuiz());
        }
        if (Objects.nonNull(recordAchievement.getMiddleTest()) && !"" .equalsIgnoreCase(String.valueOf(recordAchievement.getMiddleTest()))){
            recDB.setMiddleTest(recordAchievement.getMiddleTest());
        }
        if (Objects.nonNull(recordAchievement.getFinalTest()) && !"" .equalsIgnoreCase(String.valueOf(recordAchievement.getFinalTest()))){
            recDB.setFinalTest(recordAchievement.getFinalTest());
        }
        int nilai = (recordAchievement.getQuiz() + recordAchievement.getMiddleTest() + recordAchievement.getFinalTest()) / 3;
        Character grade;
        if (nilai >= 85){
            grade = 'A';
        } else if (nilai >=75) {
            grade = 'B';
        } else if (nilai >=65) {
            grade = 'C';
        } else if (nilai >=50) {
            grade = 'D';
        }else {
            grade = 'E';
        }
        recDB.setFinalGrade(grade);
        return recordAchievementRepository.save(recDB);
    }

    @Override
    public void deleteRecordById(Integer idRecord){
        recordAchievementRepository.deleteById(idRecord);
    }
}
