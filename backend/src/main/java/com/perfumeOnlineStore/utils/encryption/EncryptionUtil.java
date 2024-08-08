package com.perfumeOnlineStore.utils.encryption;

public interface EncryptionUtil {
    String encrypt(String data);

    String decrypt(String encryptedData);
}
