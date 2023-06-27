package id.co.indivara.jdt12.university.service;




import id.co.indivara.jdt12.university.entity.Classroom;
import id.co.indivara.jdt12.university.exception.Message;

import java.util.List;


public interface ClassroomService {
    //POST : /class
    Classroom saveClass(Classroom classroom);
    //GET : /class
    List<Classroom> fetchClassList();
    //GET : /class/find/{idClassroom}
    Classroom findById(Integer idClassroom);
    //PUT : /class/{idClassroom}
    Classroom updateClass(Classroom classroom, Integer idClassroom);
    //DELETE : /class/{idClass}
    Message deleteClassById(Integer idClass);
}
