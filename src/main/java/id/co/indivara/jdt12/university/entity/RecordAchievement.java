package id.co.indivara.jdt12.university.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "record_achievement")
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Accessors(chain = true)
public class RecordAchievement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_record", nullable = false)
    private Integer idRecord;

//    @ManyToMany(mappedBy = "enrolledSubjects")
//    @JsonIgnore
//    private List<Student> students;
//
//    @ManyToOne(cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    private Classroom Classroom;
    @Column(name = "id_subject")
    private Integer idSubject;

    @Column(name = "id_student")
    private Integer idStudent;

    @Column(name = "quiz")
    private Integer quiz;

    @Column(name = "middle_test")
    private Integer middleTest;

    @Column(name = "final_test")
    private Integer finalTest;

    @Column(name = "final_grade")
    private Character finalGrade;

    @JoinColumn(name = "id_student",insertable = false,updatable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    @JoinColumn(name = "id_subject",insertable = false,updatable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subject subject;

//    @OneToOne(cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    private Student student;
}
