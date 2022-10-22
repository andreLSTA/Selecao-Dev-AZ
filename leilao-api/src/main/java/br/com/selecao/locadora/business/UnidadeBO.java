package br.com.selecao.locadora.business;

import br.com.selecao.locadora.dto.request.UnidadeRequestDTO;
import br.com.selecao.locadora.entity.Unidade;
import br.com.selecao.locadora.exception.APIException;
import br.com.selecao.locadora.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeBO {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<Unidade> buscarTodos(){
        return unidadeRepository.findAll();
    }

    public Unidade buscarPorId(Long id){
        Unidade unidade = this.validarUnidadePorId(id);
        return unidade;
    }

    public Unidade salvar(UnidadeRequestDTO unidadeRequestDTO){
        Unidade unidade = new Unidade();
        this.preencherUnidade(unidade, unidadeRequestDTO);

        return unidadeRepository.save(unidade);
    }

    public Unidade editarPorId(Long id, UnidadeRequestDTO unidadeRequestDTO){
        Unidade unidade = this.validarUnidadePorId(id);
        this.preencherUnidade(unidade, unidadeRequestDTO);

        return unidadeRepository.save(unidade);
    }

    public void deletarPorId(Long id) {
        Unidade unidade = this.validarUnidadePorId(id);
        unidadeRepository.delete(unidade);
    }

    private Unidade validarUnidadePorId(Long id) {
        return unidadeRepository.findById(id)
                .orElseThrow(() -> new APIException(String.format("Não foi encontrado uma unidade de id %d.", id), HttpStatus.NOT_FOUND));
    }

    private void preencherUnidade(Unidade unidade, UnidadeRequestDTO unidadeRequestDTO) {
        unidade.setNome(unidadeRequestDTO.getNome());
    }

}
