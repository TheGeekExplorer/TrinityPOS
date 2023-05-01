package pos.models;

import pos.config.*;
import pos.controllers.*;
import pos.models.*;
import pos.views.*;
import pos.services.*;
import java.util.HashMap;


public class ProductModel {


    /**
     * Main model method to get a product's details from the store and return it.
     * DRAFT - this is a draft model, and contains test mocked-up products.
     * @param barcode
     * @return
     */
    public HashMap<String, Object> get (String barcode) {

        // Define variables
        HashMap<String, Object> product = new HashMap<>();
        String description = "";
        Double price = 0.00;
        Integer qty = 0;
        Integer uom = 0;


        // Test products
        switch (barcode) {

            // Define a test product
            case "501326541562":
                description = "Coca-Cola 24x330ml";
                uom = 24;
                price = 13.99;
                qty = 5;
                break;

            // Define a test product
            case "8516416153":
                description = "Fairy Professional 140 Wash Liquid";
                uom = 2;
                price = 24.59;
                qty = 29;
                break;

            // Define a test product
            case "9841521631155":
                description = "Faustino VII Rioja Red Wine 75cl";
                uom = 1;
                price = 6.99;
                qty = 1;
                break;
        }

        // Add product to hashmap
        product.put("description", description);
        product.put("price", price);
        product.put("qty", qty);
        product.put("uom", uom);

        // Return product
        return product;
    }

}
