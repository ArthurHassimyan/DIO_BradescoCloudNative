public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Example Bank");

        Account acc1 = new CheckingAccount(1, "João");
        Account acc2 = new SavingsAccount(2, "Maria");

        bank.addAccount(acc1);
        bank.addAccount(acc2);

        acc1.deposit(1000);
        acc1.transfer(200, acc2);

        acc1.printStatement();
        acc2.printStatement();
    }
}