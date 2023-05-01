package pos.views;

import pos.config.*;
import pos.controllers.*;
import pos.models.*;
import pos.views.*;
import pos.services.*;
import javax.swing.*;
import java.awt.*;


public class MainView {

    public JFrame f = new JFrame(MainConfig.viewTitle);
    public JTextField totalsTextField = new JTextField("0.00");
    public JTextArea totalsBreakdown = new JTextArea();
    public JButton b1 = new JButton(MainConfig.keypad1label);
    public JButton b2 = new JButton(MainConfig.keypad2label);
    public JButton b3 = new JButton(MainConfig.keypad3label);
    public JButton b4 = new JButton(MainConfig.keypad4label);
    public JButton b5 = new JButton(MainConfig.keypad5label);
    public JButton b6 = new JButton(MainConfig.keypad6label);
    public JButton b7 = new JButton(MainConfig.keypad7label);
    public JButton b8 = new JButton(MainConfig.keypad8label);
    public JButton b9 = new JButton(MainConfig.keypad9label);
    public JButton b0 = new JButton(MainConfig.keypad0label);
    public JButton bDOT = new JButton(MainConfig.keypadDOTlabel);
    public JButton bDC = new JButton(MainConfig.keypadDClabel);
    public JButton bMP = new JButton(MainConfig.keypadMPlabel);
    public JButton bENTER = new JButton(MainConfig.keypadEnterlabel);


    public void show() {

        f.repaint();

        /** ~~~~~~~~ MAIN FORM ~~~~~~~~ **/

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setSize(MainConfig.viewWidth, MainConfig.viewHeight);
        f.setExtendedState( f.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        f.setLayout(null);                                                                 // using no layout managers


        /** ~~~~~~~~~ CONTROLS ~~~~~~~~~ **/

        //////// TOTALS /////////

        totalsTextField.setBounds(MainConfig.totalsX, MainConfig.totalsY, MainConfig.totalsWidth, MainConfig.totalsHeight);
        Font lf = new Font(MainConfig.totalsFontName, Font.BOLD, MainConfig.totalsFontSize);  // Create font
        totalsTextField.setFont(lf);                                                          // Set the font of the totals box to this one.
        totalsTextField.setHorizontalAlignment(JTextField.CENTER);                            // Align the font center
        f.add(totalsTextField);


        //////// KEYPAD /////////

        // KEYPAD 7

        b7.setBounds(MainConfig.keypad7X, MainConfig.keypad7Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b7);

        // KEYPAD 8
        b8.setBounds(MainConfig.keypad8X, MainConfig.keypad8Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b8);

        // KEYPAD 9
        b9.setBounds(MainConfig.keypad9X, MainConfig.keypad9Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b9);

        // KEYPAD 4
        b4.setBounds(MainConfig.keypad4X, MainConfig.keypad4Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b4);

        // KEYPAD 5
        b5.setBounds(MainConfig.keypad5X, MainConfig.keypad5Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b5);

        // KEYPAD 6
        b6.setBounds(MainConfig.keypad6X, MainConfig.keypad6Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b6);

        // KEYPAD 1
        b1.setBounds(MainConfig.keypad1X, MainConfig.keypad1Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b1);

        // KEYPAD 2
        b2.setBounds(MainConfig.keypad2X, MainConfig.keypad2Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b2);

        // KEYPAD 3
        b3.setBounds(MainConfig.keypad3X, MainConfig.keypad3Y, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(b3);

        // KEYPAD 0
        b0.setBounds(MainConfig.keypad0X, MainConfig.keypad0Y, MainConfig.keypad0Width, MainConfig.keypadKeyHeight);
        f.add(b0);

        // KEYPAD "." (DOT)
        bDOT.setBounds(MainConfig.keypadDOTX, MainConfig.keypadDOTY, MainConfig.keypadKeyWidth, MainConfig.keypadKeyHeight);
        f.add(bDOT);

        // KEYPAD "Discount"
        bDC.setBounds(MainConfig.keypadDCX, MainConfig.keypadDCY, MainConfig.keypadDCWidth, MainConfig.keypadKeyHeight);
        f.add(bDC);

        // KEYPAD "Manual Price"
        bMP.setBounds(MainConfig.keypadMPX, MainConfig.keypadMPY, MainConfig.keypadMPWidth, MainConfig.keypadKeyHeight);
        f.add(bMP);

        // KEYPAD "ENTER"
        bENTER.setBounds(MainConfig.keypadEnterX, MainConfig.keypadEnterY, MainConfig.keypadEnterWidth, MainConfig.keypadEnterHeight);
        f.add(bENTER);


        // Totals, breakdown
        totalsBreakdown.setBounds(MainConfig.totalsBreakdownX, MainConfig.totalsBreakdownY, MainConfig.totalsBreakdownWidth, MainConfig.totalsBreakdownHeight);
        Font tBF = new Font(MainConfig.totalsBreakdownFontName, Font.ITALIC, MainConfig.totalsBreakdownFontSize);  // Create font
        totalsBreakdown.setFont(tBF);
        f.add(totalsBreakdown);



        /** ~~~~~~~~~ SHOW FORM ~~~~~~~~~ **/
        f.setVisible(true);
    }



}

