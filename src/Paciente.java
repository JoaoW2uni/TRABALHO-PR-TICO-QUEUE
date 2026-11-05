import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Paciente implements Comparable<Paciente> {
    private static int contadorSenha = 1;

    private final int senha;
    private final String nome;
    private final String cpf;
    private final LocalDateTime horaChegada;
    private LocalDateTime horaAtendimentoRecepcao;
    private LocalDateTime horaAtendimentoMedico;
    private final boolean prioritario;

    public Paciente(String nome, String cpf, boolean prioritario) {
        this.senha = contadorSenha++;
        this.nome = nome;
        this.cpf = cpf;
        this.horaChegada = LocalDateTime.now();
        this.prioritario = prioritario;
    }

    public int getSenha() { return senha; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public LocalDateTime getHoraChegada() { return horaChegada; }
    public LocalDateTime getHoraAtendimentoRecepcao() { return horaAtendimentoRecepcao; }
    public void setHoraAtendimentoRecepcao(LocalDateTime horaAtendimentoRecepcao) {
        this.horaAtendimentoRecepcao = horaAtendimentoRecepcao;
    }
    public LocalDateTime getHoraAtendimentoMedico() { return horaAtendimentoMedico; }
    public void setHoraAtendimentoMedico(LocalDateTime horaAtendimentoMedico) {
        this.horaAtendimentoMedico = horaAtendimentoMedico;
    }
    public boolean isPrioritario() { return prioritario; }

    @Override
    public int compareTo(Paciente outro) {
        if (this.prioritario && !outro.prioritario) return -1;
        if (!this.prioritario && outro.prioritario) return 1;
        return Integer.compare(this.senha, outro.senha);
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        String prio = prioritario ? " [PRIORITARIO]" : "";
        return String.format("Senha #%03d | Nome: %-15s | CPF: %s | Chegada: %s%s",
                senha, nome, cpf, horaChegada.format(fmt), prio);
    }
}
