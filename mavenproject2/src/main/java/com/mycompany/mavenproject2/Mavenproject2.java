
package com.mycompany.mavenproject2;



public class Mavenproject2 {

    public static void main(String[] args) {
        CadastroControle cadastro = new CadastroControle();
        cadastro.carregarDados();

        MenuPrincipal menu = new MenuPrincipal(cadastro);
        menu.exibirMenu();

        cadastro.salvarDados();
    }
}