/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Connection;
import dominio.Turma;
import javax.persistence.EntityManager;

/**
 *
 * @author juan
 */
public class TurmaDao {
    public void cadastrarTurma(Turma t){
        EntityManager em = Connection.getEntityManager();
        em.getTransaction().begin();
        if(t.getNome()!=null){
         t = em.merge(t);
         }
     em.persist(t);
     em.getTransaction().commit();
     em.close();
    }
}
