package ifsc.poo.locadora.domain;

import java.util.Objects;

public class Cliente {
    // Estáticos
    public static final String SENHA_PADRAO;

    static {
        SENHA_PADRAO = "1234";
    }

    // Atributos
    private String login, nome, email, telefone, senha;

    // Utils
    private void checkInvariants() {
        if (senha.isEmpty()) senha = SENHA_PADRAO;
    }

    // Construtor
    public Cliente(String login, String nome, String email, String telefone, String senha) {
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.checkInvariants();
    }

    // Acessos
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        this.checkInvariants();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Representação
    @Override
    public String toString() {
        return "Cliente{" +
                "login='" + login + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    // Comparação semântica
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(login, cliente.login);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(login);
    }
}
