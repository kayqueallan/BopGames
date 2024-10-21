import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataTest {
    @Test
    public void testCriarData() {
        Data data = new Data(10, 10, 2023);

        // Verificação
        assertEquals(10, data.getDia(), "O dia não está correto");
        assertEquals(10, data.getMes(), "O mês não está correto");
        assertEquals(2023, data.getAno(), "O ano não está correto");
    }
}
