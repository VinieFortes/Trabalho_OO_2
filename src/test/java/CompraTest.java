import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompraTest {

    @Test
    public void deveRetornarCasoRecoUnitInferioraZero()
    {
        try {
            Fornecedor fornecedor = new Fornecedor("Xiaomi Brasil","29.366.628/0001-97");
            Produto produto = new Produto("Redmi 9T", 100, 1080, 0, 100);
            Compra compra = new Compra("27/08/20", produto,fornecedor,1,-1);
            fail();
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Preço unitario inferior a zero !", e.getMessage());
        }
    }

    @Test
    public void deveRetornarCasoFornecedorNulo()
    {
        try {
            Produto produto = new Produto("Samsung Galaxy S10", 521, 1500, 0, 600);
            Compra compra = new Compra("13/11/20", produto,null,5,1500);
            fail();
        }
        catch (NullPointerException e)
        {
            assertEquals("Forncedor esta nulo !", e.getMessage());
        }
    }
}