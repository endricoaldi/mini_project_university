package id.co.indivara.jdt12.university.repo;

import id.co.indivara.jdt12.university.entity.RecordAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordAchievementRepository extends JpaRepository<RecordAchievement, Integer> {
}
