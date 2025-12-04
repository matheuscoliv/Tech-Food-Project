package org.example;

public class UsuarioIdoso extends Usuario implements ClassificarPlano {
    private int idade;
    private String comorbidade;
    private int somaDasAvaliacoes;
    public UsuarioIdoso(String nome, String senha, int idade, String comorbidade) {
       super(nome, senha);
       this.idade = idade;
       this.comorbidade = comorbidade;
    }
    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 4;
    }
}
