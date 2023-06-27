package id.co.indivara.jdt12.university.controller;

import id.co.indivara.jdt12.university.entity.Lecturer;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.impl.LecturerServiceImpl;
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
public class LecturerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    LecturerServiceImpl lecturerServiceImpl;

    @Test
    public void getAllLecturerTest() throws Exception{
        List<Lecturer> lecturerCheck = lecturerServiceImpl.fetchLecturerList();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/lecturer/findall")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    List<Lecturer> lecturer = Convert.getAllData(result.getResponse().getContentAsString(), Lecturer.class);
                    Assertions.assertNotNull(lecturer);
                    Assertions.assertEquals(lecturerCheck.get(0).getNama(),lecturer.get(0).getNama());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idLecturer").isNotEmpty());
    }
    @Test
    public void getLecturerById() throws Exception{
        Lecturer lecturer = lecturerServiceImpl.findById(3);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/lecturer/find/3")
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    Lecturer lecturer1 = Convert.getData(result.getResponse().getContentAsString(), Lecturer.class);
                    Assertions.assertNotNull(lecturer1);
                    Assertions.assertEquals(lecturer.getIdLecturer(), lecturer1.getIdLecturer());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLecturer").isNotEmpty());
    }
    @Test
    public void updateLecturer() throws Exception {
        Lecturer lecturer = lecturerServiceImpl.findById(3);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/lecturer/update/3")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(lecturer))
                )
                .andDo (result -> {
                    Lecturer lecturer1 = Convert.getData(result.getResponse().getContentAsString(), Lecturer.class);
                    Assertions.assertNotNull(lecturer);
                    Assertions.assertEquals(lecturer.getIdLecturer(),lecturer1.getIdLecturer());

                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLecturer").isNotEmpty());
    }
    @Test
    public void addAndDeleteLecturer() throws Exception {
        Lecturer lecturer  = Lecturer.builder()
                .nip(129212)
                .nama("Azhari")
                .jenisKelamin("Male")
                .email("azhari@gmail.com")
                .build();
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/lecturer/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(lecturer))
                )
                .andDo(result -> {
                    Lecturer lecturer1 = Convert.getData(result.getResponse().getContentAsString(), Lecturer.class);
                    Assertions.assertNotNull(lecturer1);
                    Assertions.assertEquals(lecturer1.getNama(),lecturer.getNama());
                    deleteLecturerById(lecturer1.getIdLecturer());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idLecturer").isNotEmpty());
    }
    public void deleteLecturerById(Integer idLecturer) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/lecturer/delete/"+idLecturer)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    Message message = Convert.getData(result.getResponse().getContentAsString(), Message.class);
                    Assertions.assertNotNull(message);
                    Assertions.assertEquals("Lecturer Berhasil Dihapus",message.getMessage());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty());
    }
}