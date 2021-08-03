import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest {

    @Test
    void deveRetornarClienteNulo() {
        try {
            Produto produto = new Produto("Moto Max", 5, 2000, 10, 200);
            Venda venda = new Venda("27/06/21", null, produto, 50);
        } catch (IllegalArgumentException e) {
            assertEquals("Cliente esta nulo", e.getMessage());
        }
    }
}