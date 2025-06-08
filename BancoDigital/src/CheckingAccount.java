public class CheckingAccount extends Account {
    private static final double WITHDRAW_FEE = 0.50;

    public CheckingAccount(int number, String holder) {
        super(number, holder);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + WITHDRAW_FEE);
    }

    @Override
    public void printStatement() {
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.println("Titular: " + getHolder());
        System.out.println("Saldo: " + getBalance());
    }
}
