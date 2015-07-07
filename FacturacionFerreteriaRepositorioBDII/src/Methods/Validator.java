package Methods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ingdonaldo
 */
public class Validator {

    public static boolean ValidatePhoneNumber(String Numero) {

        for (int i = 0; i < Numero.length(); i++) {
            char c = Numero.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean ValidateRUC(String RUC) {
        Pattern p = Pattern.compile("^[A-Z][0-9]{14}$");
        Matcher m = p.matcher(RUC);
        if (!m.find()) {
            return false;
        }
        return true;
    }

    public static boolean isInt(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException nf) {
            return false;
        }
    }
    
    public static float Redondear(float cantidad) {
        return (float)Math.rint(cantidad * 100) / 100;
    }
    
}
