package org.example;

import java.io.IOException;
import java.util.Scanner;
import org.example.PlanoAlimentar;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        String comorbidade = "";


        UsuarioIdoso meuIdoso = new UsuarioIdoso("Conceição", "123456", 72, "Diabetica");
        meuIdoso.criarPlano();

    }
}