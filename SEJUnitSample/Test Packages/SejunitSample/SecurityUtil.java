package sejunitsample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Security utilities for password hashing and verification.
 * Uses SHA-256 with salt.
 */
public class SecurityUtil {

    // Generate a hashed password with salt
    public static String hashPassword(String password) {
        try {
            // Generate a 16-byte random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Apply SHA-256 hash with salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            // Combine salt and hash
            byte[] combined = new byte[salt.length + hashedPassword.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);

            // Return Base64 encoded string of salt + hash
            return Base64.getEncoder().encodeToString(combined);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to hash password", e);
        }
    }

    // Verify a plain password against the stored Base64(salt + hash)
    public static boolean verifyPassword(String inputPassword, String storedHash) {
        try {
            // Decode the Base64 hash into salt + hash bytes
            byte[] combined = Base64.getDecoder().decode(storedHash);
            byte[] salt = new byte[16];
            System.arraycopy(combined, 0, salt, 0, salt.length);

            // Hash the input password using the same salt
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedInput = md.digest(inputPassword.getBytes());

            // Compare input hash with stored hash part
            for (int i = 0; i < hashedInput.length; i++) {
                if (hashedInput[i] != combined[i + salt.length]) {
                    return false;
                }
            }

            return true;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to verify password", e);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        String password = "admin123";
        String hashedPassword = hashPassword(password);

        System.out.println("Original password: " + password);
        System.out.println("Hashed password:   " + hashedPassword);

        boolean result = verifyPassword(password, hashedPassword);
        System.out.println("Password verified: " + result);
    }
}
