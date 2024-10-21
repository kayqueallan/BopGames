import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuracaoTest {

    @Test
    public void testGetHoras() {
        Duracao duracao = new Duracao(2, 30, 15);
        assertEquals(2, duracao.getHoras());
    }
}
