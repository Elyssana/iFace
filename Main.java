import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        IfaceCRUD CRUD = new IfaceCRUD();

        /*
         * /* CRUD.criarConta("Elyssana",
         * "Ely",
         * "1234");
         * 
         * CRUD.criarConta("joao",
         * "John",
         * "4321");
         * 
         * CRUD.listarContas();
         * 
         * 
         * // Conta userLog;
         * 
         * // userLog.adicionarAmigo(CRUD);
         * // userLog.editarPerfil();
         * // userLog.criarComunidade(CRUD);
         * // userLog.entrarComunidade(CRUD, CRUD.getContas().get(1));
         * // userLog.recuperarInformacao();
         * // TODO criar menu
         * 
         * // userLog.removerAmigo();
         */

        Scanner in = new Scanner(System.in);
        do {
            listarMenuInicial();
            int opcao = in.nextInt();

            if (opcao == 1) {
                
                Conta userLog = CRUD.login();
                
                if(userLog != null){

                    int opcao2;

                    do {
                        
                        listarMenuUsuario();
                        opcao2 = in.nextInt();


                        switch (opcao2) {
                            case 1:
                                userLog.editarPerfil();
                                
                                break;

                            case 2:
                                userLog.adicionarAmigo(CRUD);
                                
                                break;
                            case 3:
                                userLog.removerAmigo();
                                
                                break;
                            case 4:
                                userLog.criarComunidade(CRUD);
                                
                                break;
                            case 5:
                                userLog.entrarComunidade(CRUD);
                                
                                break;
                            case 6:
                                userLog.recuperarInformacao();
                                
                                break;
                            case 7:
                                userLog.deletarPerfil(CRUD);
                                opcao2 = 9;
                                
                                break;
                        
                            default:
                                break;
                        }

                        
                    } while (opcao2 != 9);
                    
                }
                

            } else if (opcao == 2) {
                CRUD.criarConta();
            } else if (opcao == 3) {
                return;            
            } else if (opcao == 4) {
                CRUD.listarContas();
            } else {
                System.out.println("Opção inválida!");
            }

        } while (true);

    }

    public static void listarMenuInicial() {
        System.out.println("\nHELLO WORLD!");
        System.out.println(".\n.\n.");
        System.out.println("1 - Login");
        System.out.println("2 - Criar conta");
        System.out.println("3 - Sair");
        System.out.println("4 - ver contas cadastradas");
        //TODO  listar comnidades cadastradas;
        System.out.print(">>");
    }

    public static void listarMenuUsuario() {
        System.out.println("\nBEM VINDO!");
        System.out.println(".\n.\n.");
        System.out.println("1 - Editar perfil");
        System.out.println("2 - Adicionar amigo ");
        System.out.println("3 - Remover amigo");
        System.out.println("4 - Criar comunidade");
        System.out.println("5 - Entrar em comunidade");
        System.out.println("6 - Ver minhas informações");
        System.out.println("7 - Deletar perfil");
        // System.out.println("8 - Postar mensagem");
        System.out.println("9 - Sair");
        System.out.print(">>");
    }

}
