/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.TurmaDao;
import dominio.Turma;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javassist.tools.rmi.RemoteException;
import org.jdesktop.observablecollections.ObservableCollections;
import util.ValidacaoException;

/**
 *
 * @author juan
 */
public class TurmaControler {
    
    private final PropertyChangeSupport propertyChangeSupport = 
            new PropertyChangeSupport(this);  
    
    private Turma turmaDigitada;
    private Turma turmaSelecionada;
    private List<Turma> turmasTabelas;
    private TurmaDao turmaDao;

    public Turma getTurmaDigitada() {
        return turmaDigitada;
    }

    public void setTurmaDigitada(Turma turmaDigitada) {
        Turma antigaTurmaDigitada = this.turmaDigitada;
        this.turmaDigitada = turmaDigitada;
        propertyChangeSupport.firePropertyChange
                ("turmaDigitada", antigaTurmaDigitada, turmaDigitada); 
    }

    public Turma getTurmaSelecionada() {
        return turmaSelecionada;
    }

    public void setTurmaSelecionada(Turma turmaSelecionada) {
        if(this.turmaSelecionada != null){
            setTurmaDigitada(turmaSelecionada);
        }
        this.turmaSelecionada = turmaSelecionada;
    }

    public List<Turma> getTurmasTabelas() {
        return turmasTabelas;
    }

    public void setTurmasTabelas(List<Turma> turmasTabelas) {
        this.turmasTabelas = turmasTabelas;
    }
    
    public TurmaControler() {
        turmaDao = new TurmaDao();
        turmasTabelas = ObservableCollections.observableList(new ArrayList<Turma>());
        novo();
        pesquisar();
    }
    
    public void salvar() throws ValidacaoException,RemoteException {
        turmaDigitada.validar();
        turmaDao.salvarAtualizarTurma(turmaDigitada); 
        novo();
        pesquisar();
    }
    
    public void excluir(){
        turmaDao.excluirTurma(turmaDigitada);
        novo();
        pesquisar();
    }
    
    public final void novo() {
        setTurmaDigitada(new Turma());
    }

    public final void pesquisar() {
       turmasTabelas.clear();
       turmasTabelas.addAll(turmaDao.buscarTurma(turmaDigitada));
    }
    
    public void addPropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.addPropertyChangeListener(e);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener e) {
        propertyChangeSupport.removePropertyChangeListener(e);
    }
    
}
