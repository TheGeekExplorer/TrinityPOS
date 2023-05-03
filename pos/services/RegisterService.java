package pos.services;

import pos.config.*;
import pos.controllers.*;
import pos.models.*;
import pos.views.*;
import pos.services.*;
import java.util.ArrayList;
import java.util.HashMap;


public class RegisterService {

    public static Double total = 0.00;
    public static int qty = 0;
    public static HashMap<String, HashMap<String, Object>> order = new HashMap<>();
    public static ArrayList<String> orderLog = new ArrayList<String>();


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
        product = RegisterService.getProductDetails(barcode);

        if (order.containsKey(barcode)) {
            product = order.get(barcode);

            // Increase the order qty
            Integer inQTY = Integer.parseInt(product.get("qty").toString());
            inQTY++;
            product.replace("qty", inQTY);
            order.replace(barcode, product);

        } else {

            // Add qty to product object
            product.put("qty", qty);
            order.put(barcode, product);
        }

        // Add to Register
        System.out.println("ORDER: " + order.get(barcode).get("qty"));
        System.out.println("MODEL: " + ProductModel.products.get(barcode).get("qty"));
        System.out.println("...");

        // Update lists, totals, etc in the View
        MainView.updateView();

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
        Object properties;

        // Get the product's details from the store
        ProductModel myProduct = new ProductModel();
        product = myProduct.get(barcode);

        String tmpDescription = product.get("description").toString();
        String tmpCase        = product.get("case").toString();
        String tmpUOM         = product.get("uom").toString();
        //String tmpStoreQty    = product.get("store_qty").toString();
        String tmpPrice       = product.get("price").toString();

        // Get the price, and add with qty
        String  description = (String)  tmpDescription;
        //Integer store_qty   = (Integer) Integer.parseInt(tmpStoreQty);
        Integer case1       = (Integer) Integer.parseInt(tmpCase);
        String  uom         = (String)  tmpUOM;
        Double  price       = (Double)  Double.parseDouble(tmpPrice);

        // Return product to requester
        return product;
    }

}
