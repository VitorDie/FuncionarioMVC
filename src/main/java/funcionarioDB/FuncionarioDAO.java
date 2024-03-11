package funcionarioDB;

import funcionario.Funcionario;

import java.util.Collection;

public interface FuncionarioDAO {
    public void inserir(Funcionario f) throws Exception;
    public Funcionario consultar(Integer id);
    public void alterar(Funcionario f) throws Exception;

    public void deletar(Integer id);

    public Collection<Funcionario> listarTodos();
}
