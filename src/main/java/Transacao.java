public class Transacao {

    private String dataTransacao;
    private int qtde;
    private Produto produto;

    Transacao(String dataTransacao, Produto produto, int qtde){
        this.dataTransacao = dataTransacao;
        this.qtde = qtde;
        this.produto = produto;
    }
    public String getDataTransacao() {
        return this.dataTransacao;
    }

    public  int getQtde(){
        return this.qtde;
    }

    public Produto getProduto() {
        return this.produto;
    }
}
