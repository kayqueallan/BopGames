import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Ciclista> ciclistas = new ArrayList<>();
        List<Etapa> etapas = new ArrayList<>();

        // Cadastro de dois ciclistas
        for (int i = 0; i < 2; i++) {
            System.out.println("Cadastro do Ciclista " + (i + 1) + ":");
            System.out.println("Digite o nome do Ciclista:");
            String nome = scanner.nextLine();
            System.out.println("Digite o número do Ciclista:");
            int numero = lerInteiro(scanner);
            ciclistas.add(new Ciclista(nome, numero, new ArrayList<>()));
        }

        // Cadastro de duas etapas
        etapas.addAll(registrarEtapas(scanner));

        // Associar etapas aos ciclistas
        for (Ciclista ciclista : ciclistas) {
            ciclista.setEtapas(new ArrayList<>(etapas)); // Atualiza as etapas de cada ciclista
        }

        // Registro das durações para cada ciclista
        for (Ciclista ciclista : ciclistas) {
            for (Etapa etapa : etapas) {
                System.out.println("Registro das durações para o ciclista " + ciclista.getNome() + ":");
                System.out.println("Etapa " + etapa.getNumero() + ":");
                Duracao duracao = lerDuracao(scanner);
                etapa.adicionarDuracao(ciclista, duracao); // Adiciona a duração à etapa
            }
        }

        // Comparação dos tempos totais
        Ciclista ciclista1 = ciclistas.get(0);
        Ciclista ciclista2 = ciclistas.get(1);
        compararTempos(scanner, ciclista1, ciclista2, etapas);

        scanner.close();
    }

    public static void compararTempos(Scanner scanner, Ciclista ciclista1, Ciclista ciclista2, List<Etapa> etapas) {
        while (true) {
            int resultadoComparacao = ciclista1.compararTempoCom(ciclista2);
            Duracao diferencaTotal = ciclista1.getDuracaoTotal().calcularDiferenca(ciclista2.getDuracaoTotal());

            // Resultado da comparação total
            if (resultadoComparacao < 0) {
                System.out.println("Ciclista " + ciclista1.getNome() + " terminou à frente.");
                System.out.printf("Diferença total: %d minutos e %d segundos.%n",
                        diferencaTotal.toSegundos() / 60, diferencaTotal.toSegundos() % 60);
            } else if (resultadoComparacao > 0) {
                System.out.println("Ciclista " + ciclista2.getNome() + " terminou à frente.");
                System.out.printf("Diferença total: %d minutos e %d segundos.%n",
                        diferencaTotal.toSegundos() / 60, diferencaTotal.toSegundos() % 60);
            } else {
                System.out.println("Empate.");
            }

            // Exibir tempos totais
            System.out.println("Tempo total de " + ciclista1.getNome() + ": " + ciclista1.getDuracaoTotal().toString());
            System.out.println("Tempo total de " + ciclista2.getNome() + ": " + ciclista2.getDuracaoTotal().toString());

            // Pergunta se deseja comparar os tempos em uma etapa específica
            System.out.println("Deseja comparar os tempos em uma etapa específica? (S/N)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("S")) {
                System.out.println("Digite o número da etapa para comparar (1 a " + etapas.size() + "):");
                int etapaNumero = lerInteiro(scanner);
                int resultadoEtapa = ciclista1.compararEtapaCom(ciclista2, etapaNumero);
                if (resultadoEtapa < 0) {
                    System.out.println("Ciclista " + ciclista1.getNome() + " terminou à frente na etapa " + etapaNumero);
                    Duracao diferenca = ciclista1.getDuracaoEtapa(etapaNumero).calcularDiferenca(ciclista2.getDuracaoEtapa(etapaNumero));
                    System.out.printf("Diferença: %s (HH:MM:SS)%n", diferenca.toString());
                } else if (resultadoEtapa > 0) {
                    System.out.println("Ciclista " + ciclista2.getNome() + " terminou à frente na etapa " + etapaNumero);
                    Duracao diferenca = ciclista2.getDuracaoEtapa(etapaNumero).calcularDiferenca(ciclista1.getDuracaoEtapa(etapaNumero));
                    System.out.printf("Diferença: %s (HH:MM:SS)%n", diferenca.toString());
                } else {
                    System.out.println("Empate na etapa " + etapaNumero);
                }
            }

            // Pergunta se deseja fazer outra comparação total
            System.out.println("Deseja fazer outra comparação total? (S/N)");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("S")) {
                break; // Encerra o loop se a resposta não for "S"
            }
        }
    }

    public static List<Etapa> registrarEtapas(Scanner scanner) {
        List<Etapa> etapas = new ArrayList<>();

        for (int i = 1; i <= 21; i++) {
            System.out.println("Etapa " + i + ":");
            String dataInput;
            boolean dataValida = false;

            while (!dataValida) {
                System.out.println("Digite a data da etapa (dd/mm/aaaa):");
                dataInput = scanner.nextLine().trim();

                if (!dataInput.isEmpty()) {
                    String[] dataParts = dataInput.split("/");
                    if (dataParts.length == 3) {
                        try {
                            int dia = Integer.parseInt(dataParts[0]);
                            int mes = Integer.parseInt(dataParts[1]);
                            int ano = Integer.parseInt(dataParts[2]);
                            dataValida = true;
                            Data data = new Data(dia, mes, ano);

                            Hora horaInicio = lerHora(scanner);
                            Etapa etapa = new Etapa(i, data, horaInicio);
                            etapas.add(etapa);
                        } catch (NumberFormatException e) {
                            System.out.println("Formato de data inválido. Tente novamente.");
                        }
                    } else {
                        System.out.println("Formato de data inválido. Use dd/mm/aaaa.");
                    }
                } else {
                    System.out.println("Data não pode ser vazia. Tente novamente.");
                }
            }
        }

        return etapas;
    }

    public static Hora lerHora(Scanner scanner) {
        while (true) {
            System.out.println("Digite a hora de início (hh:mm:ss):");
            String horaInput = scanner.nextLine().trim();
            String[] partes = horaInput.split(":");

            if (partes.length == 3) {
                try {
                    int horas = Integer.parseInt(partes[0]);
                    int minutos = Integer.parseInt(partes[1]);
                    int segundos = Integer.parseInt(partes[2]);
                    return new Hora(horas, minutos, segundos);
                } catch (NumberFormatException e) {
                    System.out.println("Formato de hora inválido. Tente novamente.");
                }
            } else {
                System.out.println("Formato de hora inválido. Use hh:mm:ss.");
            }
        }
    }

    public static Duracao lerDuracao(Scanner scanner) {
        while (true) {
            System.out.println("Digite a duração (hh:mm:ss):");
            String duracaoInput = scanner.nextLine().trim();
            String[] partes = duracaoInput.split(":");

            if (partes.length == 3) {
                try {
                    int duracaoHoras = Integer.parseInt(partes[0]);
                    int duracaoMinutos = Integer.parseInt(partes[1]);
                    int duracaoSegundos = Integer.parseInt(partes[2]);
                    return new Duracao(duracaoHoras, duracaoMinutos, duracaoSegundos);
                } catch (NumberFormatException e) {
                    System.out.println("Formato de duração inválido. Tente novamente.");
                }
            } else {
                System.out.println("Formato de duração inválido. Use hh:mm:ss.");
            }
        }
    }

    public static int lerInteiro(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
            }
        }
    }
}
