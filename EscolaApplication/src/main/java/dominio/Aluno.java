/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import util.ValidacaoException;

/**
 *
 * @author juan
 */

@Entity
@Table (name="aluno")
public class Aluno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//Postgresql auto increment
    private Long matricula;
    
    @Column(name="alu_nome", length= 255, nullable=false)
    private String nome;
    
    @Column(name="alu_anoNasc", nullable=false)
    private Long anoNasc;
    
    @Column(name="alu_PCD", nullable=false)
    private boolean PCD;
    
    @Column(name="tur_id")
    private Long tur_id;

    public Aluno() {
    }
    
    /**
     * @return the matricula
     */
    public Long getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
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
     * @return the anoNasc
     */
    public Long getAnoNasc() {
        return anoNasc;
    }

    /**
     * @param anoNasc the anoNasc to set
     */
    public void setAnoNasc(Long anoNasc) {
        this.anoNasc = anoNasc;
    }

    /**
     * @return the PCD
     */
    public boolean getPCD() {
        return PCD;
    }

    /**
     * @param PCD the PCD to set
     */
    public void setPCD(boolean PCD) {
        this.PCD = PCD;
    }
    
    /**
     * @return the tur_id
     */
    public Long getTur_id() {
        return tur_id;
    }

    /**
     * @param tur_id the tur_id to set
     */
    public void setTur_id(Long tur_id) {
        this.tur_id = tur_id;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", nome=" + nome + ", anoNasc=" + anoNasc + ", PCD=" + PCD + ", tur_id=" + tur_id + '}';
    }

    public void validar() throws ValidacaoException{
        if (this.nome == null || this.nome.equals("")) {
            throw new ValidacaoException("Campo nome precisa ser preenchido");
        }
    }
}
