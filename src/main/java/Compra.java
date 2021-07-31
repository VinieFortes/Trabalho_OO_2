public class Compra extends Transacao {

    private int precoUnit;


    Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int qtdeCompra, float precoUnit) {
        super(dataCompra, produto, qtdeCompra);
    }

    public void comprar(Produto produto, int qtdeCompra){

    }
}
