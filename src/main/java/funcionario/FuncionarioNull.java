package funcionario;

public class FuncionarioNull extends Funcionario {
    private String funcionarioNaoCadastradoMsg =
            "Este funcionario não está no banco de dados!";
    private FuncionarioNull() {
        super(-1, "Usuário Inexistente");
    }

    private static FuncionarioNull instance = null;
    public static FuncionarioNull getInstance() {
        if (instance == null) {
            instance = new FuncionarioNull();
        }

        return instance;
    }

    @Override
    public void setNome(String nome) throws Exception {
        //throw new Exception(funcionarioNaoCadastradoMsg);
    }

}
