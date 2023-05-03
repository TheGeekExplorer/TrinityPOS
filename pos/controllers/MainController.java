package pos.controllers;

import pos.models.*;
import pos.views.*;
import pos.services.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainController {

    /**
     * Main view show method
     */
    public static void show () {

        // Add products
        ProductsDB.AddProductsCatalog();

        // Show the main view
        MainView.show();
    }

}
