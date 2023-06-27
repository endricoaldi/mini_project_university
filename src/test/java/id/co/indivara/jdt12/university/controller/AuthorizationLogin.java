//package id.co.indivara.jdt12.university.controller;
//
//
//import id.co.indivara.jdt12.university.service.StudentService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.Base64;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class AuthorizationLogin {
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    private StudentService studentService;
//
//    private static final String getBasicAuthenticationHeader(String username, String password) {
//        String valueToEncode = username + ":" + password;
//        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
//    }
//    @Test
//    public void getAllTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/tes/student/")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .header("Authorization", getBasicAuthenticationHeader("admin", "password"))
//                )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
//    }
//}
//
