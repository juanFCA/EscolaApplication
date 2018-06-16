/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author juan
 */

@Entity
@Table(name="turma")
public class Turma {
   
    @Id
    @Column(name="tur_nome", length = 10, nullable = false)
    private String nome;
    
    @Column(name="tur_ensino")//limitar entre Fundamental 1, Fundamental e Médio
    private String ensino;
    
    @Column(name="tur_ano")
    private int ano;
    
    @Column(name="tur_totalAlunos")
    private int totalAlunos;
    
    public Turma(){
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the ensino
     */
    public String getEnsino() {
        return ensino;
    }

    /**
     * @param ensino the ensino to set
     */
    public void setEnsino(String ensino) {
        this.ensino = ensino;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the totalAlunos
     */
    public int getTotalAlunos() {
        return totalAlunos;
    }

    /**
     * @param totalAlunos the totalAlunos to set
     */
    public void setTotalAlunos(int totalAlunos) {
        this.totalAlunos = totalAlunos;
    }
    
 }
