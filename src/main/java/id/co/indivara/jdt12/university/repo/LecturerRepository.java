package id.co.indivara.jdt12.university.repo;

import id.co.indivara.jdt12.university.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
//    Lecturer findByNip(Integer nip);
}
