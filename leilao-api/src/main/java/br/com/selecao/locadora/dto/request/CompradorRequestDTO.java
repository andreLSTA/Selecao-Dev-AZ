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
public class CompradorRequestDTO {
    @NotNull(message = "O campo 'empresaId' não deve ser nulo.")
    private Long empresaId;

    @NotNull(message = "O campo 'leilaoId' não deve ser nulo.")
    private Long leilaoId;
}
