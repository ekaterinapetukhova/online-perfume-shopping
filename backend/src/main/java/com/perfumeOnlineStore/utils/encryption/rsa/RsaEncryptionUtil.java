package com.perfumeOnlineStore.utils.encryption.rsa;

import com.perfumeOnlineStore.utils.encryption.EncryptionUtil;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

@Component
public class RsaEncryptionUtil implements EncryptionUtil {
    private static final String CIPHER_NAME = "RSA/ECB/PKCS1Padding";
    private static final String ALGO_NAME = "RSA";
    private static final int KEY_SIZE = 2048;

    private KeyPair keyPair;

    public RsaEncryptionUtil() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGO_NAME);
            keyPairGen.initialize(KEY_SIZE);
            keyPair = keyPairGen.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encrypt(String data) {
         try {
            PublicKey publicKey = keyPair.getPublic();

            Cipher cipher = Cipher.getInstance(CIPHER_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

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

            PrivateKey privateKey = keyPair.getPrivate();

            Cipher cipher = Cipher.getInstance(CIPHER_NAME);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
