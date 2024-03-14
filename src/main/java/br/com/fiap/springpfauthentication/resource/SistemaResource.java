package br.com.fiap.springpfauthentication.resource;

import br.com.fiap.springpfauthentication.entity.Sistema;
import br.com.fiap.springpfauthentication.entity.Usuario;
import br.com.fiap.springpfauthentication.repository.SistemaRepository;
import br.com.fiap.springpfauthentication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@RestController
@RequestMapping(value = "/sistema")
public class SistemaResource {
    @Autowired
    private SistemaRepository sistemRepo;

    @Autowired
    private UsuarioRepository userRepo;

    @GetMapping
    public List<Sistema> findAll() {
        return sistemRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Sistema findById(@PathVariable Long id) {
        return sistemRepo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Sistema save(@RequestBody Sistema sistema) {
        return sistemRepo.save(sistema);
    }

    @GetMapping(value = "/{id}/responsaveis")
    public Set<Usuario> findRespo(@PathVariable Long id) {
        Sistema sistema = sistemRepo.findById(id).orElseThrow();
        return sistema.getResponsaveis();
    }

    @Transactional
    @PostMapping(value = "/{id}/responsaveis")
    public Sistema addRespo(@PathVariable Long id, @RequestBody Usuario user) {
        Sistema sistema = sistemRepo.findById(id).orElseThrow();

        if (Objects.isNull(user)) return null;

        if (Objects.nonNull(user.getId())) {
            Usuario usuario = userRepo.findById(user.getId()).orElseThrow();
            sistema.getResponsaveis().add(usuario);
            return sistema;
        }
        sistema.getResponsaveis().add(user);
        return sistema;
    }
}
