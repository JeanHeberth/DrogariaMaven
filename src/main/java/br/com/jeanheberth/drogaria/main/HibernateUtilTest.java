package br.com.jeanheberth.drogaria.main;

import org.hibernate.Session;
import org.junit.Test;

import br.com.jeanheberth.drogaria.util.HibernateUtil;

public class HibernateUtilTest {

    @Test
    public void conectar(){
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        sessao.close();
        HibernateUtil.getFabricaDeSessoes().close();
    }
}	
