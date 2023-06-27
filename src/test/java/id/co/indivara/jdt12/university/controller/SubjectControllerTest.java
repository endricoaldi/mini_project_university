package id.co.indivara.jdt12.university.controller;


import id.co.indivara.jdt12.university.entity.Subject;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.impl.SubjectServiceImpl;
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
public class SubjectControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    SubjectServiceImpl subjectServiceImpl;

    @Test
    public void getAllSubjectTest() throws Exception{
        List<Subject> subjectCheck = subjectServiceImpl.fetchSubjectList();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/subject/findall")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    List<Subject> subject = Convert.getAllData(result.getResponse().getContentAsString(), Subject.class);
                    Assertions.assertNotNull(subject);
                    Assertions.assertEquals(subjectCheck.get(0).getNamaSubject(),subject.get(0).getNamaSubject());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idSubject").isNotEmpty());

    }
    @Test
    public void getSubjectById() throws Exception{
        Subject subject = subjectServiceImpl.findById(1);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/subject/find/1")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    Subject subject1 = Convert.getData(result.getResponse().getContentAsString(), Subject.class);
                    Assertions.assertNotNull(subject1);
                    Assertions.assertEquals(subject.getIdSubject(), subject1.getIdSubject());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idSubject").isNotEmpty());
    }
    @Test
    public void updateSubject() throws Exception {
        Subject subject = subjectServiceImpl.findById(1);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/subject/update/1")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(subject))
                )
                .andDo (result -> {
                    Subject subject1 = Convert.getData(result.getResponse().getContentAsString(), Subject.class);
                    Assertions.assertNotNull(subject);
                    Assertions.assertEquals(subject.getIdSubject(),subject.getIdSubject());

                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idSubject").isNotEmpty());
    }
    @Test
    public void addAndDeleteSubject() throws Exception {
        Subject subject  = Subject.builder()
                .namaSubject("Biologi")
                .build();
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/subject/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(subject))
                )
                .andDo(result -> {
                    Subject subject1 = Convert.getData(result.getResponse().getContentAsString(), Subject.class);
                    Assertions.assertNotNull(subject1);
                    Assertions.assertEquals(subject1.getNamaSubject(),subject1.getNamaSubject());
                    deleteSubjectById(subject1.getIdSubject());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idSubject").isNotEmpty());
    }
    public void deleteSubjectById(Integer idSubject) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/subject/delete/"+idSubject)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    Message message = Convert.getData(result.getResponse().getContentAsString(), Message.class);
                    Assertions.assertNotNull(message);
                    Assertions.assertEquals("Subject Berhasil Dihapus",message.getMessage());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty());
    }
}
