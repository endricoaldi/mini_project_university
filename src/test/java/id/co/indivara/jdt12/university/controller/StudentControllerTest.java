package id.co.indivara.jdt12.university.controller;

import id.co.indivara.jdt12.university.entity.Student;
import id.co.indivara.jdt12.university.exception.Message;
import id.co.indivara.jdt12.university.impl.StudentServiceImpl;
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
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @Test
    public void getAllStudentTest() throws Exception{
        List<Student> studentCheck = studentServiceImpl.fetchStudentList();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/student/findall")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(result -> {
                    List<Student> student = Convert.getAllData(result.getResponse().getContentAsString(), Student.class);
                    Assertions.assertNotNull(student);
                    Assertions.assertEquals(studentCheck.get(0).getNama(),student.get(0).getNama());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idStudent").isNotEmpty());

    }

    @Test
    public void getStudentById() throws Exception{
        Student student = studentServiceImpl.findById(5);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/student/find/5")
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(result -> {
                    Student student1 = Convert.getData(result.getResponse().getContentAsString(), Student.class);
                    Assertions.assertNotNull(student1);
                    Assertions.assertEquals(student.getIdStudent(), student1.getIdStudent());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idStudent").isNotEmpty());
    }
    @Test
    public void updateStudent() throws Exception {
        Student student = studentServiceImpl.findById(7);
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/student/update/7")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(student))
                )
                .andDo (result -> {
                    Student student1 = Convert.getData(result.getResponse().getContentAsString(), Student.class);
                    Assertions.assertNotNull(student);
                    Assertions.assertEquals(student.getIdStudent(),student.getIdStudent());

                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idStudent").isNotEmpty());
    }
    @Test
    public void addAndDeleteStudent() throws Exception {
        Student student  = Student.builder()
                .nim(121212)
                .nama("Azhar")
                .jenisKelamin("Male")
                .email("azhar@gmail.com")
                .tahunMasuk(2023)
                .build();
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/student/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Convert.toJson(student))
                )
                .andDo(result -> {
                    Student student1 = Convert.getData(result.getResponse().getContentAsString(), Student.class);
                    Assertions.assertNotNull(student1);
                    Assertions.assertEquals(student1.getNama(),student.getNama());
                    deleteStudentById(student1.getIdStudent());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.idStudent").isNotEmpty());
    }
    public void deleteStudentById(Integer idStudent) throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/student/delete/"+idStudent)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(result -> {
                    Message message = Convert.getData(result.getResponse().getContentAsString(), Message.class);
                    Assertions.assertNotNull(message);
                    Assertions.assertEquals("Student Berhasil Dihapus",message.getMessage());
                })
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty());
    }
}
