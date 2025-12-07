package br.com.techfood.usuarios;


import br.com.techfood.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class Usuario {
    private String nome;
    private String senha;
    private int Id_User;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;

    }


    public int GuardaUsuarioBD(){
        Conexao cx = new Conexao();
        Connection conn = null;
        conn = cx.getConnection();

        String sql = "INSERT INTO Usuario (nome,credencial) values ('"+nome+"','"+senha+"')";


        try {
            Statement st = conn.createStatement();

            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                int idGerado = rs.getInt(1); // ID real criado no MySQL

                // salva no objeto
                this.Id_User = idGerado;

                System.out.println("ID gerado do usuario = " + idGerado);
                return idGerado;  // devolve o ID para ser usado em idoso/responsavel
            }

        } catch (SQLException e){
            System.out.println("erro ao inserir no banco: " + e.getMessage());
        }

        return -1; // caso dê erro
    }

    public void setId_User(int id) {
        this.Id_User = id;
    }

    public int getId_User() {
        return this.Id_User;
    }


}
