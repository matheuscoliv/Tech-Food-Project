package br.com.techfood.lembretes;
import br.com.techfood.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Lembretes {
    private String titulo;
    private String descricaoLembrete;
    private int idUsuario;

    public Lembretes(String titulo, String descricaoLembrete, int idUsuario) {
        this.titulo = titulo;
        this.descricaoLembrete = descricaoLembrete;
        this.idUsuario = idUsuario;
    }

    private Lembretes(Builder builder) {
        this.titulo = builder.titulo;
        this.descricaoLembrete = builder.descricaoLembrete;
        this.idUsuario = builder.idUsuario;
    }

    public int GuardaLembreteBD() {

        Conexao cx = new Conexao();
        Connection conn = cx.getConnection();

        String sql = "INSERT INTO lembrete (titulo, descricao, Id_User) VALUES ('"
                + this.titulo + "', '" + this.descricaoLembrete + "', " + this.idUsuario + ")";

        try {
            Statement st = conn.createStatement();

            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                System.out.println("Lembrete inserido com sucesso! ID = " + idGerado);
                return idGerado;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir lembrete: " + e.getMessage());
        }

        return -1;
    }


    public static class Builder {
        private String titulo;
        private String descricaoLembrete;
        private int idUsuario;

        public Builder(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public Builder adicionarTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder adicionarDesc(String descricaoLembrete) {
            this.descricaoLembrete = descricaoLembrete;
            return this;
        }

        public Lembretes build() {
            return new Lembretes(this);
        }
    }


    @Override
    public String toString() {
        return "==========================================\n" +
                "Lembrete Gerado!\n" +
                "==========================================\n" +
                "Título do Lembrete: " + titulo + "\n" +
                "Descrição: " + descricaoLembrete + "\n" +
                "------------------------------------------\n" +
                "ID DO USUÁRIO: " + idUsuario + "\n" +
                "==========================================";
    }
}
