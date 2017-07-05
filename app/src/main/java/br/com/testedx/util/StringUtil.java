package br.com.testedx.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by rafaela on 29/06/2017.
 */

public class StringUtil {

    public static String formatNumberToCurrent(double f) {
        try {
            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrencySymbol("R$");
            ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);
            return nf.format(f);

        } catch (Exception e) {
            return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(f);
        }
    }

    public static String getDateFormated(long date){
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy 'as' HH:mm",Locale.US);
        return df2.format(date);
    }

}
