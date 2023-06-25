package id.co.indivara.jdt12.university.controller;

import id.co.indivara.jdt12.university.entity.Subject;
import id.co.indivara.jdt12.university.exception.CanNotFindException;
import id.co.indivara.jdt12.university.repo.SubjectRepository;
import id.co.indivara.jdt12.university.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("findall")
    List<Subject> findAllSubject(){
        return subjectService.fetchSubjectList();
    }

    @PostMapping("/create")
    Subject createSubject(@RequestBody Subject subject){
        return subjectService.saveSubject(subject);
    }

    @GetMapping("/find/{idSubject}")
    Subject findSubjectById(@PathVariable("idSubject") Integer idSubject){
        return subjectService.findById(idSubject);
    }

    @PutMapping("/update/{idSubject}")
    Subject updateSubject(@RequestBody Subject subject, @PathVariable("idSubject") Integer idSubject){
        return subjectService.updateSubject(subject,idSubject);
    }

    @DeleteMapping("/delete/{idSubject}")
    public String deleteSubjectById(@PathVariable("idSubject") Integer idSubject){
        subjectService.deleteSubjectById(idSubject);
        return "Delete Sukses...";
    }

//    @DeleteMapping("/delete")
//    public ResponseEntity<HttpStatus> deleteAllSubject(){
//        subjectRepository.deleteAll();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
