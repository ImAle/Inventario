package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtil {

    public static String hashPassword(String password) {
        byte[] hashedPassword = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Semilla fija
            String semilla = "SemillaFijaParaPassword";
            md.update(semilla.getBytes());

            // Procesa la contraseña con la semilla
            hashedPassword = md.digest(password.getBytes());
            
        } catch (NoSuchAlgorithmException nsaex) {
            nsaex.printStackTrace();
        }
        
        // Devuelve la contraseña cifrada en Base64
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
}

