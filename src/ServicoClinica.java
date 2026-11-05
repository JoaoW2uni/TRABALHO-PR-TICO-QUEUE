import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ServicoClinica {
    private final Queue<Paciente> filaAtendimento;
    private final Queue<Paciente> filaConsultas;
    private final List<Paciente> atendidos;
    private final int limiteFilaConsultas;

    public ServicoClinica(int limiteFilaConsultas) {
        this.filaAtendimento = new LinkedList<>();
        this.filaConsultas = new ArrayDeque<>();
        this.atendidos = new ArrayList<>();
        this.limiteFilaConsultas = limiteFilaConsultas;
    }

    public Paciente retirarSenha(String nome, String cpf, boolean prioritario) {
        Paciente p = new Paciente(nome, cpf, prioritario);
        filaAtendimento.offer(p);
        System.out.println("Senha emitida: " + p);
        return p;
    }

    public boolean chamarProximoRecepcao() {
        if (filaAtendimento.isEmpty()) {
            System.out.println("Fila de atendimento vazia.");
            return false;
        }

        if (filaConsultas.size() >= limiteFilaConsultas) {
            System.out.println("Fila de consultas lotada. O paciente precisa esperar.");
            return false;
        }

        Paciente p = filaAtendimento.poll();
        if (p != null) {
            p.setHoraAtendimentoRecepcao(LocalDateTime.now());
            filaConsultas.offer(p);
            System.out.println("Paciente " + p.getNome() + " foi atendido na recepcao.");
            return true;
        }
        return false;
    }

    public boolean chamarProximoConsulta() {
        if (filaConsultas.isEmpty()) {
            System.out.println("Nao ha paciente na fila da consulta.");
            return false;
        }

        Paciente p = filaConsultas.poll();
        if (p != null) {
            p.setHoraAtendimentoMedico(LocalDateTime.now());
            atendidos.add(p);
            System.out.println("Paciente " + p.getNome() + " foi chamado para a consulta.");
            return true;
        }
        return false;
    }

    public void listarFilaAtendimento() {
        System.out.println("\n--- FILA DE ATENDIMENTO [" + filaAtendimento.size() + "] ---");
        if (filaAtendimento.isEmpty()) {
            System.out.println("Fila vazia");
        } else {
            filaAtendimento.forEach(p -> System.out.println("  " + p));
        }
    }

    public void listarFilaConsultas() {
        System.out.println("\n--- FILA DE CONSULTAS [" + filaConsultas.size() + "/" + limiteFilaConsultas + "] ---");
        if (filaConsultas.isEmpty()) {
            System.out.println("Fila vazia");
        } else {
            filaConsultas.forEach(p -> System.out.println("  " + p));
        }
    }

    public void verProximosPeek() {
        System.out.println("\n--- PROXIMOS ---");
        Paciente proxAtendimento = filaAtendimento.peek();
        Paciente proxConsulta = filaConsultas.peek();

        System.out.println("Proximo da recepcao: " + (proxAtendimento != null ? proxAtendimento : "Nenhum"));
        System.out.println("Proximo da consulta: " + (proxConsulta != null ? proxConsulta : "Nenhum"));
    }

    public void demonstrarMetodosExcecao() {
        System.out.println("\n--- TESTE DE EXCECOES ---");

        try {
            System.out.println("Tentando usar element()...");
            Paciente p = filaAtendimento.element();
            System.out.println("Elemento encontrado: " + p.getNome());
        } catch (NoSuchElementException e) {
            System.out.println("Nao tem paciente na fila de atendimento.");
        }

        try {
            System.out.println("Tentando usar remove()...");
            Paciente p = filaConsultas.remove();
            System.out.println("Paciente removido: " + p.getNome());
        } catch (NoSuchElementException e) {
            System.out.println("Nao tem paciente na fila de consultas.");
        }
    }

    public void gerarRelatorio() {
        System.out.println("\n========================================");
        System.out.println("           RELATORIO DA CLINICA");
        System.out.println("========================================");
        System.out.println("Pacientes na fila de atendimento: " + filaAtendimento.size());
        System.out.println("Pacientes na fila de consultas: " + filaConsultas.size());
        System.out.println("Total de pacientes atendidos: " + atendidos.size());

        if (!atendidos.isEmpty()) {
            long somaEsperaRecepcao = 0;
            long somaEsperaTotal = 0;

            System.out.println("\n--- PACIENTES ATENDIDOS ---");
            for (Paciente p : atendidos) {
                long esperaRecepcao = Duration.between(p.getHoraChegada(), p.getHoraAtendimentoRecepcao()).getSeconds();
                long esperaTotal = Duration.between(p.getHoraChegada(), p.getHoraAtendimentoMedico()).getSeconds();

                somaEsperaRecepcao += esperaRecepcao;
                somaEsperaTotal += esperaTotal;

                System.out.printf(" - %s | Tempo na recepcao: %ds | Tempo total: %ds\n",
                        p.getNome(), esperaRecepcao, esperaTotal);
            }

            double mediaRecepcao = (double) somaEsperaRecepcao / atendidos.size();
            double mediaTotal = (double) somaEsperaTotal / atendidos.size();

            System.out.printf("\nTempo medio na recepcao: %.2f segundos\n", mediaRecepcao);
            System.out.printf("Tempo medio total: %.2f segundos\n", mediaTotal);
        } else {
            System.out.println("\nAinda nao teve atendimento.");
        }
        System.out.println("========================================\n");
    }
}
