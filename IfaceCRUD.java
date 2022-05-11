import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;

public class IfaceCRUD {
    private ArrayList<Conta> contas;
    private ArrayList<Comunidade> comunidades;
    private Feed feed;

    public IfaceCRUD() {
        this.contas = new ArrayList<Conta>();
        this.comunidades = new ArrayList<Comunidade>();
        this.feed = new Feed();
    }

    public void criarConta() {
        System.out.println("\nCRIAR CONTA\n");
        Scanner in = new Scanner(System.in);
        String nome, usuario, senha;

        // in.nextLine();

        System.out.print("\nNome: \n>");
        nome = in.nextLine();

        System.out.print("\nUsuario: \n>");
        usuario = in.nextLine();
        // TODO verificar se o nome de usuario está disponível

        System.out.print("\nSenha: \n>");
        senha = in.nextLine();

        Conta novaConta = new Conta(UUID.randomUUID(), nome, usuario, senha);

        contas.add(novaConta);
        System.out.println("Conta criada com sucesso!");

    }

    public void criarConta(String nome, String usuario, String senha) {
    System.out.println("CRIAR CONTA");
        Conta novaConta = new Conta(UUID.randomUUID(), nome, usuario, senha);

        contas.add(novaConta);
        System.out.println("Conta criada com sucesso!");

    }

    public Conta login() {
        System.out.println("\nLOGIN\n");
        Scanner in = new Scanner(System.in);
        String usuario, senha;

        System.out.print("Usuario:\n>");
        usuario = in.nextLine(); 
        //usuario = "Ely";//TODO APAGAR ISSO AQUI

        System.out.print("Senha:\n>");
        senha = in.nextLine();
        //senha = "1234";//TODO APAGAR ISSO AQUI

        for (Conta c : contas) {
            if (Objects.equals(usuario, c.getUsuario())) {
                if (Objects.equals(senha, c.getSenha())) {
                    System.out.println("Usuário logado com sucesso!\n");
                    return c;
                }
            }

        }
        System.out.println("Usuario não encontrado!\n");
        return null;

    }

    public void listarContas() {
        int i = 0;
        for (Conta cont : contas) {
            System.out.print(i + " - ");
            System.out.println(cont.toString());
            i++;
        }
    }

    public Conta getConta(String usuario) {

        for (Conta c : this.contas) {
            if (Objects.equals(usuario, c.getUsuario())){
                return c;
            }
            // System.out.println("Convite enviado!\n");
        }
        
        return null;
        
    }
    
    
    public void addComunidade(Comunidade comunidade) {
        this.comunidades.add(comunidade);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public ArrayList<Comunidade> getComunidades() {
        return comunidades;
    }

    public void setComunidades(ArrayList<Comunidade> comunidades) {
        this.comunidades = comunidades;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }


}
