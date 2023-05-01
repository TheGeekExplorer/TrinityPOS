package pos.controllers;

import pos.views.*;
import pos.services.*;
import java.util.HashMap;


public class MainController {

    // Views
    public MainView v;


    /**
     * Main view show method
     */
    public void show () {

        // Show the main view
        v = new MainView();
        v.show();

        // "Scan" some test products
        scanBarcode("501326541562");
        scanBarcode("8516416153");
        scanBarcode("9841521631155");
    }


    /**
     * Scan a barcode
     * @param barcode
     */
    public void scanBarcode (String barcode) {

        ///// SERVICE & MODEL WORK /////

        // Get product from store
        HashMap<String, Object> product = RegisterService.getProductDetails(barcode);
        String  description = (String)  product.get("description");
        Double  price       = (Double)  product.get("price");
        Integer qty         = (Integer) product.get("qty");

        // Add product to the Register
        RegisterService.addProduct(barcode, 1);

        ///// UPDATE VIEW /////

        // Add product to visual log
        String log = v.totalsBreakdown.getText();
        log = log + "Added product '" + description + "', Barcode: '" + barcode + "', Price: £" + price + "\r\n";
        v.totalsBreakdown.setText(log);

        // Update total
        String totalPrice = v.totalsTextField.getText();
        double totalPrice2 = Double.parseDouble(totalPrice) + price;
        totalPrice = String.valueOf(totalPrice2);
        v.totalsTextField.setText(totalPrice);

        System.out.println("Added product '" + barcode + "', price £" + price);
    }

}
