
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
     // khai báo thông tin dưới dạng hằng số
     // url kết nối mysql
       private static final String url = "jdbc:mysql://localhost:3306/AbiboFashop";
       private static final String user = "root";
       private static final String password = "Huyngovu16";

        public static Connection getConnection () {
            Connection connection = null;

            try {
                // kết nối đến cơ sở dữ lệu
                //Connection connection = DriverManager.getConnection(url, user, password);
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Kết nối thành công");
                //connection.close();
            } catch (SQLException e) {
                System.out.println("Lỗi kết nối" +e.getMessage());
                e.printStackTrace();
            }
            return connection;
        }

        // phương thức kiểm tra kết nối ( mục đích chính kiểm tra kết nối )
public static void main(String[]args){
            Connection connection = getConnection();
            if (connection != null){
                System.out.println("Đã kết nối đến cơ sở dữ liệu");

            }try {
                connection.close();
    }catch (SQLException e){
                e.printStackTrace();
    }
        }
}



