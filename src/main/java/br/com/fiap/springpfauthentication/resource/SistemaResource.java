package br.com.fiap.springpfauthentication.resource;

import br.com.fiap.springpfauthentication.entity.Sistema;
import br.com.fiap.springpfauthentication.entity.Usuario;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/sistema")
public class SistemaResource {

    @Autowired
    private SistemaRepository repo;

    @GetMapping
    public List<Sistema> findAll() {
        return repo.findAll();
    }

    @Transactional
    @PostMapping
    public Sistema save(@RequestBody Sistema sistema) {
        return repo.save( sistema );
    }

    @GetMapping(value = "/{id}")
    public Sistema findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping(value = "/{id}/responsaveis")
    public Set<Usuario> GetResponsaveisByPerfilId(@PathVariable Long id) {
        Sistema sistema = repo.findById(id).orElseThrow();
        return sistema.getResponsaveis();
    }

    @PostMapping(value = "/{id}/permissoes")
    public ResponseEntity<String> addPermissaoToPerfil(@PathVariable Long id, @RequestBody Usuario usuario) {
        Sistema sistema = repo.findById(id).orElseThrow();
        sistema.getResponsaveis().add(usuario);
        repo.save(sistema); // Salvar o perfil atualizado com a nova permissão
        return ResponseEntity.ok("Permissão adicionada com sucesso ao perfil de ID " + id);
    }
}
