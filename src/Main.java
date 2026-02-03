import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    public static void main(String[] args){
        BankAccount acc1 = new BankAccount(101, "Hash", 5000);
        BankAccount acc2 = new BankAccount(102, "Luffy", 10000);
        BankAccount acc3 = new BankAccount(103, "Tan", 7000);
        BankAccount acc4 = new BankAccount(104, "Steve", 8000);

        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        HashMap<Integer, BankAccount> accountMap = new HashMap<>();
        accountMap.put(101, acc1);
        accountMap.put(102, acc2);
        accountMap.put(103, acc3);

        AccountDAO dao = new AccountDAO();

//        dao.saveAccount(acc4);

        int searchId = 102;
        BankAccount foundAcc = dao.getAccount(searchId);
        if (foundAcc != null) {
            System.out.println("--- Account Found ---");
            System.out.println("ID: " + foundAcc.accountNumber);
            System.out.println("Name: " + foundAcc.holderName);
            System.out.println("Balance: $" + foundAcc.balance);
        } else {
            System.out.println("Account with ID " + searchId + " not found.");
        }

        try{
            acc1.withdraw(100000);
        } catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
    }
}