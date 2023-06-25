package id.co.indivara.jdt12.university.repo;


import id.co.indivara.jdt12.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    Student findByNim(Integer nim);

}
