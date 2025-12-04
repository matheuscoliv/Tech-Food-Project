package org.example;

import com.google.genai.types.GenerateContentResponse;
import java.util.Scanner;
import com.google.genai.Client;

public class UsuarioIdoso extends Usuario implements ClassificarPlano {
    private int idade;
    private String comorbidade;
    private int idUsuarioResponsavel;
    private int somaDasAvaliacoes;

    public UsuarioIdoso(String nome, String senha, int idade, String comorbidade) {
       super(nome, senha);
       this.idade = idade;
       this.comorbidade = comorbidade;
    }

    public UsuarioIdoso(String nome, String senha, int idade, String comorbidade, int idUsuarioResponsavel) {
        super(nome, senha);
        this.idade = idade;
        this.comorbidade = comorbidade;
        this.idUsuarioResponsavel = idUsuarioResponsavel;
    }

    public String getComorbidade() {
        return comorbidade;
    }

    public void criarPlano() {
        String comorbidadeUsuario;
        Scanner sc = new Scanner(System.in);
        Client client = new Client();

        System.out.println("Criando um plano para o Idoso...");
        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "Crie um plano alimentar para uma pessoa com a seguinte comorbidade: " +
                                getComorbidade() + " informando apenas " +
                                "as refeições: Café da manhã, lanche da manhã, almoço, lanche da tarde" +
                                "jantar e ceia ",
                        null);
        System.out.println(response.text());
    }
    @Override
    public int getClassificacao() {
        return (int) somaDasAvaliacoes / 4;
    }
}
