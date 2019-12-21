package com.fonseca.lucas.Encrypt.service;

import com.fonseca.lucas.Encrypt.dto.EncryptInDTO;
import com.fonseca.lucas.Encrypt.dto.EncryptOutDTO;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface EncryptDecryptService {
    EncryptOutDTO encrypt(EncryptInDTO encryptDTO) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException;
    EncryptOutDTO decrypt(EncryptInDTO encryptDTO);
}
