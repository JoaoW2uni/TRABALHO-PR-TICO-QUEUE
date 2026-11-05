import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicoClinica clinica = new ServicoClinica(5);
        int opcao = -1;

        System.out.println("========================================");
        System.out.println("      CLINICA - CONTROLE DE FILAS");
        System.out.println("========================================");

        while (opcao != 0) {
            exibirMenu();
            System.out.print("Escolha uma opcao: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opcao invalida. Digite um numero do menu.");
                scanner.next();
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do paciente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Paciente prioritario? (s/n): ");
                    String prioInput = scanner.nextLine().trim();
                    boolean prioritario = prioInput.equalsIgnoreCase("s");

                    clinica.retirarSenha(nome, cpf, prioritario);
                    break;

                case 2:
                    clinica.chamarProximoRecepcao();
                    break;

                case 3:
                    clinica.chamarProximoConsulta();
                    break;

                case 4:
                    clinica.listarFilaAtendimento();
                    break;

                case 5:
                    clinica.listarFilaConsultas();
                    break;

                case 6:
                    clinica.verProximosPeek();
                    break;

                case 7:
                    clinica.gerarRelatorio();
                    break;

                case 8:
                    clinica.demonstrarMetodosExcecao();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Ate logo!");
                    break;

                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--------------------- MENU ---------------------");
        System.out.println("1 - Retirar senha");
        System.out.println("2 - Chamar proximo na recepcao");
        System.out.println("3 - Chamar proximo para consulta");
        System.out.println("4 - Ver fila de atendimento");
        System.out.println("5 - Ver fila de consultas");
        System.out.println("6 - Ver proximo de cada fila");
        System.out.println("7 - Ver relatorio");
        System.out.println("8 - Testar excecoes");
        System.out.println("0 - Sair");
        System.out.println("-----------------------------------------------");
    }
}
