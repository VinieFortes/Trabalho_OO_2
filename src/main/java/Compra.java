public class Compra extends Transacao {

    private int precoUnit;


    Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int qtdeCompra, float precoUnit) {
        super(dataCompra, produto, qtdeCompra);
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
