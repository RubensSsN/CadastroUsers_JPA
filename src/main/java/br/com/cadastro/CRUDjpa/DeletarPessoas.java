package br.com.cadastro.CRUDjpa;

import br.com.cadastro.dao.PessoaDAO;
import br.com.cadastro.modelo.Pessoas;
import br.com.cadastro.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class DeletarPessoas {

    public static void getDelete() {

        System.out.println("Você está na aba de deletar usuários!");
        //Faz com que podemos gerenciar as entidades
        EntityManager em = JPAUtil.getEntityManager();
        //Necessário para deletar no banco de dados
        PessoaDAO dao = new PessoaDAO(em);
        Pessoas delet;

        //Faz com que seja possivel a pessoa digitar o ID para ser excluido
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o ID a ser excluido");
        Long idvalue = teclado.nextLong();

        //Deletando o ID informado
        em.getTransaction().begin();
        delet = dao.buscarPorID(idvalue);
        em.remove(delet);
        em.getTransaction().commit();
        em.close();


    }

}
