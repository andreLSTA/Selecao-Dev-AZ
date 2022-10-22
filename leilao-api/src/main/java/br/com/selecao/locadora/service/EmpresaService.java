package br.com.selecao.locadora.service;

import br.com.selecao.locadora.business.EmpresaBO;
import br.com.selecao.locadora.dto.request.EmpresaRequestDTO;
import br.com.selecao.locadora.dto.response.ResponseDTO;
import br.com.selecao.locadora.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/empresas")
public class EmpresaService {

    @Autowired
    private EmpresaBO empresaBO;

    @GetMapping
    public ResponseEntity<Object> buscarTodos() {
        List<Empresa> empresas = empresaBO.buscarTodos();
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar as empresas.", HttpStatus.OK, empresas);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        Empresa empresa = empresaBO.buscarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao buscar a empresa.", HttpStatus.OK, empresa);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = empresaBO.salvar(empresaRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao criar a empresa.", HttpStatus.CREATED, empresa);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> editarPorId(@PathVariable Long id, @Valid @RequestBody EmpresaRequestDTO empresaRequestDTO) {
        Empresa empresa = empresaBO.editarPorId(id, empresaRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao salvar a empresa.", HttpStatus.OK, empresa);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Object> deletePorId(@PathVariable Long id) {
        empresaBO.deletarPorId(id);
        ResponseDTO responseDTO = new ResponseDTO(true, "Sucesso ao deletar a empresa.", HttpStatus.OK, null);
        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

}