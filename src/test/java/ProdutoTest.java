import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {
    @Test
    public void deveRetornarCasoNomeInvalido() {
        try {
            Produto produto = new Produto(null, 20, 5, 0, 20);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("O nome do produto esta nulo", e.getMessage());
        }
    }

    @Test
    public void deveRetornarCasoEstoqueInferiorZero() {
        try {
            Produto produto = new Produto("Sony Xperia Z2", -8, 1400, 0, 100);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque inferior a zero", e.getMessage());
        }
    }

    @Test
    public void deveRetornarCasoEstoqueMaxInferiorEstoqueMin() {
        try {
            Produto produto = new Produto("Moto G", 15, 400, 0, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque maximo inferior ao estoque minimo", e.getMessage());
        }
    }

    @Test
    void deveRetornarCasoPrecUnitInferiorZero() {
        try{
            Produto produto = new Produto("LG G6", 8, -3,10,200);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("Preço inferior a zero", e.getMessage());
        }
    }

    @Test
    void deveRetornarCasoEstoqueMinInferiorZero() {
        try{
            Produto produto = new Produto("Iphone 5s", 50, 2,-1,200);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("Estoque minimo inferior a zero", e.getMessage());
        }
    }

    @Test
    public void deveRetornarHistoricoCompra() {
        Produto produto = new Produto("Iphone 12", 10, 2, 0, 20);
        Cliente cliente = new Cliente("Marco", "154362598");
        Fornecedor fornecedor = new Fornecedor("Apple", "00.623.904/0001-73");
        produto.comprar("04/08/21", fornecedor, 100, 12000);

        List<String> registro = List.of("Iphone 12, 04/08/21, 100");
        assertEquals(registro, produto.exibirHistorico());
    }
    @Test
    public void deveRetornarHistoricoVenda() {
        Produto produto = new Produto("Iphone 11", 10, 2, 0, 20);
        Cliente cliente = new Cliente("Marco", "154362598");
        produto.vender("04/08/21", cliente, 10);
        List<String> registro = List.of("Iphone 11, 04/08/21, 10");
        assertEquals(registro, produto.exibirHistorico());
    }

    @Test
    public void deveRetornarCasoQuantidadeCompraSuperiorEstoque() {
        try {
            Produto produto = new Produto("Moto X2", 50, 200, 0, 20);
            produto.debitarEstoque(55);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("A quantidade superior ao estoque", e.getMessage());
        }
    }

    @Test
    public void deveRetornarCasoEstoqueBaixo() {
        Produto produto = new Produto("CCE Motion Plus", 10, 1, 12, 20);
        assertTrue(produto.verificarEstoqueBaixo());
    }

    @Test
    public void deveRetornarCasoEstoqueInsuficiente() {
        Produto produto = new Produto("HTC M3", 20, 2, 4, 10);
        assertTrue(produto.verificarEstoqueInsuficiente(25));
    }

    @Test
    public void deveRetornarCasoEstoqueExcedente() {
        Produto produto = new Produto("Galaxy Pocket", 10, 2, 12, 20);
        assertTrue(produto.verificarEstoqueExcedente(15));
    }
}