import java.util.ArrayList;
import java.util.UUID;

public class Comunidade {

    private UUID id;
    private Conta admin;
    private String nome;
    private String descrição;
    private ArrayList<Conta> membros;

    public Comunidade(UUID id, Conta admin, String nome, String descrição, ArrayList<Conta> membros) {
        this.id = id;
        this.admin = admin;
        this.nome = nome;
        this.descrição = descrição;
        this.membros = membros;
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

    public void setMembros(ArrayList<Conta> membros) {
        this.membros = membros;
    }

}
