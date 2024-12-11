// lớp productdao này quản lý ds sản phẩm
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


// Dao là Data Access Object
public class ProductDao {
    // CREATE
    public void addProduct(String Name,String Gender,String BrandName,String Material,String Description,Double Price,int Stock,int Sold,int CategoryID){
        String url = "jdbc:mysql://localhost:3306/AbiboFashop";
        String user = "root";
        String password ="Huyngovu16";
        String sql = "INSERT INTO products ( Name, Gender, BrandName, Material, Description, Price, Stock, Sold, CategoryID) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = MySQLConnection.getConnection(); // phương thức này ko chấp nhận tham số
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,Name);
            pstmt.setString(2,Gender);
            pstmt.setString(3,BrandName);
            pstmt.setString(4,Material);
            pstmt.setString(5,Description);
            pstmt.setDouble(6,Price);
            pstmt.setInt(7,Stock);
            pstmt.setInt(8,Sold);
            pstmt.setInt(9,CategoryID);
            pstmt.executeUpdate();
            System.out.println("Bảng products được thêm thành công!");
        } catch (SQLException e ){
            System.out.println("Thêm bảng products không thành công!" + e.getMessage());
            e.printStackTrace(); // in ra toàn bộ stack trace của lỗi
        }
    }
    //READ
    public List<Products> getAllProducts(){
        List<Products> productsList = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Products products = new Products();
                products.setName(resultSet.getString("Name"));
                products.setGender(resultSet.getString("Gender"));
                products.setBrandName(resultSet.getString("BrandName"));
                products.setMaterial(resultSet.getString("Material"));
                products.setDescription(resultSet.getString("Description"));
                products.setPrice(resultSet.getDouble("Price"));
                products.setStock(resultSet.getInt("Stock"));
                products.setSold(resultSet.getInt("Sold"));
                products.setCategoryId(resultSet.getInt("CategoryID"));
                productsList.add(products);
            }
        } catch (SQLException e){
            System.out.println("Lô khi lấy danh sách sản phẩm" + e.getMessage());
        }

return productsList;
    }
    //UPDATE
    public void updateProduct(int ProductID, String Name, String Gender, String BrandName, String Material, String Description, Double Price, int Stock, int Sold, int CategoryID){
        UpdateProduct updateProduct = new UpdateProduct();
        UpdateProduct.updateProduct(ProductID,Name,Gender,BrandName,Material,Description,Price,Stock,Sold,CategoryID);
    }

    // DELETE
    public void deleteProduct(int ProductID){
        DeleteProduct deleteProduct = new DeleteProduct();
        deleteProduct.deleteProduct(ProductID);
    }

}
