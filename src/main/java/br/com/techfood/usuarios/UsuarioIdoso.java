package br.com.techfood.usuarios;

import br.com.techfood.lembretes.Lembretes;
import br.com.techfood.planosAlimentares.ClassificarPlano;
import br.com.techfood.planosAlimentares.PlanoAlimentar;
import br.com.techfood.planosAlimentares.PlanoConvertido;

import com.google.genai.types.GenerateContentResponse;

import com.google.genai.Client;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.util.Scanner;

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
            System.out.println(meuPlanoAlimentar.toString());
            return meuPlanoAlimentar;
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
            return null;
        }
    }

    public void criarLembrete() {
        Scanner sc = new Scanner(System.in);
        int idUsuario;
        String descricaoLembrete = "";
        String titulo = "";
        System.out.println("Informe o ID do Usuario");
        idUsuario = sc.nextInt();
        sc.nextLine();
        System.out.println("Titulo do lembrete: ");
        titulo = sc.nextLine();
        System.out.println("Descrição: ");
        descricaoLembrete = sc.nextLine();

        Lembretes meuLembrete = new Lembretes(titulo, descricaoLembrete, idUsuario);
        System.out.println(meuLembrete.toString());
    }


    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 4;
    }
}
