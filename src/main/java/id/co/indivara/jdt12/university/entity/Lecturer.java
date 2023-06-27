package id.co.indivara.jdt12.university.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "lecturers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lecturer", nullable = false)
    @NotNull(message = "ID lecturer Tidak Boleh Kosong")
    private Integer idLecturer;

    @NotNull (message = "Nip Tidak Boleh Kosong")
    @Column(name = "nip", nullable = false)
    private Integer nip;

    @NotNull (message = "Nama Tidak Boleh Kosong")
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull (message = "Jenis Kelamin Tidak Boleh Kosong")
    @Column (name = "jenis_kelamin", nullable = false)
    private String jenisKelamin;

    @NotNull (message = "Email Kelamin Tidak Boleh Kosong")
    @Column (name = "email", nullable = false)
    private String email;
}

