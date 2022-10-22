package br.com.selecao.locadora.entity;

import br.com.selecao.locadora.entity.embeddable.DefaultTimestamp;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "tb_leilao")
@SequenceGenerator(name = "seq_leilao", sequenceName = "seq_leilao", allocationSize = 1)
public class Leilao implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_leilao")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "codigo")
    private int codigo;

    @Column(name = "descricao", length = 60, nullable = false)
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor", referencedColumnName = "id", nullable = false)
    private Empresa vendedor;

    @Column(name = "inicioPrevisto", nullable = false)
    private LocalDateTime inicioPrevisto;

    @OneToMany(mappedBy = "leilao")
    private List<Lote> lotes;

    @Embedded
    private DefaultTimestamp timestamps = new DefaultTimestamp();

}


