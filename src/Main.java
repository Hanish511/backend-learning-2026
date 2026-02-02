import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    public static void main(String[] args){
        BankAccount acc1 = new BankAccount(504, "Hash", 5000);
        BankAccount acc2 = new BankAccount(102, "Luffy", 10000);
        BankAccount acc3 = new BankAccount(103, "Tan", 7000);

        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);

        HashMap<Integer, BankAccount> accountMap = new HashMap<>();
        accountMap.put(504, acc1);
        accountMap.put(102, acc2);
        accountMap.put(103, acc3);

        try{
            acc1.withdraw(100000);
        } catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
    }
}