package com.ifrn.mapgas.repository.posto;

import com.ifrn.mapgas.domain.posto.Posto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoRepository extends JpaRepository<Posto, Long> {
}
