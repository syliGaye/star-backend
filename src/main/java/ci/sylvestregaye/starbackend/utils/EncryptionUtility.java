package ci.sylvestregaye.starbackend.utils;

import jakarta.xml.bind.DatatypeConverter;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

/**
 * Utilitaire pour les opérations d'encryption et de génération de codes aléatoires.
 */
public class EncryptionUtility {
    /**
     * Clé AES utilisée pour le chiffrement.
     */
    private static final String AES_KEY = "9DE99833C7053C092BBC9213B8968B25709B1C6E8F6922BBB0DC38A5E8D8AC60";

    /**
     * Caractères alphanumériques utilisés pour générer des chaînes de caractères aléatoires.
     */
    private static final String STRING_RANDOM_WORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * Caractères alphabétiques majuscules utilisés pour générer des chaînes de caractères aléatoires.
     */
    private static final String STRING_2_RANDOM_WORD_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Caractères alphanumériques utilisés pour générer des chaînes de caractères aléatoires, y compris les chiffres.
     */
    private static final String MIX_RANDOM_WORD_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Caractères alphanumériques utilisés pour générer des chaînes de caractères aléatoires, y compris les chiffres et les lettres minuscules.
     */
    private static final String MIX_2_RANDOM_WORD_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * Calcule le hash SHA-256 d'une chaîne de caractères.
     *
     * @param base La chaîne à hasher.
     * @return Une valeur optionnelle contenant le hash SHA-256 de la chaîne, ou vide en cas d'erreur.
     */
    public static Optional<String> sha256From(String base) {
        MessageDigest digest;
        Optional<String> encoded = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] byteOfTextToHash = base.getBytes("UTF-8");
            byte[] hashedByteArray = digest.digest(byteOfTextToHash);
            encoded = Optional.of(DatatypeConverter.printHexBinary(new Base64().encode(hashedByteArray)).toUpperCase(Locale.getDefault()));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encoded;
    }

    /**
     * Génère un code PIN aléatoire à 4 chiffres.
     *
     * @return Le code PIN aléatoire.
     */
    public static String randomizePinCode() {
        return String.valueOf((int) (Math.random() * 9000) + 1000);
    }

    /**
     * Génère une chaîne aléatoire de caractères.
     *
     * @param length La longueur de la chaîne générée.
     * @return La chaîne aléatoire.
     */
    public static String randomizeStringCode(long length) {
        return new Random().ints(length, 0, STRING_RANDOM_WORD_CHARS.length())
                .mapToObj(STRING_RANDOM_WORD_CHARS::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    /**
     * Génère une chaîne aléatoire de caractères alphanumériques.
     *
     * @param length La longueur de la chaîne générée.
     * @return La chaîne aléatoire.
     */
    public static String randomizeMixCode(long length) {
        return new Random().ints(length, 0, MIX_RANDOM_WORD_CHARS.length())
                .mapToObj(MIX_RANDOM_WORD_CHARS::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    /**
     * Génère une chaîne aléatoire de caractères alphanumériques, les lettres minuscules comme majuscules.
     *
     * @param length La longueur de la chaîne générée.
     * @return La chaîne aléatoire.
     */
    public static String randomizeMixCode_2(long length) {
        return new Random().ints(length, 0, MIX_2_RANDOM_WORD_CHARS.length())
                .mapToObj(MIX_2_RANDOM_WORD_CHARS::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    /**
     * Chiffre une chaîne de caractères en utilisant l'algorithme AES avec le mode CBC et le padding PKCS5.
     *
     * @param plainText Le texte à chiffrer.
     * @return Le texte chiffré en hexadécimal.
     * @throws Exception Si une erreur survient lors du chiffrement.
     */
    public static String encrypt(String plainText) throws Exception {
        byte[] clean = plainText.getBytes();
        int ivSize = 16;
        byte[] iv = new byte[ivSize];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(AES_KEY.getBytes("UTF-8"));
        byte[] keyBytes = new byte[16];
        System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encrypted = cipher.doFinal(clean);
        byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
        System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
        System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);
        return DatatypeConverter.printHexBinary(encryptedIVAndText).toUpperCase(Locale.getDefault());
    }

    /**
     * Déchiffre une chaîne de caractères chiffrée avec AES en mode CBC avec un padding PKCS5.
     *
     * @param encryptedIvTextHex Le texte chiffré en hexadécimal.
     * @return Le texte déchiffré.
     * @throws Exception Si une erreur survient lors du déchiffrement.
     */
    public static String decrypt(String encryptedIvTextHex) throws Exception {
        int ivSize = 16;
        int keySize = 16;

        byte[] encryptedIvTextBytes = DatatypeConverter.parseHexBinary(encryptedIvTextHex);

        // Extract IV.
        byte[] iv = Arrays.copyOfRange(encryptedIvTextBytes, 0, ivSize);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        // Extract encrypted part.
        int encryptedSize = encryptedIvTextBytes.length - ivSize;
        byte[] encryptedBytes = Arrays.copyOfRange(encryptedIvTextBytes, ivSize, encryptedIvTextBytes.length);

        // Hash key.
        byte[] keyBytes = new byte[keySize];
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(AES_KEY.getBytes());
        System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        // Decrypt.
        Cipher cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

        return new String(decrypted);
    }
}
