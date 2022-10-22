package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.CompradorBO;
import br.com.selecao.locadora.dto.request.CompradorRequestDTO;
import br.com.selecao.locadora.dto.response.ResponseDTO;
import br.com.selecao.locadora.entity.Comprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/compradores")
public class CompradorService {

    @Autowired
    private CompradorBO compradorBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        List<Comprador> compradores = compradorBO.buscarTodos();
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar os compradores.", HttpStatus.OK, compradores);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        Comprador comprador = compradorBO.buscarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar o comprador.", HttpStatus.OK, comprador);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody CompradorRequestDTO compradorRequestDTO) {
        Comprador comprador = compradorBO.salvar(compradorRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao criar o comprador.", HttpStatus.CREATED, comprador);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> editarPorId(@PathVariable Long id, @Valid @RequestBody CompradorRequestDTO compradorRequestDTO) {
        Comprador comprador = compradorBO.editarPorId(id, compradorRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao salvar o comprador.", HttpStatus.OK, comprador);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletePorId(@PathVariable Long id) {
        compradorBO.deletarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao deletar o comprador.", HttpStatus.OK, null);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

}