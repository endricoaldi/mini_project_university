package id.co.indivara.jdt12.university.controller;

import id.co.indivara.jdt12.university.entity.Classroom;
import id.co.indivara.jdt12.university.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("/findall")
    List<Classroom> findAllClass(){
        return classroomService.fetchClassList();
    }
    @PostMapping("/create")
    Classroom createClass(@RequestBody Classroom classroom){
        return classroomService.saveClass(classroom);
    }
    @GetMapping("/find/{idClass}")
    Classroom findById(@PathVariable("idClass") Integer idClass){
        return classroomService.findById(idClass);
    }
    @PutMapping("/update/{idClass}")
    Classroom updateClass(@RequestBody Classroom classroom, @PathVariable("idClass") Integer idClass){
        return classroomService.updateClass(classroom, idClass);
    }
    @DeleteMapping("/delete/{idClass}")
    public String deleteClass(@PathVariable("idClass") Integer idClass){
        classroomService.deleteClassById(idClass);
        return "Delete Sukses...";
    }
}
