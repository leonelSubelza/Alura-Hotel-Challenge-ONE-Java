package com.hotelAlura.core.utils;

import javax.swing.*;

public class ValidFieldUtils {

    public static boolean notNullOnlyLetters(String txt, String fieldName, JFrame frame){
        if(txt.equals("") || txt.equals(" ")){
            JOptionPane.showMessageDialog(frame, "El campo: "+fieldName+" es incorrecto", "Campo Incorrecto", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        }
        return  txt.matches("^(?!\\s*$)[a-zA-Z\\s]*$");
    }

    public static boolean notNullOnlyNumbers(String txt, String fieldName, JFrame frame){
        if(txt.equals("") || txt.equals(" ")){
            JOptionPane.showMessageDialog(frame, "El campo: "+fieldName+" es incorrecto", "Campo Incorrecto", JOptionPane.INFORMATION_MESSAGE);
            return  false;
        }
        return txt.matches("^[0-9]{10,}$");
    }

}
