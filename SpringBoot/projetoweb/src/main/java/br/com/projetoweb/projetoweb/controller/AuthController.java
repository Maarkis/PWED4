package br.com.projetoweb.projetoweb.controller;

import br.com.projetoweb.projetoweb.entity.Usuario;
import br.com.projetoweb.projetoweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
public class AuthController {
    @Autowired
    private UsuarioRepository _usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, Object> credentials, HttpSession session) {
        String login = (String) credentials.get("login");
        String password = (String) credentials.get("password");
        List<Usuario> users = _usuarioRepository.findByLoginAndSenha(login, password);
        if (!users.isEmpty()) {
            Usuario foundUser = users.get(0);
            UUID sessionId = UUID.randomUUID();
            session.setAttribute("access-token", sessionId.toString());
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("username", foundUser.getNome());
            map.put("profile", foundUser.getPerfilUsuario().getNome());
            map.put("access-token", sessionId.toString());
            map.put("id", foundUser.getIdUsuario());
            return ResponseEntity.ok(map);
        }
        return ResponseEntity.notFound().build();
    }

}
