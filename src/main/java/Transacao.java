public class Transacao {

    private String dataTransacao;
    private int qtde;

    Transacao(String dataTransacao, Produto produto, int qtde){
        this.dataTransacao = dataTransacao;
        this.qtde = qtde;
    }
}
