package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.request.EmpresaRequestDTO;
import br.com.selecao.locadora.entity.Empresa;
import br.com.selecao.locadora.exception.APIException;
import br.com.selecao.locadora.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaBO {

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Empresa> buscarTodos(){
        return empresaRepository.findAll();
    }

    public Empresa buscarPorId(Long id){
        Empresa empresa = this.validarEmpresaPorId(id);
        return empresa;
    }

    public Empresa salvar(EmpresaRequestDTO empresaRequestDTO){
        Empresa empresa = new Empresa();
        this.preencherEmpresa(empresa, empresaRequestDTO);

        return empresaRepository.save(empresa);
    }

    public Empresa editarPorId(Long id, EmpresaRequestDTO empresaRequestDTO){
        Empresa empresa = this.validarEmpresaPorId(id);
        this.preencherEmpresa(empresa, empresaRequestDTO);

        return empresaRepository.save(empresa);
    }

    public void deletarPorId(Long id) {
        Empresa empresa = this.validarEmpresaPorId(id);
        empresaRepository.delete(empresa);
    }

    private Empresa validarEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado uma empresa de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private void preencherEmpresa(Empresa empresa, EmpresaRequestDTO empresaRequestDTO) {
        empresa.setRazaoSocial(empresaRequestDTO.getRazaoSocial());
        empresa.setCnpj(empresaRequestDTO.getCnpj());
        empresa.setLogradouro(empresaRequestDTO.getLogradouro());
        empresa.setMunicipio(empresaRequestDTO.getMunicipio());
        empresa.setComplemento(empresaRequestDTO.getComplemento());
        empresa.setBairro(empresaRequestDTO.getBairro());
        empresa.setCep(empresaRequestDTO.getCep());
        empresa.setTelefone(empresaRequestDTO.getTelefone());
        empresa.setEmail(empresaRequestDTO.getEmail());
        empresa.setSite(empresaRequestDTO.getSite());
        empresa.setUsuario(empresaRequestDTO.getUsuario());
        empresa.setSenha(empresaRequestDTO.getSenha());
    }

}
