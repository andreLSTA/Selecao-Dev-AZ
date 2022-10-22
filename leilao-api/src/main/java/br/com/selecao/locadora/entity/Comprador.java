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
@Table(name = "tb_comprador")
@SequenceGenerator(name = "seq_comprador", sequenceName = "seq_comprador", allocationSize = 1)
public class Comprador implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_comprador")
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa", referencedColumnName = "id", nullable = false)
    private Empresa empresa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "leilao", referencedColumnName = "id", nullable = false)
    private Leilao leilao;

    @Embedded
    private DefaultTimestamp timestamps = new DefaultTimestamp();

}


