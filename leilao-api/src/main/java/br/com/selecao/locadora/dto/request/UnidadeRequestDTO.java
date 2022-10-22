package br.com.selecao.locadora.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeRequestDTO {
    @NotEmpty(message = "O campo 'nome' não deve estar vazio.")
    @Size(max = 128, message = "O campo 'nome' não deve possuir mais de 128 caracteres.")
    private String nome;
}
