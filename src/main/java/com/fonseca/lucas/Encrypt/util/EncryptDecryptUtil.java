package com.fonseca.lucas.Encrypt.util;

import ch.qos.logback.core.encoder.ByteArrayUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public final class EncryptDecryptUtil {
    public static String encrypt(@NotNull String value, @NotNull String key)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {

        byte[] iv = new byte[16];
        SecureRandom secureRandom = new SecureRandom();

        secureRandom.nextBytes(iv);

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));

        byte[] cipherText = cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
//        ByteBuffer byteBuffer = ByteBuffer.allocate(4 + iv.length + cipherText.length);
//
//        byteBuffer.putInt(iv.length);
//        byteBuffer.put(iv);
//        byteBuffer.put(cipherText);

        return Arrays.toString(cipherText);
    }

    public static String decrypt(@NotNull String value, @NotNull String key) {
        return value;
    }
}
