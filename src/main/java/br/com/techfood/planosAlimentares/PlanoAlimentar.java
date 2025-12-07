package br.com.techfood.planosAlimentares;

import br.com.techfood.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        this.tituloDoPlano = planoJson.titulo(); // titulo
        this.comorbidadeSelecionada = planoJson.comorbidadeSelect();
        this.descricaoPlano = planoJson.dietaDoPlano(); // descrição
        this.dicasExtras = planoJson.dicas(); // dieta

    }


    // DADOS INSERIDOS NO BD MySQL
    public int GuardaPlanoBD() {
        Conexao cx = new Conexao();
        Connection conn = cx.getConnection();

        String sql = "INSERT INTO plano_alimentar (titulo, descricao, dieta) VALUES ('" + this.tituloDoPlano + "', '" + this.descricaoPlano + "', '" + this.dicasExtras + "')";

        try {
            Statement st = conn.createStatement();

            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int idPlanoGerado = rs.getInt(1);
                System.out.println("Plano alimentar inserido com sucesso! ID = " + idPlanoGerado);
                return idPlanoGerado;
            }

        } catch (SQLException e){
            System.out.println("Erro ao inserir no banco: " + e.getMessage());
        }

        return -1;
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
