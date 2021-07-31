public class Venda extends Transacao{

    Venda(String dataVenda, Cliente cliente, Produto produto, int qtdeVendida) {
        super(dataVenda, produto, qtdeVendida);
    }

    public boolean vender(Produto produto, int qtdeVendida){
        if(produto.verificarEstoqueInsuficiente(qtdeVendida)){
            System.out.println("Estoque Insuficiente !");
            return false;
        }
        else{
            produto.debitarEstoque(qtdeVendida);
            System.out.println(produto.calcularValorVenda(qtdeVendida));

            if(produto.verificarEstoqueBaixo())
                System.out.println("Estoque baixo !");
            return true;
        }
    }
}
