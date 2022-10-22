package br.com.selecao.locadora.entity;

import br.com.selecao.locadora.entity.embeddable.DefaultTimestamp;
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
@Table(name = "tb_unidade")
@SequenceGenerator(name = "seq_unidade", sequenceName = "seq_unidade", allocationSize = 1)
public class Unidade implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_unidade")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome", length = 128, nullable = false)
    private String nome;

    @Embedded
    private DefaultTimestamp timestamps = new DefaultTimestamp();

}

