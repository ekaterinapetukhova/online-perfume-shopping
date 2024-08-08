package com.perfumeOnlineStore.utils.encryption.aes;

import com.perfumeOnlineStore.utils.encryption.EncryptionUtil;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class AesEncryptionUtil implements EncryptionUtil {
    private static final String ALGO_NAME = "AES";
    private static final String CIPHER_NAME = "AES/ECB/PKCS5Padding";
    private static final int KEY_SIZE = 128;

    private SecretKey secretKey;

    public AesEncryptionUtil() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGO_NAME);
            keyGen.init(KEY_SIZE);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] encryptedBytes = cipher.doFinal(data.getBytes());

            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String decrypt(String encryptedData) {
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

            Cipher cipher = Cipher.getInstance(ALGO_NAME);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
