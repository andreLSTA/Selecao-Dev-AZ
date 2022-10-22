package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.request.LoteRequestDTO;
import br.com.selecao.locadora.entity.Leilao;
import br.com.selecao.locadora.entity.Lote;
import br.com.selecao.locadora.exception.APIException;
import br.com.selecao.locadora.repository.LeilaoRepository;
import br.com.selecao.locadora.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteBO {

    @Autowired
    private LoteRepository loteRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public List<Lote> buscarTodos(){
        return loteRepository.findAll();
    }

    public Lote buscarPorId(Long id){
        Lote lote = this.validarLotePorId(id);
        return lote;
    }

    public Lote salvar(LoteRequestDTO loteRequestDTO){
        Lote lote = new Lote();
        this.preencherLeilao(lote, loteRequestDTO);

        return loteRepository.save(lote);

    }

    public Lote editarPorId(Long id, LoteRequestDTO loteRequestDTO){
        Lote lote = this.validarLotePorId(id);
        this.preencherLeilao(lote, loteRequestDTO);

        return loteRepository.save(lote);
    }

    public void deletarPorId(Long id) {
        Lote lote = this.validarLotePorId(id);

        loteRepository.delete(lote);
    }

    private Lote validarLotePorId(Long id) {
        return loteRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado um lote de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private Leilao validarLeilaoPorId(Long id) {
        return leilaoRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado um leilão de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private void preencherLeilao(Lote lote, LoteRequestDTO loteRequestDTO) {
        Leilao leilao = this.validarLeilaoPorId(loteRequestDTO.getLeilaoId());

        lote.setLeilao(leilao);
        lote.setNumeroLote(loteRequestDTO.getNumeroLote());
        lote.setDescricao(loteRequestDTO.getDescricao());
        lote.setQuantidade(loteRequestDTO.getQuantidade());
        lote.setValorInicial(loteRequestDTO.getValorInicial());
        lote.setUnidade(loteRequestDTO.getUnidade());
    }

}
