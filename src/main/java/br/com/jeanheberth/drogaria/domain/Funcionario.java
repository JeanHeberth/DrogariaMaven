package br.com.jeanheberth.drogaria.domain;


import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain {


    @Column(length = 15, nullable = false)
    private String carteiraDeTrabalho;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @OneToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    public String getCarteiraDeTrabalho() {
        return carteiraDeTrabalho;
    }

    public void setCarteiraDeTrabalho(String carteiraDeTrabalho) {
        this.carteiraDeTrabalho = carteiraDeTrabalho;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
