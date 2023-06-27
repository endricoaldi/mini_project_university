package id.co.indivara.jdt12.university.controller;


import id.co.indivara.jdt12.university.entity.Lecturer;
import id.co.indivara.jdt12.university.exception.CanNotFindException;

import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("http://localhost:8081")@RestController
@RequestMapping("/lecturer")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @GetMapping("/findall")
    List<Lecturer> findAllLecturer(){
        return lecturerService.fetchLecturerList();
    }

    @PostMapping("/create")
    Lecturer createLecturer(@RequestBody Lecturer lecturer){
        return lecturerService.saveLecturer(lecturer);
    }
    @GetMapping("/find/{idLecturer}")
    Lecturer findLecturerById(@PathVariable ("idLecturer") Integer idLecturer){
        return lecturerService.findById(idLecturer);
    }

    @PutMapping("/update/{idLecturer}")
    Lecturer updateLecturer(@RequestBody Lecturer lecturer, @PathVariable("idLecturer") Integer idLecturer){
        return lecturerService.updateLecturer(lecturer, idLecturer);
    }
    @DeleteMapping("/delete/{idLecturer}")
    public Message deleteLecturerById(@PathVariable ("idLecturer") Integer idLecturer){
        lecturerService.deleteLecturerById(idLecturer);
        return new Message(200,"Lecturer Berhasil Dihapus") ;
    }

}
