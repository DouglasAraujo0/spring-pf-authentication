package br.com.fiap.springpfauthentication.resource;

import br.com.fiap.springpfauthentication.entity.Perfil;
import br.com.fiap.springpfauthentication.repository.PerfilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil")

public class PerfilResource {

    @Autowired
    private PerfilRepository repo;

    @GetMapping
    public List<Perfil> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Perfil findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public  Perfil save(@RequestBody Perfil perfil) {
        return repo.save( perfil );
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        Perfil perfil = repo.findById( id ).get();
        repo.delete( perfil );
    }
}
