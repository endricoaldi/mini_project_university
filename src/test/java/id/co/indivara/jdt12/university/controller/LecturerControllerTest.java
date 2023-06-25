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
//public class LecturerControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void testRegisterLecturerSuccess() throws Exception{
//        String registerLecturerJson = "{\r\n    \"nip\":33442,\r\n    \"nama\":\"Ari\",\r\n    \"jenisKelamin\":\"Male\",\r\n    \"email\":\"ari@gmail.com\"\r\n}";
//        ResultActions resultActions = mockMvc.perform(post("/lecturer/create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(registerLecturerJson))
//                .andExpect(status().isCreated());
//    }
//}
