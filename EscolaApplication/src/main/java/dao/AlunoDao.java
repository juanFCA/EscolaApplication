/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Connection;
import dominio.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author juan
 */
public class AlunoDao {
    public void matricularAluno(Aluno a){//deve informar a turma
        EntityManager em = Connection.getEntityManager();
        em.getTransaction().begin();
        if(a.getMatricula()!=null){
         a = em.merge(a);
         }
     em.persist(a);
     em.getTransaction().commit();
     em.close();
    }
    
    public List<Aluno> buscarAluno(Aluno a){
        EntityManager em = Connection.getEntityManager();
        StringBuilder sql = new StringBuilder("FROM Aluno a WHERE 1 = 1");
        if(a.getMatricula() != null){
            sql.append("and a.matricula = :matricula");
        }
        if(a.getNome() != null && a.getNome().equals("")){
            sql.append("and a.nome like :alu_nome");
        }
        if(a.getAnoNasc()!= null){
            sql.append("and a.AnoNasc = :alu_AnoNasc");
        }
        if(a.getPCD()== true || a.getPCD() == false){
            sql.append("and a.nome like :alu_nome");
        }
        if(a.getTur_id()!= null){
            sql.append("and a.tur_id = :tur_id");
        }
        Query query = em.createQuery(sql.toString());
        
        if(a.getMatricula()!= null){
            query.setParameter("matricula", a.getMatricula());
        }
        if(a.getNome() != null && a.getNome().equals("")){
            query.setParameter("alu_nome", "%" + a.getNome() + "%");
        }
        if(a.getAnoNasc()!= null){
            query.setParameter("alu_anoNasc", a.getAnoNasc());
        }
        if(a.getPCD()== true || a.getPCD() == false){
            query.setParameter("alu_PCD", a.getPCD());
        }
        if(a.getTur_id()!= null){
            query.setParameter("tur_id", a.getTur_id());
        }
        return query.getResultList();
    }
    
    public void removerAluno(Aluno a){
        EntityManager em = Connection.getEntityManager();
        em.getTransaction().begin();
        a = em.merge(a);
        em.remove(a);
        em.getTransaction().commit();
        em.close();
    }
}
