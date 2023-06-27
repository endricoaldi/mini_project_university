package id.co.indivara.jdt12.university.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import id.co.indivara.jdt12.university.entity.Lecturer;
import id.co.indivara.jdt12.university.entity.Student;
import id.co.indivara.jdt12.university.entity.Subject;

import java.util.ArrayList;
import java.util.List;

public class Convert{

//    public static Lecturer registerToLecturer(RegisterWithRole registerWithRole){
//        return Lecturer.builder()
//                .username(registerWithRole.getUsername())
//                .password(registerWithRole.getPassword())
//                .isEnabled(true)
//                .isAccountLocked(false)
//                .build();
//    }
//
//    public static Subject registertoSubject(RegisterWithRole registerWithRole){
//        Subject subject = new Subject();
//        subject.setEmail(registerWithRole.getEmail());
//        subject.setPhoneNumber(registerWithRole.getPhoneNumber());
//        subject.setGender(registerWithRole.getGender());
//        subject.setName(registerWithRole.getFullName());
//        return subject;
//    }
//    public static Student registertoStudent(RegisterWithDriverRole registerWithDriverRole){
//        Student student = new Student();
//        student.setEmail(registerWithDriverRole.getEmail());
//        student.setPhoneNumber(registerWithDriverRole.getPhoneNumber());
//        student.setGender(registerWithDriverRole.getGender());
//        student.setName(registerWithDriverRole.getFullName());
//        student.setLicenceDriver(registerWithDriverRole.getLicenceDriver());
//        return student;
//    }
//
//    public static  List<Customer> getAllDataCustomer(String json) throws JsonProcessingException {
//        return new ObjectMapper().readValue(json, new TypeReference<List<Customer>>() {
//        });
//    }

    public static <T> List<T> getAllData(String json, Class<T> elementClass)throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType listType =
                objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, elementClass);
        return objectMapper.readValue(json, listType);
    }
    public static <T> T getData(String json, Class<T> tclass) throws  JsonProcessingException{
        ObjectMapper ob = new ObjectMapper();

        return ob.readValue(json, tclass);
    }
    public static <T> String toJson(T object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
