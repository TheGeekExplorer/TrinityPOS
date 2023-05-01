package pos.config;

public class MainConfig {

    // View config
    public static String viewTitle = "TrinityPOS - Serving more customers daily!";
    public static int viewWidth = 1920;
    public static int viewHeight = 980;

    // Versioning
    public static int version_major = 1;
    public static int verison_minor = 0;
    public static int version_revision = 0;

    /** View Controls **/

    // Totals
    public static int totalsWidth = 380;
    public static int totalsHeight = 200;
    public static int totalsX = 1530;
    public static int totalsY = 10;
    public static String totalsFontName = "Arial";
    public static int totalsFontSize = 120;

    // Totals Breakdown
    public static int totalsBreakdownWidth = 380;
    public static int totalsBreakdownHeight = 400;
    public static int totalsBreakdownX = 1530;
    public static int totalsBreakdownY = 560;
    public static String totalsBreakdownFontName = "Arial";
    public static int totalsBreakdownFontSize = 13;

    // Keypad - Generic Key / Default
    public static int keypadKeyWidth = 70;
    public static int keypadKeyHeight = 70;

    // Key "7"
    public static String keypad7label = "7";
    public static int keypad7X = 1530;
    public static int keypad7Y = 230;

    // Key "8"
    public static String keypad8label = "8";
    public static int keypad8X = (keypad7X + keypadKeyWidth + 10);
    public static int keypad8Y = keypad7Y;

    // Key "9"
    public static String keypad9label = "9";
    public static int keypad9X = (keypad8X + keypadKeyWidth + 10);
    public static int keypad9Y = keypad7Y;

    // Key "4"
    public static String keypad4label = "4";
    public static int keypad4X = keypad7X;
    public static int keypad4Y = (keypad7Y + keypadKeyHeight + 10);

    // Key "5"
    public static String keypad5label = "5";
    public static int keypad5X = (keypad4X + keypadKeyWidth + 10);
    public static int keypad5Y = keypad4Y;

    // Key "6"
    public static String keypad6label = "6";
    public static int keypad6X = (keypad5X + keypadKeyWidth + 10);
    public static int keypad6Y = keypad4Y;

    // Key "1"
    public static String keypad1label = "1";
    public static int keypad1X = keypad7X;
    public static int keypad1Y = (keypad4Y + keypadKeyHeight + 10);

    // Key "2"
    public static String keypad2label = "2";
    public static int keypad2X = (keypad1X + keypadKeyWidth + 10);
    public static int keypad2Y = keypad1Y;

    // Key "3"
    public static String keypad3label = "3";
    public static int keypad3X = (keypad2X + keypadKeyWidth + 10);
    public static int keypad3Y = keypad1Y;

    // Key "0"
    public static String keypad0label = "0";
    public static int keypad0X = keypad1X;
    public static int keypad0Y = (keypad1Y + (keypadKeyHeight + 10));
    public static int keypad0Width = ((keypadKeyWidth * 2) + 10);

    // Key "." (DOT)
    public static String keypadDOTlabel = ".";
    public static int keypadDOTX = (keypad0X + ((keypadKeyWidth * 2) + 20));
    public static int keypadDOTY = keypad0Y;

    // Key "Discount"
    public static String keypadDClabel = "Discount";
    public static int keypadDCX = (keypadDOTX + keypadKeyWidth + 10);
    public static int keypadDCY = keypad7Y;
    public static int keypadDCWidth = (keypadKeyWidth * 2);

    // Key "Manual Price"
    public static String keypadMPlabel = "Manual Price";
    public static int keypadMPX = keypadDCX;
    public static int keypadMPY = keypad4Y;
    public static int keypadMPWidth = keypadDCWidth;

    // Key "Enter"
    public static String keypadEnterlabel = "Enter";
    public static int keypadEnterX = keypadDCX;
    public static int keypadEnterY = (keypadMPY + keypadKeyHeight + 10);
    public static int keypadEnterWidth = keypadDCWidth;
    public static int keypadEnterHeight = (keypadKeyHeight * 2 + 10);

}
