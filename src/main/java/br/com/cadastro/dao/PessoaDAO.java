package br.com.cadastro.dao;

import br.com.cadastro.modelo.Pessoas;

import javax.persistence.EntityManager;
import java.util.List;

public class PessoaDAO {

    private EntityManager em;

    public PessoaDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pessoas pessoas) {
        this.em.persist(pessoas);
    }

    public void atualizar(Pessoas pessoas) {
        this.em.merge(pessoas);
    }

    public void remover(Long pessoas) {
        pessoas = em.merge(pessoas);
        this.em.remove(pessoas);
    }

    public List<Pessoas> buscarPessoas() {
        String jpql = "SELECT p FROM Pessoas p";
        return em.createQuery(jpql, Pessoas.class).getResultList();
    }

    public Pessoas buscarPorID(Long id) {
        return em.find(Pessoas.class, id);
    }

    public List<Pessoas> buscarCPF() {
        String jpql = "SELECT cpf FROM Pessoas";
        return em.createQuery(jpql, Pessoas.class).getResultList();
    }

}

