package br.com.fiap.springpfauthentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_2TDSPF_PERMISSAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERMISSAO")
    @SequenceGenerator(
            name = "SQ_PERMISSAO",
            sequenceName = "SQ_PERMISSAO",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_PERMISSAO")
    private Long id;

    @Column(name = "NM_PERMISSAO")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "sistema_id")
    private Sistema sistema;
}
