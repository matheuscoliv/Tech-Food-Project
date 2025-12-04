package org.example;

public class UsuarioResponsavel extends Usuario{
    private String nome;
    private String senha;
    private int somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public UsuarioResponsavel (String nome, String senha) {
        super(nome, senha);

    }
}
