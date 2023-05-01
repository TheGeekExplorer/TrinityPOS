package pos.services;

import pos.models.*;
import java.util.HashMap;


public class RegisterService {

    public static Double total;
    public static int qty;
    public static HashMap<String, HashMap<String, ?>> order = new HashMap<>();
    public static HashMap<String, Integer> orderLog = new HashMap<>();


    /**
     * Adds the product, with it's QTY, to the register
     * @param barcode
     * @param qty
     * @return
     */
    public static boolean addProduct (String barcode, int qty) {

        HashMap<String, Object> properties = new HashMap<>();
        HashMap<String, Object> product = new HashMap<>();

        // Get the product's details from the store
        ProductModel myProduct = new ProductModel();
        product = myProduct.get(barcode);

        // Increase the order qty
        //HashMap<String, ?> tmpProd = order.get(barcode);
        //Integer orderQty = (Integer) tmpProd.get("order_qty");
        //orderQty++;
        //tmpProd.remove("order_qty");
        //tmpProd.put("order_qty", orderQty);
        //order.remove(barcode);
        //order.put(barcode, tmpProd);

        // Add to order
        order.put(barcode, product);

        return true;
    }


    /**
     * Gets the Product details, such as QTY in store, price, picture url, etc
     * @param barcode
     * @return
     */
    public static HashMap<String, Object> getProductDetails (String barcode) {

        // Define product object
        HashMap<String, Object> product = new HashMap<>();

        // Get the product's details from the store
        ProductModel myProduct = new ProductModel();
        product = myProduct.get(barcode);

        // Get the price, and add with qty
        String  description = (String)  product.get("description");
        Double  price       = (Double)  product.get("price");
        Integer qty         = (Integer) product.get("qty");

        // Return product to requester
        return product;
    }

}
