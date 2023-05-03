package pos.models;

import pos.models.*;

public class ProductsDB {

    public static void AddProductsCatalog () {
        ProductModel.product.clear();
        ProductModel.products.clear();

        ProductModel.product.clear();
        ProductModel.product.put("description", "All Purpose Cleaning Fluid 500ml");
        ProductModel.product.put("case", 8);
        ProductModel.product.put("uom", "500ml");
        ProductModel.product.put("price", 7.99);
        ProductModel.product.put("rrp", 2.19);
        ProductModel.products.put("851654161231", ProductModel.product);
        ProductModel.product.clear();
        ProductModel.product.put("description", "Any Surface Dusting Clothes Twin Pack");
        ProductModel.product.put("case", 2);
        ProductModel.product.put("uom", "Single");
        ProductModel.product.put("price", 1.99);
        ProductModel.product.put("rrp", 2.99);
        ProductModel.products.put("8616516516253", ProductModel.product);
        ProductModel.product.clear();
        ProductModel.product.put("description", "Simple Microwave Chips in Easy Open Box");
        ProductModel.product.put("case", 3);
        ProductModel.product.put("uom", "Single");
        ProductModel.product.put("price", 3.99);
        ProductModel.product.put("rrp", 4.99);
        ProductModel.products.put("5016878012156", ProductModel.product);
        ProductModel.product.clear();

    }
}
