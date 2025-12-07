package br.com.techfood;

import br.com.techfood.planosAlimentares.PlanoAlimentar;
import br.com.techfood.usuarios.UsuarioIdoso;
import br.com.techfood.usuarios.UsuarioResponsavel;

public class Main {
    public static void main(String[] args) {

        UsuarioIdoso meuIdoso = new UsuarioIdoso("Conceição", "123456", 72, "Diabetica");
        PlanoAlimentar meuPlano = meuIdoso.criarPlano();
        meuIdoso.criarLembrete();

        //USUARIO RESPONSAVEL VISUALIZA O PLANO DO IDOSO
        //UsuarioResponsavel meuResponsavel = new UsuarioResponsavel("Matheus", "4002", 1);
        //meuResponsavel.mostrarPlanoDoIdosoVinculado(meuPlano, 1);
    }
}