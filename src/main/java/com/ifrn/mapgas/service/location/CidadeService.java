package com.ifrn.mapgas.service.location;

import com.ifrn.mapgas.domain.location.Cidade;
import com.ifrn.mapgas.exception.ResourceNotFoundException;
import com.ifrn.mapgas.repository.location.CidadeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {
    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    public Cidade findCidadeById(Long id) {
        return cidadeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Cidade", "id", id)
        );
    }
}
