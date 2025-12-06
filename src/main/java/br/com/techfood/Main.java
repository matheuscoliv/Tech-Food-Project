package br.com.techfood;

import br.com.techfood.usuarios.UsuarioIdoso;

public class Main {
    public static void main(String[] args) {

        UsuarioIdoso meuIdoso = new UsuarioIdoso("Conceição", "123456", 72, "Diabetica");
        meuIdoso.criarPlano();
        meuIdoso.criarLembrete();

    }
}