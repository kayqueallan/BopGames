import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CiclistaTest {
    private Ciclista ciclista;
    private List<Etapa> etapas;

    @BeforeEach
    public void setUp() {
        etapas = new ArrayList<>();
        ciclista = new Ciclista("Ciclista 1", 1, etapas);
    }

    @Test
    public void testCriarCiclista() {
        assertEquals("Ciclista 1", ciclista.getNome());
        assertEquals(1, ciclista.getNumero());
        assertTrue(ciclista.getDuracaoTotal().toSegundos() == 0);
    }

    @Test
    public void testAdicionarEtapas() {
        Etapa etapa1 = new Etapa(1, new Data(1, 1, 2024), new Hora(10, 0, 0));
        etapas.add(etapa1);
        ciclista.setEtapas(etapas);

        assertNull(etapa1.getDuracao(ciclista)); // Verificando a duração da etapa para o ciclista
    }


    @Test
    public void testCompararTempos() {
        Etapa etapa1 = new Etapa(1, new Data(1, 1, 2024), new Hora(10, 0, 0));
        etapas.add(etapa1);
        ciclista.setEtapas(etapas);

        Duracao duracao1 = new Duracao(0, 30, 0); // 30 minutos
        etapa1.adicionarDuracao(ciclista, duracao1);

        Ciclista ciclista2 = new Ciclista("Ciclista 2", 2, new ArrayList<>());
        ciclista2.setEtapas(etapas);
        Duracao duracao2 = new Duracao(0, 40, 0); // 40 minutos
        etapa1.adicionarDuracao(ciclista2, duracao2);

        assertEquals(-1, ciclista.compararTempoCom(ciclista2)); // ciclista 1 deve ser mais rápido
    }
}
