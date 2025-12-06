package org.example;

import com.google.genai.types.GenerateContentResponse;

import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;
import com.google.genai.Client;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

    public void criarPlano() throws IOException, InterruptedException {
        String comorbidadeUsuario;
        Scanner sc = new Scanner(System.in);
        Client client = new Client();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();





        String descricaoPlano;
        String tituloDoPlano;
        String comorbidadeSelecionada;

        System.out.println("Criando um plano para o Idoso...");
        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "Crie um plano alimentar para uma pessoa com a seguinte comorbidade: " +
                                getComorbidade() + " informando apenas " +
                                "as refeições: Café da manhã, lanche da manhã, almoço, lanche da tarde" +


                                "jantar e ceia ",
                        null);
        String json = response.text();

        System.out.print("Informe o titulo desse Plano Alimentar: ");
        tituloDoPlano = sc.nextLine();
        descricaoPlano = response.text();
        comorbidadeSelecionada = getComorbidade();

        PlanoAlimentar plano = new PlanoAlimentar(descricaoPlano, tituloDoPlano, comorbidadeSelecionada);
        System.out.println(response.text());
        System.out.println();
        System.out.println();
        System.out.println();
        FileWriter teste = new FileWriter("testandojson.txt");
        teste.write(gson.toJson(descricaoPlano));
        System.out.println(json);
    }

    public void criarLembrete() {

    }


    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 4;
    }
}
