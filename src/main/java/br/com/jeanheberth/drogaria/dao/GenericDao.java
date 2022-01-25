package br.com.jeanheberth.drogaria.dao;

import br.com.jeanheberth.drogaria.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDao<Entidade> {
    public void salvar(Entidade entidade) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }


    }
}
