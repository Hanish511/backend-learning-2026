import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    public static Connection getConnection(){
        try{
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("db.properties");
            props.load(fis);

            return DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.username"),
                    props.getProperty("db.password")
            );
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

