package br.com.jeanheberth.drogaria.dao;

import br.com.jeanheberth.drogaria.domain.Fabricante;
import org.junit.Test;

import java.util.List;

public class FabricanteDaoTest {

    @Test
    public void salvar() {
        Fabricante fabricante = new Fabricante();
        fabricante.setDescricao("Teste 1");

        FabricanteDao fabricanteDao = new FabricanteDao();
        fabricanteDao.salvar(fabricante);
    }

    @Test
    public void Listar() {
        FabricanteDao fabricanteDao = new FabricanteDao();
        List<Fabricante> resultadoFabricante = fabricanteDao.listar();

        try {
            if (!resultadoFabricante.equals("")) {
                System.out.println("Total de descrições cadastradas: " + resultadoFabricante.size());
                for (Fabricante fabricante : resultadoFabricante) {
                    System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
                }
            } else {
                System.out.println("Nenhuma descrição encontrada");
            }
        } catch (RuntimeException erro) {
            throw erro;
        }
    }

    @Test
    public void buscar(){
        Long codigo = 3L;
        FabricanteDao fabricanteDao = new FabricanteDao();
        Fabricante fabricante = fabricanteDao.buscar(codigo);

        if (fabricante != null){
            System.out.println("Registro encontrado: ");
            System.out.println("Código:" +fabricante.getCodigo() + " Descrição:" +fabricante.getDescricao());
        }else{
            System.out.println("Nenhum registro encontrado!");
        }
    }

    @Test
    public void excluir(){
        Long codigo = 3L;
        FabricanteDao fabricanteDao = new FabricanteDao();
        Fabricante fabricante = fabricanteDao.buscar(codigo);

        if (fabricante != null) {
            fabricanteDao.excluir(fabricante);
            System.out.println("Registro removido: ");
        } else {
            System.out.println("Nenhum registro encontrado!");
        }
    }

    @Test
    public void editar(){
        Long codigo = 2L;
        FabricanteDao fabricanteDao = new FabricanteDao();
        Fabricante fabricante = fabricanteDao.buscar(codigo);

        if (fabricante != null) {
            fabricante.setDescricao("Farmácia manipuladora");
            fabricanteDao.editar(fabricante);
            System.out.println("Editado com sucesso!");
        } else {
            System.out.println("Nenhum registro encontrado!");
        }
    }
}
