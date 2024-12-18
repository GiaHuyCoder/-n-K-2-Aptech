import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        ProductDao productDao = new ProductDao();

        Scanner scanner = new Scanner(System.in);
        // thêm một sản phẩm vào db
        productDao.addProduct(
                "Áo",
                "Unisex",
                "AbiboFasho",
                "Cotton",
                "Hoodie form oversized, thiết kế unisex phù hợp cho cả nam và nữ. Chất liệu nỉ cotton cao cấp, mềm mại, giữ ấm tốt nhưng vẫn thoáng khí, mang lại cảm giác thoải mái suốt cả ngày dài. ",
                690.99,
                50,
                100,
                103

        );
        // đọc danh sách sản phẩm từ db
        try {
            System.out.println("Danh sách sản phẩm");
            productDao.getAllProducts().forEach(products -> {
                System.out.println("Tên :" + products.getName());
                System.out.println("Giá :" + products.getPrice());
                System.out.println("Số lượng tồn kho :" + products.getStock());
                System.out.println("------------------------");



            });
        } catch (Exception e){
            System.out.println("Lỗi khi lấy danh sách sản phẩm !"+ e.getMessage());
        }

        // tùy chọn cập nhật và xóa
        System.out.println("Chọn hành động : 1 - Update , 2 - Delete");
        int choice = scanner.nextInt();
        if (choice == 1){
            // Update
            ProductDao.updateProduct(
                    1,
                    "Áo Hoodie",
                    "Unisex",
                    "AbiboFashop",
                    "Cotton",
                    "Thiết kế mới với chất liệu tuyệt vời từ vải cotton, phù hợp cả nam và nữ . Thiết kế bởi nhà thiết kế Jay,",
                    890.99,
                    130,
                    76,
                    103

            );
        } else if (choice == 2) {
            // Delete
            System.out.println("Nhập ID sản phẩm cần xóa:");
            int productId = scanner.nextInt();
            ProductDao.deleteProduct(productId);
        } else {
            System.out.println("Hành động không hợp lệ !");
        }
        scanner.close();

    }

}