package com.ifrn.mapgas.repository.location;

import com.ifrn.mapgas.domain.location.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
