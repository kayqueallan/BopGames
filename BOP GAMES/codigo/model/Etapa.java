import java.util.HashMap;
import java.util.Map;

class Etapa {
    private int numero;
    private Data data;
    private Hora horaInicio;
    private Map<Ciclista, Duracao> duracoes;

    public Etapa(int numero, Data data, Hora horaInicio) {
        this.numero = numero;
        this.data = data;
        this.horaInicio = horaInicio;
        this.duracoes = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public void adicionarDuracao(Ciclista ciclista, Duracao duracao) {
        duracoes.put(ciclista, duracao);
    }

    public Duracao getDuracao(Ciclista ciclista) {
        return duracoes.get(ciclista);
    }
}
