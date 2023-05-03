package pos.models;

import pos.config.*;
import pos.controllers.*;
import pos.models.*;
import pos.views.*;
import pos.services.*;
import java.util.HashMap;


public class ProductModel {

    public static HashMap<String, Object> product = new HashMap<>();
    public static HashMap<String, HashMap<String, Object>> products = new HashMap<>();


    /**
     * Main model method to get a product's details from the store and return it.
     * DRAFT - this is a draft model, and contains test mocked-up products.
     * @param barcode
     * @return
     */
    public HashMap<String, Object> get (String barcode) {

        // Define variables
        HashMap<String, Object> product = new HashMap<>();
        String  description = "";
        Double  price = 0.00;
        Integer store_qty = 0;
        String  deal_text = "";
        Integer deal_qty_qualifier  = 0;
        Integer deal_price_discount = 0;
        Integer deal_perc_discount  = 0;
        Integer uom = 0;

        // Find product in model
        if (ProductModel.products.containsKey(barcode)) {
            product = ProductModel.products.get(barcode);
        }

        // Return product
        return product;
    }

}
