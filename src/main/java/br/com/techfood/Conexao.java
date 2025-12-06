package br.com.techfood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private String login = "root";
    private String senha = "pokemon.123";
    private String host = "localhost";
    private String dbName = "techfood";
    private String url = "jdbc:mysql://"+ host+":3306/"+dbName+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";




    public  Connection conexao = null;

    public  Conexao(){ }

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
        try {
            this.conexao = (Connection) DriverManager.getConnection(url,login,senha);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return this.conexao;
    }
}
