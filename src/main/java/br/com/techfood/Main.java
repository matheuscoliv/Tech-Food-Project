package br.com.techfood;

import br.com.techfood.usuarios.UsuarioIdoso;

public class Main {
    public static void main(String[] args) {

        UsuarioIdoso meuIdoso = new UsuarioIdoso("maria", "123456", 72, "Diabetica");

        int idUser = meuIdoso.GuardaUsuarioBD();   // método da classe Usuario
        meuIdoso.setId_User(idUser); //

        meuIdoso.GuardarIdoso();//


        meuIdoso.criarPlano();
        meuIdoso.criarLembrete();

    }
}