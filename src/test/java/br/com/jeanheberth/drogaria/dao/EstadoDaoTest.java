package br.com.jeanheberth.drogaria.dao;

import br.com.jeanheberth.drogaria.domain.Estado;
import org.junit.Test;

public class EstadoDaoTest {

    @Test
    public void salvar(){
        Estado estado = new Estado();
        estado.setNome("Rio de Janeiro");
        estado.setSigla("RJ");

        EstadoDao estadoDao = new EstadoDao();
        estadoDao.salvar(estado);
    }

}
