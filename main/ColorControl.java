package main;

import java.awt.Color;
import java.awt.Component;

public class ColorControl {

    private static final Color NIGERIA_GREEN = new Color(0, 104, 71);
    private static final Color NIGERIA_WHITE = Color.WHITE;
    private static final Color CONGO_RED = new Color(220, 36, 31);
    private static final Color DEFAULT_BACKGROUND = Color.WHITE;
    private static final Color DEFAULT_FOREGROUND = Color.BLACK;

    public static void setTheme(String region, Component component) {
        if (component != null) {
            switch (region.toLowerCase()) {
                case "nigeria":
                    applyNigeriaTheme(component);
                    break;
                case "congo":
                    applyCongoTheme(component);
                    break;
                default:
                    applyDefaultTheme(component);
                    break;
            }
        }
    }

    private static void applyNigeriaTheme(Component component) {
        component.setBackground(NIGERIA_GREEN);
        component.setForeground(NIGERIA_WHITE);
    }

    private static void applyCongoTheme(Component component) {
        component.setBackground(CONGO_RED);
        component.setForeground(NIGERIA_WHITE);
    }

    private static void applyDefaultTheme(Component component) {
        component.setBackground(DEFAULT_BACKGROUND);
        component.setForeground(DEFAULT_FOREGROUND);
    }

    public static Color getBackgroundColor(String region) {
        switch (region.toLowerCase()) {
            case "nigeria":
                return NIGERIA_GREEN;
            case "congo":
                return CONGO_RED;
            default:
                return DEFAULT_BACKGROUND;
        }
    }
}
