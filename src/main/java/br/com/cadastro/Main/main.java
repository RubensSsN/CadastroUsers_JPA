package br.com.cadastro.Main;

import br.com.cadastro.CRUDjpa.DeletarPessoas;
import br.com.cadastro.CRUDjpa.Listar;
import br.com.cadastro.CRUDjpa.UpdatePessoa;
import br.com.cadastro.CRUDjpa.UserCadastro;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        System.out.println("Seja bem vindo ao programa de cadastro de Pessoas com JPA");

        Scanner escolha = new Scanner(System.in);
        //Faz com que o programa rode as opções do programa
        try {
            int choose;
            do {
                System.out.println("1 = Cadastrar pessoa || 2 = Listar || 3 = Atualizar Cadastro || 4 = Deletar Cadastro 0 = Sair");
                choose = escolha.nextInt();
                switch (choose) {
                    //Cadastrar Users
                    case 1:
                        UserCadastro.getCreate();
                        break;
                    //Para listar usuarios
                    case 2:
                        Listar.getPessoas();
                        break;
                    //Atualiza o cadastro
                    case 3:
                        UpdatePessoa.getUpdate(); //Arrumar uma maneira de puxar o cpf do BD e atribuir novamente, para não precisar dar setcpf novamente!
                        break;
                    //Deleta o cadastro
                    case 4:
                        DeletarPessoas.getDelete();
                        break;
                }
            } while (choose != 0);
            System.out.println("Saindo...");
        } catch (Exception e) {
            e.printStackTrace();
        }
        escolha.close();
    }

}
