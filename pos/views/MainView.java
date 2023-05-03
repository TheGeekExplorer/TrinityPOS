package pos.views;

import pos.config.*;
import pos.controllers.*;
import pos.models.*;
import pos.views.*;
import pos.services.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;


public class MainView {

    // UI Styling
    public static ImageIcon tmpIcon     = new ImageIcon("/home/mark/Documents/JavaProjects/TrinityPOS/src/images/button.png");
    public static ImageIcon tmpIconLong = new ImageIcon("/home/mark/Documents/JavaProjects/TrinityPOS/src/images/button_long.png");
    public static Image scaledImgKeypad = tmpIcon.getImage().getScaledInstance(MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight,  java.awt.Image.SCALE_SMOOTH);
    public static Image scaledImgZero   = tmpIconLong.getImage().getScaledInstance(MainConfig.keypad0Width, MainConfig.keypadKeyHeight,  java.awt.Image.SCALE_SMOOTH);
    public static Image scaledImgEnter  = tmpIcon.getImage().getScaledInstance(MainConfig.keypadEnterWidth, MainConfig.keypadEnterHeight,  java.awt.Image.SCALE_SMOOTH);
    public static Image scaledImgPromos = tmpIcon.getImage().getScaledInstance(MainConfig.keypadEnterWidth, MainConfig.keypadKeyHeight,  java.awt.Image.SCALE_SMOOTH);
    public static ImageIcon iconKeypad  = new ImageIcon(scaledImgKeypad);
    public static ImageIcon iconZero    = new ImageIcon(scaledImgZero);
    public static ImageIcon iconEnter   = new ImageIcon(scaledImgEnter);
    public static ImageIcon iconPromos  = new ImageIcon(scaledImgPromos);

    // Fonts
    public static Font keypadFont        = new Font(MainConfig.keypadFontName, Font.BOLD, MainConfig.keypadFontSize);  // Create font
    public static Font keypadFontSmaller = new Font(MainConfig.keypadFontName, Font.BOLD, MainConfig.keypadFontSizeSmaller);  // Create font

    // Controls
    public static JFrame f = new JFrame(MainConfig.viewTitle);
    public static JTextField totalsTextField = new JTextField("0.00");
    public static JTextArea totalsBreakdown  = new JTextArea();
    public static JButton b1 = new JButton(iconKeypad); //MainConfig.keypad1label);
    public static JButton b2 = new JButton(iconKeypad); //MainConfig.keypad2label);
    public static JButton b3 = new JButton(iconKeypad); //MainConfig.keypad3label);
    public static JButton b4 = new JButton(iconKeypad); //MainConfig.keypad4label);
    public static JButton b5 = new JButton(iconKeypad); //MainConfig.keypad5label);
    public static JButton b6 = new JButton(iconKeypad); //MainConfig.keypad6label);
    public static JButton b7 = new JButton(iconKeypad); //MainConfig.keypad7label);
    public static JButton b8 = new JButton(iconKeypad); //MainConfig.keypad8label);
    public static JButton b9 = new JButton(iconKeypad); //MainConfig.keypad9label);
    public static JButton b0 = new JButton(iconZero);   //MainConfig.keypad0label);
    public static JButton bDOT = new JButton(iconKeypad);  //MainConfig.keypadDOTlabel);
    public static JButton bDC  = new JButton(iconPromos);  //MainConfig.keypadDClabel);
    public static JButton bMP  = new JButton(iconPromos);  //MainConfig.keypadMPlabel);
    public static JButton bENTER = new JButton(iconEnter); //MainConfig.keypadEnterlabel);

    // Product Log
    public static JList productLog = new JList();


    /**
     * Updates the view with the Register and totals etc
     */
    public static void updateView () {

        // Clear the view down
        MainView.totalsTextField.setText("0.00");
        MainView.totalsBreakdown.setText("");
        MainView.productLog.removeAll();
        MainView.productLog.removeAll();
        RegisterService.total = 0.00;
        RegisterService.orderLog.clear();


        // Run through the products in the Register
        RegisterService.order.forEach((k, v) -> {

                // Get product details
                HashMap<String, Object> product = RegisterService.getProductDetails(k.toString());


                ///// GET DATA FOR VIEW UPDATE /////

                String  description         = (String)  product.get("description");
                Double  price               = (Double)  product.get("price");
                //Integer store_qty           = (Integer) product.get("store_qty");
                //String  dealText            = (String)  product.get("deal_text");
                //Integer deal_qty_qualifier  = (Integer) product.get("deal_qty_qualifier");
                //Integer deal_price_discount = (Integer) product.get("deal_price_discount");
                //Integer deal_perc_discount  = (Integer) product.get("deal_perc_discount");
                Integer qty                 = (Integer) v.get("qty");

                // Pad the fields out to fixed lengths
                String  stringBarcode     = k;
                String  stringDescription = description;
                String  stringPrice       = price.toString();
                //String  stringStoreQty    = store_qty.toString();
                //String  stringDealText    = dealText.toString();
                String  stringQty         = qty.toString();

                int lenQty         = 4  - stringQty.length();
                int lenBarcode     = 20 - stringBarcode.length();
                int lenDescription = 60 - stringDescription.length();
                int lenPrice       = 10 - stringPrice.length();
                //int lenStoreQty    = 10 - stringStoreQty.length();
                //int lenDealText    = 40 - stringDealText.length();

                for (int i=0; i<(lenQty);         i++) { stringQty         = stringQty         + " "; }
                for (int i=0; i<(lenBarcode);     i++) { stringBarcode     = stringBarcode     + " "; }
                for (int i=0; i<(lenDescription); i++) { stringDescription = stringDescription + " "; }
                for (int i=0; i<(lenPrice);       i++) { stringPrice       = stringPrice       + " "; }
                //for (int i=0; i<(lenStoreQty);    i++) { stringStoreQty    = stringStoreQty    + " "; }
                //for (int i=0; i<(lenDealText);    i++) { stringDealText    = stringDealText    + " "; }


                ///// UPDATE VIEW /////

                // Add product to visual product log
                RegisterService.orderLog.add(stringQty + " x " + stringDescription + "  EAN: " + stringBarcode + "  £" + stringPrice + "  "); // + dealText);

                // Update total
                RegisterService.total = RegisterService.total + price;


            });

            // Update controls
            MainView.productLog.setListData(RegisterService.orderLog.toArray());
            MainView.totalsTextField.setText("£" + RegisterService.total.toString());
    }



    /**
     * Method to show the main POS View
     */
    public static void show() {

        f.repaint();

        // Setup the key listener
        KeyListener keysListen = (new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                displayInfo(e, "KEY TYPED: ");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                displayInfo(e, "KEY TYPED: ");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                displayInfo(e, "KEY TYPED: ");
            }
        });

        /** ~~~~~~~~ MAIN FORM ~~~~~~~~ **/

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(MainConfig.viewWidth, MainConfig.viewHeight);
        f.setExtendedState( f.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        f.setLayout(null);                                                                 // using no layout managers
        f.setBackground(new Color(255,255,255));
        f.addKeyListener(keysListen);

        /** ~~~~~~~~~ CONTROLS ~~~~~~~~~ **/

        //////// TOTALS /////////

        totalsTextField.setBounds(MainConfig.totalsX, MainConfig.totalsY, MainConfig.totalsWidth, MainConfig.totalsHeight);
        Font lf = new Font(MainConfig.totalsFontName, Font.BOLD, MainConfig.totalsFontSize);  // Create font
        totalsTextField.setFont(lf);                                                          // Set the font of the totals box to this one.
        totalsTextField.setHorizontalAlignment(JTextField.CENTER);                            // Align the font center
        totalsTextField.addKeyListener(keysListen);
        f.add(totalsTextField);


        //////// KEYPAD /////////

        // KEYPAD 7

        b7.setBounds(MainConfig.keypad7X, MainConfig.keypad7Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b7.setBackground(new Color(255,255,255));
        b7.setBorderPainted(false);
        b7.setHorizontalTextPosition(JButton.CENTER);
        b7.setVerticalTextPosition(JButton.CENTER);
        b7.setFont(keypadFont);                           // Set the font of the totals box to this one.
        b7.setText("7");
        b7.addKeyListener(keysListen);
        f.add(b7);

        // KEYPAD 8
        b8.setBounds(MainConfig.keypad8X, MainConfig.keypad8Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b8.setBackground(new Color(255,255,255));
        b8.setBorderPainted(false);
        b8.setHorizontalTextPosition(JButton.CENTER);
        b8.setVerticalTextPosition(JButton.CENTER);
        b8.setFont(keypadFont);
        b8.setText("8");
        b8.addKeyListener(keysListen);
        f.add(b8);

        // KEYPAD 9
        b9.setBounds(MainConfig.keypad9X, MainConfig.keypad9Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b9.setBackground(new Color(255,255,255));
        b9.setBorderPainted(false);
        b9.setHorizontalTextPosition(JButton.CENTER);
        b9.setVerticalTextPosition(JButton.CENTER);
        b9.setFont(keypadFont);
        b9.setText("9");
        b9.addKeyListener(keysListen);
        f.add(b9);

        // KEYPAD 4
        b4.setBounds(MainConfig.keypad4X, MainConfig.keypad4Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b4.setBackground(new Color(255,255,255));
        b4.setBorderPainted(false);
        b4.setHorizontalTextPosition(JButton.CENTER);
        b4.setVerticalTextPosition(JButton.CENTER);
        b4.setFont(keypadFont);
        b4.setText("4");
        b4.addKeyListener(keysListen);
        f.add(b4);

        // KEYPAD 5
        b5.setBounds(MainConfig.keypad5X, MainConfig.keypad5Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b5.setBackground(new Color(255,255,255));
        b5.setBorderPainted(false);
        b5.setHorizontalTextPosition(JButton.CENTER);
        b5.setVerticalTextPosition(JButton.CENTER);
        b5.setFont(keypadFont);
        b5.setText("5");
        b5.addKeyListener(keysListen);
        f.add(b5);

        // KEYPAD 6
        b6.setBounds(MainConfig.keypad6X, MainConfig.keypad6Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b6.setBackground(new Color(255,255,255));
        b6.setBorderPainted(false);
        b6.setHorizontalTextPosition(JButton.CENTER);
        b6.setVerticalTextPosition(JButton.CENTER);
        b6.setFont(keypadFont);
        b6.setText("6");
        b6.addKeyListener(keysListen);
        f.add(b6);

        // KEYPAD 1
        b1.setBounds(MainConfig.keypad1X, MainConfig.keypad1Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b1.setBackground(new Color(255,255,255));
        b1.setBorderPainted(false);
        b1.setHorizontalTextPosition(JButton.CENTER);
        b1.setVerticalTextPosition(JButton.CENTER);
        b1.setFont(keypadFont);
        b1.setText("1");
        b1.addKeyListener(keysListen);
        f.add(b1);

        // KEYPAD 2
        b2.setBounds(MainConfig.keypad2X, MainConfig.keypad2Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b2.setBackground(new Color(255,255,255));
        b2.setBorderPainted(false);
        b2.setHorizontalTextPosition(JButton.CENTER);
        b2.setVerticalTextPosition(JButton.CENTER);
        b2.setFont(keypadFont);
        b2.setText("2");
        b2.addKeyListener(keysListen);
        f.add(b2);

        // KEYPAD 3
        b3.setBounds(MainConfig.keypad3X, MainConfig.keypad3Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        b3.setBackground(new Color(255,255,255));
        b3.setBorderPainted(false);
        b3.setHorizontalTextPosition(JButton.CENTER);
        b3.setVerticalTextPosition(JButton.CENTER);
        b3.setFont(keypadFont);
        b3.setText("3");
        b3.addKeyListener(keysListen);
        f.add(b3);

        // KEYPAD 0
        b0.setBounds(MainConfig.keypad0X, MainConfig.keypad0Y, MainConfig.keypad0Width, MainConfig.keypadKeyHeight);
        b0.setBackground(new Color(255,255,255));
        b0.setBorderPainted(false);
        b0.setHorizontalTextPosition(JButton.CENTER);
        b0.setVerticalTextPosition(JButton.CENTER);
        b0.setFont(keypadFont);
        b0.setText("0");
        b0.addKeyListener(keysListen);
        f.add(b0);

        // KEYPAD "." (DOT)
        bDOT.setBounds(MainConfig.keypadDOTX, MainConfig.keypadDOTY, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        bDOT.setBackground(new Color(255,255,255));
        bDOT.setBorderPainted(false);
        bDOT.setHorizontalTextPosition(JButton.CENTER);
        bDOT.setVerticalTextPosition(JButton.CENTER);
        bDOT.setFont(keypadFont);
        bDOT.setText(".");
        bDOT.addKeyListener(keysListen);
        f.add(bDOT);

        // KEYPAD "Discount"
        bDC.setBounds(MainConfig.keypadDCX, MainConfig.keypadDCY, MainConfig.keypadDCWidth, MainConfig.keypadKeyHeight);
        bDC.setBackground(new Color(255,255,255));
        bDC.setBorderPainted(false);
        bDC.setHorizontalTextPosition(JButton.CENTER);
        bDC.setVerticalTextPosition(JButton.CENTER);
        bDC.setFont(keypadFontSmaller);
        bDC.setText("DISCOUNT");
        bDC.addKeyListener(keysListen);
        f.add(bDC);

        // KEYPAD "Manual Price"
        bMP.setBounds(MainConfig.keypadMPX, MainConfig.keypadMPY, MainConfig.keypadMPWidth, MainConfig.keypadKeyHeight);
        bMP.setBackground(new Color(255,255,255));
        bMP.setBorderPainted(false);
        bMP.setHorizontalTextPosition(JButton.CENTER);
        bMP.setVerticalTextPosition(JButton.CENTER);
        bMP.setFont(keypadFontSmaller);
        bMP.setText("OVERRIDE");
        bMP.addKeyListener(keysListen);
        f.add(bMP);

        // KEYPAD "ENTER"
        bENTER.setBounds(MainConfig.keypadEnterX, MainConfig.keypadEnterY, MainConfig.keypadEnterWidth, MainConfig.keypadEnterHeight);
        bENTER.setBackground(new Color(255,255,255));
        bENTER.setBorderPainted(false);
        bENTER.setHorizontalTextPosition(JButton.CENTER);
        bENTER.setVerticalTextPosition(JButton.CENTER);
        bENTER.setFont(keypadFont);
        bENTER.setText("ENTER");
        bENTER.addKeyListener(keysListen);
        f.add(bENTER);


        // Totals, breakdown
        totalsBreakdown.setBounds(MainConfig.totalsBreakdownX, MainConfig.totalsBreakdownY, MainConfig.totalsBreakdownWidth, MainConfig.totalsBreakdownHeight);
        Font tBF = new Font(MainConfig.totalsBreakdownFontName, Font.ITALIC, MainConfig.totalsBreakdownFontSize);  // Create font
        totalsBreakdown.setFont(tBF);
        totalsBreakdown.addKeyListener(keysListen);
        f.add(totalsBreakdown);


        // Log
        productLog.setBounds(MainConfig.productLogX, MainConfig.productLogY, MainConfig.productLogWidth, MainConfig.productLogHeight);
        Font tPL = new Font(MainConfig.productLogFontName, Font.BOLD, MainConfig.productLogFontSize);  // Create font
        productLog.setFont(tPL);
        productLog.addKeyListener(keysListen);
        f.add(productLog);



        /** ~~~~~~~~~ SHOW FORM ~~~~~~~~~ **/
        f.setVisible(true);
    }




    private static void displayInfo(KeyEvent e, String keyStatus){

        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = String.valueOf(c);

            // If detect an ending char
            if (keyString.contains("\n")) {

                // Scanned a barcode!
                if (ScannerService.inBarcode.isEmpty()) {
                    // Do nothing
                } else {
                    ScannerService.scanBarcode(ScannerService.inBarcode);
                    ScannerService.inBarcode = "";
                }
            } else {
                ScannerService.inBarcode = ScannerService.inBarcode + keyString;
            }

        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }

        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }

        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }

        String locationString = "key location: ";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }



    }

}

