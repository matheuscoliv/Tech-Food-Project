package br.com.techfood;
import br.com.techfood.usuarios.UsuarioResponsavel;

import br.com.techfood.planosAlimentares.PlanoAlimentar;
import br.com.techfood.usuarios.UsuarioIdoso;
import br.com.techfood.usuarios.UsuarioResponsavel;

public class Main {
    public static void main(String[] args) {

        UsuarioIdoso meuIdoso = new UsuarioIdoso("mar", "123456", 72, "Diabetica");

        int idUser = meuIdoso.GuardaUsuarioBD();
        meuIdoso.setId_User(idUser);

        //USUARIO RESPONSAVEL VISUALIZA O PLANO DO IDOSO
        //UsuarioResponsavel meuResponsavel = new UsuarioResponsavel("Matheus", "4002", 1);
        //meuResponsavel.mostrarPlanoDoIdosoVinculado(meuPlano, 1);
        meuIdoso.GuardarIdoso();
        meuIdoso.criarPlano();
        meuIdoso.criarLembrete();
        UsuarioResponsavel resp = new UsuarioResponsavel("joz", "senha143", meuIdoso.getId_User());
        resp.GuardarUsuarioResponsavel();

    }
}