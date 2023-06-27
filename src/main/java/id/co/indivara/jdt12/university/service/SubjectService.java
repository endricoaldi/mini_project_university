package id.co.indivara.jdt12.university.service;


import id.co.indivara.jdt12.university.entity.Subject;
import id.co.indivara.jdt12.university.exception.Message;

import java.util.List;

public interface SubjectService {
    //POST : /subject
    Subject saveSubject(Subject subject);
    //GET : /subject
    List<Subject> fetchSubjectList();
    //GET : /subject/find/{idSubject}
    Subject findById(Integer idSubject);
    //PUT : /subject/{idSubject}
    Subject updateSubject(Subject subject, Integer idSubject);
    //DELETE : /subject/{idSubject}
    Message deleteSubjectById(Integer idSubject);
}
