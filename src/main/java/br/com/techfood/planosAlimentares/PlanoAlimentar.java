package br.com.techfood.planosAlimentares;

public class PlanoAlimentar {
    private String descricaoPlano;
    private String tituloDoPlano;
    private String comorbidadeSelecionada;
    private String dicasExtras;

    public PlanoAlimentar(String tituloDoPlano, String comorbidadeSelecionada, String descricaoPlano, String dicasExtras) {
        this.tituloDoPlano = tituloDoPlano;
        this.comorbidadeSelecionada = comorbidadeSelecionada;
        this.descricaoPlano = descricaoPlano;
        this.dicasExtras = dicasExtras;
    }

    public PlanoAlimentar(PlanoConvertido planoJson) {
        this.tituloDoPlano = planoJson.titulo();
        this.comorbidadeSelecionada = planoJson.comorbidadeSelect();
        this.descricaoPlano = planoJson.dietaDoPlano();
        this.dicasExtras = planoJson.dicas();
    }



    //PRECISO ENTENDER COMO COLOCAR UM PLANO ALIMENTAR CONVERTIDO EM JSON DENTRO DA CLASSE PLANO ALIMENTAR POS SER CONVERTIDO

    public String getDescricaoPlano() {
        return descricaoPlano;
    }

    @Override
    public String toString() {
        return "==========================================\n" +
                "Plano Alimentar Gerado!\n" +
                "==========================================\n" +
                "Título do Plano: " + tituloDoPlano + "\n" +
                "Comorbidade: " + comorbidadeSelecionada + "\n" +
                "------------------------------------------\n" +
                "DIETA DO PLANO:\n" + descricaoPlano + "\n" +
                "------------------------------------------\n" +
                "DICAS EXTRAS:\n" + dicasExtras + "\n" +
                "==========================================";
    }
}
