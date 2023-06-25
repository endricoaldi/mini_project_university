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
//public class SubjectControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void testRegisterSubjectSuccess() throws Exception {
//
//        String registerSubjectJson = "{\r\n\t\"namaSubject\":\"Akuntansi\"\r\n}";
//        ResultActions resultActions = mockMvc.perform(post("/subject/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(registerSubjectJson))
//                .andExpect(status().isCreated());
//    }
//}
