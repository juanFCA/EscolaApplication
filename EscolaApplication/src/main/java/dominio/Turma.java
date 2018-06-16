/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import util.ValidacaoException;

/**
 *
 * @author juan
 */

@Entity
@Table(name="turma")
public class Turma implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//Postgresql auto increment
    private Long id;
    
    @Column(name="tur_nome", length = 10, nullable = false)
    private String nome;
    
    @Column(name="tur_ensino")//limitar entre Fundamental 1, Fundamental e Médio
    private String ensino;
    
    @Column(name="tur_ano")
    private Long ano;
    
    @Column(name="tur_tot_Alunos")
    private Long totalAlunos;
    
    public Turma(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public Long getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Long getTotalAlunos() {
        return totalAlunos;
    }

    public void setTotalAlunos(Long totalAlunos) {
        this.totalAlunos = totalAlunos;
    }

    @Override
    public String toString() {
        return "Turma{" + "id=" + id + ", nome=" + nome + ", ensino=" + ensino + ", ano=" + ano + ", totalAlunos=" + totalAlunos + '}';
    }
    
    public void validar() throws ValidacaoException{
        if (this.nome == null || this.nome.equals("")) {
            throw new ValidacaoException("Campo nome precisa ser preenchido");
        }
    }
 }
