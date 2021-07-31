import java.util.List;

public class Produto {

    private String nome;
    private int qtdeEstoque;
    private float precoUnit;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private List<String> historico;

    Produto(String nome, int qtdeEstoque, float precoUnit, int estoqueMinimo, int estoqueMaximo){

    }

    public void registarEstoque(Transacao transacao){

    }

    public void exibirHistorico(){

    }

    public void debitarEstoque(int quantidade){

    }

    public void creditarEstoque(int quantidade){

    }

    public void verificarEstoqueBaixo(){

    }

    public void verificarEstoqueInsuficiente(int quantidade){

    }

    public void verificarEstoqueExcedente(int quantidade){

    }

    public void calcularValorVenda(int quantidade){

    }

    public void vender(String dataVenda, Cliente cliente, int qtdeVendida){

    }

    public void comprar(String dataCompra, Fornecedor fornecedor, int qtdeCompra, float precoUnit){

    }
}
