package com.example.a3t_travel;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {
    public static String formatCurrency(float number, Locale locale) {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        return format.format(number);
    }
}
