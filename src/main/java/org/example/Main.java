package org.example;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String comorbidade = "";


        UsuarioIdoso meuIdoso = new UsuarioIdoso("Conceição", "123456", 72, "Diabetica");
        meuIdoso.criarPlano();

        System.out.println();
        System.out.println();
        System.out.println();


       /* Conexao cx = new Conexao();
        Connection conn = null;


        conn = cx.getConnection();
        if( conn == null)
            System.out.println("A conexão não ocorreu");
        else
            System.out.println("O banco de dados está conectado");


        System.out.println(" ");

        System.out.println("Nome do Cliente: ");
        String nome= sc.nextLine();
        System.out.println("Fone do Cliente: ");
        String fone = sc.nextLine();

        String sql = "INSERT INTO Usuario (nome,telefone) values ('"+nome+"','"+fone+"')";
        //System.out.println(sql);

        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();

            int intRs = st.executeUpdate(sql);
            if (intRs > 0)
                System.out.println("Inclusão relaizada com sucesso");
            else
                System.out.println("Inclusão não realizada");
        } catch (SQLException e){
            System.out.println("erro ao inserir no banco: "+ e.getMessage());
        }
*/
    }
}