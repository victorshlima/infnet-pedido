package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Funcionario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FuncionarioDAOTest {

    @Before
    public void inicializar(){
        IDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario("João", "Master Boss");
        funcionarioDAO.salvar(funcionario);
    }

    @Test
    public void test() {
        IDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionario = new Funcionario("João", "Master Boss");
        boolean validacao = funcionarioDAO.salvar(funcionario);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testUpdate() {
        IDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> lista = funcionarioDAO.listarTodos();
        Funcionario funcionario = new Funcionario(lista.get(0).getCodigo(), "João", "Gerente");
        boolean validacao = funcionarioDAO.atualizar(funcionario);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testDelete() {
        IDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> lista = funcionarioDAO.listarTodos();
        Funcionario funcionario = new Funcionario(lista.get(lista.size()-1).getCodigo(), "João", "Gerente");
        boolean validacao = funcionarioDAO.deletar(funcionario);
        Assert.assertTrue(validacao);
    }

    @Test
    public void testListaClientes() {
        IDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> lista = funcionarioDAO.listarTodos();
        Assert.assertTrue(lista.size() > 0);
    }

    @Test
    public void testObterCliente() {
        IDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> lista = funcionarioDAO.listarTodos();
        Funcionario funcionario = (Funcionario) funcionarioDAO.obter(lista.get(0).getCodigo());
        Assert.assertNotNull(funcionario);
    }

}
