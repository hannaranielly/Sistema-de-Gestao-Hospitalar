/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufersa.controlConsult.model.validacao;

/**
 *
 * @author Leonesio
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Criptografia {

    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }

    private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                    hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
    }

    public static char[] criptografar(char[] password_raw) {
        char[] password_hash = null;
        if (md != null) {
            try {
                byte[] password_raw_bytes = new String(password_raw).getBytes("UTF-8");
                password_hash = new String(hexCodes(md.digest(password_raw_bytes))).toCharArray();
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return password_hash;
    }
}
