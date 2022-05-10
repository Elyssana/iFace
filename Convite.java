import java.util.UUID;

public class Convite {
    private UUID id;
    private Conta remetente;
    private Conta destinatario;
    
    public Convite(UUID id, Conta remetente, Conta destinatario) {
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Conta getRemetente() {
        return remetente;
    }

    public void setRemetente(Conta remetente) {
        this.remetente = remetente;
    }

    public Conta getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Conta destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "\nConvite [destinatario=" + destinatario + ", remetente=" + remetente + "]\n";
    }
    
}
