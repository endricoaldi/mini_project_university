package id.co.indivara.jdt12.university.controller;

import id.co.indivara.jdt12.university.entity.RecordAchievement;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.service.RecordAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordAchievementController {
    @Autowired
    private RecordAchievementService recordAchievementService;

    @GetMapping("/findall")
    List<RecordAchievement> findAllRecord(){
        return recordAchievementService.fetchRecordList();
    }
    @PostMapping("/create")
    RecordAchievement createRecord(@RequestBody RecordAchievement recordAchievement){
        return recordAchievementService.saveRecord(recordAchievement);
    }
    @GetMapping("/find/{idRecord}")
    RecordAchievement findById(@PathVariable ("idRecord") Integer idRecord){
        return recordAchievementService.findById(idRecord);
    }
    @PutMapping("/update/{idRecord}")
    RecordAchievement updateRecord(@RequestBody RecordAchievement recordAchievement, @PathVariable ("idRecord") Integer idRecord){
        return recordAchievementService.updateRecord(recordAchievement, idRecord);
    }
    @DeleteMapping("/delete/{idRecord}")
    public Message deleteRecord(@PathVariable ("idRecord") Integer idRecord){
        recordAchievementService.deleteRecordById(idRecord);
        return new Message(200,"Record Achievement Berhasil Dihapus") ;
    }

}
