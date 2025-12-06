package org.example;

import com.google.genai.types.GenerateContentResponse;
import java.io.FileWriter;
import java.util.Scanner;
import com.google.genai.Client;
import com.google.gson.Gson;

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

    public void criarPlano() {
        Scanner sc = new Scanner(System.in);
        try {
            String tituloDoPlano;
            Client client = new Client();

            System.out.println("Crie o titulo desse plano: ");
            tituloDoPlano = sc.nextLine();
            System.out.println("Criando um plano para o Idoso...");

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-2.5-flash",
                            """
                                    Gere um plano alimentar em JSON no formato abaixo, sem texto fora dele:
                                    {
                                        "titulo": "%s",
                                        "dietaDoPlano": "string",
                                        "dicas": "string"
                                        "comorbidadeSelect": "string"
                                    }   
                                    
                                    Comorbidade: %s
                                    """.formatted(tituloDoPlano, getComorbidade()),
                            null);

            String jsonLimpo = response.text().replaceAll("```json", "")
                    .replaceAll("```", "")
                    .trim();

            Gson gson = new Gson();
            PlanoConvertido dadosConvertidos = gson.fromJson(jsonLimpo, PlanoConvertido.class);

            PlanoAlimentar meuPlanoAlimentar = new PlanoConvertido(dadosConvertidos);

            FileWriter teste = new FileWriter("testandojson.txt");
            teste.write(jsonLimpo);
            teste.close();
            System.out.println(meuPlanoAlimentar);



        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    public void criarLembrete() {

    }


    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 4;
    }
}
