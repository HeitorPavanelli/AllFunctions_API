package api.AllFunctions.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.AllFunctions.dtos.Login;
import api.AllFunctions.dtos.Sessao;
import api.AllFunctions.model.Usuario;
import api.AllFunctions.repository.UsuarioRepository;
import api.AllFunctions.security.CreateToken;
import api.AllFunctions.security.ObjectsToken;
import api.AllFunctions.security.SecurityConfig;

@RestController
public class LoginController {
     @Autowired
    private PasswordEncoder encoder;

    // @Autowired
    // private SecurityConfig securityConfig;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public Sessao logar(@RequestBody Login login){
        Usuario user = repository.buscarUsuarioByUsername(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getSenha());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Sessao sessao = new Sessao();
            sessao.setLogin(user.getNome());

            ObjectsToken jwtObject = new ObjectsToken();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            //jwtObject.setRoles(user.getRoles());
            sessao.setToken(CreateToken.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login");
        }
    }
}
