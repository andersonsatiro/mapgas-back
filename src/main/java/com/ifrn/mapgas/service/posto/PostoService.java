package com.ifrn.mapgas.service.posto;

import com.ifrn.mapgas.domain.location.Endereco;
import com.ifrn.mapgas.domain.posto.Posto;
import com.ifrn.mapgas.dto.posto.PostoRequestDTO;
import com.ifrn.mapgas.repository.posto.PostoRepository;
import com.ifrn.mapgas.service.location.EnderecoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostoService {

    private final EnderecoService enderecoService;
    private final PostoRepository postoRepository;

    public PostoService(
        EnderecoService enderecoService,
        PostoRepository postoRepository
    ) {
        this.enderecoService = enderecoService;
        this.postoRepository = postoRepository;
    }

    @Transactional
    public Posto createPosto(PostoRequestDTO dto) {
        Endereco endereco = enderecoService.createEnderecoFromPosto(dto);
        if (endereco == null) return null;

        Posto posto = new Posto();
        posto.setRazaoSocial(dto.getRazaoSocial());
        posto.setNomeFantasia(dto.getNomeFantasia());
        posto.setStatus(dto.getStatus());
        posto.setEndereco(endereco);

        return postoRepository.save(posto);
    }

    public List<Posto> getAllPostos() {
        return postoRepository.findAll();
    }
}
