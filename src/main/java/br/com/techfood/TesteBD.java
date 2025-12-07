/*package br.com.techfood;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TesteBD {
    public static void main (String[] args){

    Conexao cx = new Conexao();
    Connection conn = null;
    conn = cx.getConnection();


    if( conn == null)
        System.out.println("A conexão não ocorreu");
    else
        System.out.println("O banco de dados está conectado");


    System.out.println(" ");

    Scanner sc = new Scanner(System.in);

    System.out.println("Nome do Cliente: ");
    String nome= sc.nextLine();
    System.out.println("Fone do Cliente: ");
    String credencial = sc.nextLine();

    String sql = "INSERT INTO usuario (nome,credencial) values ('"+nome+"','"+credencial+"')";
    //System.out.println(sql);

    ResultSet rs = null;
    try {
        Statement st = conn.createStatement();

        int linhas = st.executeUpdate(sql);
        if (linhas > 0)
            System.out.println("Inclusão relaizada com sucesso");
        else
            System.out.println("Inclusão não realizada");
    } catch (SQLException e){
        System.out.println("erro ao inserir no banco: "+ e.getMessage());
    }

    }
}

*/