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
@Table(name = "classroom")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_classroom")
    private Integer idClassroom;

    @Column (name = "period")
    private String period;

    @Column(name = "id_lecturer")
    private Integer idLecturer;

    @Column(name = "id_subject")
    private Integer idSubject;

    @JoinColumn(name = "id_lecturer",insertable = false,updatable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Lecturer lecturer;

    @JoinColumn(name = "id_subject",insertable = false,updatable = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Subject subject;

}
