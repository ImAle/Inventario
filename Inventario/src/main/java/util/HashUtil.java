package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class HashUtil {

    
    public static String hashPassword(String password) {
    	byte[] hashedPassword = null;
    	
    	try {
    		MessageDigest md = MessageDigest.getInstance("SHA-256");
            String semilla = getSemilla();
            md.update(semilla.getBytes());
            hashedPassword = md.digest(password.getBytes());
            
    	}catch(NoSuchAlgorithmException nsaex) {
    		nsaex.printStackTrace();
    	}
        
        return Base64.getEncoder().encodeToString(hashedPassword); // Devuelve la contraseña cifrada
    }

    // Método para generar una semilla fija
    public static String getSemilla() {
        byte[] seed = "SemillaFijaParaPassword".getBytes();
        SecureRandom sr = new SecureRandom(seed); // Crear un SecureRandom con la semilla fija
        byte[] semilla = new byte[16];
        sr.nextBytes(semilla);
        return Base64.getEncoder().encodeToString(semilla); // Devuelve la semilla con la que cifrar
    }

}
