package br.com.cadastro.CRUDjpa;

import br.com.cadastro.dao.PessoaDAO;
import br.com.cadastro.modelo.Pessoas;
import br.com.cadastro.modelo.ValidaCPF;
import br.com.cadastro.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Scanner;

public class UserCadastro {

    public static void getCreate() {
        Pessoas usuario = new Pessoas();
        Scanner tecla = new Scanner(System.in);

        //Informando o NOME
        System.out.println("Digite o seu nome: ");
        String nome = tecla.next();
        usuario.setNome(nome);

        //Informando a Idade
        System.out.println("Digite sua idade: ");
        int idade = tecla.nextInt();
        if(idade > 0 && idade < 120) {
            usuario.setIdade(idade);
        } else {
            System.out.println("Digite uma idade válida");
        }
        //Informando a Cidade
        System.out.println("Digite sua Cidade: ");
        String cidade = tecla.next();
        usuario.setEndereço(cidade);
        //Informando a Data
        usuario.setDataCadastro(new Date());

        //Informando o CPF
        System.out.println("Informe o seu CPF (APENAS NUMEROS): ");
        String cpf = tecla.next();
        if(ValidaCPF.isCPF(cpf) == true) {
            usuario.setCpf(ValidaCPF.imprimeCPF(cpf));
        } else {
            System.out.println("ERRO DIGITE UM CPF VÁLIDO!");
        }

        try{
            EntityManager em = JPAUtil.getEntityManager();
            PessoaDAO dao = new PessoaDAO(em);

            em.getTransaction().begin();
            dao.cadastrar(usuario);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
