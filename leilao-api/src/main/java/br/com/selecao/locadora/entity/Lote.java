package br.com.selecao.locadora.entity;

import br.com.selecao.locadora.entity.embeddable.DefaultTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "tb_lote")
@SequenceGenerator(name = "seq_lote", sequenceName = "seq_lote", allocationSize = 1)
public class Lote implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_lote")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "numeroLote")
    private int numeroLote;

    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

    @Column(name = "quantidade", nullable = false)
    private float quantidade;

    @Column(name = "valorInicial")
    private float valorInicial;

    @Column(name = "unidade", length = 128, nullable = false)
    private String unidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "leilao", referencedColumnName = "id", nullable = false)
    private Leilao leilao;

    @Embedded
    private DefaultTimestamp timestamps = new DefaultTimestamp();

}

