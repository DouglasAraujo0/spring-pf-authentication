package br.com.fiap.springpfauthentication.resource;


import br.com.fiap.springpfauthentication.entity.Permissao;
import br.com.fiap.springpfauthentication.entity.Sistema;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sistema")

public class SistemaResource {

    @Autowired
    private SistemaRepository repo;

    @GetMapping
    public List<Sistema> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Sistema findById(@PathVariable Long id) {
        return repo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Sistema save(@RequestBody Sistema sistema) {
        return repo.save( sistema );
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        Sistema sistema = repo.findById( id ).get();
        repo.delete( sistema );
    }
}
