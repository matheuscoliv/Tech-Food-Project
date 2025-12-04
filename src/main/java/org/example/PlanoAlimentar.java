package org.example;

public class PlanoAlimentar {
    private String descricaoPlano;
    private String tituloDoPlano;
    private String comorbidadeSelecionada;

    public PlanoAlimentar(String descricaoPlano, String tituloDoPlano, String comorbidadeSelecionada) {
        this.descricaoPlano = descricaoPlano;
        this.tituloDoPlano = tituloDoPlano;
        this.comorbidadeSelecionada = comorbidadeSelecionada;
    }

    public String getDescricaoPlano() {
        return descricaoPlano;
    }

    @Override
    public String toString() {
        String desc = getDescricaoPlano();
        return "Descrição da Dieta: " + desc +
                "\nData do Plano: " + tituloDoPlano +
                "\nComorbidade(s): " + comorbidadeSelecionada;
    }
}
