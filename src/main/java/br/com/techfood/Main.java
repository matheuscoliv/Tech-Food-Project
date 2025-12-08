package br.com.techfood;
import br.com.techfood.usuarios.UsuarioResponsavel;

import br.com.techfood.planosAlimentares.PlanoAlimentar;
import br.com.techfood.usuarios.UsuarioIdoso;
import br.com.techfood.usuarios.UsuarioResponsavel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idade;
        String comorbidade;
        String nome;
        String senha;
        System.out.println("=====================");
        System.out.print("Informe seu nome de usuario: ");
        nome = sc.nextLine();
        System.out.print("Informe sua senha: ");
        senha = sc.nextLine();
        System.out.println("=====================");
        System.out.println("Informe sua idade: ");
        idade = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe sua comorbidade: ");
        comorbidade = sc.nextLine();

        UsuarioIdoso meuIdoso = new UsuarioIdoso(nome, senha, idade, comorbidade);
        //UsuarioIdoso meuIdoso = new UsuarioIdoso("maria", "123456", 72, "Diabetica");

        int idUser = meuIdoso.GuardaUsuarioBD();
        meuIdoso.setId_User(idUser);
        //USUARIO RESPONSAVEL VISUALIZA O PLANO DO IDOSO
        //UsuarioResponsavel meuResponsavel = new UsuarioResponsavel("Matheus", "4002", 1);
        //meuResponsavel.mostrarPlanoDoIdosoVinculado(meuPlano, 1);
        meuIdoso.GuardarIdoso();
        meuIdoso.criarPlano();
        meuIdoso.criarLembrete();
        UsuarioResponsavel resp = new UsuarioResponsavel("jose", "senha143", meuIdoso.getId_User());
        resp.GuardarUsuarioResponsavel();

    }
}