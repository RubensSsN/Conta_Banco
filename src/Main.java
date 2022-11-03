import banco.Conta;

public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        c1.setNumConta(12345);
        c1.setDono("Jorgin");
        c1.abrirConta("CC");

        Conta c2 = new Conta();
        c2.setNumConta(2222);
        c2.setDono("Karol");
        c2.abrirConta("CP");

        c1.depositar();
        c2.depositar();

        c2.sacar();

        c1.estadoAtual();
        c2.estadoAtual();
    }
}