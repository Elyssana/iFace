public class MensagensFeed extends Mensagem {
    private boolean controleVisualizacao;


    public MensagensFeed(Conta remetente, String conteudo, boolean controleVisualizacao) {
        super(remetente, conteudo);
        this.controleVisualizacao = controleVisualizacao;
    }

    public boolean isControleVisualizacao() {
        return controleVisualizacao;
    }

    public void setControleVisualizacao(boolean controleVisualizacao) {
        this.controleVisualizacao = controleVisualizacao;
    }

}
