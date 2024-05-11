package AlkeWallet;

public class Wallet {
    private int saldo; // Cambiado a tipo int para representar pesos chilenos

    public Wallet() {
        this.saldo = 0; // Inicializado en 0 al inicio
    }

    public int getSaldo() {
        return saldo;
    }

    public void depositar(int monto) {
        saldo += monto;
    }

    public boolean retirar(int monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
