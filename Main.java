import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        IfaceCRUD CRUD = new IfaceCRUD();

        CRUD.criarConta("Elyssana",
                "Ely",
                "1234");

        CRUD.criarConta("joao",
                "John",
                "4321");
        CRUD.listarContas();

        Conta userLog = CRUD.login();

        //TODO criar menu

        userLog.adicionarAmigo(CRUD);
    }


}
