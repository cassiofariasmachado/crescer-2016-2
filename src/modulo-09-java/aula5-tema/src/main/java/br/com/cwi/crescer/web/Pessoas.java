package br.com.cwi.crescer.web;

import br.com.cwi.crescer.beans.PessoaBean;
import br.com.cwi.crescer.entidades.Pessoa;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class Pessoas {

    @EJB
    private PessoaBean pessoaBean;

    private Pessoa pessoa;
    private List<Pessoa> pessoas;

    @PostConstruct
    public void init() {
        this.pessoa = new Pessoa();
        this.pessoas = pessoaBean.findAll();
        this.pessoas.sort((a, b) -> a.getIdPessoa().compareTo(b.getIdPessoa()));
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void adicionar() {
        pessoaBean.insert(pessoa);
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Teste", "teste"));
    }
}
