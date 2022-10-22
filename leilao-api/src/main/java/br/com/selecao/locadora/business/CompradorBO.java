package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.request.CompradorRequestDTO;
import br.com.selecao.locadora.entity.Empresa;
import br.com.selecao.locadora.entity.Leilao;
import br.com.selecao.locadora.entity.Comprador;
import br.com.selecao.locadora.exception.APIException;
import br.com.selecao.locadora.repository.EmpresaRepository;
import br.com.selecao.locadora.repository.LeilaoRepository;
import br.com.selecao.locadora.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorBO {

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public List<Comprador> buscarTodos(){
        return compradorRepository.findAll();
    }

    public Comprador buscarPorId(Long id){
        Comprador comprador = this.validarCompradorPorId(id);
        return comprador;
    }

    public Comprador salvar(CompradorRequestDTO compradorRequestDTO){
        Comprador comprador = new Comprador();
        this.preencherComprador(comprador, compradorRequestDTO);

        return compradorRepository.save(comprador);

    }

    public Comprador editarPorId(Long id, CompradorRequestDTO compradorRequestDTO){
        Comprador comprador = this.validarCompradorPorId(id);
        this.preencherComprador(comprador, compradorRequestDTO);

        return compradorRepository.save(comprador);
    }

    public void deletarPorId(Long id) {
        Comprador comprador = this.validarCompradorPorId(id);

        compradorRepository.delete(comprador);
    }

    private Comprador validarCompradorPorId(Long id) {
        return compradorRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado um comprador de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private Leilao validarLeilaoPorId(Long id) {
        return leilaoRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado um leilão de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private Empresa validarEmpresaPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado uma empresa de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private void preencherComprador(Comprador comprador, CompradorRequestDTO compradorRequestDTO) {
        Empresa empresa = this.validarEmpresaPorId(compradorRequestDTO.getEmpresaId());
        Leilao leilao = this.validarLeilaoPorId(compradorRequestDTO.getLeilaoId());

        comprador.setLeilao(leilao);
        comprador.setEmpresa(empresa);
    }

}
