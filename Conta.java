import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class Conta {
    private UUID id;
    private boolean status;
    private String name;
    private String usuario;
    private String senha;
    private ArrayList<Comunidade> comunidades;
    private ArrayList<Conta> amigos;
    private ArrayList<Convite> convites;
    private ArrayList<Atributo> atributos;
    private ArrayList<MensagemDireta> mensagensDiretas;

    public Conta(UUID id, String name, String usuario, String senha) {
        this.id = id;
        this.status = true;
        this.name = name;
        this.usuario = usuario;
        this.senha = senha;
        this.comunidades = new ArrayList<Comunidade>();
        this.amigos = new ArrayList<Conta>();
        this.convites = new ArrayList<Convite>();
        this.atributos = new ArrayList<Atributo>();
        this.mensagensDiretas = new ArrayList<MensagemDireta>();

    }

    public void recuperarInformacao() {
        Scanner in = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("RECUPERAR INFORMAÇÃO");
            System.out.println("1 - Perfil\n"
                    + "2 - Comunidades\n"
                    + "3 - Amigos\n"
                    + "4 - mensagens\n"
                    + "5 - sair\n");

            System.out.print("Seleciona a informação desejada:\n>");
            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    this.imprimirPerfil();
                    break;

                case 2:
                    this.imprimirComunidades();
                    break;
                
                case 3:
                    this.imprimirAmigos();
                    break;
                case 4:
                    this.imprimirMensagens();
                    break;

                default:
                    break;
            }
        } while (opcao != 5);
    }

    private void imprimirMensagens() {
    }

    private void imprimirAmigos() {
        System.out.println(this.amigos);
    }

    private void imprimirComunidades() {
        System.out.println(this.comunidades);
    }

    private void imprimirPerfil() {
        System.out.println(this);
        this.listarAtributos();
    }

    public void criarComunidade(IfaceCRUD CRUD) {

        System.out.println("CRIAR COMUNIDADE");

        Scanner in = new Scanner(System.in);

        System.out.print("\nInsira o nome da nova comunidade:\n>");
        String nome = in.nextLine();

        System.out.print("\nInsira uma descrição:\n>");
        String descricao = in.nextLine();

        Comunidade comunidade = new Comunidade(UUID.randomUUID(), this, nome, descricao);
        this.comunidades.add(comunidade);
        CRUD.addComunidade(comunidade);

        /* System.out.println(this.comunidades.get(0));
        System.out.println("*************************");
        System.out.println(CRUD.getComunidades().get(0)); */

    }

    public void entrarComunidade(IfaceCRUD CRUD, Conta admin) {

        System.out.println("ENTRAR EM COMUNIDADE");

    
        Scanner in = new Scanner(System.in);

        System.out.print("\nInsira o nome da comunidade:\n>");
        String nome = in.nextLine();

        for (Comunidade c : CRUD.getComunidades()) {
            if (Objects.equals(nome, c.getNome().toString())) {
                this.comunidades.add(c);
                c.addMembro(this);
                System.out.println("Você entrou na comunidade " + c.getNome());
                return;
                /*
                 * System.out.println(this.comunidades.get(1));
                 * System.out.println("*************************");
                 * System.out.println(CRUD.getComunidades().get(1)) ;
                 */

            }
        }
        System.out.println("Comunidade não encontrada!");
    }

    public void removerAmigo() {

        System.out.println("REMOVER AMIGO");
        Scanner in = new Scanner(System.in);
        System.out.print("Insira o nome de usuario do amigo:\n>");
        String nomeAmigo = in.nextLine();

        for (Conta a : this.amigos) {
            if (Objects.equals(nomeAmigo, a.usuario)) {

                this.amigos.remove(a);
                System.out.println("Amigo removido com sucesso!");
                return;
            }
        }
        System.out.println("Amigo não encontrado!");

    }

    public void adicionarAmigo(IfaceCRUD CRUD) {
        System.out.println("ADICIONAR AMIGO");
        Scanner in = new Scanner(System.in);

        // encontrar na lista de usuarios o usuarios que eu quero
        System.out.print("Insira o nome de usuario da pessoa:\n>");
        String nomeUsuario = in.nextLine();

        Conta usuario = CRUD.getConta(nomeUsuario);

        /* inicio teesteeeeeeeeeeeeeee */
        this.addConvite(UUID.randomUUID(), usuario, this);
        /*
         * System.out.println(usuario);
         * 
         * 
         * System.out.println(this.getConvites().get(0).toString());
         */
        /* fim testeeeee ******************** */

        Convite convite = this.temConvite(nomeUsuario);
        // verificar se tem algum convite dela na minha lista de convites

        if (convite != null) {
            // se sim: adicionar um ao outro a lista de amigos de ambos e remover convite da
            // lista
            this.amigos.add(convite.getRemetente());
            usuario.amigos.add(convite.getDestinatario());

            this.convites.remove(convite);

            System.out.println("Você e " + nomeUsuario + " agora são amigos!\n");
        } // senão: envia convite
        else {
            usuario.addConvite(UUID.randomUUID(), this, usuario);
            System.out.println("Convite enviado com sucesso!");
        }

        /* System.out.println(this.getConvites().get(0).toString()); */

    }

    public Convite temConvite(String user) {

        for (Convite c : this.convites) {
            if (Objects.equals(user, c.getRemetente().usuario)) {
                return c;
            }
        }
        return null;
    }

    public void addConvite(UUID id, Conta remetente, Conta destinatario) {
        Convite c = new Convite(id, remetente, destinatario);
        this.convites.add(c);
    }

    public void editarPerfil() {
        Scanner in = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\nQue alteração deseja realizar no seu perfil?\n");
            System.out.println("1-alterar nome");
            System.out.println("2-adicionar atributo");
            System.out.println("3-editar atributo");
            System.out.println("4-deletar atributo");
            System.out.print("5-sair\n>>");

            opcao = in.nextInt();

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

                    /*
                     * Atributo atributo = atributos.get(0);
                     * System.out.println("nome: " + atributo.getName());
                     * System.out.println("valor: " + atributo.getValor());
                     * System.out.println("id: " + atributo.getId());
                     */

                    break;

                case 3:

                    System.out.println("\nInsira o índice do atributo à ser editado:");

                    listarAtributos();
                    System.out.print(">>");

                    int optAtb = in.nextInt();

                    System.out.print("\nInsira o novo valor de " + (atributos.get(optAtb)).getName() + "\n>>");
                    in.nextLine();
                    novoValor = in.nextLine();

                    (atributos.get(optAtb)).setValor(novoValor);

                    /*
                     * for (Atributo atb : atributos) {
                     * System.out.print(cont+" - ");
                     * System.out.println(atb.toString());
                     * ++cont;
                     * }
                     */

                    break;
                case 4:

                    System.out.println("\nInsira o índice do atributo à ser deletado:");

                    listarAtributos();

                    System.out.print(">>");

                    optAtb = in.nextInt();

                    atributos.remove(optAtb);

                    break;

                default:
                    break;
            }
        } while (opcao != 5);
        /* -alterar nome */

    }

    public void listarAtributos() {
        int cont = 0;
        for (Atributo atb : atributos) {
            System.out.print(cont + " - ");
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    @Override
    public String toString() {
        return "\n****************CONTA****************"
                // +" \n\nId: "+ id
                + "\n\nNome: " + name
                + "\nUsuario: " + usuario
                + "\n***************************************\n\n";
    }

}
