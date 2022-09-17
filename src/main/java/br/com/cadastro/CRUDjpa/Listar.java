package br.com.cadastro.CRUDjpa;

import br.com.cadastro.dao.PessoaDAO;
import br.com.cadastro.modelo.Pessoas;
import br.com.cadastro.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Listar {

    public static void getPessoas() {


        System.out.println("Você está na aba de Listagem de pessoas!\n");
        EntityManager em = JPAUtil.getEntityManager();
        PessoaDAO dao = new PessoaDAO(em);
        List<Pessoas> Names = dao.buscarPessoas();
        System.out.println("---------------------------------------------------------");
        System.out.print("  NAME" + "        CPF" + "          CIDADE");
        System.out.println();
        System.out.println("---------------------------------------------------------");
        Names.forEach(x -> System.out.print(" " + x.getNome() + " | " + x.getCpf() + " | " +  x.getEndereço() + "\n\r"));
        System.out.println("---------------------------------------------------------");


        }
}