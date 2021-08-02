public class Compra extends Transacao {

    private float precoUnit;
    private Fornecedor fornecedor;

    Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int qtdeCompra, float precoUnit) {
        super(dataCompra, produto, qtdeCompra);
        this.fornecedor = fornecedor;
        this.precoUnit = precoUnit;
    }

    public boolean comprar(Produto produto, int qtdeCompra){
        if(produto.verificarEstoqueExcedente(qtdeCompra)){
            System.out.print("Compra efetuada !");
            return false;
        }
        else{
            produto.creditarEstoque(qtdeCompra);
            return true;
        }
    }
}
