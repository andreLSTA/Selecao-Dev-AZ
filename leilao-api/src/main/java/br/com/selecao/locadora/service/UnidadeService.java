package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.UnidadeBO;
import br.com.selecao.locadora.dto.request.UnidadeRequestDTO;
import br.com.selecao.locadora.dto.response.ResponseDTO;
import br.com.selecao.locadora.entity.Unidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/unidades")
public class UnidadeService {

    @Autowired
    private UnidadeBO unidadeBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        List<Unidade> unidades = unidadeBO.buscarTodos();
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar as unidades.", HttpStatus.OK, unidades);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        Unidade unidade = unidadeBO.buscarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar a unidade.", HttpStatus.OK, unidade);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody UnidadeRequestDTO unidadeRequestDTO) {
        Unidade unidade = unidadeBO.salvar(unidadeRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao criar a unidade.", HttpStatus.CREATED, unidade);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> editarPorId(@PathVariable Long id, @Valid @RequestBody UnidadeRequestDTO unidadeRequestDTO) {
        Unidade unidade = unidadeBO.editarPorId(id, unidadeRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao salvar a unidade.", HttpStatus.OK, unidade);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletePorId(@PathVariable Long id) {
        unidadeBO.deletarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao deletar a unidade.", HttpStatus.OK, null);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

}