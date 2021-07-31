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

    public void debitarEstoque(int quantidade) {
        if(!verificarEstoqueInsuficiente(quantidade)){
            this.qtdeEstoque -= quantidade;
        }
    }

    public void creditarEstoque(int quantidade){
        if(quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero !");
        }
        else {
            this.qtdeEstoque += quantidade;
        }
    }

    public boolean verificarEstoqueBaixo(){
        return (qtdeEstoque < estoqueMinimo);
    }

    public boolean verificarEstoqueInsuficiente(int quantidade){
        if(quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero !");
        }
        else {
            return (qtdeEstoque < quantidade);
        }
    }

    public boolean verificarEstoqueExcedente(int quantidade){
        if(quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero !");
        }
        else {
            return (qtdeEstoque > quantidade);
        }
    }

    public float calcularValorVenda(int quantidade){
        if(quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero !");
        }
        return precoUnit * quantidade;
    }

    public void vender(String dataVenda, Cliente cliente, int qtdeVendida){

    }

    public void comprar(String dataCompra, Fornecedor fornecedor, int qtdeCompra, float precoUnit){

    }
}
