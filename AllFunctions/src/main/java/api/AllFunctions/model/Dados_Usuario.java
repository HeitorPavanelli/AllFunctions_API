package api.AllFunctions.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dados_Usuario")
public class Dados_Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long Celular;

    @Column(nullable = false)
    private String Endereco;

    @Column(nullable = false)

    private String Cep;

    @Column(nullable = false, unique = true)
    private String Cpf;

    @Column(nullable = false)
    private String Sexo;

    @Column(nullable = false)
    private Date Data_Nasc;

    public Dados_Usuario() {
    }

    public Dados_Usuario(Long celular, String endereco, String cep, String cpf, String sexo, Date data_Nasc) {
        this.Celular = celular;
        this.Endereco = endereco;
        this.Cep = cep;
        this.Cpf = cpf;
        this.Sexo = sexo;
        this.Data_Nasc = data_Nasc;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getCelular() {
        return Celular;
    }
    public void setCelular(Long celular) {
        Celular = celular;
    }

    public String getEndereco() {
        return Endereco;
    }
    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getCep() {
        return Cep;
    }
    public void setCep(String cep) {
        Cep = cep;
    }

    public String getCpf() {
        return Cpf;
    }
    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public Date getData_Nasc() {
        return Data_Nasc;
    }
    public void setData_Nasc(Date data_Nasc) {
        Data_Nasc = data_Nasc;
    }

}
