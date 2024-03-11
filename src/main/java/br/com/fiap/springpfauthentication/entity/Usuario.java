package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_2TDSPF_USUARIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(
            name = "SQ_USUARIO",
            sequenceName = "SQ_USUARIO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_USUARIO")
    private Long id;
    @Column(name = "EMAIL_USUARIO")
    private String email;
    @Column(name = "SENHA_USUARIO")
    private String senha;
}
