package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.LeilaoBO;
import br.com.selecao.locadora.dto.request.LeilaoRequestDTO;
import br.com.selecao.locadora.dto.response.ResponseDTO;
import br.com.selecao.locadora.entity.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/leiloes")
public class LeilaoService {

    @Autowired
    private LeilaoBO leilaoBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        List<Leilao> leiloes = leilaoBO.buscarTodos();
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar os leilões.", HttpStatus.OK, leiloes);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        Leilao leilao = leilaoBO.buscarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar o leilão.", HttpStatus.OK, leilao);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody LeilaoRequestDTO leilaoRequestDTO) {
        Leilao leilao = leilaoBO.salvar(leilaoRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao criar o leilão.", HttpStatus.CREATED, leilao);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> editarPorId(@PathVariable Long id, @Valid @RequestBody LeilaoRequestDTO leilaoRequestDTO) {
        Leilao leilao = leilaoBO.editarPorId(id, leilaoRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao salvar o leilão.", HttpStatus.OK, leilao);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletePorId(@PathVariable Long id) {
        leilaoBO.deletarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao deletar o leilão.", HttpStatus.OK, null);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

}