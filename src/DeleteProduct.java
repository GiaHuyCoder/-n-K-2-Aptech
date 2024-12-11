import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProduct {
    public void deleteProduct(int ProductID){
        String sql = "DELETE FROM products WHERE ProductID = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ProductID);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected >0){
                System.out.println("Xóa sản phẩm thành công !");
            } else {
                System.out.println("Không tìm thấy sản phẩm để xóa!");
            }
        } catch (SQLException e){
            System.out.println("Lỗi khi xóa sản phẩm : " +e.getMessage());
        }
    }
}
