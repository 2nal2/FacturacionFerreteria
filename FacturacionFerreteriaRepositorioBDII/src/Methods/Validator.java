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
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean ValidarEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
    
}
