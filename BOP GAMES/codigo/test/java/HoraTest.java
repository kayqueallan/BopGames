import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HoraTest {

    @Test
    public void testCriarHora() {
        Hora hora = new Hora(10, 30, 45);

        assertEquals(10, hora.getHoras());
        assertEquals(30, hora.getMinutos());
        assertEquals(45, hora.getSegundos());
    }
}
