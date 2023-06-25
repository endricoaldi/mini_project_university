package id.co.indivara.jdt12.university.controller;


import id.co.indivara.jdt12.university.entity.Lecturer;
import id.co.indivara.jdt12.university.exception.CanNotFindException;

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
//    @GetMapping("/find/by/{nip}")
//    public ResponseEntity<Lecturer> getLecturerByNip(@PathVariable("nip") Integer nip){
//        Lecturer lect = lecturerRepository.findByNip(nip);
//        if (lect == null){
//            throw new RuntimeException("NIP tidak ditemukan");
//        }
//        return new ResponseEntity<>(lect,HttpStatus.OK);
//    }
    @PutMapping("/update/{idLecturer}")
    Lecturer updateLecturer(@RequestBody Lecturer lecturer, @PathVariable("idLecturer") Integer idLecturer){
        return lecturerService.updateLecturer(lecturer, idLecturer);
    }
    @DeleteMapping("/delete/{idLecturer}")
    public String  deleteLecturerById(@PathVariable ("idLecturer") Integer idLecturer){
        lecturerService.deleteLecturerById(idLecturer);
        return "Delete Sukses...";
    }
//    @DeleteMapping("/delete")
//    public ResponseEntity<HttpStatus> deleteAllLecturer(){
//        lecturerRepository.deleteAll();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
