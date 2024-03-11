package funcionario;

public class Funcionario {
    private final Integer id;
    private String nome;

    public Funcionario(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() throws Exception {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        this.nome = nome;
    }

    public Integer getId() throws Exception {
        return id;
    }
}
