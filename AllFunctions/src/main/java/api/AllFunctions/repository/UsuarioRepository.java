package api.AllFunctions.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.AllFunctions.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //São exemplo, mas essas funções dentro do JPA ja faz tudo praticamente sozinho com o extends.    
    // @Query("SELECT * FROM Usuario WHERE Id = :id")
    // Usuario buscarUsuarioById(Long id);

    // @Query("SELECT * FROM Usuario WHERE nome = :nome")
    // Usuario buscarUsuarioByUsername(String nome);

    Usuario findAllById(Long id);

    @Query("SELECT u FROM Usuario u WHERE u.nome = :nome")
    Usuario buscarUsuarioByUsername(@Param("nome") String nome);

    @Query("DELETE FROM Usuario WHERE Id = :id")
    Usuario deletarUsuarioById(Long id);

    @Query(value = "INSERT INTO Usuario (nome, email, senha) VALUES (:nome, :email, :senha)", nativeQuery = true)
    void adicionarUsuario(@Param("nome") String nome, @Param("email") String email, @Param("senha") String senha);

}
