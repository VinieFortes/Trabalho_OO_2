public class Fornecedor extends Pessoa{

    private String cnpj;

    Fornecedor(String nome, String cnpj){
        super(nome);
        this.cnpj = cnpj;
    }
}
