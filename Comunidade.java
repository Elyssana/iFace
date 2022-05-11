import java.util.ArrayList;
import java.util.UUID;

public class Comunidade {

    private UUID id;
    private Conta admin;
    private String nome;
    private String descrição;
    private ArrayList<Conta> membros;

    public Comunidade() { 
        
        this.membros = new ArrayList<Conta>();
    }


    public Comunidade(UUID id, Conta admin, String nome, String descrição) {
        this.id = id;
        this.admin = admin;
        this.nome = nome;
        this.descrição = descrição;
        this.membros = new ArrayList<Conta>();
    }
    
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Conta getAdmin() {
        return admin;
    }

    public void setAdmin(Conta admin) {
        this.admin = admin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public ArrayList<Conta> getMembros() {
        return membros;
    }

    public void addMembro(Conta membro) {
        this.membros.add(membro);
    }


    @Override
    public String toString() {
        return "Comunidade [admin=" + admin.getUsuario() + ", descrição=" + descrição + ", membros=" + membros + ", nome=" + nome + "]";
    }

}
