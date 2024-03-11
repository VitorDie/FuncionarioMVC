import funcionario.Funcionario;
import funcionarioDB.FuncionarioDAO;
import funcionarioDB.FuncionarioMapDAO;
import org.junit.Assert;
import org.junit.Test;

public class FuncionarioTest {
    @Test
    public void funcionarioCrudTest() throws Exception {
        try {
            Integer funcionarioId = 1;
            Funcionario f = new Funcionario(funcionarioId, "Vitor");
            FuncionarioDAO dao = new FuncionarioMapDAO();

            dao.inserir(f);
            Assert.assertEquals(f, dao.consultar(funcionarioId));


            Funcionario vitorParaJoao = new Funcionario(funcionarioId, "Joao");
            dao.alterar(vitorParaJoao);
            Assert.assertEquals(vitorParaJoao, dao.consultar(funcionarioId));
            Assert.assertEquals(vitorParaJoao.getNome(), dao.consultar(funcionarioId).getNome());

            dao.deletar(funcionarioId);

            Integer menosUm = -1;
            Assert.assertEquals(dao.consultar(funcionarioId).getId(), menosUm);
            Assert.assertEquals(dao.consultar(funcionarioId).getNome(), "");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
