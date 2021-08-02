public class Venda extends Transacao{
    private Cliente cliente;

    Venda(String dataVenda, Cliente cliente, Produto produto, int qtdeVendida) {
        super(dataVenda, produto, qtdeVendida);
        this.cliente = cliente;
    }

    public boolean vender(Produto produto, int qtdeVendida){
        if(produto.verificarEstoqueInsuficiente(qtdeVendida)){
            System.out.println("Estoque Insuficiente !");
            return false;
        }
            produto.debitarEstoque(qtdeVendida);
            System.out.println(produto.calcularValorVenda(qtdeVendida));
            return true;
    }
}
