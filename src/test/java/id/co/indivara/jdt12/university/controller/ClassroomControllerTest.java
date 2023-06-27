package id.co.indivara.jdt12.university.controller;

import id.co.indivara.jdt12.university.entity.Classroom;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.impl.ClassroomServiceImpl;
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
public class ClassroomControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ClassroomServiceImpl classroomServiceImpl;

    @Test
    public void getAllClassroomTest() throws Exception{
        List<Classroom> classCheck = classroomServiceImpl.fetchClassList();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/class/findall")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    List<Classroom> classroom = Convert.getAllData(result.getResponse().getContentAsString(), Classroom.class);
                    Assertions.assertNotNull(classroom);
                    Assertions.assertEquals(classCheck.get(0).getPeriod(),classroom.get(0).getPeriod());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idClassroom").isNotEmpty());
    }
    @Test
    public void getClassById() throws Exception{
        Classroom classroom = classroomServiceImpl.findById(31);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/class/find/31")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    Classroom classroom1 = Convert.getData(result.getResponse().getContentAsString(), Classroom.class);
                    Assertions.assertNotNull(classroom1);
                    Assertions.assertEquals(classroom.getIdClassroom(), classroom1.getIdClassroom());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idClassroom").isNotEmpty());
    }
    @Test
    public void updateClass() throws Exception {
        Classroom classroom = classroomServiceImpl.findById(31);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/class/update/31")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(classroom))
                )
                .andDo (result -> {
                    Classroom classroom1 = Convert.getData(result.getResponse().getContentAsString(), Classroom.class);
                    Assertions.assertNotNull(classroom);
                    Assertions.assertEquals(classroom.getIdClassroom(),classroom.getIdClassroom());

                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idClassroom").isNotEmpty());
    }
    @Test
    public void addAndDeleteClass() throws Exception {
        Classroom classroom  = Classroom.builder()
                .period("Sembilan")
                .idLecturer(3)
                .idSubject(1)
                .build();
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/class/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(classroom))
                )
                .andDo(result -> {
                    Classroom classroom1 = Convert.getData(result.getResponse().getContentAsString(), Classroom.class);
                    Assertions.assertNotNull(classroom1);
                    Assertions.assertEquals(classroom1.getPeriod(),classroom1.getPeriod());
                    deleteClassById(classroom1.getIdClassroom());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idClassroom").isNotEmpty());
    }
    public void deleteClassById(Integer idClass) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/class/delete/"+idClass)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    Message message = Convert.getData(result.getResponse().getContentAsString(), Message.class);
                    Assertions.assertNotNull(message);
                    Assertions.assertEquals("Classroom Berhasil Dihapus",message.getMessage());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty());
    }

}
