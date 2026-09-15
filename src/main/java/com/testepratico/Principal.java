package com.testepratico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;
import java.text.NumberFormat;

public class Principal {

    public static void separator(){
        System.out.println("=================================");
    }

    static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(
                "Maria",
                LocalDate.of(2000, 10, 18),
                new BigDecimal("2009.44"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "João",
                LocalDate.of(1990, 5, 12),
                new BigDecimal("2284.38"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "Caio",
                LocalDate.of(1961, 5, 2),
                new BigDecimal("9836.14"),
                "Coordenador"
        ));

        funcionarios.add(new Funcionario(
                "Miguel",
                LocalDate.of(1988, 10, 14),
                new BigDecimal("19119.88"),
                "Diretor"
        ));

        funcionarios.add(new Funcionario(
                "Alice",
                LocalDate.of(1995, 1, 5),
                new BigDecimal("2234.68"),
                "Recepcionista"
        ));

        funcionarios.add(new Funcionario(
                "Heitor",
                LocalDate.of(1999, 11, 19),
                new BigDecimal("1582.72"),
                "Operador"
        ));

        funcionarios.add(new Funcionario(
                "Arthur",
                LocalDate.of(1993, 3, 31),
                new BigDecimal("4071.84"),
                "Contador"
        ));

        funcionarios.add(new Funcionario(
                "Laura",
                LocalDate.of(1994, 7, 8),
                new BigDecimal("3017.45"),
                "Gerente"
        ));

        funcionarios.add(new Funcionario(
                "Heloisa",
                LocalDate.of(2003, 5, 24),
                new BigDecimal("1606.85"),
                "Eletricista"
        ));

        funcionarios.add(new Funcionario(
                "Helena",
                LocalDate.of(1996, 9, 2),
                new BigDecimal("2799.93"),
                "Gerente"
        ));


        // 3.2 - Remover João

        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));


        // 3.3 - Imprimir funcionários

        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        NumberFormat formatoMoeda = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));

        formatoMoeda.setMinimumFractionDigits(2);

        for (Funcionario funcionario : funcionarios) {

            String dataFormatada = funcionario.getDataNascimento().format(formatoData);

            String salarioFormatado = formatoMoeda.format(funcionario.getSalario());

            System.out.println(
                    "Nome: " + funcionario.getNome()
                            + " | Data de nascimento: " + dataFormatada
                            + " | Salário: " + salarioFormatado
                            + " | Função: " + funcionario.getFuncao()
            );
        }


        // 3.4 - Aumentar salários em 10%

        for (Funcionario funcionario : funcionarios) {

            BigDecimal aumento = funcionario
                    .getSalario()
                    .multiply(new BigDecimal("0.10"));

            funcionario.setSalario( funcionario.getSalario()
                            .add(aumento)
                            .setScale(2, RoundingMode.HALF_UP)
            );
        }

        separator();

        // Imprimir novos salários
        for (Funcionario funcionario : funcionarios) {

            String salarioFormatado =
                    formatoMoeda.format(funcionario.getSalario());

            System.out.println(
                    funcionario.getNome()
                            + " | Novo salário: "
                            + salarioFormatado
            );
        }

        separator();
        // 3.5 - Agrupar funcionários por função

        Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {

            String funcao = funcionario.getFuncao();

            funcionariosPorFuncao.computeIfAbsent(funcao, chave -> new ArrayList<>())
                    .add(funcionario);

        }

        // 3.6 Imprimir funcionários agrupados por função.
        for (Map.Entry<String, List<Funcionario>> entry
                : funcionariosPorFuncao.entrySet()) {

            System.out.println("Função: " + entry.getKey());

            for (Funcionario funcionario : entry.getValue()) {

                String dataFormatada = funcionario.getDataNascimento().format(formatoData);

                String salarioFormatado = formatoMoeda.format(funcionario.getSalario());

                System.out.println(
                        "Nome: " + funcionario.getNome()
                                + " | Data de nascimento: " + dataFormatada
                                + " | Salário: " + salarioFormatado
                );

            }
        }

        separator();

        // 3.8 - Funcionários que fazem aniversário nos meses 10 e 12
        for (Funcionario funcionario : funcionarios) {

            int mesNascimento = funcionario.getDataNascimento().getMonthValue();

            if (mesNascimento == 10 || mesNascimento == 12) {

                System.out.println(
                        "Nome: " + funcionario.getNome()
                                + " | Data de nascimento: "
                                + funcionario.getDataNascimento().format(formatoData)
                );
            }
        }
        separator();

        //3.9 Encontrar funcionario mais velho

        Funcionario funcionarioMaisVelho = funcionarios.getFirst();

        for (Funcionario funcionario : funcionarios) {

            if (funcionario.getDataNascimento()
                    .isBefore(funcionarioMaisVelho.getDataNascimento())) {

                funcionarioMaisVelho = funcionario;
            }
        }

        LocalDate hoje = LocalDate.now();

        int idade = hoje.getYear()
                - funcionarioMaisVelho.getDataNascimento().getYear();

        int mesAtual = hoje.getMonthValue();

        int mesNascimento =
                funcionarioMaisVelho.getDataNascimento().getMonthValue();

        if (mesAtual < mesNascimento
                || (mesAtual == mesNascimento
                && hoje.getDayOfMonth() < funcionarioMaisVelho.getDataNascimento().getDayOfMonth())) {

            idade--;

        }

        System.out.println(
                "Nome: " + funcionarioMaisVelho.getNome()
                        + " | Idade: " + idade + " anos"
        );

        separator();

        //3.10 - Ordenar funcionarios por ordem alfabetica

        funcionarios.sort(
                Comparator.comparing(Funcionario::getNome)
        );
        for (Funcionario funcionario : funcionarios) {

            System.out.println(
                    "Nome: " + funcionario.getNome()
            );
        }

        separator();

        BigDecimal totalSalarios = BigDecimal.ZERO;

        for (Funcionario funcionario : funcionarios) {

            totalSalarios = totalSalarios.add(funcionario.getSalario());
        }

        System.out.println("Total dos salários: " + formatoMoeda.format(totalSalarios));

        separator();

        BigDecimal salarioMinimo = new BigDecimal("1212.00");

        for (Funcionario funcionario : funcionarios) {

            BigDecimal quantidadeSalariosMinimos =
                    funcionario.getSalario()
                            .divide(salarioMinimo, 2, RoundingMode.HALF_UP);

            System.out.println(
                    "Nome: " + funcionario.getNome()
                            + " | Salários mínimos: "
                            + quantidadeSalariosMinimos
            );
        }


    }
}