package br.com.minhamepresa.app_de_recados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.minhamepresa.app_de_recados.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query("SELECT u FROM Usuario u WHERE u.username = (:username)")
    public Usuario findByUsername(@Param("username") String username);
    
}
