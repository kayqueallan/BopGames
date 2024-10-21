import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList; // Adicione esta linha para importar ArrayList

public class EtapaTest {
    @Test
    public void testAdicionarDuracao() {
        Ciclista ciclista = new Ciclista("Ciclista 1", 1, new ArrayList<>());
        Etapa etapa = new Etapa(1, new Data(1, 1, 2024), new Hora(10, 0, 0));

        Duracao duracao = new Duracao(0, 30, 0); // 30 minutos
        etapa.adicionarDuracao(ciclista, duracao);

        assertEquals(duracao, etapa.getDuracao(ciclista));
    }
}
