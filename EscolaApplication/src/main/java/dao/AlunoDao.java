/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import dominio.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author juan
 */
public class AlunoDao {
    
    public void salvarAtualizarAluno(Aluno aluno) { //deve informar a turma
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(aluno.getMatricula()!= null){
            aluno = em.merge(aluno);
        }
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluirAluno(Aluno aluno) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        aluno = em.merge(aluno);
        em.remove(aluno);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Aluno> buscarAluno(Aluno aluno){
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("FROM Aluno a WHERE 1 = 1");
        if(aluno.getMatricula() != null){
            sql.append("and a.matricula = :matricula");
        }
        if(aluno.getNome() != null && aluno.getNome().equals("")){
            sql.append("and a.nome like :alu_nome");
        }
        if(aluno.getAnoNasc()!= null){
            sql.append("and a.anoNasc = :alu_AnoNasc");
        }
        if(aluno.getPCD() == 0 || aluno.getPCD() == 1){
            sql.append("and a.PCD like :alu_PCD");
        }
        if(aluno.getTur_id()!= null){
            sql.append("and a.tur_id = :tur_id");
        }
        Query query = em.createQuery(sql.toString());
        
        if(aluno.getMatricula()!= null){
            query.setParameter("matricula", aluno.getMatricula());
        }
        if(aluno.getNome() != null && aluno.getNome().equals("")){
            query.setParameter("alu_nome", "%" + aluno.getNome() + "%");
        }
        if(aluno.getAnoNasc()!= null){
            query.setParameter("alu_anoNasc", aluno.getAnoNasc());
        }
        if(aluno.getPCD()== 0 || aluno.getPCD() == 1){
            query.setParameter("alu_PCD", aluno.getPCD());
        }
        if(aluno.getTur_id()!= null){
            query.setParameter("tur_id", aluno.getTur_id());
        }
        return query.getResultList();
    }

}
