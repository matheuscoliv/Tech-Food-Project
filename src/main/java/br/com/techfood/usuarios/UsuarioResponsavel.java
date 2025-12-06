package br.com.techfood.usuarios;

import br.com.techfood.planosAlimentares.ClassificarPlano;

public class UsuarioResponsavel extends Usuario implements ClassificarPlano {
    private String nome;
    private String senha;
    private int idIdosoVinculado;
    private int somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public UsuarioResponsavel (String nome, String senha) {
        super(nome, senha);
    }

    public UsuarioResponsavel (String nome, String senha, int idIdosoVinculado) {
        super(nome, senha);
        this.idIdosoVinculado = idIdosoVinculado;
    }

    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 2;
    }
}
