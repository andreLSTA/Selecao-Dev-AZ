package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.LoteBO;
import br.com.selecao.locadora.dto.request.LoteRequestDTO;
import br.com.selecao.locadora.dto.response.ResponseDTO;
import br.com.selecao.locadora.entity.Lote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/lotes")
public class LoteService {

    @Autowired
    private LoteBO loteBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        List<Lote> lotes = loteBO.buscarTodos();
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar os lotes.", HttpStatus.OK, lotes);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        Lote lote = loteBO.buscarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar o lote.", HttpStatus.OK, lote);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody LoteRequestDTO loteRequestDTO) {
        Lote lote = loteBO.salvar(loteRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao criar o lote.", HttpStatus.CREATED, lote);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> editarPorId(@PathVariable Long id, @Valid @RequestBody LoteRequestDTO loteRequestDTO) {
        Lote lote = loteBO.editarPorId(id, loteRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao salvar o lote.", HttpStatus.OK, lote);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletePorId(@PathVariable Long id) {
        loteBO.deletarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao deletar o lote.", HttpStatus.OK, null);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

}