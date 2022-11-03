package banco;

import java.util.Scanner;

public class Conta {

    Scanner teclado = new Scanner(System.in);

    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual() {
        System.out.println("------------------------------");
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.isStatus());
    }

    public Conta() {
        this.setSaldo(0);
        this.setStatus(false);
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if(t.equals("CC") || t.equals("cc")) {
            this.setSaldo(50);
        } else if (t.equals("CP") || t.equals("cp")) {
            this.setSaldo(150);
        }
        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta() {
        if (this.getSaldo() == 0) {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        } else {
            System.out.println("A conta não pode ser fechada verifique o saldo!");
        }
    }

    public void depositar() {
        if (this.isStatus()) {
            System.out.println("Informe o valor a ser depositado na conta de: " + this.getDono());
            float deposito = teclado.nextFloat();
            this.setSaldo((this.getSaldo() + deposito));
            System.out.println("Deposito realizado com sucesso na conta de " + this.getDono());
        } else {
            System.out.println("Conta deve estar aberta para receber depositos!");
        }
    }

    public void sacar() {
        System.out.println("Informe o valor a ser sacado: ");
        float sacar = teclado.nextFloat();
        if (this.isStatus()) {
            if (saldo >= sacar) {
                this.setSaldo((this.getSaldo() - sacar));
                System.out.println("Saque realizado no valor de "+ sacar + "para conta de "+ this.getDono());
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println("Conta está fechada!");
        }
    }

    public void pagarMensal() {
        int v = 0;
        if (this.getTipo().equals("CC") || this.getTipo().equals("cc")) {
            v = 12;
        } else if (this.getTipo().equals("CP") || this.getTipo().equals("cp")) {
            v = 20;
        }
        if (this.isStatus()) {
            if (this.getSaldo()>= v) {
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Mensalidade paga com sucesso por "+ this.getDono());
            }
        }
    }

}
