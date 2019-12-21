package com.fonseca.lucas.Encrypt.controller;

import com.fonseca.lucas.Encrypt.dto.EncryptInDTO;
import com.fonseca.lucas.Encrypt.dto.EncryptOutDTO;
import com.fonseca.lucas.Encrypt.service.EncryptDecryptService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class EncryptController {

    private final EncryptDecryptService encryptDecryptService;

    public EncryptController(final EncryptDecryptService encryptDecryptService) {
        this.encryptDecryptService = encryptDecryptService;
    }

    @PostMapping("/encrypt")
    public EncryptOutDTO encryptText(@RequestBody final EncryptInDTO encryptDTO)
            throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        return encryptDecryptService.encrypt(encryptDTO);
    }

    @PostMapping("/decrypt")
    public EncryptOutDTO decryptText(@RequestBody final EncryptInDTO encryptDTO) {
        return encryptDecryptService.decrypt(encryptDTO);
    }
}
