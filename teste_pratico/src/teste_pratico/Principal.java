package teste_pratico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        // 3.2 - Remover o funcionário “João” da lista.
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 - Imprimir todos os funcionários com todas suas informações.
        System.out.println("Todos os funcionários:");
        funcionarios.forEach(System.out::println);

        // 3.4 - Aumentar salário em 10%
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(BigDecimal.valueOf(1.10))));

        // 3.5 - Agrupar os funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 - Imprimir os funcionários, agrupados por função.
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, listaFuncionarios) -> {
            System.out.println(funcao + ":");
            listaFuncionarios.forEach(System.out::println);
        });

        // 3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("\nFuncionários que fazem aniversário em Outubro e Dezembro:");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(System.out::println);

        // 3.9 - Imprimir o funcionário com a maior idade.
        Funcionario maisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        System.out.printf("\nFuncionário com maior idade: %s, %d anos\n",
                maisVelho.getNome(),
                LocalDate.now().getYear() - maisVelho.getDataNascimento().getYear());

        // 3.10 - Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("\nFuncionários por ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        // 3.11 - Imprimir o total dos salários dos funcionários.
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("\nTotal dos salários: %,.2f\n", totalSalarios);

        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário.
        final BigDecimal salarioMinimo = new BigDecimal("1212.00");
        System.out.println("\nQuantidade de salários mínimos por funcionário:");
        funcionarios.forEach(f -> System.out.printf("%s ganha %.2f salários mínimos\n",
                f.getNome(),
                f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP)));
    }
}