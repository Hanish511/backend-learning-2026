public class BankAccount{
    int accountNumber;
    String holderName;
    double balance;

    BankAccount(int accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public BankAccount() {

    }

    void deposit(double amount){
        balance += amount;
        System.out.println("Deposited : "+ amount);
    }

    void withdraw(double amount) throws InsufficientBalanceException{
        if(amount > balance){
            throw new InsufficientBalanceException("Not enough balance");
        }
        balance -= amount;
        System.out.println("Withdrawn : "+ balance);
    }

    void checkBalance(){
        System.out.println("Current balance : "+ balance);
    }

    void displayDetails(){
        System.out.println(accountNumber + " " + holderName);
    }
}