//package id.co.indivara.jdt12.university.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//public class StudentControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void testRegisterStudentSuccess() throws Exception {
//
//        String registerStudentJson = " {   \"nim\":11212253,\r\n    \"nama\":\"petra\",\r\n    \"jenisKelamin\":\"Male\",\r\n    \"email\":\"petra@gmail.com\",\r\n    \"tahunMasuk\":2022}";
//        ResultActions resultActions = mockMvc.perform(post("/student/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(registerStudentJson))
//                .andExpect(status().isCreated());
//    }
//}
