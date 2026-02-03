import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAO {
    public void saveAccount(BankAccount acc){
        try{
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO accounts VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, acc.accountNumber);
            ps.setString(2, acc.holderName);
            ps.setDouble(3, acc.balance);

            ps.executeUpdate();
            System.out.println("Account saved to DB");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public BankAccount getAccount(int accNum){
        BankAccount acc = null;
        try{
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM accounts WHERE account_number = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, accNum);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                acc = new BankAccount();
                acc.accountNumber = rs.getInt("account_number");
                acc.holderName = rs.getString("holder_name");
                acc.balance = rs.getDouble("balance");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return acc;
    }
}
