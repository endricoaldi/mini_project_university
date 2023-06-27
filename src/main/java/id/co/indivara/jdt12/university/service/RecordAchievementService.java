package id.co.indivara.jdt12.university.service;



import id.co.indivara.jdt12.university.entity.RecordAchievement;
import id.co.indivara.jdt12.university.exception.Message;

import java.util.List;

public interface RecordAchievementService {
    //POST : /record
    RecordAchievement saveRecord(RecordAchievement recordAchievement);
    //GET : /record
    List<RecordAchievement> fetchRecordList();
    //GET : /record/find/{idRecord}
    RecordAchievement findById(Integer idRecord);
    //PUT : /record/{idRecord}
    RecordAchievement updateRecord(RecordAchievement recordAchievement, Integer idRecord);
    //DELETE : /record/{idRecord}
    Message deleteRecordById(Integer idRecord);
}
