package tehtava_1;

public class BankAccount {

    // Nämä ovat instanssimuuttujia: jokaisella oliolla on OMA versionsa näistä.
    private int accountNumber;
    private double balance;

    // Tämä on STAATTINEN muuttuja: tästä on vain YKSI yhteinen kappale koko luokalle.
    private static int totalAccounts = 0;

    //KONSTRUKTORI
    public BankAccount(double initialBalance) {
        // Asetetaan tämän olion omat arvot.
        this.balance = initialBalance;
        totalAccounts++;
        // Annetaan uudelle tilille uniikki numero laskurin perusteella.
        this.accountNumber = totalAccounts;
    }

    // Tavallinen, olioon liittyvä metodi.
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    // Tavallinen, olioon liittyvä metodi.
    public void withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
        }
    }

    // Getterit olion omille tiedoille.
    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    // STAATTINEN metodi: Tämä liittyy koko luokkaan, ei yhteen olioon.
    // Sitä kutsutaan luokan nimellä: BankAccount.getTotalAccounts()
    public static int getTotalAccounts() {
        return totalAccounts;
    }


    // MAIN
    public static void main(String[] args) {
        System.out.println("Luodaan tilejä...");
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        System.out.println("Tehdään tilisiirtoja...");
        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Tilin " + account1.getAccountNumber() + " saldo: " + account1.getBalance());
        System.out.println("Tilin " + account2.getAccountNumber() + " saldo: " + account2.getBalance());

        System.out.println();

        // Kutsutaan staattista metodia luokan nimellä.
        System.out.println("Tilinumeroita yhteensä: " + BankAccount.getTotalAccounts());
    }
}