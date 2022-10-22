package br.com.selecao.locadora.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequestDTO {

    @NotNull(message = "O campo 'razaoSocial' não deve estar vazio.")
    @Size(max = 64, message = "O campo 'razaoSocial' não deve possuir mais de 64 caracteres.")
    private String razaoSocial;

    @NotEmpty(message = "O campo 'cnpj' não deve estar vazio.")
    @Size(max = 64, message = "O campo 'cnpj' não deve possuir mais de 64 caracteres.")
    private String cnpj;

    @Size(max = 64, message = "O campo 'logradouro' não deve possuir mais de 64 caracteres.")
    private String logradouro;

    @Size(max = 64, message = "O campo 'municipio' não deve possuir mais de 64 caracteres.")
    private String municipio;

    @Size(max = 10, message = "O campo 'numero' não deve possuir mais de 10 caracteres.")
    private String numero;

    @Size(max = 64, message = "O campo 'complemento' não deve possuir mais de 64 caracteres.")
    private String complemento;

    @Size(max = 64, message = "O campo 'bairro' não deve possuir mais de 64 caracteres.")
    private String bairro;

    @Size(max = 16, message = "O campo 'cep' não deve possuir mais de 16 caracteres.")
    private String cep;

    @Size(max = 32, message = "O campo 'telefone' não deve possuir mais de 32 caracteres.")
    private String telefone;

    @NotEmpty(message = "O campo 'email' não deve estar vazio.")
    @Size(max = 254, message = "O campo 'email' não deve possuir mais de 254 caracteres.")
    @Email(message = "O campo 'email' deve possuir um email válido.")
    private String email;

    @Size(max = 254, message = "O campo 'site' não deve possuir mais de 254 caracteres.")
    private String site;

    @NotEmpty(message = "O campo 'usuario' não deve estar vazio.")
    @Size(max = 20, message = "O campo 'usuario' não deve possuir mais de 20 caracteres.")
    private String usuario;

    @Size(max = 128, message = "O campo 'senha' não deve possuir mais de 128 caracteres.")
    private String senha;

}
