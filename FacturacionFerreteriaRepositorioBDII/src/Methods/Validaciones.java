/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.IOException;

/**
 *
 * @author Donaldo Vargas
 */
public class Validaciones {

    public static boolean ValidateName(String nombre) {

        for (int i = 0; i < nombre.length(); i++) {
            char letter = nombre.charAt(i);
            if (!Character.isAlphabetic(letter)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isDouble(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException nf) {
            return false;
        }

    }
}
