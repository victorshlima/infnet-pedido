package br.edu.infnet.pedido.model.persistencia;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends JdbcDAO<Funcionario> {
    @Override
    public Boolean salvar(Funcionario funcionario) {
        String sql = "insert into funcionario(nome, codigo, cargo) values (?,null,?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCargo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Boolean atualizar(Funcionario Funcionario) {
        String sql = "update funcionario set nome = ?, cargo = ? where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, Funcionario.getNome());
            pstm.setString(2, Funcionario.getCargo());
            pstm.setLong(3, Funcionario.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deletar(Funcionario Funcionario) {
        String sql = "delete from funcionario where codigo = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, Funcionario.getCodigo());
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Funcionario obter(Long codigo){
        String sql = "select * from funcionario where codigo = ?";
        Funcionario funcionario = new Funcionario();
        try {
            pstm = con.prepareStatement(sql);
            pstm.setLong(1, codigo);
            rs = pstm.executeQuery();
            if(rs.next()) {
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                Long codigoDB = rs.getLong("codigo");
                funcionario = new Funcionario(codigoDB, nome, cargo);
            }
            return funcionario;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Funcionario> listarTodos(){
        String sql = "select * from funcionario";
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                Long codigo = rs.getLong("codigo");
                Funcionario funcionario = new Funcionario(codigo, nome, cargo);
                funcionarios.add(funcionario);
            }
            return funcionarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
