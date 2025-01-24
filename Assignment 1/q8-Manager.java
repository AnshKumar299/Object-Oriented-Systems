class Account {
    static int accountNumber = 100000;
    String holderName;
    int balance;

    Account() {
        accountNumber = accountNumber++;
        holderName = "";
        balance = 0;
    }

    String getname() {
        return holderName;
    }

    int getnum() {
        return accountNumber;
    }

    int getbal() {
        return balance;
    }

    void setname(String s) {
        holderName = s;
    }

    void setbal(int k) {
        balance = k;
    }

    void printDetails() {
        System.out.println("Name: " + holderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    float interestRate;

    SavingsAccount(String name, int bal, float interestrate) {
        interestRate = interestrate;
        setname(name);
        setbal(bal);
    }

    double calculateYearlyInterest() {
        return (balance * interestRate) / 100.0;
    }

    void printDetails() {
        System.out.println("Account type: Savings Account -----------------------------------");
        super.printDetails();
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Yearly interest : " + calculateYearlyInterest());
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String name, int bal) {
        setname(name);
        setbal(bal);
    }

    void printDetails() {
        System.out.println("Account Type: Current Account -------------------------------------");
        super.printDetails();
    }
}

public class Manager {
    static Account accounts[] = new Account[5];
    int i[] = new int[8];

    public static void main(String[] args) {
        Account ob = new SavingsAccount("Ansh", 49000, 5);
        accounts[0] = ob;
        accounts[1] = new SavingsAccount("Deb", 65000, 6);
        accounts[2] = new CurrentAccount("Kaustav", 60000);
        accounts[3] = new CurrentAccount("Aritra", 84000);
        accounts[4] = new CurrentAccount("Rishi", 55000);

        for (int i = 0; i < 5; i++) {
            accounts[i].printDetails();
            System.out.println();
        }
    }
}
