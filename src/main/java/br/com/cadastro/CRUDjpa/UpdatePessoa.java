package br.com.cadastro.CRUDjpa;

import br.com.cadastro.dao.PessoaDAO;
import br.com.cadastro.modelo.Pessoas;
import br.com.cadastro.modelo.ValidaCPF;
import br.com.cadastro.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Scanner;

public class UpdatePessoa {

    public static void getUpdate() {
        System.out.println("Você está na aba de Update!");
        //Faz com que podemos gerenciar as entidades
        EntityManager em = JPAUtil.getEntityManager();

        //Passa tudo que tem no dao junto com o Entitymanager
        PessoaDAO dao = new PessoaDAO(em);
        //Define que o update é do tipo Pessoas
        Pessoas update;
        //Gera um novo usuario só que ao mandarmos como MERGE ele da o update
        Pessoas usuarioUP = new Pessoas();

        //Coletando o ID a ser atualizado
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o ID a ser atualizado");
        Long idvalue = teclado.nextLong();
        //SET no id igual antes só para passa-lo
        usuarioUP.setId(idvalue);

        //Infomrando nome ATT
        System.out.println("Informe o nome atualizado!");
        String nome = teclado.next();
        usuarioUP.setNome(nome);

        //Informa a idade ATT
        System.out.println("Informe a idade atualizada!");
        int idade = teclado.nextInt();
        usuarioUP.setIdade(idade);

        //Definindo data da ATT
        usuarioUP.setDataCadastro(new Date());

        //Informando cidade ATT
        System.out.println("Informe a cidade atualizada!");
        String cidade = teclado.next();
        usuarioUP.setEndereço(cidade);

        //Busca o CPF e passa para a ATT
        System.out.println("Informe o CPF (APENAS NÚMEROS): ");
        String cpf = teclado.next();
        if(ValidaCPF.isCPF(cpf) == true) {
            usuarioUP.setCpf(cpf);
        } else {
            System.out.println("[ERRO] DIGITE UM CPF VÁLIDO!");
            return;
        }

        //Atualizando a pessoa informada por ID
        em.getTransaction().begin();
        dao.atualizar(usuarioUP);
        em.getTransaction().commit();
        em.close();

    }

}
