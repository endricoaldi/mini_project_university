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
//public class ClassroomControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void testRegisterClassroomSuccess() throws Exception {
//
//        String registerClassroomJson = "{\r\n    \"period\":\"Lima\",\r\n    \"idLecturer\":39,\r\n    \"idSubject\": 41\r\n}";
//        ResultActions resultActions = mockMvc.perform(post("/class/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(registerClassroomJson))
//                .andExpect(status().isCreated());
//    }
//}
