package br.com.minhamepresa.app_de_recados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minhamepresa.app_de_recados.entity.Recado;

@Repository
public interface RecadoRepository extends JpaRepository<Recado, Long>{
    
}
