package funcionarioDB;

import funcionario.Funcionario;
import funcionario.FuncionarioNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FuncionarioMapDAO implements FuncionarioDAO {
    Map<Integer, Funcionario> db = new HashMap<>();

    @Override
    public void inserir(Funcionario f) throws Exception {
        if (db.containsKey(f.getId())) {
            throw new Exception("Um usuário já está cadastrado com esse Id");
        }
        db.put(f.getId(), f);
    }

    @Override
    public Funcionario consultar(Integer id) {
        Funcionario f = db.get(id);
        return f == null ? FuncionarioNull.getInstance() : f;
    }

    @Override
    public void alterar(Funcionario f) throws Exception {
        db.replace(f.getId(), f);
    }

    @Override
    public void deletar(Integer id) {
        db.remove(id);
    }

    @Override
    public Collection<Funcionario> listarTodos(){
        return db.values();
    }
}
