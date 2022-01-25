package br.com.jeanheberth.drogaria.dao;

import br.com.jeanheberth.drogaria.domain.Cidade;
import br.com.jeanheberth.drogaria.domain.Estado;
import org.junit.Test;

public class CidadeDaoTest {

    @Test
    public void salvar() {
        EstadoDao estadoDao = new EstadoDao();
        Estado estado = estadoDao.buscar(6L);

        Cidade cidade = new Cidade();
        cidade.setNome("Taguatinga");
        cidade.setEstado(estado);

        CidadeDao cidadeDao = new CidadeDao();
        cidadeDao.salvar(cidade);
        System.out.println("Salvo com sucesso!");
    }
}
