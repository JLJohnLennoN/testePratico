package teste_pratico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public String toString() {
        return String.format("%s, %s, %s, %s", 
                getNome(), 
                getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                String.format("%,.2f", salario),
                funcao);
    }
}