package br.com.techfood;

import br.com.techfood.usuarios.UsuarioIdoso;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String comorbidade = "";


        UsuarioIdoso meuIdoso = new UsuarioIdoso("Conceição", "123456", 72, "Diabetica");
        meuIdoso.criarPlano();

    }
}