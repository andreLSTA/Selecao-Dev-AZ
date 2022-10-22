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
@Table(name = "tb_empresa")
@SequenceGenerator(name = "seq_empresa", sequenceName = "seq_empresa", allocationSize = 1)
public class Empresa implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_empresa")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "razaoSocial", length = 64, nullable = false)
    private String razaoSocial;

    @Column(name = "cnpj", length = 32, nullable = false, unique = true)
    private String cnpj;

    @Column(name = "logradouro", length = 64)
    private String logradouro;

    @Column(name = "municipio", length = 64)
    private String municipio;

    @Column(name = "numero", length = 10)
    private String numero;

    @Column(name = "complemento", length = 64)
    private String complemento;

    @Column(name = "bairro", length = 64)
    private String bairro;

    @Column(name = "cep", length = 16)
    private String cep;

    @Column(name = "telefone", length = 32)
    private String telefone;

    @Column(name = "email", length = 254, nullable = false)
    private String email;

    @Column(name = "site", length = 254)
    private String site;

    @Column(name = "usuario", length = 20, nullable = false, unique = true)
    private String usuario;

    @Column(name = "senha", length = 128)
    private String senha;

    @Embedded
    private DefaultTimestamp timestamps = new DefaultTimestamp();

}

