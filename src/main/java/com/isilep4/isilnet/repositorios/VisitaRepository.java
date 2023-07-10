package com.isilep4.isilnet.repositorios;

import com.isilep4.isilnet.entidades.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Long> {
    boolean existsByDniAfiliado(String dniAfiliado);
    Visita findByDniAfiliado(String dniAfiliado);
}