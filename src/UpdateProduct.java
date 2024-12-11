import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProduct {
    public static void updateProduct(int ProductID, String Name, String Gender, String BrandName, String Material, String Description, Double Price, int Stock, int Sold, int CategoryID){
        String sql = "UPDATE products SET Name = ?,Gender =?,BrandName = ?,Material = ? , Description = ? , Price = ? , Stock = ? , Sold = ? , CategoryID = ? WHERE ProductID = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,Name);
            pstmt.setString(2,Gender);
            pstmt.setString(3,BrandName);
            pstmt.setString(4,Material);
            pstmt.setString(5,Description);
            pstmt.setDouble(6,Price);
            pstmt.setDouble(7,Stock);
            pstmt.setDouble(8,Sold);
            pstmt.setDouble(9,CategoryID);
            pstmt.setDouble(10,ProductID);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cập nhật sản phẩm thành công!");
            }else {
                System.out.println("Không tìm thấy sản phẩm để cập nhật!");
            }
        } catch (SQLException e ){
            System.out.println("Lỗi khi cập nhật sản phẩm : "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateProduct(int i, String áoHoodie, String unisex, String abiboFashop, String cotton, String s, double v, int i1, int i2) {
    }
}
