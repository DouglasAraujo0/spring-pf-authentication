package br.com.fiap.springpfauthentication.repository;

import br.com.fiap.springpfauthentication.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
