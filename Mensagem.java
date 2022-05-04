
public class Mensagem {
    private Conta remetente;
    private String conteudo;

    public Mensagem(Conta remetente, String conteudo) {
        this.remetente = remetente;
        this.conteudo = conteudo;
    }

    public Conta getRemetente() {
        return remetente;
    }

    public void setRemetente(Conta remetente) {
        this.remetente = remetente;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
