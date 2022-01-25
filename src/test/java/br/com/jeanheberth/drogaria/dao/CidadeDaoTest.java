package br.com.jeanheberth.drogaria.dao;

import br.com.jeanheberth.drogaria.domain.Cidade;
import br.com.jeanheberth.drogaria.domain.Estado;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void listar() {
        CidadeDao cidadeDao = new CidadeDao();
        List<Cidade> resultadoCidade = cidadeDao.listar();

        try {
            if (!resultadoCidade.equals("")) {
                System.out.println("Total de Registros Encontrados: " + resultadoCidade.size());
                for (Cidade cidade : resultadoCidade) {
                    System.out.println("Registro encontrados: ");
                    System.out.println("Codigo da cidade: " + cidade.getCodigo());
                    System.out.println("Nome da cidade: " + cidade.getNome());
                    System.out.println("Codigo do estado: " + cidade.getEstado().getCodigo());
                    System.out.println("Sigla do estado: " + cidade.getEstado().getSigla());
                    System.out.println("Nome do estado: " + cidade.getEstado().getNome());
                }
            } else {
                System.out.println("Não existem estados cadastrados");
            }
        } catch (RuntimeException erro) {
            throw erro;
        }

    }

    @Test
    public void buscar() {
        Long codigoCidade = 12L;
        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = cidadeDao.buscar(codigoCidade);

        if (cidade != null) {
            System.out.println("Registro encontrados: ");
            System.out.println("Codigo da cidade: " + cidade.getCodigo());
            System.out.println("Nome da cidade: " + cidade.getNome());
            System.out.println("Codigo do estado: " + cidade.getEstado().getCodigo());
            System.out.println("Sigla do estado: " + cidade.getEstado().getSigla());
            System.out.println("Nome do estado: " + cidade.getEstado().getNome());
        } else {
            System.out.println("Nenhum registro encontrado!");
        }
    }

    @Test
    public void excluir() {
        Long codigoCidade = 1L;
        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = cidadeDao.buscar(codigoCidade);

        if (cidade != null) {
            cidadeDao.excluir(cidade);
            System.out.println("Registro removido!");
        } else {
            System.out.println("Nenhum registro encontrado!");
        }
    }

    @Test
    public void editar() {
        Long codigoCidade = 10L;
        Long codigoEstado = 6L;
        EstadoDao estadoDao = new EstadoDao();
        Estado estado = estadoDao.buscar(codigoCidade);

        CidadeDao cidadeDao = new CidadeDao();
        Cidade cidade = cidadeDao.buscar(codigoCidade);

        if (cidade != null) {
            cidade.setNome("São Paulo");
            cidadeDao.editar(cidade);
            System.out.println("Editado com sucesso!");
        } else {
            System.out.println("Nenhum registro encontrado!");
        }
    }
}
