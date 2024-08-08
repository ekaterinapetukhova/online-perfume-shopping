package com.perfumeOnlineStore.utils.encryption.aes;

import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AesEncrypt implements AttributeConverter<String, String> {
    private final AesEncryptionUtil aesEncryptionUtil;

    @Override
    public String convertToDatabaseColumn(String s) {
        return aesEncryptionUtil.encrypt(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return aesEncryptionUtil.decrypt(s);
    }
}
