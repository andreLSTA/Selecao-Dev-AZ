package br.com.selecao.locadora.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private Boolean sucesso;
    private String mensagem;
    private HttpStatus status;
    private Object dados;
}
