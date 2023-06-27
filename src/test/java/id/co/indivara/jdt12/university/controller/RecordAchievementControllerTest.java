package id.co.indivara.jdt12.university.controller;


import id.co.indivara.jdt12.university.entity.RecordAchievement;
import id.co.indivara.jdt12.university.entity.Student;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.impl.RecordAchievementServiceImpl;
import id.co.indivara.jdt12.university.mapper.Convert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RecordAchievementControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    RecordAchievementServiceImpl recordAchievementServiceImpl;

    @Test
    public void getAllRecordTest() throws Exception {
        List<RecordAchievement> recordCheck = recordAchievementServiceImpl.fetchRecordList();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/record/findall")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    List<RecordAchievement> recordAchievement = Convert.getAllData(result.getResponse().getContentAsString(), RecordAchievement.class);
                    Assertions.assertNotNull(recordAchievement);
                    Assertions.assertEquals(recordCheck.get(0).getQuiz(), recordAchievement.get(0).getQuiz());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idRecord").isNotEmpty());
    }
    @Test
    public void getRecordById() throws Exception{
        RecordAchievement recordAchievement = recordAchievementServiceImpl.findById(13);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/record/find/13")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    RecordAchievement recordAchievement1 = Convert.getData(result.getResponse().getContentAsString(), RecordAchievement.class);
                    Assertions.assertNotNull(recordAchievement1);
                    Assertions.assertEquals(recordAchievement.getIdRecord(), recordAchievement1.getIdRecord());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idRecord").isNotEmpty());
    }
    @Test
    public void updateRecord() throws Exception {
        RecordAchievement recordAchievement = recordAchievementServiceImpl.findById(13);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/record/update/13")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(recordAchievement))
                )
                .andDo (result -> {
                    RecordAchievement recordAchievement1 = Convert.getData(result.getResponse().getContentAsString(), RecordAchievement.class);
                    Assertions.assertNotNull(recordAchievement);
                    Assertions.assertEquals(recordAchievement.getIdRecord(),recordAchievement.getIdRecord());

                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idRecord").isNotEmpty());
    }
    @Test
    public void addAndDeleteRecord() throws Exception {
        RecordAchievement recordAchievement  = RecordAchievement.builder()
                .idStudent(5)
                .idSubject(1)
                .quiz(100)
                .middleTest(87)
                .finalTest(70)
                .build();
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/record/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(recordAchievement))
                )
                .andDo(result -> {
                    RecordAchievement recordAchievement1 = Convert.getData(result.getResponse().getContentAsString(), RecordAchievement.class);
                    Assertions.assertNotNull(recordAchievement1);
                    Assertions.assertEquals(recordAchievement1.getQuiz(),recordAchievement.getQuiz());
                    deleteRecordById(recordAchievement1.getIdRecord());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idRecord").isNotEmpty());
    }
    public void deleteRecordById(Integer idRecord) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/record/delete/"+idRecord)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    Message message = Convert.getData(result.getResponse().getContentAsString(), Message.class);
                    Assertions.assertNotNull(message);
                    Assertions.assertEquals("Record Achievement Berhasil Dihapus",message.getMessage());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty());
    }
}
