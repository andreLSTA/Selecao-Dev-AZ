package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.request.LeilaoRequestDTO;
import br.com.selecao.locadora.entity.Empresa;
import br.com.selecao.locadora.entity.Leilao;
import br.com.selecao.locadora.exception.APIException;
import br.com.selecao.locadora.repository.EmpresaRepository;
import br.com.selecao.locadora.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeilaoBO {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<Leilao> buscarTodos(){
        return leilaoRepository.findAll();
    }

    public Leilao buscarPorId(Long id) {
        Leilao leilao = this.validarLeilaoPorId(id);
        return leilao;
    }

    public Leilao salvar(LeilaoRequestDTO leilaoRequestDTO) {
        Leilao leilao = new Leilao();
        this.preencherLeilao(leilao, leilaoRequestDTO);

        return leilaoRepository.save(leilao);

    }

    public Leilao editarPorId(Long id, LeilaoRequestDTO leilaoRequestDTO) {
        Leilao leilao = this.validarLeilaoPorId(id);
        this.preencherLeilao(leilao, leilaoRequestDTO);

        return leilaoRepository.save(leilao);
    }

    public void deletarPorId(Long id) {
        Leilao leilao = this.validarLeilaoPorId(id);
        leilaoRepository.delete(leilao);
    }

    private Leilao validarLeilaoPorId(Long id) {
        return leilaoRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado um leilão de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private Empresa validarVendedorPorId(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado uma empresa de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private void preencherLeilao(Leilao leilao, LeilaoRequestDTO leilaoRequestDTO) {
        Empresa vendedor = this.validarVendedorPorId(leilaoRequestDTO.getVendedorId());

        leilao.setVendedor(vendedor);
        leilao.setCodigo(leilaoRequestDTO.getCodigo());
        leilao.setDescricao(leilaoRequestDTO.getDescricao());
        leilao.setInicioPrevisto(leilaoRequestDTO.getInicioPrevisto());
        leilao.setLotes(new ArrayList<>());
    }
}
