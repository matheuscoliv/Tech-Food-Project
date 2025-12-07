package br.com.techfood.usuarios;

import br.com.techfood.Conexao;
import br.com.techfood.lembretes.Lembretes;
import br.com.techfood.planosAlimentares.ClassificarPlano;
import br.com.techfood.planosAlimentares.PlanoAlimentar;
import br.com.techfood.planosAlimentares.PlanoConvertido;

import com.google.genai.types.GenerateContentResponse;

import com.google.genai.Client;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuarioIdoso extends Usuario implements ClassificarPlano {
    private int idade;
    private String comorbidade;
    private int idUsuario;
    private int somaDasAvaliacoes;

    public UsuarioIdoso(String nome, String senha, int idade, String comorbidade) {
       super(nome, senha);
       this.idade = idade;
       this.comorbidade = comorbidade;
    }

    public UsuarioIdoso(String nome, String senha, int idade, String comorbidade, int idUsuario) {
        super(nome, senha);
        this.idade = idade;
        this.comorbidade = comorbidade;
        this.idUsuario = idUsuario;
    }

    public int GuardarIdoso() {
        Conexao cx = new Conexao();
        Connection conn = cx.getConnection();

        String sql = "INSERT INTO idoso (Id_User, idade) VALUES ("
                + this.getId_User() + ", " + this.idade + ")";

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                int idIdosoGerado = rs.getInt(1);
                System.out.println("Idoso inserido com sucesso! (Id_Idoso=" + idIdosoGerado + ")");
                return idIdosoGerado;
            }

        } catch (SQLException e){
            System.out.println("Erro ao inserir idoso: " + e.getMessage());
        }

        return -1;
    }


    public int salvarComorbidade(int idIdoso, String nome) {

        Conexao cx = new Conexao();
        Connection conn = cx.getConnection();

        // NOME CORRETO DA TABELA: comorbidade
        String sql = "INSERT INTO comorbidades (nome_comorbidade, Id_Idoso) VALUES ('"
                + nome + "', " + idIdoso + ")";

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                int idGerado = rs.getInt(1);
                System.out.println("Comorbidade inserida! ID_Comorbidade = " + idGerado);
                return idGerado;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir comorbidade: " + e.getMessage());
        }

        return -1;
    }

    public void salvarIdosoComorbidade(int idIdoso, int idComorbidade, int idPlano) {

        Conexao cx = new Conexao();
        Connection conn = cx.getConnection();

        // NOME CORRETO DA TABELA: idoso_comorbidades (com S)
        String sql = "INSERT INTO idoso_comorbidade (Id_Idoso, Id_Comorbidade, Id_Plano_Alimentar) VALUES ("
                + idIdoso + ", " + idComorbidade + ", " + idPlano + ")";

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);

            System.out.println("Relacionamento salvo: Idoso=" + idIdoso +
                    ", Comorbidade=" + idComorbidade +
                    ", Plano=" + idPlano);

        } catch (SQLException e) {
            System.out.println("Erro ao salvar idoso_comorbidade: " + e.getMessage());
        }
    }







    public String getComorbidade() {
        return comorbidade;
    }

    public PlanoAlimentar criarPlano() {
        try {
            Client client = new Client();
            System.out.println("Criando um plano para o Idoso...");

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-2.5-flash",
                            """
                                    Gere um plano alimentar em JSON .json no formato abaixo, sem texto fora dele:
                                    {
                                        "titulo": "string",
                                        "dietaDoPlano": "string",
                                        "dicas": "string"
                                        "comorbidadeSelect": "string"
                                    }   
                                    
                                    Comorbidade: %s
                                    """.formatted(getComorbidade()),
                            null);

            String jsonLimpo = response.text().replaceAll("```json", "")
                    .replaceAll("```", "")
                    .trim();

            Gson gson = new Gson();
            PlanoConvertido planoJson = gson.fromJson(jsonLimpo, PlanoConvertido.class);


            FileWriter teste = new FileWriter("testandojson.json");
            teste.write(jsonLimpo);
            teste.close();


            PlanoAlimentar meuPlanoAlimentar = new PlanoAlimentar(planoJson);

            int idPlanoGerado = meuPlanoAlimentar.GuardaPlanoBD();

            if (idPlanoGerado <= 0) {
                System.out.println("ERRO: plano não foi salvo no banco.");
                return null;
            }

            //System.out.println("Plano salvo no banco! ID = " + idPlanoGerado);

            // SALVAR A COMORBIDADE DO IDOSO
            int idComorbidade = salvarComorbidade(this.getId_User(), this.comorbidade);

            if (idComorbidade > 0) {
                salvarIdosoComorbidade(this.getId_User(), idComorbidade, idPlanoGerado);
            }

            System.out.println(meuPlanoAlimentar.toString());
            return meuPlanoAlimentar;
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
            return null;
        }
    }

    public void criarLembrete() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Título do lembrete:");
        String titulo = sc.nextLine();

        System.out.println("Descrição do lembrete:");
        String desc = sc.nextLine();

        int idUser = this.getId_User(); // ID verdadeiro!

        Lembretes l = new Lembretes(titulo, desc, idUser);
        int idGerado = l.GuardaLembreteBD();

        if (idGerado > 0) {
            System.out.println("Lembrete salvo! ID = " + idGerado);
        }
    }






    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 4;
    }
}
