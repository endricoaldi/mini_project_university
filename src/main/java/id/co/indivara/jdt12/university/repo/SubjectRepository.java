package id.co.indivara.jdt12.university.repo;

import id.co.indivara.jdt12.university.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
