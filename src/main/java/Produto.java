import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Produto {

    private String nome;
    private int qtdeEstoque;
    private float precoUnit;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private List<String> historico;

    Produto(String nome, int qtdeEstoque, float precoUnit, int estoqueMinimo, int estoqueMaximo){
        if(nome == null){
            throw new IllegalArgumentException("O nome do produto esta nulo");
        }else {
            this.nome = nome;
        }
        if(qtdeEstoque < 0) {
            throw new IllegalArgumentException("Estoque inferior a zero");
        }
        else {
            this.qtdeEstoque = qtdeEstoque;
        }
        if(precoUnit <= 0) {
            throw new IllegalArgumentException("Preço inferior a zero");
        }
        else {
            this.precoUnit = precoUnit;
        }
        if(estoqueMinimo < 0)
            throw new IllegalArgumentException("Estoque minimo inferior a zero");
        else {
            this.estoqueMinimo = estoqueMinimo;
        }
        if (estoqueMaximo < estoqueMinimo){
            throw new IllegalArgumentException("Estoque maximo inferior ao estoque minimo");
        } else {
            this.estoqueMaximo = estoqueMaximo;
        }
        this.historico = new ArrayList<String>();
    }

    public void registrarHistorico(String transacao){
        if (historico == null) {
            throw new NullPointerException("Transacao nula");
        }
        this.historico.add(transacao);
    }

    public List<String> exibirHistorico(){
        if (historico == null) {
            throw new NullPointerException("Historico vazio");
        }
        return this.historico;
    }

    public void debitarEstoque(int quantidade) {
        if(quantidade < 0){
            throw new InvalidParameterException("A quantidade inferior a zero !");
        }
        if(quantidade > qtdeEstoque){
            throw new InvalidParameterException("A quantidade superior ao estoque");
        }
            this.qtdeEstoque -= quantidade;
    }

    public void creditarEstoque(int quantidade){
        if(quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero !");
        }
            this.qtdeEstoque += quantidade;
    }

    public boolean verificarEstoqueBaixo(){
        return (this.qtdeEstoque < this.estoqueMinimo);
    }

    public boolean verificarEstoqueInsuficiente(int quantidade){
        if(quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero !");
        }
            return (this.qtdeEstoque < quantidade);
    }

    public boolean verificarEstoqueExcedente(int quantidade){
        if(quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero !");
        }
            return (this.qtdeEstoque > this.estoqueMaximo);
    }

    public float calcularValorVenda(int quantidade){
        if(quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero !");
        }
        return this.precoUnit * quantidade;
    }

    public void vender(String dataVenda, Cliente cliente, int qtdeVendida){
        if(qtdeVendida < 0){
            throw new InvalidParameterException("A quantidade inferior a zero");
        }
        if(dataVenda == null ){
            throw new NullPointerException("A data esta nula");
        }
        if(cliente == null){
            throw new NullPointerException("O cliente esta nulo");
        }
        Venda venda = new Venda( dataVenda ,cliente, Produto.this , qtdeVendida);
        if(venda.vender(this, qtdeVendida)){
            this.registrarHistorico("Venda" + "\nNome: " +  this.nome + "\nData: " + dataVenda + "\nQuantidade: " + qtdeVendida + "\nPreço Unidade: " + precoUnit);
        }
    }

    public void comprar(String dataCompra, Fornecedor fornecedor, int qtdeCompra, float precoUnit){
        if(qtdeCompra < 0){
            throw new InvalidParameterException("A quantidade inferior a zero");
        }
        if(precoUnit < 0){
            throw new InvalidParameterException("O valor inferior a zero");
        }
        if(dataCompra == null ){
            throw new NullPointerException("A data esta nula");
        }
        if(fornecedor == null){
            throw new NullPointerException("O fornecedor esta nulo");
        }
        Compra compra = new Compra( dataCompra ,Produto.this, fornecedor, qtdeCompra,precoUnit);
        if(compra.comprar(this, qtdeCompra)){
            this.registrarHistorico("Compra" + "\nNome: " +  this.nome + "\nData: " + dataCompra + "\nQuantidade: " + qtdeCompra + "\nPreço Unidade: " + precoUnit);
        }
    }
}
