package br.com.jeanheberth.drogaria.domain;


import javax.persistence.*;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain{

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(nullable = false)
    private Boolean liberado;

    @OneToOne
    @JoinColumn(nullable = false)
    private Pessoa pessoa;

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Boolean getLiberado() {
        return liberado;
    }

    public void setLiberado(Boolean liberado) {
        this.liberado = liberado;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
