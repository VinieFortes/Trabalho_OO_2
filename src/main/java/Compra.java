public class Compra extends Transacao {

    private float precoUnit;
    private Fornecedor fornecedor;

    Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int qtdeCompra, float precoUnit) {
        super(dataCompra, produto, qtdeCompra);
        if(fornecedor == null) {
            throw new NullPointerException("Forncedor esta nulo !");
        } else {
            this.fornecedor = fornecedor;
        }
        if(precoUnit <= 0) {
            throw new IllegalArgumentException("Preço unitario inferior a zero !");
        }
        else if(precoUnit > 0) {
            this.precoUnit = precoUnit;
        }
    }

    public boolean comprar(Produto produto, int qtdeCompra){
        if(produto.verificarEstoqueExcedente(qtdeCompra)){
            produto.registrarHistorico("Estoque esta excedente");
            return false;
        }
        else{
            produto.creditarEstoque(qtdeCompra);
            return true;
        }
    }
}
