package br.com.projetoweb.projetoweb.controller;


import br.com.projetoweb.projetoweb.entity.PerfilUsuario;
import br.com.projetoweb.projetoweb.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PerfilUsuarioController {
    @Autowired
    private PerfilUsuarioRepository _perfilUsuarioRepository;

    // Method GET
    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public List<PerfilUsuario> Get() {
        return _perfilUsuarioRepository.findAll();
    }

    // Method GET ById
    @RequestMapping(value = "/perfil/{idPerfilUsuario}", method = RequestMethod.GET)
    public ResponseEntity<PerfilUsuario> GetById(@PathVariable(value = "idPerfilUsuario") long idPerfilUsuario) {
        Optional<PerfilUsuario> perfilUsuario = _perfilUsuarioRepository.findById(idPerfilUsuario);
        if (perfilUsuario.isPresent())
            return new ResponseEntity<PerfilUsuario>(perfilUsuario.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Method POST
    @RequestMapping(value = "/perfil", method = RequestMethod.POST)
    public PerfilUsuario Post(@Valid @RequestBody PerfilUsuario perfilUsuario) { return _perfilUsuarioRepository.save(perfilUsuario); }


    // Method PUT
    @RequestMapping(value = "/perfil/{idPerfilUsuario}", method = RequestMethod.PUT)
    public ResponseEntity<PerfilUsuario> Put(@PathVariable(value = "idPerfilUsuario") long idPerfilUsuario, @Valid @RequestBody PerfilUsuario newPerfilUsuario) {
        Optional<PerfilUsuario> oldPerfilUsuario = _perfilUsuarioRepository.findById(idPerfilUsuario);
        if (oldPerfilUsuario.isPresent()) {
            PerfilUsuario perfilUsuario = oldPerfilUsuario.get();
            perfilUsuario.setNome(newPerfilUsuario.getNome());
            perfilUsuario.setDescricao(newPerfilUsuario.getDescricao());
            _perfilUsuarioRepository.save(perfilUsuario);
            return new ResponseEntity<PerfilUsuario>(perfilUsuario, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // Method DELETE ById
    @RequestMapping(value = "/pessoa/{idPerfilUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "idPerfilUsuario") long idPerfilUsuario) {
        Optional<PerfilUsuario> perfilUsuario = _perfilUsuarioRepository.findById(idPerfilUsuario);
        if (perfilUsuario.isPresent()) {
            _perfilUsuarioRepository.delete(perfilUsuario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
