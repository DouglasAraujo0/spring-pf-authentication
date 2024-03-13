package br.com.fiap.springpfauthentication.resource;

import br.com.fiap.springpfauthentication.entity.Perfil;
import br.com.fiap.springpfauthentication.entity.Permissao;
import br.com.fiap.springpfauthentication.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

    @Autowired
    private PerfilRepository repo;

    @GetMapping
    public List<Perfil> findAll() {
        return repo.findAll();
    }

    @Transactional
    @PostMapping
    public Perfil save(@RequestBody Perfil perfil) {
        return repo.save( perfil );
    }

    @GetMapping(value = "/{id}")
    public Perfil findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping(value = "/{id}/permissoes")
    public Set<Permissao> GetPermissoesByPerfilId(@PathVariable Long id) {
        Perfil perfil = repo.findById(id).orElseThrow();
        return perfil.getPermissoes();
    }

    @PostMapping(value = "/{id}/permissoes")
    public ResponseEntity<String> addPermissaoToPerfil(@PathVariable Long id, @RequestBody Permissao permissao) {
        Perfil perfil = repo.findById(id).orElseThrow();
        perfil.getPermissoes().add(permissao);
        repo.save(perfil);
        return ResponseEntity.ok("Permissão adicionada com sucesso ao perfil de ID " + id);
    }
}

