package com.ifrn.mapgas.repository.location;

import com.ifrn.mapgas.domain.location.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
