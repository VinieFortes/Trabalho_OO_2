public class Venda extends Transacao{
    private Cliente cliente;

    Venda(String dataVenda, Cliente cliente, Produto produto, int qtdeVendida) {
        super(dataVenda, produto, qtdeVendida);
        if(cliente == null) {
            throw new IllegalArgumentException("Cliente esta nulo");
        }
        else {
            this.cliente = cliente;
        }
    }

    public boolean vender(Produto produto, int qtdeVendida){
        if(produto.verificarEstoqueInsuficiente(qtdeVendida)){
            produto.registrarHistorico("Estoque esta insuficiente");
            return false;
        }
        else {
            produto.debitarEstoque(qtdeVendida);
        } if (produto.verificarEstoqueBaixo()){
            produto.registrarHistorico("Estoque esta baixo");
        }
            return true;
    }
}
