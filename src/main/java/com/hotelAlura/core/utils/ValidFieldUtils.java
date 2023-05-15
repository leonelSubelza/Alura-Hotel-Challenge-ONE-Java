package com.hotelAlura.core.utils;

import javax.swing.*;

public class ValidFieldUtils {

    public static boolean notNullOnlyLetters(String txt, String fieldName, JFrame frame){
        if(txt.equals("") || txt.equals(" ") || !txt.matches("^[^\\s\\d][a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s-]*$")){
            JOptionPane.showMessageDialog(frame, "El campo: "+fieldName+" es incorrecto", "Campo Incorrecto", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        }
        return true;

    }

    public static boolean notNullOnlyNumbers(String txt, String fieldName, JFrame frame){
        if(txt.equals("") || txt.equals(" ") || !txt.matches("^[0-9]+(\\.[0-9]+)?$")){
            JOptionPane.showMessageDialog(frame, "El campo: "+fieldName+" es incorrecto", "Campo Incorrecto", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        }
        return true;
    }

}
