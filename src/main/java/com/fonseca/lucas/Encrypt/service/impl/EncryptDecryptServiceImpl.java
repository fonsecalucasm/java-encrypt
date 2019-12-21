package com.fonseca.lucas.Encrypt.service.impl;

import com.fonseca.lucas.Encrypt.dto.EncryptInDTO;
import com.fonseca.lucas.Encrypt.dto.EncryptOutDTO;
import com.fonseca.lucas.Encrypt.service.EncryptDecryptService;
import com.fonseca.lucas.Encrypt.util.EncryptDecryptUtil;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class EncryptDecryptServiceImpl implements EncryptDecryptService {
    @Override
    public EncryptOutDTO encrypt(@NotNull final EncryptInDTO encryptDTO)
            throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException,
            BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        final String encrypted = EncryptDecryptUtil.encrypt(encryptDTO.getValue(), encryptDTO.getKey());
        return EncryptOutDTO.builder().value(encrypted).build();
    }

    @Override
    public EncryptOutDTO decrypt(@NotNull final EncryptInDTO encryptDTO) {
        final String decrypted = EncryptDecryptUtil.decrypt(encryptDTO.getValue(), encryptDTO.getKey());
        return EncryptOutDTO.builder().value(decrypted).build();
    }
}
