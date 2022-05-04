import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Conta {
    private UUID id;
    private boolean status;
    private String name;
    private String login;
    private String senha;
    private ArrayList<Comunidade> comunidades;
    private ArrayList<Conta> amigos;
    private ArrayList<Convite> convites;
    private ArrayList<Atributo> atributos;
    private ArrayList<MensagemDireta> mensagensDiretas;

    /*
     * public Conta(UUID id, boolean status, String name, String login, String
     * senha, ArrayList<Comunidade> comunidades,
     * ArrayList<Conta> amigos, ArrayList<Convite> convites, ArrayList<Atributo>
     * atributos,
     * ArrayList<MensagemDireta> mensagensDiretas) {
     * this.id = id;
     * this.status = status;
     * this.name = name;
     * this.login = login;
     * this.senha = senha;
     * this.comunidades = comunidades;
     * this.amigos = amigos;
     * this.convites = convites;
     * this.atributos = atributos;
     * this.mensagensDiretas = mensagensDiretas;
     * }
     */

    public Conta(UUID id, boolean status, String name, String login, String senha) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.login = login;
        this.senha = senha;
        this.comunidades = new ArrayList<Comunidade>();
        this.amigos = new ArrayList<Conta>();
        this.convites = new ArrayList<Convite>();
        this.atributos = new ArrayList<Atributo>();
        this.mensagensDiretas = new ArrayList<MensagemDireta>();

    }

    public void editarPerfil() {
        do{
        System.out.println("Que alteração deseja realizar no seu perfil?\n");
        System.out.println("1-alterar nome");
        System.out.println("2-adicionar atributo");
        System.out.println("3-editar atributo");
        System.out.print("4-deletar atributo\n>>");

        Scanner in = new Scanner(System.in);

        int opcao = in.nextInt();
        String novoNome, novoValor;
        switch (opcao) {
            case 1:

                System.out.print("\nDigite o novo nome:\n>>");

                in.nextLine();
                novoNome = in.nextLine();

                setName(novoNome);
                System.out.println(getName());

                break;

            case 2:

                System.out.print("\nDê um nome ao novo atributo:\n>>");
                in.nextLine();
                novoNome = in.nextLine();

                System.out.print("\nQual valor deseja adicionar à " + novoNome + "\n>>");
                novoValor = in.nextLine();

                Atributo novoAtributo = new Atributo(UUID.randomUUID(), novoNome, novoValor);
                atributos.add(novoAtributo);

                /* Atributo atributo = atributos.get(0);
                System.out.println("nome: " + atributo.getName());
                System.out.println("valor: " + atributo.getValor());
                System.out.println("id: " + atributo.getId()); */

                break;

            case 3:

                System.out.print("\nInsira o índice do atributo à ser editado:\n>>");
                
                listarAtributos();

                int optAtb = in.nextInt();

                System.out.print("\nInsira o novo valor de "+ (atributos.get(optAtb)).getName()+"\n>>");
                in.nextLine();
                novoValor = in.nextLine();

                (atributos.get(optAtb)).setValor(novoValor);

                /* for (Atributo atb : atributos) {
                    System.out.print(cont+" - ");
                    System.out.println(atb.toString());
                    ++cont;
                } */

                break;
            case 4:

                System.out.println("Insira o índice do atributo à ser deletado:\n");

                listarAtributos();

                optAtb = in.nextInt();

                atributos.remove(optAtb);
                
                break;

            default:
                break;
        }
        }while(true);
        /* -alterar nome */

    }

    public void listarAtributos(){
        int cont = 0;
        for (Atributo atb : atributos) {
            System.out.print(cont+" - ");
            System.out.println(atb.toString());
            ++cont;
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList<Comunidade> getComunidades() {
        return comunidades;
    }

    public void setComunidades(ArrayList<Comunidade> comunidades) {
        this.comunidades = comunidades;
    }

    public ArrayList<Conta> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Conta> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<Convite> getConvites() {
        return convites;
    }

    public void setConvites(ArrayList<Convite> convites) {
        this.convites = convites;
    }

    /*
     * public ArrayList<Atributo> getAtributo() {
     * return atributo;
     * }
     * 
     * public void setAtributo(ArrayList<Atributo> atributo) {
     * this.atributo = atributo;
     * }
     */

    public ArrayList<MensagemDireta> getMensagensDiretas() {
        return mensagensDiretas;
    }

    public void setMensagensDiretas(ArrayList<MensagemDireta> mensagensDiretas) {
        this.mensagensDiretas = mensagensDiretas;
    }

}
