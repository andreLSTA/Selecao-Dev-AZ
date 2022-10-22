package br.com.selecao.locadora.dto.request;

import br.com.selecao.locadora.entity.Leilao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoteRequestDTO {
    @NotNull(message = "O campo 'numeroLote' não deve ser nulo.")
    @PositiveOrZero(message = "O campo 'numeroLote' deve ser positivo ou zero.")
    private int numeroLote;

    @NotEmpty(message = "O campo 'descricao' não deve estar vazio.")
    @Size(max = 60, message = "O campo 'descricao' não deve possuir mais de 60 caracteres.")
    private String descricao;

    @Column(name = "quantidade", nullable = false)
    private float quantidade;

    @Column(name = "valorInicial")
    private float valorInicial;

    @NotEmpty(message = "O campo 'unidade' não deve estar vazio.")
    @Size(max = 128, message = "O campo 'unidade' não deve possuir mais de 128 caracteres.")
    private String unidade;

    @NotNull(message = "O campo 'leilaoId' não deve ser nulo.")
    @PositiveOrZero(message = "O campo 'leilaoId' deve ser positivo ou zero.")
    private Long leilaoId;
}
