
public class MensagemDireta extends Mensagem{
    
    private Conta destinatario;

    public MensagemDireta(Conta remetente, Conta destinatario, String conteudo) {
        super(remetente, conteudo);
        this.destinatario = destinatario;
    }

    public Conta getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Conta destinatario) {
        this.destinatario = destinatario;
    }

}
