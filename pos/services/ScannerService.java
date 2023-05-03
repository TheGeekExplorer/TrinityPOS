package pos.services;

import pos.config.*;
import pos.controllers.*;
import pos.models.*;
import pos.views.*;
import pos.services.*;
import java.util.HashMap;



public class ScannerService {

    public static String inBarcode = "";


    /**
     * Scan a barcode
     * @param barcode
     */
    public static void scanBarcode (String barcode) {

        ///// SERVICE & MODEL WORK /////
        RegisterService.addProduct(barcode, 1);
    }
}
