import database.JDBCUtil;
import java.sql.Connection;

public class testJDBC {
    public static void main(String[] args) {
      Connection connection = JDBCUtil.getConnection();
      System.out.print(connection);
    }
}
