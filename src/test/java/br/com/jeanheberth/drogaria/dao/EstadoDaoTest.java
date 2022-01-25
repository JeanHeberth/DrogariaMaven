package br.com.jeanheberth.drogaria.dao;

import br.com.jeanheberth.drogaria.domain.Estado;
import org.junit.Test;

import javax.swing.*;
import java.util.List;

public class EstadoDaoTest {

    @Test
    public void salvar() {

        Estado estado = new Estado();
        estado.setNome("Maceió");
        estado.setSigla("AL");

        EstadoDao estadoDao = new EstadoDao();
        estadoDao.salvar(estado);
        System.out.println("Salvo com sucesso!");

    }

    @Test
    public void listar() {
        EstadoDao estadoDao = new EstadoDao();
        List<Estado> resultado = estadoDao.listar();

        try {
            if (!resultado.equals("")) {
                System.out.println("Total de Registros Encontrados: " + resultado.size());
                for (Estado estado : resultado) {
                    System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
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
        Long codigo = 13L;
        EstadoDao estadoDao = new EstadoDao();
        Estado estado = estadoDao.buscar(codigo);

        if (estado != null) {
            System.out.println("Registro encontrados: ");
            System.out.println("Codigo: " + estado.getCodigo() + " Nome: " + estado.getNome() + " Sigla: " + estado.getSigla());
        } else {
            System.out.println("Nenhum registro encontrado!");
        }
    }

    @Test
    public void excluir(){
        Long codigo = 12L;
        EstadoDao estadoDao = new EstadoDao();
        Estado estado = estadoDao.buscar(codigo);

        if (estado != null) {
            estadoDao.excluir(estado);
            System.out.println("Registro removido!");
        } else {
            System.out.println("Nenhum registro encontrado!");
        }
    }

    @Test
    public void editar(){
        Long codigo = 11L;
        EstadoDao estadoDao = new EstadoDao();
        Estado estado = estadoDao.buscar(codigo);

        if (estado != null) {
            estado.setNome("São Paulo");
            estadoDao.editar(estado);
            System.out.println("Editado com sucesso!");
        } else {
            System.out.println("Nenhum registro encontrado!");
        }
    }
}

