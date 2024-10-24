package com.cbz.secret;


import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static com.baomidou.dynamic.datasource.toolkit.Base64.base64ToByteArray;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/23
 */
public class RSAAlgorithm {

    public static void main(String[] args) throws Exception {
        // 原始密码
        String originalText = "secret66";
        String encryptStr = encrypt(originalText);
        System.out.println("原文: " + originalText);
        System.out.println("加密后的文本: " + encryptStr);
        System.out.println("解密后的文本: " + decrypt(encryptStr));
    }


    private static final String Algorithm = "RSA";

    /**
     * RSA公钥加密
     * @param text 输入的密码
     * @return 加密后的密文
     */
    public static String encrypt(String text) throws Exception {
        // 将 Base64编码的公钥字符串 转成 字节数组
        byte[] publicBytes = base64ToByteArray(CipherDemo.publicKey);
        // 将 字节数组 转成 X.509标准编码密钥格式
        X509EncodedKeySpec spec = new X509EncodedKeySpec(publicBytes);
        // 生成公钥对象
        KeyFactory factory = KeyFactory.getInstance(Algorithm);
        PublicKey publicKey = factory.generatePublic(spec);
        // Java内置加密对象Cipher，使用公钥加密
        Cipher cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * RSA私钥解密
     * @param text 加密后Base64编码的密文
     * @return 原始密码
     */
    public static String decrypt(String text) throws Exception {
        // 将 Base64编码的私钥字符串 转成 字节数组
        byte[] secretBytes = base64ToByteArray(CipherDemo.secretKey);
        // 将 字节数组 转成 PKCS#8标准编码密钥格式
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(secretBytes);
        // 生成公钥对象
        KeyFactory factory = KeyFactory.getInstance(Algorithm);
        PrivateKey privateKey = factory.generatePrivate(spec);
        // Java内置加密对象Cipher，使用公钥加密
        Cipher cipher = Cipher.getInstance(Algorithm);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(text));
        return new String(decryptedBytes);
    }

}
