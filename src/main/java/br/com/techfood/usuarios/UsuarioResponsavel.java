package br.com.techfood.usuarios;

import br.com.techfood.Conexao;
import br.com.techfood.planosAlimentares.ClassificarPlano;

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


    public void GuardarUsuarioResponsavel() {

        int idUserGerado = this.GuardaUsuarioBD();

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
            int linhas = st.executeUpdate(sql);

            if (linhas > 0) {
                System.out.println("Responsável vinculado ao idoso com sucesso!");
            } else {
                System.out.println("Falha ao vincular responsável.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir responsável: " + e.getMessage());
        }
    }


    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 2;
    }
}
