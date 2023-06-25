package id.co.indivara.jdt12.university.service;

import id.co.indivara.jdt12.university.entity.Lecturer;


import java.util.List;

public interface LecturerService {
    //POST : /lecturer
    Lecturer saveLecturer(Lecturer lecturer);
    //GET : /lecturer
    List<Lecturer> fetchLecturerList();
    //GET : /lecturer/find/{idLecturer}
    Lecturer findById(Integer idLecturer);
    //PUT : /lecturer/{idLecturer}
    Lecturer updateLecturer(Lecturer lecturer, Integer idLecturer);
    //DELETE : /lecturer/{idLecturer}
    void deleteLecturerById(Integer idLecturer);
}
