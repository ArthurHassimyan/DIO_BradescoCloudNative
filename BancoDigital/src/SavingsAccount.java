public class SavingsAccount extends Account {

    public SavingsAccount(int number, String holder) {
        super(number, holder);
    }

    @Override
    public void printStatement() {
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.println("Titular: " + getHolder());
        System.out.println("Saldo: " + getBalance());
    }
}
