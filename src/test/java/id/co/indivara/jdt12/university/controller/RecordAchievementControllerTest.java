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
//public class RecordAchievementControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    void testRegisterRecordAchievementSuccess() throws Exception {
//
//        String registerRecordAchievementJson = "{\r\n    \"idStudent\":24,\r\n    \"idSubject\": 41,\r\n    \"quiz\":70,\r\n    \"middleTest\": 95,\r\n    \"finalTest\": 85\r\n}";
//        ResultActions resultActions = mockMvc.perform(post("/record/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(registerRecordAchievementJson))
//                .andExpect(status().isCreated());
//    }
//}
