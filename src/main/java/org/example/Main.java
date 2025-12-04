package org.example;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String comorbidadeUsuario;
        Scanner sc = new Scanner(System.in);
        Client client = new Client();

        /*System.out.print("Informe sua comorbidade: ");
        comorbidadeUsuario = sc.nextLine();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "Crie um plano alimentar para uma pessoa com a seguinte comorbidade" +
                                 comorbidadeUsuario + "informando apenas " +
                                "as refeições: Café da manhã, lanche da manhã, almoço, lanche da tarde" +
                                "jantar e ceia ",
                        null);


        PlanoAlimentar primeiroPlanoTeste = new PlanoAlimentar(response.text(), "Plano Alimentar para " + comorbidadeUsuario, comorbidadeUsuario);
        System.out.println(primeiroPlanoTeste.toString());*/
        UsuarioIdoso meuIdoso = new UsuarioIdoso("Conceição", "123456", 72, "Diabetica");
        meuIdoso.criarPlano();

        System.out.println();
        System.out.println();
        System.out.println();
        //.length() sem o prompt especifico tinha tamanho de 7500 caracteres, apos prompt especifico tempo
        //de resposta ficou mais curto e a quantidade de caracteres ficou em 3676 (média 4000)
        //System.out.println(response.text().length());

    }
}