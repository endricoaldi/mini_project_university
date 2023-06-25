package id.co.indivara.jdt12.university.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_student", nullable = false)
    private Integer idStudent;

    @NotNull(message = "NIM Tidak Boleh Kosong")
    @Column(name = "nim", nullable = false)
    private Integer nim;

    @NotNull(message = "Nama Tidak Boleh Kosong")
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull(message = "Jenis Kelamin Tidak Boleh Kosong")
    @Column(name = "jenis_kelamin", nullable = false)
    private String jenisKelamin;

    @NotNull(message = "Email Tidak Boleh Kosong")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull(message = "Tahun Masuk Tidak Boleh Kosong")
    @Column(name = "tahun_masuk", nullable = false)
    private Integer tahunMasuk;

//    @OneToOne (mappedBy = "student")
//    @JsonIgnore
//    private List<RecordAchievement> recordAchievements;

//    @OneToOne(mappedBy = "student")
//    @JsonIgnore
//    private RecordAchievement recordAchievement;

//    @ManyToMany
//    @JsonIgnore
//    private List<RecordAchievement> enrolledSubjects;
//
//    public Student(Integer nim, String nama, String jenisKelamin, String email, Integer tahunMasuk) {
//        this.idStudent = 0;
//        this.nim = nim;
//        this.nama = nama;
//        this.jenisKelamin = jenisKelamin;
//        this.email = email;
//        this.tahunMasuk = tahunMasuk;
//    }
}
