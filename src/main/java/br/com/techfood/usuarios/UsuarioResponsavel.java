package br.com.techfood.usuarios;

import br.com.techfood.Conexao;
import br.com.techfood.planosAlimentares.ClassificarPlano;
import br.com.techfood.planosAlimentares.PlanoAlimentar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

<<<<<<< HEAD
    public void mostrarPlanoDoIdosoVinculado(PlanoAlimentar plano, int idIdosoVinculado) {
        System.out.println(plano.toString());
    }

=======

    public void GuardarUsuarioResponsavel() {

        int idUserGerado = this.GuardaUsuarioBD(); // cria o usuário responsável

        if (idUserGerado <= 0) {
            System.out.println("Erro ao criar usuário responsável.");
            return;
        }

        Conexao cx = new Conexao();
        Connection conn = cx.getConnection();

        String sql = "INSERT INTO responsavel (Id_User, Id_Idoso) VALUES ("
                + idUserGerado + ", " + this.idIdosoVinculado + ")";

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.println("Responsável vinculado ao idoso com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir responsável: " + e.getMessage());
        }
    }



>>>>>>> a38146e48ea99685bc6ba9977a65609a9ccbfd46
    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 2;
    }
}
