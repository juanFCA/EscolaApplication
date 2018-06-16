/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import dominio.Turma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author juan
 */
public class TurmaDao {
    
    public void salvarAtualizarTurma(Turma turma) { //deve informar a turma
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        if(turma.getId()!= null){
            turma = em.merge(turma);
        }
        em.persist(turma);
        em.getTransaction().commit();
        em.close();
    }
    
    public void excluirTurma(Turma turma) {
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        turma = em.merge(turma);
        em.remove(turma);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Turma> buscarTurma(Turma turma){
        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("FROM Turma t WHERE 1 = 1");
        if(turma.getId()!= null){
            sql.append("and t.id = :id");
        }
        if(turma.getNome() != null && turma.getNome().equals("")){
            sql.append("and t.nome like :tur_nome");
        }
        if(turma.getEnsino() != null && turma.getEnsino().equals("")){
            sql.append("and t.ensino like :tur_ensino");
        }
        if(turma.getAno()!= null){
            sql.append("and t.ano like :tur_ano");
        }
        if(turma.getTotalAlunos()!= null){
            sql.append("and t.totalAlunos like :tur_tot_Alunos");
        }
        
        Query query = em.createQuery(sql.toString());
        
        if(turma.getId()!= null){
            query.setParameter("id", turma.getId());
        }
        if(turma.getNome() != null && turma.getNome().equals("")){
            query.setParameter("tur_nome", "%" + turma.getNome() + "%");
        }
        if(turma.getEnsino() != null && turma.getEnsino().equals("")){
            query.setParameter("tur_ensino", "%" + turma.getEnsino() + "%");
        }
        if(turma.getAno()!= null){
            query.setParameter("tur_ano", turma.getAno());
        }
        if(turma.getTotalAlunos()!= null){
            query.setParameter("tur_tot_Alunos", turma.getTotalAlunos());
        }
        
        return query.getResultList();
    }
}
