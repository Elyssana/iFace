import java.util.UUID;

public class Atributo {
    private UUID id;
    private String name;
    private String valor;

    public Atributo(UUID id, String name, String valor) {
        this.id = id;
        this.name = name;
        this.valor = valor;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Atributo "+ name + " = "+valor;
    }
}
