package br.com.selecao.locadora.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeilaoRequestDTO {
    @NotNull(message = "O campo 'codigo' não deve ser nulo.")
    @PositiveOrZero(message = "O campo 'codigo' deve ser positivo ou zero.")
    private int codigo;

    @NotEmpty(message = "O campo 'descricao' não deve estar vazio.")
    @Size(max = 60, message = "O campo 'descricao' não deve possuir mais de 60 caracteres.")
    private String descricao;

    @NotNull(message = "O campo 'vendedorId' não deve ser nulo.")
    private Long vendedorId;

    @NotNull
    private LocalDateTime inicioPrevisto;
}
