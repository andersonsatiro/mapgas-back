package com.ifrn.mapgas.service.location;

import com.ifrn.mapgas.domain.location.Cidade;
import com.ifrn.mapgas.domain.location.Endereco;
import com.ifrn.mapgas.dto.posto.PostoRequestDTO;
import com.ifrn.mapgas.repository.location.EnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EnderecoService {

    private final CidadeService cidadeService;
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(
        CidadeService cidadeService, EnderecoRepository enderecoRepository
    ) {
        this.cidadeService = cidadeService;
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Endereco createEnderecoFromPosto(PostoRequestDTO postoDto) {
        if (postoDto == null) return null;

        Cidade cidade = cidadeService.findCidadeById(postoDto.getCidadeId());

        Endereco endereco = new Endereco();
        endereco.setRua(postoDto.getRua());
        endereco.setCep(postoDto.getCep());
        endereco.setLatitude(postoDto.getLatitude());
        endereco.setLongitude(postoDto.getLongitude());
        endereco.setComplemento(postoDto.getComplemento());
        endereco.setCidade(cidade);

        return enderecoRepository.save(endereco);
    }
}
