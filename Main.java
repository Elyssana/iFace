import java.util.UUID;

public class Main {
    public static void main(String[] args){
        Conta novaConta = new Conta(UUID.randomUUID(), 
        true, 
        "Elyssana", 
        "Ely", 
        "1234");
        
        novaConta.editarPerfil();
    }


}
