/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import util.ValidacaoException;

/**
 *
 * @author juan
 */

@Entity
@Table (name="aluno")
public class Aluno implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//Postgresql auto increment
    @Column(name = "alu_matricula", updatable = false, nullable = false)
    private Long matricula;
    
    @Column(name="alu_nome", length= 255, nullable=false)
    private String nome;
    
    @Column(name="alu_anoNasc", nullable=false)
    private Long anoNasc;
    
    @Column(name="alu_PCD", nullable = false)
    private int PCD;
    
    @Column(name="alu_tur_id")
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
        Long oldMatricula = this.matricula;
        this.matricula = matricula;
        changeSupport.firePropertyChange("matricula", oldMatricula, matricula);
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
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
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
        Long oldAnoNasc = this.anoNasc;
        this.anoNasc = anoNasc;
        changeSupport.firePropertyChange("anoNasc", oldAnoNasc, anoNasc);
    }

    /**
     * @return the PCD
     */
    public int getPCD() {
        return PCD;
    }

    /**
     * @param PCD the PCD to set
     */
    public void setPCD(int PCD) {
        int oldPCD = this.PCD;
        this.PCD = PCD;
        changeSupport.firePropertyChange("PCD", oldPCD, PCD);
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
        Long oldTur_id = this.tur_id;
        this.tur_id = tur_id;
        changeSupport.firePropertyChange("tur_id", oldTur_id, tur_id);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
