package com.ifrn.mapgas.service.location;

import com.ifrn.mapgas.domain.location.Cidade;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {
    public Cidade findCidadeById(Long id) {
        return new Cidade();
    }
}
