package id.co.indivara.jdt12.university.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_subject", nullable = false)
    private Integer idSubject;

    @Column(name = "nama_subject", nullable = false)
    private String namaSubject;

//    @OneToMany(mappedBy = "subject")
//    @JsonIgnore
//    private List<Classroom> classrooms;

//    public Subject(String namaSubject) {
//        this.idSubject = 0;
//        this.namaSubject = namaSubject;
//    }

}
