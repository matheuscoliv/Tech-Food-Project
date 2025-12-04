package org.example;

public class Usuario implements ClassificarPlano{
    private String nome;
    private String senha;
    private int somaDasAvaliacoes;
    private int totalDeAvaliacoes;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
    @Override
    public int getClassificacao() {
        return (int) pegaMedia();
    }

}
