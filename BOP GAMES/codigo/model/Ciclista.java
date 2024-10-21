import java.util.List;

public class Ciclista {
    private String nome;
    private int numero;
    private List<Etapa> etapas;

    public Ciclista(String nome, int numero, List<Etapa> etapas) {
        this.nome = nome;
        this.numero = numero;
        this.etapas = etapas;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public Duracao getDuracaoTotal() {
        Duracao total = new Duracao(0, 0, 0);
        for (Etapa etapa : etapas) {
            Duracao duracaoEtapa = etapa.getDuracao(this);
            if (duracaoEtapa != null) {
                total = total.adicionar(duracaoEtapa);
            }
        }
        return total;
    }

    public Duracao getDuracaoEtapa(int numeroEtapa) {
        for (Etapa etapa : etapas) {
            if (etapa.getNumero() == numeroEtapa) {
                return etapa.getDuracao(this);
            }
        }
        return null;
    }

    public int compararTempoCom(Ciclista outro) {
        int totalSegundos = this.getDuracaoTotal().toSegundos();
        int outroTotalSegundos = outro.getDuracaoTotal().toSegundos();
        return Integer.compare(totalSegundos, outroTotalSegundos); // Menor é melhor
    }

    public int compararEtapaCom(Ciclista outro, int etapaNumero) {
        Duracao duracao1 = this.getDuracaoEtapa(etapaNumero);
        Duracao duracao2 = outro.getDuracaoEtapa(etapaNumero);

        if (duracao1 == null || duracao2 == null) {
            throw new IllegalArgumentException("Duração da etapa não encontrada para um dos ciclistas.");
        }

        return Integer.compare(duracao1.toSegundos(), duracao2.toSegundos()); // Menor é melhor
    }
}
